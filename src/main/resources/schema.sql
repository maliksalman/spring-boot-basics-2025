create table if not exists hero(
    name varchar(64) primary key,
    secret_identity varchar(64),
    universe varchar(10),
    age int
);
create table if not exists universe(
    name varchar(64) primary key,
    fictional_cities boolean
);