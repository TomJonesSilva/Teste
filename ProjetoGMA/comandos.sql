
#codigo atualizado 
#quem ja tiver criado o banco executa o seguinte codigo : drop database gma;
#e depois so executar o codigo abaixo
create database gma;

use gma;

create table usuario (
	id integer primary key auto_increment,
	senha varchar(30) not null,
	email varchar(30) not null unique,
	nick varchar(30) not null unique,
	telefone varchar(15)
);

create table jogador (
	id_usuario integer primary key,
	nick varchar(30),
	id_ficha integer,
	id_mesa integer,
	Resumo varchar(300),
	habilidades varchar(100)
);

create table mesa (
	id integer primary key auto_increment,
	mestre varchar(30),
	jogadores varchar(30),
	avisos varchar(1000),
	privacidade boolean
    
);

create table bag (
	id_jogador integer primary key,
	id_mesa integer,
	bag varchar(500)
);

create table avisos_sessao (
	id_mesa integer primary key,
	horario datetime not null,
    nick_jogador varchar(30),
	aviso varchar(500)
);

create table ficha (
	id integer primary key auto_increment,
    id_jogador integer,
    ficha varchar(1000)
);

alter table jogador 
add foreign key(id_usuario)references usuario(id),
add foreign key(nick)references usuario(nick),
add foreign key(id_ficha)references ficha(id),
add foreign key(id_mesa)references mesa(id);

alter table mesa 
add foreign key(mestre)references jogador(nick),
add foreign key(jogadores)references jogador(nick);

alter table bag
add foreign key(id_jogador)references jogador(id_usuario),
add foreign key(id_mesa)references mesa(id);

alter table avisos_sessao
add foreign key(id_mesa)references mesa(id),
add foreign key(nick_jogador)references jogador(nick);

alter table ficha 
add foreign key(id_jogador)references jogador(id_usuario);


