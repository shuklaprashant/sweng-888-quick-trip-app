'use strict';

const constants = require('../constants').aws;
const AWS = require('aws-sdk');
const isEmpty = require('lodash').isEmpty;
let env;

async function _getEnv() {
  if (env) return env;

  // Alternatively we could check for the existence of VCAP_APPLICATION in the env
  // this indicates we are in the CF runtime otherwise we callback to AWS bootstrap
  switch (process.env.PLATFORM) {
    case 'AWS':
      env = await _loadFromAWSSSM();
    default:
      env = {
        postgresql: {
          uri: 'postgres://postgres:postgres@localhost:5432/quicktrip'
        }
      };
  }
  return env;
}

async function _loadFromAWSSSM() {
  const ssm = new AWS.SSM({ apiVersion: constants.SSM.apiVersion });
  const parameters = await ssm
    .getParameters({
      Names: [constants.SSM.applicationParameters.db]
    })
    .promise();

  if (!isEmpty(parameters.InvalidParameters)) {
    throw new Error('Env could not be determined. Check configuration.');
  }
  // Process the parameters into a JSON Object similar to the VCAP variables
  return {
    postgresql: _extractParameter(
      constants.SSM.applicationParameters.db,
      parameters.Parameters
    )
  };
}

function _extractParameter(parameterName, parameterList) {
  for (let a = 0, len = parameterList.length; a < len; a++) {
    const parameter = parameterList[a];
    if (parameter.Name === parameterName) {
      return JSON.parse(parameter.Value);
    }
  }
}

module.exports = {
  get: _getEnv
};
