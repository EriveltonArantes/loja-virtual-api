package com.lojavirtualapi.dto;

import jakarta.validation.constraints.*;

public class PedidoRequestDTO {

    @NotNull(message = "ClienteId é obrigatório")
    @Positive(message = "ClienteId deve ser um ID válido (positivo)")
    private Long clienteId;
    @FutureOrPresent(message = "data hora não pode ser retroativo")
    @NotNull(message = "data hora não pode ser nulo")
    private java.time.LocalDateTime dataHora;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @DecimalMin(value = "0.0", message = "valor total não pode ser negativo")
    @NotNull(message = "valor total não pode ser nulo")
    private Double valorTotal;
    @NotBlank(message = "forma pagamento não pode estar em branco")
    private String formaPagamento;
    @NotBlank(message = "endereco entrega não pode estar em branco")
    private String enderecoEntrega;

    private String observacoes;

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public java.time.LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(java.time.LocalDateTime dataHora) { this.dataHora = dataHora; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
    public String getEnderecoEntrega() { return enderecoEntrega; }
    public void setEnderecoEntrega(String enderecoEntrega) { this.enderecoEntrega = enderecoEntrega; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
