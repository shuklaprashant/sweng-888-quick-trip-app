'use strict';

const sql = require('../sql').categories;

class CategoryRepository {
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

  all() {
    return this._db.any(sql.readAll);
  }
}

module.exports = CategoryRepository;
