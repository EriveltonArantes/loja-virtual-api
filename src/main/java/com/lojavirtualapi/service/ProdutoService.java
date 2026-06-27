package com.lojavirtualapi.service;

import com.lojavirtualapi.dto.ProdutoRequestDTO;
import com.lojavirtualapi.dto.ProdutoResponseDTO;
import com.lojavirtualapi.exception.ResourceNotFoundException;
import com.lojavirtualapi.mapper.ProdutoMapper;
import com.lojavirtualapi.model.Produto;
import com.lojavirtualapi.repository.ProdutoRepository;
import com.lojavirtualapi.repository.CategoriaProdutoRepository;
import com.lojavirtualapi.model.CategoriaProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoMapper mapper;

    @Autowired
    private CategoriaProdutoRepository categoriaRepository;

    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProdutoResponseDTO buscar(Long id) {
        Produto entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ProdutoResponseDTO criar(ProdutoRequestDTO dto) {
        Produto entity = mapper.toEntity(dto);
        CategoriaProduto categoria = categoriaRepository.findById(dto.getCategoriaId())
            .orElseThrow(() -> new ResourceNotFoundException("CategoriaProduto não encontrado com id: " + dto.getCategoriaId()));
        entity.setCategoria(categoria);
        Produto salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado com id: " + id);
        }
        Produto entity = mapper.toEntity(dto);
        entity.setId(id);
        CategoriaProduto categoria = categoriaRepository.findById(dto.getCategoriaId())
            .orElseThrow(() -> new ResourceNotFoundException("CategoriaProduto não encontrado com id: " + dto.getCategoriaId()));
        entity.setCategoria(categoria);
        Produto salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
