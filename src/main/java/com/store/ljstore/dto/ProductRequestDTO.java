package com.store.ljstore.dto;

public record ProductRequestDTO(
        String nome, double preco, String imgUrl, Integer quantidade, String descricao
) {}