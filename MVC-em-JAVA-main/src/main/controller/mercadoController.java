package com.apiestoque.conn.controller;

import com.apiestoque.conn.model.mercado;
import com.apiestoque.conn.service.mercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mercados")
public class mercadoController {

    @Autowired
    private mercadoService mercadoService;

    @GetMapping
    public List<mercado> getAllMercados() {
        return (List<mercado>) mercadoService.findAllMercados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<mercado> getMercadoById(@PathVariable Long id) {
        mercado mercado = mercadoService.findMercadoById(id).orElse(null);
        return mercado != null ? ResponseEntity.ok(mercado) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<mercado> addMercado(@RequestBody mercado mercado) {
        mercado novoMercado = mercadoService.saveMercado(mercado);
        return ResponseEntity.ok(novoMercado);
    }

    @PostMapping("/{id}")
    public ResponseEntity<mercado> updateMercado(@PathVariable Long id, @RequestBody mercado novoMercado) {
        return mercadoService.findMercadoById(id)
                .map(existingMercado -> {
                    existingMercado.setNomeFantasia(novoMercado.getNomeFantasia());
                    existingMercado.setCnpj(novoMercado.getCnpj());
                    existingMercado.setRazaoSocial(novoMercado.getRazaoSocial());
                    existingMercado.setWhatsapp(novoMercado.getWhatsapp());
                    existingMercado.setEndereco(novoMercado.getEndereco());

                    mercadoService.saveMercado(existingMercado);
                    return ResponseEntity.ok(existingMercado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMercado(@PathVariable Long id) {
        if (mercadoService.mercadoExistsById(id)) {
            mercadoService.deleteMercadoById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
