package com.apiestoque.conn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.apiestoque.conn.model.categoria;
import com.apiestoque.conn.service.categoriaService;

@RestController
@RequestMapping("/api/categorias")
public class categoriaController {

    @Autowired
    private categoriaService categoriaService;

    @GetMapping
    public List<categoria> getAllCategorias() {
        return (List<categoria>) categoriaService.findAllCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<categoria> getCategoriaById(@PathVariable Long id) {
        categoria categoria = categoriaService.findCategoriaById(id).orElse(null);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<categoria> addCategoria(@RequestBody categoria categoria) {
        categoria novaCategoria = categoriaService.saveCategoria(categoria);
        return ResponseEntity.ok(novaCategoria);
    }

    @PostMapping("/{id}")
    public ResponseEntity<categoria> updateCategoria(@PathVariable Long id, @RequestBody categoria novaCategoria) {
        return categoriaService.findCategoriaById(id)
                .map(existingCategoria -> {
                    existingCategoria.setNomeCategoria(novaCategoria.getNomeCategoria());
                    existingCategoria.setDescricaoCategoria(novaCategoria.getDescricaoCategoria());
                    existingCategoria.setSetor(novaCategoria.getSetor());

                    categoriaService.saveCategoria(existingCategoria);
                    return ResponseEntity.ok(existingCategoria);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        if (categoriaService.categoriaExistsById(id)) {
            categoriaService.deleteCategoriaById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
