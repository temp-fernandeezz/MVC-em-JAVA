package com.apiestoque.conn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.apiestoque.conn.model.estoque;
import com.apiestoque.conn.repository.estoqueRepository;

@Service
public class estoqueService {

    private final estoqueRepository estoqueRepository;

    @Autowired
    public estoqueService(estoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public estoque saveEstoque(estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public Iterable<estoque> saveAllEstoques(Iterable<estoque> estoques) {
        return estoqueRepository.saveAll(estoques);
    }

    public Optional<estoque> findEstoqueById(Long id) {
        return estoqueRepository.findById(id);
    }

    public boolean estoqueExistsById(Long id) {
        return estoqueRepository.existsById(id);
    }

    public Iterable<estoque> findAllEstoques() {
        return estoqueRepository.findAll();
    }

    public Iterable<estoque> findAllEstoquesById(Iterable<Long> ids) {
        return estoqueRepository.findAllById(ids);
    }

    public long countEstoques() {
        return estoqueRepository.count();
    }

    public void deleteEstoqueById(Long id) {
        estoqueRepository.deleteById(id);
    }

    public void deleteEstoque(estoque estoque) {
        estoqueRepository.delete(estoque);
    }

    public void deleteAllEstoquesById(Iterable<Long> ids) {
        estoqueRepository.deleteAllById(ids);
    }

    public void deleteAllEstoques(Iterable<estoque> estoques) {
        estoqueRepository.deleteAll(estoques);
    }

    public void deleteAllEstoques() {
        estoqueRepository.deleteAll();
    }
}
