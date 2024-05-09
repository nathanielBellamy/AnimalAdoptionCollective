-- AnimalAdoptionCollective

-- TODO: debug findAll after running this - something about adoption_id doesn't exist on things where adoption_id shouldn't matter

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
CREATE TABLE names
(
    id                      serial PRIMARY KEY NOT NULL
,   uuid                    uuid
,   first_name_preferred    VARCHAR(255)
,   first_name              VARCHAR(255)
,   middle_name             VARCHAR(255)
,   last_name               VARCHAR(255)
,   entity_type             VARCHAR(255)
,   archived                boolean
);

CREATE TABLE pets
(
    id               serial PRIMARY KEY NOT NULL
,   uuid             uuid
,   pet_type         VARCHAR(255)
,   pet_size         VARCHAR(255)
,   breed            VARCHAR(255)
,   date_of_birth    DATE
,   date_of_intake   DATE
,   name_id          bigint REFERENCES names (id)
);

CREATE TABLE persons
(
    id           serial PRIMARY KEY NOT NULL
,   uuid         uuid
,   date_joined  DATE
,   name_id      bigint REFERENCES names (id)
);

CREATE TABLE adoptions
(
    id                serial PRIMARY KEY NOT NULL,
    uuid              uuid,
    date_of_adoption  DATE
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
    adoption_id   bigint REFERENCES adoptions (id)
,   person_id     bigint REFERENCES persons (id)
);

ALTER TABLE adoption_to_person
    ADD CONSTRAINT adoption_person UNIQUE (adoption_id, person_id);

-- adoption_to_pet
CREATE TABLE adoption_to_pet
(
    adoption_id   bigint REFERENCES adoptions (id)
,   pet_id        bigint REFERENCES pets (id)
);

ALTER TABLE adoption_to_pet
    ADD CONSTRAINT adoption_pet UNIQUE (adoption_id, pet_id);

-- note_to_adoption
CREATE TABLE note_to_adoption
(
    note_id         bigint REFERENCES notes (id)
,   adoption_id     bigint REFERENCES adoptions (id)
);

ALTER TABLE note_to_adoption
    ADD CONSTRAINT note_adoption UNIQUE (note_id, adoption_id);

-- note_to_person
CREATE TABLE note_to_person
(
    note_id       bigint REFERENCES notes (id)
,   person_id     bigint REFERENCES persons (id)
);

ALTER TABLE note_to_person
    ADD CONSTRAINT note_person UNIQUE (note_id, person_id);

-- note_to_pet
CREATE TABLE note_to_pet
(
    note_id    bigint REFERENCES notes (id)
,   pet_id     bigint REFERENCES pets (id)
);

ALTER TABLE note_to_pet
    ADD CONSTRAINT note_pet UNIQUE (note_id, pet_id);

-- phone_number_to_person
CREATE TABLE phone_number_to_person
(
    phone_number_id   bigint REFERENCES phone_numbers (id)
,   person_id         bigint REFERENCES persons (id)
);

ALTER TABLE phone_number_to_person
    ADD CONSTRAINT phone_number_person UNIQUE (phone_number_id, person_id);

--Grant permissions
REVOKE ALL ON SCHEMA public FROM PUBLIC;

-- GRANT ALL ON SCHEMA public TO postgres;
GRANT USAGE ON SCHEMA public TO admin;
GRANT SELECT, INSERT, UPDATE, DELETE, TRUNCATE on ALL TABLES IN SCHEMA public TO admin;
GRANT USAGE, SELECT, UPDATE on ALL SEQUENCES IN SCHEMA public TO admin;
--