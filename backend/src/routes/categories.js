'use strict';

const BASE_PATH = '/api/v1.0/categories;
const { asyncMiddleware, validateBody } = require('../utils');
const Ajv = require('ajv');
const ajv = new Ajv({ allErrors: true });
const codes = require('http-status-codes');
const { Router } = require('express');
const passport = require('passport');

module.exports = (app, passport, db) => {
  router.get(
    BASE_PATH,
    passport.authenticate('basic', { session: false }),
    asyncMiddleware(async (req, res, next) => {
      const categories = await db.getRepositories().categories.getAll();
      res.status(codes.OK);
      res.send(categories);
      next();
    }
  );
};
