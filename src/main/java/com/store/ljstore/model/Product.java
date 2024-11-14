package com.store.ljstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer id;

    @Column(name = "nome") // nome da coluna no banco
    private String nome;

    @Column(name = "preco_unitario") // nome da coluna no banco
    private double precoUnitario;

    @Column(name = "imgUrl") // nome da coluna no banco
    private String imgUrl;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "descricao")
    private String descricao;

}