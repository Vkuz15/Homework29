-- liquibase formatted sql

-- changeset vkuznecov:1
CREATE INDEX students_name_index ON student (name);

-- changeset vkuznecov:2
CREATE INDEX faculty_name_color_index ON faculty (name, color);