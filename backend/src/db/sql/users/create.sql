CREATE SCHEMA IF NOT EXISTS ${schema~};
CREATE TABLE IF NOT EXISTS ${schema~}.users
(
    id serial PRIMARY KEY,
    name text NOT NULL
)