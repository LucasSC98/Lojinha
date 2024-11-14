create table usuarios (
    usuario_id int primary key auto_increment,
    nome_completo varchar(80) not null,
    email varchar(255) unique not null,
    genero enum('masculino', 'feminino', 'outro'),
    data_cadastro timestamp default current_timestamp,
    pais varchar(40),
    cidade varchar(60),
    endereco varchar(225)
);