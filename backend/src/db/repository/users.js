'use strict';

const sql = require('../sql').users;

class UsersRepository {
  constructor(db, pgp) {
    this._db = db;
    this._pgp = pgp;
  }

  create() {
    return this._db.none(sql.create);
  }

  initWithSampleData() {
    return this._db.none(sql.init);
  }

  findOne(email) {
    return this._db.one(sql.findOne, email);
  }

  add(user) {
    return this._db.one(sql.add, [
      user.email,
      user.name,
      user.password,
      user.birthday
    ]);
  }

  all() {
    return this._db.any(sql.readAll);
  }
}

module.exports = UsersRepository;
