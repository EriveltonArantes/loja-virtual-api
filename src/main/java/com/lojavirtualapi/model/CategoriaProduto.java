package com.lojavirtualapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoriaprodutos")
public class CategoriaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String icone;
    private Boolean ativo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getIcone() { return icone; }
    public void setIcone(String icone) { this.icone = icone; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
