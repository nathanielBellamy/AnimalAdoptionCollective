-- AnimalAdoptionCollective


-- set current_user
set ROLE admin;
-- 0. CLEAR DB
-- entities
DROP TABLE IF EXISTS pets CASCADE;
DROP TABLE IF EXISTS adoptions CASCADE;
DROP TABLE IF EXISTS persons CASCADE;
DROP TABLE IF EXISTS names CASCADE;
DROP TABLE IF EXISTS notes CASCADE;
DROP TABLE IF EXISTS phone_numbers CASCADE;

-- join tables
DROP TABLE IF EXISTS adoption_to_person CASCADE;
DROP TABLE IF EXISTS adoption_to_pet CASCADE;
DROP TABLE IF EXISTS name_to_person CASCADE;
DROP TABLE IF EXISTS name_to_pet CASCADE;
DROP TABLE IF EXISTS note_to_pet CASCADE;
DROP TABLE IF EXISTS note_to_person CASCADE;
DROP TABLE IF EXISTS note_to_adoption CASCADE;
DROP TABLE IF EXISTS phone_number_to_person CASCADE;
-- 1. CREATE TABLES

-- entities
CREATE TABLE pets
(
    id               serial PRIMARY KEY NOT NULL,
    uuid             uuid,
    pet_size         VARCHAR(20),
    breed            VARCHAR(255),
    date_of_birth    DATE,
    date_of_intake   DATE
);

CREATE TABLE persons
(
    id           serial PRIMARY KEY NOT NULL,
    uuid         uuid,
    date_joined  DATE
);

CREATE TABLE adoptions
(
    id                serial PRIMARY KEY NOT NULL,
    uuid              uuid,
    date_of_adoption  DATE
);

CREATE TABLE names
(
    id                      serial PRIMARY KEY NOT NULL,
    uuid                    uuid,
    first_name_preferred    VARCHAR(255),
    first_name              VARCHAR(255),
    middle_name             VARCHAR(255),
    last_name               VARCHAR(255),
    archived                boolean
);

CREATE TABLE notes
(
    id                      serial PRIMARY KEY NOT NULL,
    uuid                    uuid,
    body                    VARCHAR(255)
);

CREATE TABLE phone_numbers
(
    id                    serial PRIMARY KEY NOT NULL,
    uuid                  uuid,
    country_code          int,
    area_code             int,
    number                int,
    extension             int,
    type                  VARCHAR(20),
    archived              boolean
);

-- join tables
--
-- adoption_to_person
CREATE TABLE adoption_to_person
(
    adoption_id   bigint
,   person_id     bigint
);

ALTER TABLE adoption_to_person
    ADD CONSTRAINT fk_adoption_to_person_adoption_id FOREIGN KEY (adoption_id)
        REFERENCES adoptions (id);

ALTER TABLE adoption_to_person
    ADD CONSTRAINT fk_adoption_to_person_person_id FOREIGN KEY (person_id)
        REFERENCES persons (id);

ALTER TABLE adoption_to_person
    ADD CONSTRAINT adoption_person UNIQUE (adoption_id, person_id);

-- adoption_to_pet
CREATE TABLE adoption_to_pet
(
    adoption_id   bigint
,   pet_id     bigint
);

ALTER TABLE adoption_to_pet
    ADD CONSTRAINT fk_adoption_to_pet_adoption_id FOREIGN KEY (adoption_id)
        REFERENCES adoptions (id);

ALTER TABLE adoption_to_pet
    ADD CONSTRAINT fk_adoption_to_pet_pet_id FOREIGN KEY (pet_id)
        REFERENCES pets (id);

ALTER TABLE adoption_to_pet
    ADD CONSTRAINT adoption_pet UNIQUE (adoption_id, pet_id);

-- name_to_person
CREATE TABLE name_to_person
(
    name_id   bigint
,   person_id     bigint
);

ALTER TABLE name_to_person
    ADD CONSTRAINT fk_name_to_person_name_id FOREIGN KEY (person_id)
        REFERENCES names (id);

ALTER TABLE name_to_person
    ADD CONSTRAINT fk_name_to_person_person_id FOREIGN KEY (person_id)
        REFERENCES persons (id);

ALTER TABLE name_to_person
    ADD CONSTRAINT name_person UNIQUE (name_id, person_id);

-- name_to_pet
CREATE TABLE name_to_pet
(
    name_id   bigint
    ,   pet_id     bigint
);

ALTER TABLE name_to_pet
    ADD CONSTRAINT fk_name_to_pet_name_id FOREIGN KEY (pet_id)
        REFERENCES names (id);

ALTER TABLE name_to_pet
    ADD CONSTRAINT fk_name_to_pet_pet_id FOREIGN KEY (pet_id)
        REFERENCES pets (id);

