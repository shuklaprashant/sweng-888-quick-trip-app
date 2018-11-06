'use strict';

const sql = require('../sql').products;
const { v4 } = require('uuid');
const constants = require('../../constants');

class Product {
  constructor(db, pgp) {
    this._db = db;
    this._pgp = pgp;
    this._cs = new pgp.helpers.ColumnSet(
      ['id', 'name', 'number', 'street', 'zip', 'city', 'state', 'geolocation'],
      { table: `${constants.db.schema}.product` }
    );
  }

  create() {
    return this._db.none(sql.create);
  }

  initWithSampleData() {
    return this._db.none(sql.init);
  }

  add(product) {
    return this._db.one(sql.add, [
      v4(),
      product.name,
      product.number,
      product.street,
      product.zip,
      product.city,
      product.state,
      product.geolocation
    ]);
  }

  addCharacteristics(characteristics) {
    const insert = this._pgp.helpers.insert(characteristics, cs);
    return this._db.none(insert);
  }

  all() {
    return this._db.any(sql.readAll);
  }
}

module.exports = Product;
