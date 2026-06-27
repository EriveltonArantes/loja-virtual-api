package com.lojavirtualapi.dto;

public class PedidoResponseDTO {

    private Long id;
    private Long clienteId;
    private java.time.LocalDateTime dataHora;
    private String status;
    private Double valorTotal;
    private String formaPagamento;
    private String enderecoEntrega;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
