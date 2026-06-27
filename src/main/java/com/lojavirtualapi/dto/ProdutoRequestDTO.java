package com.lojavirtualapi.dto;

import jakarta.validation.constraints.*;

public class ProdutoRequestDTO {

    @NotNull(message = "CategoriaId é obrigatório")
    @Positive(message = "CategoriaId deve ser um ID válido (positivo)")
    private Long categoriaId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotBlank(message = "sku não pode estar em branco")
    private String sku;
    @DecimalMin(value = "0.0", message = "preco não pode ser negativo")
    @NotNull(message = "preco não pode ser nulo")
    private java.math.BigDecimal preco;
    @Min(value = 0, message = "estoque não pode ser negativo")
    @NotNull(message = "estoque não pode ser nulo")
    private Integer estoque;
    @Min(value = 0, message = "estoque minimo não pode ser negativo")
    @NotNull(message = "estoque minimo não pode ser nulo")
    private Integer estoqueMinimo;
    @NotBlank(message = "imagem url não pode estar em branco")
    private String imagemUrl;
    @NotNull(message = "ativo não pode ser nulo")
    private Boolean ativo;

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
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
