package com.apiestoque.conn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.apiestoque.conn.model.estoque;
import com.apiestoque.conn.service.estoqueService;

@RestController
@RequestMapping("/api/estoques")
public class estoqueController {

    @Autowired
    private estoqueService estoqueService;

    @GetMapping
    public List<estoque> getAllEstoques() {
        return (List<estoque>) estoqueService.findAllEstoques();
    }

    @GetMapping("/{id}")
    public ResponseEntity<estoque> getEstoqueById(@PathVariable Long id) {
        estoque estoque = estoqueService.findEstoqueById(id).orElse(null);
        return estoque != null ? ResponseEntity.ok(estoque) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<estoque> addEstoque(@RequestBody estoque estoque) {
        estoque novoEstoque = estoqueService.saveEstoque(estoque);
        return ResponseEntity.ok(novoEstoque);
    }

    @PostMapping("/{id}")
    public ResponseEntity<estoque> updateEstoque(@PathVariable Long id, @RequestBody estoque novoEstoque) {
        return estoqueService.findEstoqueById(id)
                .map(existingEstoque -> {
                    existingEstoque.setStatus(novoEstoque.getStatus());
                    existingEstoque.setLocalizacao(novoEstoque.getLocalizacao());
                    existingEstoque.setDataInicio(novoEstoque.getDataInicio());
                    existingEstoque.setMercado(novoEstoque.getMercado());

                    estoqueService.saveEstoque(existingEstoque);
                    return ResponseEntity.ok(existingEstoque);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstoque(@PathVariable Long id) {
        if (estoqueService.estoqueExistsById(id)) {
            estoqueService.deleteEstoqueById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
