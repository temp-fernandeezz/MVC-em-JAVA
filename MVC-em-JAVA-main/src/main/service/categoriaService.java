package com.apiestoque.conn.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.apiestoque.conn.repository.categoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.apiestoque.conn.model.categoria;


@Service
public class categoriaService {

    private final categoriaRepository categoriaRepository;

    @Autowired
    public categoriaService(categoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public categoria saveCategoria(categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Iterable<categoria> saveAllCategorias(Iterable<categoria> categorias) {
        return categoriaRepository.saveAll(categorias);
    }

    public Optional<categoria> findCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    public boolean categoriaExistsById(Long id) {
        return categoriaRepository.existsById(id);
    }

    public Iterable<categoria> findAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Iterable<categoria> findAllCategoriasById(Iterable<Long> ids) {
        return categoriaRepository.findAllById(ids);
    }

    public long countCategorias() {
        return categoriaRepository.count();
    }

    public void deleteCategoriaById(Long id) {
        categoriaRepository.deleteById(id);
    }

    public void deleteCategoria(categoria categoria) {
        categoriaRepository.delete(categoria);
    }

    public void deleteAllCategoriasById(Iterable<Long> ids) {
        categoriaRepository.deleteAllById(ids);
    }

    public void deleteAllCategorias(Iterable<categoria> categorias) {
        categoriaRepository.deleteAll(categorias);
    }

    public void deleteAllCategorias() {
        categoriaRepository.deleteAll();
    }
}
