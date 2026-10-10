package com.examenT2.ACT2_Dominguez_Shamir.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.ACT2_Dominguez_Shamir.model.Producto;
import com.examenT2.ACT2_Dominguez_Shamir.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

	private final ProductoRepository productoRepository;
	
	public List<Producto> getAll(){
		return productoRepository.findAll();
	}
	
}
