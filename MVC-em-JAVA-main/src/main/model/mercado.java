package com.apiestoque.conn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "mercado")
public class mercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mercado")
    private Long idMercado;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private endereco endereco;

    @Column(name = "nome_fantasia", unique = true, nullable = false)
    private String nomeFantasia;

    @Column(name = "cnpj", length = 20, nullable = false)
    private String cnpj;

    @Column(name = "razao_social", unique = true, nullable = false)
    private String razaoSocial;

    @Column(name = "whatsapp", unique = true)
    private String whatsapp;



    // Construtores

    public mercado() {
    }

    public mercado(Long idMercado, com.apiestoque.conn.model.endereco endereco, String nomeFantasia, String cnpj, String razaoSocial, String whatsapp) {
        this.idMercado = idMercado;
        this.endereco = endereco;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.whatsapp = whatsapp;
    }

    // Getters e Setters

    public Long getIdMercado() {
        return idMercado;
    }

    public void setIdMercado(Long idMercado) {
        this.idMercado = idMercado;
    }

    public endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(endereco endereco) {
        this.endereco = endereco;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }


}
