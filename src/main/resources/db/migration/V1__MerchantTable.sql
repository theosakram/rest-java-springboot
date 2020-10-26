CREATE TABLE Merchant (
  id UUID NOT NULL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE EXTENSION "uuid-ossp";

SELECT uuid_generate_v4();

INSERT INTO merchant (id, name) VALUES (uuid_generate_v4(), 'Berchant the Best Merchant');