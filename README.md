/*Código para criar o banco de dados e a tabela*/
CREATE DATABASE IF NOT EXISTS desafio_tecnico();

CREATE TABLE IF NOT EXISTS produtos(
id_produto serial primary key,
nome_produto varchar(30),
preco_produto real,
quantidade int
);
