'use strict';

module.exports.asyncMiddleware = fn => (req, res, next) => {
  Promise.resolve(fn(req, res, next)).catch(next);
};

module.exports.validateBody = (fn, req, res, next) => {
  fn(req.body) ? next() : next(fn.errors);
};
