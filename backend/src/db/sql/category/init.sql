DELETE FROM ${schema~}.category;
DELETE FROM ${schema~}.category_characteristic;
DELETE FROM ${schema~}.category_characteristic_value;

INSERT INTO ${schema~}.category(id, name) VALUES
(1, 'Resturants'),
(2, 'Events'),
(3, 'Activities');

INSERT INTO ${schema~}.category_characteristic(id, categoryId, name) VALUES
(1, 1, 'Style'), -- Indian, Italian, Amerian, Mexican, etc
(2, 1, 'Type'),  -- Vegitarian, Non-Vegitarian, Vegan, 
(3, 1, 'Spicyness'), -- Low Heat, Medium Heat, Killer Heat
(4, 1, 'Features'), -- House Brew Beer, Wine, Live Music
(5, 2, 'Type'), -- Music, Art, Tour, Sport, Political, Social, Comedy
(6, 2, 'Location'), -- Indoors, Outdoors, Theater, Stadium
(7, 3, 'Type'); -- Movie, Hiking, Biking, Running, Water, Mueseum, Historical

INSERT INTO ${schema~}.category_characteristic_value(id, characteristicId, value) VALUES
(1, 1, 'Indian'),
(2, 1, 'Italian'),
(3, 1, 'Amerian'),
(4, 1, 'Mexican'),
(5, 2, 'Vegitarian'),
(6, 2, 'Non-Vegitarian'),
(7, 2, 'Vegan'),
(8, 3, 'Low Heat'),
(9, 3, 'Medium Heat'),
(10, 3, 'Killer Heat'),
(11, 4, 'Craft Beer'),
(12, 4, 'Wine'),
(13, 4, 'Live Music'),
(14, 5, 'Music'),
(15, 5, 'Art'),
(16, 5, 'Tour'),
(17, 5, 'Sport'),
(18, 5, 'Political'),
(19, 5, 'Social'),
(20, 5, 'Comedy'),
(21, 6, 'Indoors'), 
(22, 6, 'Outdoors'),
(23, 6, 'Theater'),
(24, 6, 'Stadium'),
(25, 7, 'Movie'),
(26, 7, 'Hiking'),
(27, 7, 'Biking'),
(28, 7, 'Type'),
(29, 7, 'Running'),
(30, 7, 'Water'),
(31, 7, 'Mueseum'),
(32, 7, 'Historical');