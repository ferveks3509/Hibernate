create table items (
    id serial primary key,
    name varchar(2000)
);
create table cars(
    id serial primary key,
    model varchar(255),
    created TIMESTAMP
)
create table j_role (
    id serial primary key,
     name varchar(2000)
);

create table j_user (
    id serial primary key,
    name varchar(2000),
    role_id int not null references j_role(id)
);

create table carMark(
    id serial primary key,
    name varchar(200)
);

create table car(
    id serial primary key,
    name varchar(200)
);