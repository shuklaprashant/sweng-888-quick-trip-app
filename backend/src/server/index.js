'use strict';

const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const compression = require('compression');
const db = require('../db');
const envLoader = require('../env');
const morgan = require('morgan');
const routers = require('../routes');
const passport = require('passport');
const { BasicStrategy } = require('passport-http');
const { validatePassword } = require('../services/user-services');

function _start() {
  app.use(morgan('combined'));
  app.use(bodyParser.json());
  app.use(compression({ threshold: 0 }));

  passport.use(
    new BasicStrategy(function(username, password, done) {
      db.getRepositories()
        .users.findOne(username)
        .then(user => {
          if (!user) {
            return done(null, false);
          }
          if (!validatePassword(user, password)) {
            return done(null, false);
          }
          return done(null, user);
        })
        .catch(err => done(err));
    })
  );

  routers.users(app, passport, db);

  // Lets get started
  return envLoader
    .get()
    .then(env => db.initialize())
    .then(() => {
      app.listen(9000, err => {
        console.log('Server up on port 9000....');
      });
    });
}

module.exports = {
  start: _start
};
