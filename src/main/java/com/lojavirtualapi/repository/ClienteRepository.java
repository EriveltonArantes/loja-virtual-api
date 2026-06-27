package com.lojavirtualapi.repository;

import com.lojavirtualapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
