package com.example.bazar.repositories;

import com.example.bazar.models.VentaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaProductoRepository extends JpaRepository<VentaProducto, Long> {
}
