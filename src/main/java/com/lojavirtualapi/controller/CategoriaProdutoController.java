package com.lojavirtualapi.controller;

import com.lojavirtualapi.dto.CategoriaProdutoRequestDTO;
import com.lojavirtualapi.dto.CategoriaProdutoResponseDTO;
import com.lojavirtualapi.service.CategoriaProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "CategoriaProduto", description = "Gerenciamento de categoriaprodutos")
@RestController
@RequestMapping("/api/categoriaprodutos")
public class CategoriaProdutoController {

    @Autowired
    private CategoriaProdutoService service;

    @Operation(summary = "Listar todos os CategoriaProduto")
    @GetMapping
    public List<CategoriaProdutoResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<CategoriaProdutoResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar CategoriaProduto por ID")
    @GetMapping("/{id}")
    public CategoriaProdutoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar CategoriaProduto")
    @PostMapping
    public ResponseEntity<CategoriaProdutoResponseDTO> criar(@Valid @RequestBody CategoriaProdutoRequestDTO categoriaProduto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(categoriaProduto));
    }

    @Operation(summary = "Atualizar CategoriaProduto")
    @PutMapping("/{id}")
    public CategoriaProdutoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody CategoriaProdutoRequestDTO categoriaProduto) {
        return service.atualizar(id, categoriaProduto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir CategoriaProduto")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
