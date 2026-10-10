package com.examenT2.ACT2_Dominguez_Shamir.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.ACT2_Dominguez_Shamir.dto.ResultadoResponse;
import com.examenT2.ACT2_Dominguez_Shamir.model.Inventario;
import com.examenT2.ACT2_Dominguez_Shamir.repository.InventarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioService {

	private final InventarioRepository inventarioRepository;
	
	public List<Inventario> getAll() {
		return inventarioRepository.findAllByOrderByNumeroInventarioDesc();
	}
	
	public ResultadoResponse create(Inventario inventario) {
		
		
		try {
			
			var registrado = inventarioRepository.save(inventario);
			
			var mensaje = String.format("Producto con Numero %d registrado", registrado.getNumeroInventario());
			
			return new ResultadoResponse(true, mensaje);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transaccion");
		}
	}
	
	public Inventario getOne(Integer id) {
		return inventarioRepository.findById(id).orElse(null);
	}
	
public ResultadoResponse update(Inventario inventario) {
		
		
		try {
			
			var registrado = inventarioRepository.save(inventario);
			
			var mensaje = String.format("Producto con Numero %d actualizado", registrado.getNumeroInventario());
			
			return new ResultadoResponse(true, mensaje);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transaccion");
		}
	}
}
	

