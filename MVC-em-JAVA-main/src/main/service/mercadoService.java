package com.apiestoque.conn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.apiestoque.conn.model.mercado;
import com.apiestoque.conn.repository.mercadoRepository;

@Service
public class mercadoService {

    private final mercadoRepository mercadoRepository;

    @Autowired
    public mercadoService(mercadoRepository mercadoRepository) {
        this.mercadoRepository = mercadoRepository;
    }

    public mercado saveMercado(mercado mercado) {
        return mercadoRepository.save(mercado);
    }

    public Iterable<mercado> saveAllMercados(Iterable<mercado> mercados) {
        return mercadoRepository.saveAll(mercados);
    }

    public Optional<mercado> findMercadoById(Long id) {
        return mercadoRepository.findById(id);
    }

    public boolean mercadoExistsById(Long id) {
        return mercadoRepository.existsById(id);
    }

    public Iterable<mercado> findAllMercados() {
        return mercadoRepository.findAll();
    }

    public Iterable<mercado> findAllMercadosById(Iterable<Long> ids) {
        return mercadoRepository.findAllById(ids);
    }

    public long countMercados() {
        return mercadoRepository.count();
    }

    public void deleteMercadoById(Long id) {
        mercadoRepository.deleteById(id);
    }

    public void deleteMercado(mercado mercado) {
        mercadoRepository.delete(mercado);
    }

    public void deleteAllMercadosById(Iterable<Long> ids) {
        mercadoRepository.deleteAllById(ids);
    }

    public void deleteAllMercados(Iterable<mercado> mercados) {
        mercadoRepository.deleteAll(mercados);
    }

    public void deleteAllMercados() {
        mercadoRepository.deleteAll();
    }
}
