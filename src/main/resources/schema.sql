drop table if exists POINTS;
drop table if exists MAPSETTINGS;

create table POINTS(
	id bigint auto_increment,
	name varchar(140),
	description varchar(140),
	latitude double,
	longitude double

);

create table MAPSETTINGS(
	id bigint auto_increment,
	title varchar(140),
	latitude double,
	longitude double,
	zoom integer
);