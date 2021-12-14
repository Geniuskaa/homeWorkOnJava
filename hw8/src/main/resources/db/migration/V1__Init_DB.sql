create table cache
(
    id       bigserial primary key,
    a        varchar(256) not null,
    b        varchar(256) not null,
    operator varchar(256) not null,
    result   varchar(256) not null
);