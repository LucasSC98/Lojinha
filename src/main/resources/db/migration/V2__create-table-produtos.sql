create table produtos (
    item_id int primary key auto_increment,
    nome varchar(255) not null,
    descricao text,
    preco_unitario decimal(10,2) not null,
    quantidade int not null,
    desconto decimal(10,2) default 0,
    data_criacao timestamp default current_timestamp,
    data_atualizacao timestamp default current_timestamp
);