CREATE SCHEMA IF NOT EXISTS ${schema~};
CREATE TABLE IF NOT EXISTS ${schema~}.images
(
    id uuid PRIMARY KEY,
    image bytea
)