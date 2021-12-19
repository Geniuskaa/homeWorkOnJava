create table authorities
(
    username  varchar not null,
    authority varchar not null,
    constraint foreign_authorities_users_1 foreign key (username) references users (username)
);