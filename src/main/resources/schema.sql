CREATE TABLE IF NOT EXISTS Tour (
    id SERIAL PRIMARY KEY,
    tourName VARCHAR(255) NOT NULL,
    description TEXT,
    tourType VARCHAR(20) NOT NULL,
    durationInDays INTEGER,
    price DOUBLE,
    startDate TIMESTAMP NOT NULL,
    createdAt TIMESTAMP NOT NULL,
    modifiedAt TIMESTAMP,
    url VARCHAR(255)
    );
