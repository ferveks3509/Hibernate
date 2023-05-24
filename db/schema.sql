create table items
(
    id   serial primary key,
    name varchar(2000)
);
create table cars
(
    id      serial primary key,
    model   varchar(255),
    created TIMESTAMP
);

create table carMark
(
    id   serial primary key,
    name varchar(200)
);

create table car
(
    id   serial primary key,
    name varchar(200)
);
create table address
(
    id     serial primary key,
    street varchar(200),
    number varchar(200)
);
create table person
(
    id   serial primary key,
    name varchar(200)
);
create table j_role
(
    id   serial primary key,
    name varchar(2000)
);
create table j_user
(
    id      serial primary key,
    name    varchar(2000),
    role_id int not null references j_role (id)
);
create table j_user_notification
(
    id        serial primary key,
    messenger text,
    identify  text,
    j_user_id int REFERENCES j_user (id)
);
CREATE TABLE participates
(
    id      serial PRIMARY KEY,
    item_id int not null REFERENCES items (id),
    user_id int not null REFERENCES j_user (id),
    UNIQUE (item_id, user_id)
);
