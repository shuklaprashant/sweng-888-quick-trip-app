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

  add(user) {
    return this._db.one(sql.add, user.name);
  }

  all() {
    return this._db.any(sql.readAll);
  }
}

module.exports = UsersRepository;
