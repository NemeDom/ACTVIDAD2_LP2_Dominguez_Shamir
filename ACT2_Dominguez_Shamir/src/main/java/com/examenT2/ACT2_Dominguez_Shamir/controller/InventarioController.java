package com.examenT2.ACT2_Dominguez_Shamir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.ACT2_Dominguez_Shamir.model.Inventario;
import com.examenT2.ACT2_Dominguez_Shamir.model.Producto;
import com.examenT2.ACT2_Dominguez_Shamir.service.InventarioService;
import com.examenT2.ACT2_Dominguez_Shamir.service.ProductoService;
import com.examenT2.ACT2_Dominguez_Shamir.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("inventario")
public class InventarioController {

	private final InventarioService inventarioService;
	
	private final ProductoService productoService;
	
	@GetMapping("listado")
	public String listado(Model model) {

		model.addAttribute("lstInventario",inventarioService.getAll());
		return "inventario/listado";
	}
	
	@GetMapping("nuevo")
	public String create(Model model) {
		
		
		model.addAttribute("inventario", new Inventario());
		model.addAttribute("lstProductos", productoService.getAll());
		return "inventario/nuevo";
	}
	
	@PostMapping("registrar")
	public String registrar(@ModelAttribute Inventario inventario,RedirectAttributes flash) {
		
		var response = inventarioService.create(inventario);
		
	var alert = Alert.sweetToast(response.mensaje(), "success", 5000);
		
		flash.addFlashAttribute("alert",alert);
		
		return "redirect:/inventario/listado";
	}
	
	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {
		
		model.addAttribute("inventario",inventarioService.getOne(id));
		model.addAttribute("lstProductos", productoService.getAll());
		return "inventario/edicion";
	}
	
	
	@PostMapping("guardar")
	public String guardar(@ModelAttribute Inventario inventario,RedirectAttributes flash) {
		
		var response = inventarioService.update(inventario);
		
	var alert = Alert.sweetToast(response.mensaje(), "success", 5000);
		
		flash.addFlashAttribute("alert",alert);
		
		return "redirect:/inventario/listado";
	}
	
}
