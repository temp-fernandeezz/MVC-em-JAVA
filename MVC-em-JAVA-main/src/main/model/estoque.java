package com.apiestoque.conn.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "estoque")
public class estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque")
    private Long idEstoque;

    @ManyToOne
    @JoinColumn(name = "id_mercado")
    private mercado mercado;

    @Column(name = "status", nullable = false)
    private String status;

    private String localizacao;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    // Construtores

    public estoque() {
    }

    public estoque(Long idEstoque, mercado mercado, String status, String localizacao, LocalDateTime dataInicio) {
        this.idEstoque = idEstoque;
        this.mercado = mercado;
        this.status = status;
        this.localizacao = localizacao;
        this.dataInicio = dataInicio;
    }

    // Getters e Setters

    public Long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public mercado getMercado() {
        return mercado;
    }

    public void setMercado(mercado mercado) {
        this.mercado = mercado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }
}
