package com.examenT2.ACT2_Dominguez_Shamir.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examenT2.ACT2_Dominguez_Shamir.service.ProductoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("producto")
public class ProductoController {

	private final ProductoService productoService;
	
	@GetMapping("listado")
	public String listado(Model model) {

		model.addAttribute("lstProductos",productoService.getAll());
		return "producto/listado";
	}
}
