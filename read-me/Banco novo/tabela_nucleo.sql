 drop table tabela_nucleo;
create table tabela_nucleo(
	seid serial unique,
	vcnome varchar(100) not null unique,
	primary key (seid, vcnome)
);