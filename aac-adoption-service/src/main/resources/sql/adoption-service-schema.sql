
set ROLE admin;

CREATE TABLE pets
(
    id           serial primary key not NULL,
    uuid         uuid,
    pet_size      VARCHAR(20),
    breed        VARCHAR(255),
    date_of_birth  DATE,
    date_of_intake DATE
);

CREATE TABLE persons
(
    id         serial primary key not NULL,
    uuid       uuid,
    date_joined  DATE
);

CREATE TABLE adoptions
(
    id             serial primary key not NULL,
    uuid           uuid,
    date_of_adoption DATE
);

CREATE TABLE names
(
    id                      serial primary key not NULL,
    uuid                    uuid,
    first_name_preferred      VARCHAR(255),
    first_name               VARCHAR(255),
    middle_name              VARCHAR(255),
    last_name                VARCHAR(255),
    archived                boolean
);

CREATE TABLE notes
(
    id                      serial primary key not NULL,
    uuid                    uuid,
    body                    VARCHAR(255)
);

CREATE TABLE phone_numbers
(
    id                    serial primary key not NULL,
    uuid                  uuid,
    country_code           INTEGER,
    area_code              INTEGER,
    number                INTEGER,
    extension             INTEGER,
    type                  VARCHAR(20),
    archived              boolean
);

-- Add Join Tables

CREATE TABLE adoption_to_person
(
    id                   serial primary key not NULL,
    adoption_id          INTEGER,
    person_id            INTEGER
);

CREATE TABLE note_to_adoption
(
    id                   serial primary key not NULL,
    note_id              INTEGER REFERENCES notes (id) ON UPDATE CASCADE,
    adoption_id          INTEGER REFERENCES adoptions (id) ON UPDATE CASCADE
);

CREATE TABLE note_to_person
(
    id                 serial primary key not NULL,
    note_id            INTEGER REFERENCES notes (id) ON UPDATE CASCADE,
    person_id          INTEGER REFERENCES persons (id) ON UPDATE CASCADE
);

CREATE TABLE note_to_pet
(
    id              serial primary key not NULL,
    note_id         INTEGER REFERENCES notes (id) ON UPDATE CASCADE,
    pet_id          INTEGER REFERENCES pets (id) ON UPDATE CASCADE
);

CREATE TABLE person_to_phone_number
(
    id                    serial primary key not NULL,
    person_id             INTEGER REFERENCES persons (id) ON UPDATE CASCADE,
    phone_number_id       INTEGER REFERENCES phone_numbers (id) ON UPDATE CASCADE
);
