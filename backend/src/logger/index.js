'use strict';

const fs = require('fs');
const path = require('path');
const winston = require('winston');
const wcf = require('winston-console-formatter');
const location = path.join(__dirname, '../../logs');

if (!fs.existsSync(location)) {
  fs.mkdirSync(location);
}

const { formatter, timestamp } = wcf();
const tsFormat = () => moment().format('YYYY-MM-DD hh:mm:ss').trim();
module.exports = new winston.Logger({
  transports: [
    new winston.transports.Console({
      level: 'info',
      formatter: formatter,
      timestamp: true,
      colorize: true
    }),
    new winston.transports.File({
      level: 'debug',
      timestamp: true,
      prettyPrint: true,
      json: false,
      filename: path.join(location, `${process.pid}: ${Date.now()}-logfile.log`)
    })
  ]
});
