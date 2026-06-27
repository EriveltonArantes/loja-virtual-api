package com.lojavirtualapi.mapper;

import com.lojavirtualapi.dto.CategoriaProdutoRequestDTO;
import com.lojavirtualapi.dto.CategoriaProdutoResponseDTO;
import com.lojavirtualapi.model.CategoriaProduto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaProdutoMapper {

    CategoriaProduto toEntity(CategoriaProdutoRequestDTO dto);

    CategoriaProdutoResponseDTO toResponseDTO(CategoriaProduto entity);
}
