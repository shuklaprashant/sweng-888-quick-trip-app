INSERT INTO ${schema~}.users(id, name, password, birthday) VALUES($1, $2, $3, $4) RETURNING *