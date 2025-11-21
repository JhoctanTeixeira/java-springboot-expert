package io.github.sbexpert.produtosapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.sbexpert.produtosapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    List<Produto> findByNome(String nome);
}
