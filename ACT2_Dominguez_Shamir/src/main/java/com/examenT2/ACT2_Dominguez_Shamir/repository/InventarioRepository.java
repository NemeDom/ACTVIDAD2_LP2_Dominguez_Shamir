package com.examenT2.ACT2_Dominguez_Shamir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenT2.ACT2_Dominguez_Shamir.model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Integer>{

	List<Inventario> findAllByOrderByNumeroInventarioDesc();
}
