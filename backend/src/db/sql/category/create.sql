CREATE SCHEMA IF NOT EXISTS ${schema~};
CREATE TABLE IF NOT EXISTS ${schema~}.category
(
    id serial PRIMARY KEY,
    name text NOT NULL,
    img integer
);

CREATE TABLE IF NOT EXISTS ${schema~}.category_characteristic
(
    id serial PRIMARY KEY,
    categoryId integer NOT NULL,
    name text NOT NULL,
    img integer
);

CREATE TABLE IF NOT EXISTS ${schema~}.category_characteristic_value
(
    id serial PRIMARY KEY,
    characteristicId integer NOT NULL,
    value text NOT NULL
);

CREATE OR REPLACE VIEW ${schema~}.category_view AS
    SELECT category.id as categoryId, 
			category.name as categoryName, 
			category.img as categoryImage,
			characteristic.id as characteristicId,
			characteristic.name as characteristicName,
			characteristic.img as characteristicImage,
            characteristic_value.id as characteristic_valueId,
            characteristic_value.value as characteristic_valueValue
			from ${schema~}.category AS category
        INNER JOIN ${schema~}.category_characteristic AS characteristic
            ON characteristic.categoryId = category.id
        INNER JOIN ${schema~}.category_characteristic_value AS characteristic_value
            ON characteristic_value.characteristicId = characteristic.id
    ORDER BY category.name;