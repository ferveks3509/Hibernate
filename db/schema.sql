create table items (
    id serial primary key,
    name varchar(2000)
);
create table cars(
    id serial primary key,
    model varchar(255),
    created TIMESTAMP
)