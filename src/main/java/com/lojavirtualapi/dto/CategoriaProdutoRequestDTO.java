package com.lojavirtualapi.dto;

import jakarta.validation.constraints.*;

public class CategoriaProdutoRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotBlank(message = "icone não pode estar em branco")
    private String icone;
    @NotNull(message = "ativo não pode ser nulo")
    private Boolean ativo;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getIcone() { return icone; }
    public void setIcone(String icone) { this.icone = icone; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
