INSERT INTO 
    ${schema~}.product(
        id, name, number, 
        street, zip, city, 
        state, geolocation) 
    VALUES($1, $2, $3, $4, $5, $6, $7, $8) RETURNING *