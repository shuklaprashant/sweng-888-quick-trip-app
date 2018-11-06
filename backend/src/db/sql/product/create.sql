CREATE SCHEMA IF NOT EXISTS ${schema~};
CREATE TABLE IF NOT EXISTS ${schema~}.product
(
    id serial PRIMARY KEY,
    category integer not null,
    name text NOT NULL,
    number integer not null,
    street text not null,
    zip text not null,
    city text not null,
    state text not null,
    geolocation text
);

CREATE TABLE IF NOT EXISTS ${schema~}.product_characteristic
(
    id serial PRIMARY KEY,
    productId uuid NOT NULL,
    characteristic uuid NOT NULL
);

CREATE TABLE IF NOT EXISTS ${schema~}.product_requirements
(
    id serial PRIMARY KEY,
    visitdurationhours integer,
    setting integer, -- Indoor = 1 Outdoor = 2 Mixed = 3
    minimumage integer
);

CREATE TABLE IF NOT EXISTS ${schema~}.product_images
(
    id serial PRIMARY KEY,
    productId integer NOT NULL,
    img integer NOT NULL
)