'use strict';

const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const compression = require('compression');
const db = require('./db');
const envLoader = require('./env');
const morgan = require('morgan');

function _start() {
  app.use(morgan('combined'));
  app.use(bodyParser.json());
  app.use(compression({ threshold: 0 }));
  app.listen(3000, () => console.log('Server up'));

  // Lets get started
  return envLoader
    .get()
    .then(env => db.initialize())
    .then(() => {
      app.listen(3000, err => {
        console.log('Server up on port 3000....');
      });
    });
}

module.exports = {
  start: _start
};
