insert into users(username, password, firstname, lastname)
values ('admin', '$2a$10$oeitDemctXqD7ywVfLP9ZeRZfVdgIO/57C0nnTsbEuR5YzoLRHGF.', 'admin', 'admin');

insert into authorities (username, authority)
values ('admin', 'ROLE_USER')