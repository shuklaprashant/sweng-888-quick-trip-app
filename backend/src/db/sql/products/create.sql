CREATE SCHEMA IF NOT EXISTS ${schema~};
CREATE TABLE IF NOT EXISTS ${schema~}.category
(
    id uuid PRIMARY KEY,
    name text NOT NULL,
    img uuid NOT NULL
)

CREATE TABLE IF NOT EXISTS ${schema~}.category_characteristic
(
    id uuid PRIMARY KEY,
    category uuid NOT NULL,
    name text NOT NULL,
    img uuid NOT NULL
)

CREATE OR REPLACE VIEW ${schema~}.category_view AS
    SELECT * from ${schema~}.category AS category
        INNER JOIN ${schema~}.category_characteristic AS characteristic
            ON characteristic.category = category.id
    ORDER BY category.name;

CREATE TABLE IF NOT EXISTS ${schema~}.product
(
    id uuid PRIMARY KEY,
    name text NOT NULL,
    number integer not null,
    street text not null,
    zip text not null,
    city text not null,
    state text not null,
    geolocation text
)

CREATE TABLE IF NOT EXISTS ${schema~}.product_characteristic
(
    id uuid PRIMARY KEY,
    product uuid NOT NULL,
    characteristic uuid NOT NULL
)

CREATE TABLE IF NOT EXISTS ${schema~}.product_requirements
(
    id uuid PRIMARY KEY,
    visitdurationhours integer,
    setting integer, -- Indoor = 1 Outdoor = 2 Mixed = 3
    minimumage integer
)