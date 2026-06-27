package com.lojavirtualapi.mapper;

import com.lojavirtualapi.dto.PedidoRequestDTO;
import com.lojavirtualapi.dto.PedidoResponseDTO;
import com.lojavirtualapi.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(target = "cliente", ignore = true)
    Pedido toEntity(PedidoRequestDTO dto);

    @Mapping(target = "clienteId", source = "cliente.id")
    PedidoResponseDTO toResponseDTO(Pedido entity);
}
