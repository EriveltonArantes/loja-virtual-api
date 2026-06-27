package com.lojavirtualapi.controller;

import com.lojavirtualapi.model.CategoriaProduto;
import com.lojavirtualapi.model.Produto;
import com.lojavirtualapi.model.Cliente;
import com.lojavirtualapi.model.Pedido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.lojavirtualapi.repository.CategoriaProdutoRepository categoriaProdutoRepository;

    @Autowired
    private com.lojavirtualapi.repository.ProdutoRepository produtoRepository;

    @Autowired
    private com.lojavirtualapi.repository.ClienteRepository clienteRepository;

    @Autowired
    private com.lojavirtualapi.repository.PedidoRepository pedidoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalCategoriaProduto", categoriaProdutoRepository.count());
        resumo.put("totalProduto", produtoRepository.count());
        resumo.put("somaPrecoProduto", produtoRepository.findAll().stream().map(e -> e.getPreco()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("totalCliente", clienteRepository.count());
        resumo.put("totalPedido", pedidoRepository.count());
        resumo.put("somaValorTotalPedido", pedidoRepository.findAll().stream().filter(e -> e.getValorTotal() != null).mapToDouble(e -> e.getValorTotal()).sum());
        resumo.put("graficoPedido", pedidoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