ALTER TABLE name_to_pet
    ADD CONSTRAINT name_pet UNIQUE (name_id, pet_id);

-- note_to_adoption
CREATE TABLE note_to_adoption
(
    note_id   bigint
,   adoption_id     bigint
);

ALTER TABLE note_to_adoption
    ADD CONSTRAINT fk_note_to_adoption_note_id FOREIGN KEY (adoption_id)
        REFERENCES notes (id);

ALTER TABLE note_to_adoption
    ADD CONSTRAINT fk_note_to_adoption_adoption_id FOREIGN KEY (adoption_id)
        REFERENCES adoptions (id);

ALTER TABLE note_to_adoption
    ADD CONSTRAINT note_adoption UNIQUE (note_id, adoption_id);

-- note_to_person
CREATE TABLE note_to_person
(
    note_id   bigint
,   person_id     bigint
);

ALTER TABLE note_to_person
    ADD CONSTRAINT fk_note_to_person_note_id FOREIGN KEY (person_id)
        REFERENCES notes (id);

ALTER TABLE note_to_person
    ADD CONSTRAINT fk_note_to_person_person_id FOREIGN KEY (person_id)
        REFERENCES persons (id);

ALTER TABLE note_to_person
    ADD CONSTRAINT note_person UNIQUE (note_id, person_id);

-- note_to_pet
CREATE TABLE note_to_pet
(
    note_id   bigint
    ,   pet_id     bigint
);

ALTER TABLE note_to_pet
    ADD CONSTRAINT fk_note_to_pet_note_id FOREIGN KEY (pet_id)
        REFERENCES notes (id);

ALTER TABLE note_to_pet
    ADD CONSTRAINT fk_note_to_pet_pet_id FOREIGN KEY (pet_id)
        REFERENCES pets (id);

ALTER TABLE note_to_pet
    ADD CONSTRAINT note_pet UNIQUE (note_id, pet_id);

-- phone_number_to_person
CREATE TABLE phone_number_to_person
(
    phone_number_id   bigint
    ,   person_id     bigint
);

ALTER TABLE phone_number_to_person
    ADD CONSTRAINT fk_phone_number_to_person_phone_number_id FOREIGN KEY (person_id)
        REFERENCES phone_numbers (id);

ALTER TABLE phone_number_to_person
    ADD CONSTRAINT fk_phone_number_to_person_person_id FOREIGN KEY (person_id)
        REFERENCES persons (id);

ALTER TABLE phone_number_to_person
    ADD CONSTRAINT phone_number_person UNIQUE (phone_number_id, person_id);


--

-- -- join tables
-- CREATE TABLE adoption_to_person
-- (
--     adoption_id          bigint REFERENCES adoptions (id) ON UPDATE CASCADE
-- ,   person_id            bigint REFERENCES persons (id) ON UPDATE CASCADE
-- ,   CONSTRAINT adoption_to_person_pkeay PRIMARY KEY (adoption_id, person_id)
-- );
--
-- CREATE TABLE adoption_to_pet
-- (
--     adoption_id       bigint REFERENCES adoptions (id) ON UPDATE CASCADE
-- ,   pet_id            bigint REFERENCES pets (id) ON UPDATE CASCADE
-- ,   CONSTRAINT adoption_to_pet_pkey PRIMARY KEY (adoption_id, pet_id)
-- );
--
-- CREATE TABLE note_to_adoption
-- (
--     note_id              bigint REFERENCES notes (id) ON UPDATE CASCADE
-- ,   adoption_id          bigint REFERENCES adoptions (id) ON UPDATE CASCADE
-- ,   CONSTRAINT note_to_adoption_pkey PRIMARY KEY (note_id, adoption_id)
-- );
--
-- CREATE TABLE note_to_person
-- (
--     note_id            bigint REFERENCES notes (id) ON UPDATE CASCADE
-- ,   person_id          bigint REFERENCES persons (id) ON UPDATE CASCADE
-- ,   CONSTRAINT note_to_person_pkey PRIMARY KEY (note_id, person_id)
-- );
--
-- CREATE TABLE note_to_pet
-- (
--      note_id         bigint REFERENCES notes (id) ON UPDATE CASCADE
-- ,    pet_id          bigint REFERENCES pets (id) ON UPDATE CASCADE
-- ,    CONSTRAINT note_to_pet_pkey PRIMARY KEY (note_id, pet_id)
-- );
--
-- CREATE TABLE phone_number_to_person
--
-- (
--     phone_number_id       bigint REFERENCES phone_numbers (id) ON UPDATE CASCADE
-- ,   person_id             bigint REFERENCES persons (id) ON UPDATE CASCADE
-- ,   CONSTRAINT phone_number_to_person_pkey PRIMARY KEY (phone_number_id, person_id)
-- );
