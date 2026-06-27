package com.lojavirtualapi.service;

import com.lojavirtualapi.dto.PedidoRequestDTO;
import com.lojavirtualapi.dto.PedidoResponseDTO;
import com.lojavirtualapi.exception.ResourceNotFoundException;
import com.lojavirtualapi.mapper.PedidoMapper;
import com.lojavirtualapi.model.Pedido;
import com.lojavirtualapi.repository.PedidoRepository;
import com.lojavirtualapi.repository.ClienteRepository;
import com.lojavirtualapi.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PedidoMapper mapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<PedidoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PedidoResponseDTO buscar(Long id) {
        Pedido entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public PedidoResponseDTO criar(PedidoRequestDTO dto) {
        Pedido entity = mapper.toEntity(dto);
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + dto.getClienteId()));
        entity.setCliente(cliente);
        Pedido salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public PedidoResponseDTO atualizar(Long id, PedidoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Pedido não encontrado com id: " + id);
        }
        Pedido entity = mapper.toEntity(dto);
        entity.setId(id);
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + dto.getClienteId()));
        entity.setCliente(cliente);
        Pedido salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Pedido não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
