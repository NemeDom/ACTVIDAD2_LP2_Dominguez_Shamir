package com.examenT2.ACT2_Dominguez_Shamir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenT2.ACT2_Dominguez_Shamir.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	List<Producto> findAllByOrderByIdProductoDesc();
}
