package com.store.ljstore.controller;

import com.store.ljstore.dto.ProductRequestDTO;
import com.store.ljstore.model.Product;
import com.store.ljstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String listarProdutos(@RequestParam(defaultValue = "nome") String sortBy,  Model model) {
        List<Product> produtos;
        switch (sortBy){
            case "preco":
                produtos = productRepository.findAllByOrderByPrecoAsc();
                break;
            case "nome":
                produtos = productRepository.findAllByOrderByNomeAsc();
                break;
            default:
                produtos = productRepository.findAllByOrderByNomeAsc();
        }

        model.addAttribute("produtos", produtos);
        model.addAttribute("sortby" ,sortBy);
        return "home";
    }

    @ResponseBody
    @GetMapping("/api/produtos")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = this.productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @ResponseBody
    @GetMapping("/api/produtos/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        return ResponseEntity.ok(product);
    }

    @ResponseBody
    @PostMapping("/api/produtos")
    public ResponseEntity<Product> save(@RequestBody ProductRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }
        Product produto = new Product();
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setImgUrl(dto.imgUrl());

        this.productRepository.save(produto);
        return ResponseEntity.ok(produto);
    }
}