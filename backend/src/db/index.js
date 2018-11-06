'use strict';

const promise = require('bluebird');
const repos = require('./repository'); // loading all repositories
const env = require('../env');
let db;

async function _init() {
  if (!db) {
    // pg-promise initialization options:
    const initOptions = {
      // Use a custom promise library, instead of the default ES6 Promise:
      promiseLib: promise,

      // Extending the database protocol with our custom repositories;
      // API: http://vitaly-t.github.io/pg-promise/global.html#event:extend
      extend(obj, dc) {
        // Database Context (dc) is mainly useful when extending multiple databases
        // with different access API-s.

        // Do not use 'require()' here, because this event occurs for every task
        // and transaction being executed, which should be as fast as possible.
        obj.repositories = {
          users: new repos.Users(obj, pgp),
          products: new repos.Products(obj, pgp),
          category: new repos.Category(obj, pgp)
        };
      }
    };

    // Load and initialize pg-promise:
    const pgp = require('pg-promise')(initOptions);
    const envDef = await env.get();

    // Create the database instance:
    db = pgp(envDef.postgresql.uri);
    await Promise.all([
      db.repositories.users.create(),
      db.repositories.products.create(),
      db.repositories.category.create()
    ]);

     await Promise.all([db.repositories.category.initWithSampleData()]);
    // await db.repositories.users.initWithSampleData();
  }

  return db;
}

function _getRepos() {
  if (db) return db.repositories;
  return {};
}

module.exports = {
  initialize: _init,
  getRepositories: _getRepos
};
