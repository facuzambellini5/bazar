package com.example.bazar.repositories;

import com.example.bazar.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {

    List<Venta> findByFechaVenta(LocalDate fechaVenta);

    List<Venta> findByFechaVentaBetween(LocalDate fechaInicio, LocalDate fechaFin);

    Venta findFirstByOrderByTotalDesc();
}
