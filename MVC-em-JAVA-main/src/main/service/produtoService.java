package com.apiestoque.conn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.apiestoque.conn.model.produto;
import com.apiestoque.conn.repository.produtoRepository;

@Service
public class produtoService {

    private final produtoRepository produtoRepository;

    @Autowired
    public produtoService(produtoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public produto saveProduto(produto produto) {
        return produtoRepository.save(produto);
    }

    public Iterable<produto> saveAllProdutos(Iterable<produto> produtos) {
        return produtoRepository.saveAll(produtos);
    }

    public Optional<produto> findProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public boolean produtoExistsById(Long id) {
        return produtoRepository.existsById(id);
    }

    public Iterable<produto> findAllProdutos() {
        return produtoRepository.findAll();
    }

    public Iterable<produto> findAllProdutosById(Iterable<Long> ids) {
        return produtoRepository.findAllById(ids);
    }

    public long countProdutos() {
        return produtoRepository.count();
    }

    public void deleteProdutoById(Long id) {
        produtoRepository.deleteById(id);
    }

    public void deleteProduto(produto produto) {
        produtoRepository.delete(produto);
    }

    public void deleteAllProdutosById(Iterable<Long> ids) {
        produtoRepository.deleteAllById(ids);
    }

    public void deleteAllProdutos(Iterable<produto> produtos) {
        produtoRepository.deleteAll(produtos);
    }

    public void deleteAllProdutos() {
        produtoRepository.deleteAll();
    }
}