package com.apiestoque.conn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.apiestoque.conn.model.endereco;
import com.apiestoque.conn.repository.enderecoRepository;

@Service
public class enderecoService {

    private final enderecoRepository enderecoRepository;

    @Autowired
    public enderecoService(enderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public endereco saveEndereco(endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Iterable<endereco> saveAllEnderecos(Iterable<endereco> enderecos) {
        return enderecoRepository.saveAll(enderecos);
    }

    public Optional<endereco> findEnderecoById(Long id) {
        return enderecoRepository.findById(id);
    }

    public boolean enderecoExistsById(Long id) {
        return enderecoRepository.existsById(id);
    }

    public Iterable<endereco> findAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Iterable<endereco> findAllEnderecosById(Iterable<Long> ids) {
        return enderecoRepository.findAllById(ids);
    }

    public long countEnderecos() {
        return enderecoRepository.count();
    }

    public void deleteEnderecoById(Long id) {
        enderecoRepository.deleteById(id);
    }

    public void deleteEndereco(endereco endereco) {
        enderecoRepository.delete(endereco);
    }

    public void deleteAllEnderecosById(Iterable<Long> ids) {
        enderecoRepository.deleteAllById(ids);
    }

    public void deleteAllEnderecos(Iterable<endereco> enderecos) {
        enderecoRepository.deleteAll(enderecos);
    }

    public void deleteAllEnderecos() {
        enderecoRepository.deleteAll();
    }
}
