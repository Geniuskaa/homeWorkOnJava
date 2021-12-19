create table users
(
    id        serial primary key,
    username  varchar not null unique,
    password  varchar not null,
    firstname varchar not null,
    lastname  varchar not null,
    enabled   boolean not null default true
);