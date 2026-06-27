package com.lojavirtualapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaProduto categoria;
    @Column(nullable = false)
    private String nome;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String sku;
    private java.math.BigDecimal preco;
    private Integer estoque;
    private Integer estoqueMinimo;
    @Column(nullable = false)
    private String imagemUrl;
    private Boolean ativo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public CategoriaProduto getCategoria() { return categoria; }
    public void setCategoria(CategoriaProduto categoria) { this.categoria = categoria; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public java.math.BigDecimal getPreco() { return preco; }
    public void setPreco(java.math.BigDecimal preco) { this.preco = preco; }
    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }
    public Integer getEstoqueMinimo() { return estoqueMinimo; }
    public void setEstoqueMinimo(Integer estoqueMinimo) { this.estoqueMinimo = estoqueMinimo; }
    public String getImagemUrl() { return imagemUrl; }
    public void setImagemUrl(String imagemUrl) { this.imagemUrl = imagemUrl; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
