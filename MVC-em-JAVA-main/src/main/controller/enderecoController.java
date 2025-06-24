package com.apiestoque.conn.controller;

import com.apiestoque.conn.model.endereco;
import com.apiestoque.conn.service.enderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class enderecoController {

    @Autowired
    private enderecoService enderecoService;

    @GetMapping
    public List<endereco> getAllEnderecos() {
        return (List<endereco>) enderecoService.findAllEnderecos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<endereco> getEnderecoById(@PathVariable Long id) {
        endereco endereco = enderecoService.findEnderecoById(id).orElse(null);
        return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<endereco> addEndereco(@RequestBody endereco endereco) {
        endereco novoEndereco = enderecoService.saveEndereco(endereco);
        return ResponseEntity.ok(novoEndereco);
    }

    @PostMapping("/{id}")
    public ResponseEntity<endereco> updateEndereco(@PathVariable Long id, @RequestBody endereco novoEndereco) {
        return enderecoService.findEnderecoById(id)
                .map(existingEndereco -> {
                    existingEndereco.setLogradouro(novoEndereco.getLogradouro());
                    existingEndereco.setNumero(novoEndereco.getNumero());
                    existingEndereco.setComplemento(novoEndereco.getComplemento());
                    existingEndereco.setCidade(novoEndereco.getCidade());
                    existingEndereco.setEstado(novoEndereco.getEstado());
                    existingEndereco.setCep(novoEndereco.getCep());

                    enderecoService.saveEndereco(existingEndereco);
                    return ResponseEntity.ok(existingEndereco);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        if (enderecoService.enderecoExistsById(id)) {
            enderecoService.deleteEnderecoById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
