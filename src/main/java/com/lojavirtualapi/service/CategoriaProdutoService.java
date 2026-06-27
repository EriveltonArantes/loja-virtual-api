package com.lojavirtualapi.service;

import com.lojavirtualapi.dto.CategoriaProdutoRequestDTO;
import com.lojavirtualapi.dto.CategoriaProdutoResponseDTO;
import com.lojavirtualapi.exception.ResourceNotFoundException;
import com.lojavirtualapi.mapper.CategoriaProdutoMapper;
import com.lojavirtualapi.model.CategoriaProduto;
import com.lojavirtualapi.repository.CategoriaProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoriaProdutoService {

    @Autowired
    private CategoriaProdutoRepository repository;

    @Autowired
    private CategoriaProdutoMapper mapper;

    @Transactional(readOnly = true)
    public List<CategoriaProdutoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoriaProdutoResponseDTO buscar(Long id) {
        CategoriaProduto entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("CategoriaProduto não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public CategoriaProdutoResponseDTO criar(CategoriaProdutoRequestDTO dto) {
        CategoriaProduto entity = mapper.toEntity(dto);
        CategoriaProduto salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public CategoriaProdutoResponseDTO atualizar(Long id, CategoriaProdutoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("CategoriaProduto não encontrado com id: " + id);
        }
        CategoriaProduto entity = mapper.toEntity(dto);
        entity.setId(id);
        CategoriaProduto salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("CategoriaProduto não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
