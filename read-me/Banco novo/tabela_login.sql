-- drop table tabela_login_1;
create table tabela_login(
	seid serial unique,
	vcsiape varchar (50) not null,
	vcusuario varchar (100) not null unique,
	vcsenha varchar (50) not null,
	foreign key (seid) references tabela_usuario(seid),
	primary key (vcusuario, seid)
);