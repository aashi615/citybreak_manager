CREATE TABLE cities (
    id BIGINT NOT NULL AUTO_INCREMENT, -- Or SERIAL in PostgreSQL
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    details TEXT, -- Use TEXT for potentially longer strings, or VARCHAR(255) if details are short
    PRIMARY KEY (id)
);

CREATE TABLE trips (
    id BIGINT NOT NULL AUTO_INCREMENT, -- Primary key for the Trip entity (use BIGSERIAL in PostgreSQL)
    city_id BIGINT, -- Foreign Key to the cities table
    start_date DATE,
    end_date DATE,
    rating INT,
    personal_notes TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (city_id) REFERENCES cities(id) -- Defines the relationship
);