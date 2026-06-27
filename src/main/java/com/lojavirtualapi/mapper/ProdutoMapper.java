package com.lojavirtualapi.mapper;

import com.lojavirtualapi.dto.ProdutoRequestDTO;
import com.lojavirtualapi.dto.ProdutoResponseDTO;
import com.lojavirtualapi.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(target = "categoria", ignore = true)
    Produto toEntity(ProdutoRequestDTO dto);

    @Mapping(target = "categoriaId", source = "categoria.id")
    ProdutoResponseDTO toResponseDTO(Produto entity);
}
