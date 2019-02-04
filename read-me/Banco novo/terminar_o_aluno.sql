﻿create table tabela_responsavel (
     sNome varchar (100),
     sCelular varchar (16),
     sTelefone varchar (16),
     sMatriculaDoFilho varchar (50) primary key
);

create table tabela_aluno (
     sNome varchar (100),
     sCidade varchar (60),
     sBairro varchar (60),
     sMatricula  varchar (50) primary key,
     sCurso varchar (100),
     sDataNascimento varchar (11),
     sCelular varchar (16),
     sTelefone varchar (16),
     sCpf varchar (15),
     sRg varchar (20),
     sSituacao varchar (20),
     sEmail varchar (100),
     sNecessidadesEspecificas boolean default false,
     sInformacoesAdicionais varchar (8000),
     sSexo varchar (10),
     sUf varchar (2),
     sNumerocasa varchar (5),
     sEndereco varchar (50),
     arMResponsavel varchar (50),
     foreign key (arMResponsavel) references tabela_responsavel(sMatriculaDoFilho)

);