package com.lojavirtualapi.dto;

public class CategoriaProdutoResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
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
