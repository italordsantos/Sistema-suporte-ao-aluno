-- drop table tabela_login;
-- drop table tabela_usuario;

create table tabela_usuario(
	seid serial unique,
	vcnome varchar (100) not null,
	vccidade varchar (60),
	vcuf varchar (2),
	vcbairro varchar (100),
	vcendereco varchar (100),
	vcnumerocasa varchar (10),
	vcsiape varchar (50) not null unique,
	vcdatanascimento varchar (11),
	vccelular varchar (16) not null,
	vctelefone varchar (16),
	vccpf varchar (15),
	vcrg varchar (20),
	vcsituacao varchar (20),
	vcemail varchar (100) not null,
	vcinformacoesadicionais text,
	vcsexo varchar (10) not null,
	vcnucleo varchar (100) not null,
	busuarioativo boolean default true,
	primary key (seid, vcsiape),
	foreign key (vcnucleo) references tabela_nucleo(vcnome)
);