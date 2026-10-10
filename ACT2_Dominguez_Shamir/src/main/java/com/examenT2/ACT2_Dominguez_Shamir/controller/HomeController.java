package com.examenT2.ACT2_Dominguez_Shamir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "redirect:/inventario/listado";
	}
}
