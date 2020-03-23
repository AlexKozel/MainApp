create table employee
(
    id integer not null auto_increment ,
    first_name varchar(255),
    last_name varchar(255),
    birth_date timestamp,
    salary integer not null,
    primary key (id)
);