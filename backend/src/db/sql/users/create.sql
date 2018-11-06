CREATE SCHEMA IF NOT EXISTS ${schema~};
CREATE TABLE IF NOT EXISTS ${schema~}.users
(
    id text PRIMARY KEY,
    name text NOT NULL,
    password text NOT NULL,
    birthday text NOT NULL,
    profileImage uuid
);


CREATE TABLE IF NOT EXISTS ${schema~}.preferences
(
    id uuid primary key,
    category text,
    characteristic text,
    preferred boolean
);

-- Write a job that will put entries in here when:
-- The user is created
-- New products are added
-- Remove then when the user confirms a visit so we do not recommend again
CREATE TABLE IF NOT EXISTS ${schema~}.recommendation
(
    id uuid PRIMARY KEY,
    userId text NOT NULL,
    product uuid NOT NULL
);

-- If the user decides they want to visit this location
-- the app should update this information here
CREATE TABLE IF NOT EXISTS ${schema~}.activity
(
    id uuid PRIMARY KEY,
    userId text NOT NULL,
    product uuid NOT NULL,
    planned timestamp with time zone default now(),
    visited timestamp with time zone default now(),
    review uuid
);