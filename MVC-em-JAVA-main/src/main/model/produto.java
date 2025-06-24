package com.apiestoque.conn.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    private String nomeProduto;

    private String codigoBarras;

    private String descricao;

    private BigDecimal precoUnitario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private categoria categoria;

    // Construtores

    public produto() {
    }

    public produto(Long idProduto, String nomeProduto, String codigoBarras, String descricao, BigDecimal precoUnitario, categoria categoria) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.codigoBarras = codigoBarras;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.categoria = categoria;
    }

    // Getters e Setters

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(categoria categoria) {
        this.categoria = categoria;
    }
}
