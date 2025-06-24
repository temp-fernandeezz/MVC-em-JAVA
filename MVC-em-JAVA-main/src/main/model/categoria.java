package com.apiestoque.conn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    @Column(name = "nome_categoria")
    private String nomeCategoria;

    @Column(name = "descricao_categoria")
    private String descricaoCategoria;

    private String setor;

    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private estoque estoque;

    // Construtores

    public categoria() {
    }

    public categoria(Long idCategoria, String nomeCategoria, String descricaoCategoria, String setor, estoque estoque) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.descricaoCategoria = descricaoCategoria;
        this.setor = setor;
        this.estoque = estoque;
    }

    // Getters e Setters

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(estoque estoque) {
        this.estoque = estoque;
    }
}
