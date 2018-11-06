'use strict';

const BASE_PATH = '/api/v1.0/users';
const { asyncMiddleware, validateBody } = require('../utils');
const Ajv = require('ajv');
const ajv = new Ajv({ allErrors: true });
const codes = require('http-status-codes');
const { Router } = require('express');
const passport = require('passport');

module.exports = (app, passport, db) => {
  const createUserValidator = ajv.compile(
    require('../../resources/raml/schema/create-user.json')
  );

  const router = new Router();

  router.get(
    BASE_PATH,
    passport.authenticate('basic', { session: false }),
    asyncMiddleware(async (req, res, next) => {
      const users = await db.getRepositories().users.all();
      res.send(users);
      next();
    })
  );

  router.post(
    BASE_PATH + '/login',
    passport.authenticate('basic', { session: false }),
    (req, res, next) => {
      res.sendStatus(codes.OK);
      next();
    }
  );

  router.post(
    BASE_PATH,
    (req, res, next) => validateBody(createUserValidator, req, res, next),
    asyncMiddleware(async (req, res, next) => {
      const user = await db.getRepositories().users.add(req.body);

      res.status(codes.CREATED);
      res.send(user);
      next();
    })
  );

  app.use(router);
};
