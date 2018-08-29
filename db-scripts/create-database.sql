DROP SCHEMA IF EXISTS eleave;
CREATE SCHEMA eleave;

USE eleave;

create table el_employee (
    id varchar(255) not null,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(60),
    job_position varchar(255),
    employee_type varchar(255),
    primary key (id)
);

create table el_leave (
    id varchar(255) not null,
    employee_id varchar(255),
    leave_type varchar(255),
    from_date DATE,
    to_date DATE,
    no_of_days int,
    comment varchar(255),
    status varchar(255),
    primary key (id)
);

create table el_leave_entitlement (
    id varchar(255) not null,
    employee_id varchar(255) not null,
    leave_type varchar(255) not null,
    year int,
    entitlement_days int,
    taken_days int,
    primary key(id)
);
