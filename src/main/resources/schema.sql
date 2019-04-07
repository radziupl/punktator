drop table if exists POINTS;

create table POINTS(
	id identity,
	name varchar(140),
	description varchar(140),
	latitude double,
	longitude double
);