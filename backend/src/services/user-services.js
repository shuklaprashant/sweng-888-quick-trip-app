'use strict';

module.exports.validatePassword = (user, password) =>
  user.password === password ? true : false;
