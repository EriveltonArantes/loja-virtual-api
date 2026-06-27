package com.lojavirtualapi.repository;

import com.lojavirtualapi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
