'use strict';

const constants = require('../../constants').db;
const path = require('path');

// See QueryFile API:
// http://vitaly-t.github.io/pg-promise/QueryFile.html
const QueryFile = require('pg-promise').QueryFile;

module.exports = {
  users: {
    create: sql('users/create.sql'),
    readAll: sql('users/read-all.sql'),
    init: sql('users/init.sql'),
    add: sql('users/add.sql')
  }
};

function sql(file) {
  const fullPath = path.join(__dirname, file); // generating full path;

  const options = {
    // minifying the SQL is always advised;
    // see also option 'compress' in the API;
    minify: true,

    // Showing how to use static pre-formatting parameters -
    // we have variable 'schema' in each SQL (as an example);
    params: {
      schema: constants.schema // replace ${schema~}
    }
  };

  const qf = new QueryFile(fullPath, options);

  if (qf.error) {
    // Something is wrong with our query file :(
    // Testing all files through queries can be cumbersome,
    // so we also report it here, while loading the module:
    console.error(qf.error);
  }

  return qf;
}
