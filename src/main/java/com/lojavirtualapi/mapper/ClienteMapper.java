package com.lojavirtualapi.mapper;

import com.lojavirtualapi.dto.ClienteRequestDTO;
import com.lojavirtualapi.dto.ClienteResponseDTO;
import com.lojavirtualapi.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteRequestDTO dto);

    ClienteResponseDTO toResponseDTO(Cliente entity);
}
