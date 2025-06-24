package com.apiestoque.conn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.apiestoque.conn.model.produto;
import com.apiestoque.conn.service.produtoService;

@RestController
@RequestMapping("/api/produtos")
public class produtoController {

    @Autowired
    private produtoService produtoService;

    @GetMapping
    public List<produto> getAllProdutos() {
        return (List<produto>) produtoService.findAllProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<produto> getProdutoById(@PathVariable Long id) {
        produto produto = produtoService.findProdutoById(id).orElse(null);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<produto> addProduto(@RequestBody produto produto) {
        produto novoProduto = produtoService.saveProduto(produto);
        return ResponseEntity.ok(novoProduto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<produto> updateProduto(@PathVariable Long id, @RequestBody produto novoProduto) {
        return produtoService.findProdutoById(id)
                .map(existingProduto -> {
                    existingProduto.setNomeProduto(novoProduto.getNomeProduto());
                    existingProduto.setCodigoBarras(novoProduto.getCodigoBarras());
                    existingProduto.setDescricao(novoProduto.getDescricao());
                    existingProduto.setPrecoUnitario(novoProduto.getPrecoUnitario());
                    existingProduto.setCategoria(novoProduto.getCategoria());

                    produtoService.saveProduto(existingProduto);
                    return ResponseEntity.ok(existingProduto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        if (produtoService.produtoExistsById(id)) {
            produtoService.deleteProdutoById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
