-- H2

-- drop table if exists points;
-- drop table if exists mapsettings;
--
-- create table points(
-- 	id bigint auto_increment,
-- 	name varchar(200),
-- 	description varchar(1000),
-- 	latitude double,
-- 	longitude double
--
-- );
--
-- create table mapsettings(
-- 	id bigint auto_increment,
-- 	title varchar(100),
-- 	latitude double,
-- 	longitude double,
-- 	zoom integer
-- );

-- MYSQL

create table points(
	id int auto_increment,
	name varchar(200),
	description varchar(1000),
	latitude double,
	longitude double,
    PRIMARY KEY (id)
);


create table mapsettings(
	id int auto_increment,
	title varchar(100),
	latitude double,
	longitude double,
	zoom int,
    PRIMARY KEY (id)
);