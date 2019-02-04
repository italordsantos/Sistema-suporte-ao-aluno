create table tabela_login(

    vcsiape varchar (50) not null,
    vcusuario varchar (100) not null,
    vcsenha varchar (50) not null,
    foreign key (vcsiape) references tabela_usuario(vcsiape),
    primary key (vcusuario, vcsiape)
);