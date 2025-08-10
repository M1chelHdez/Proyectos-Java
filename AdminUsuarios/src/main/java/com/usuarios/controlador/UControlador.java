package com.usuarios.controlador;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.entidad.Usuario;
import com.usuarios.servicios.UServicio;

@RestController
public class UControlador {

	private UServicio servicio;

	public UControlador(UServicio servicio) {
		this.servicio = servicio;
	}
	

	@GetMapping("/agregar")
	public String addForm() {
		return "agregar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model m) {
		Usuario e = servicio.getById(id);
		m.addAttribute("emp", e);
		return "editar";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Usuario e) {
		servicio.addEmp(e);
		return "redirect:/";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute Usuario e) {
		servicio.addEmp(e);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id) {
		servicio.delete(id);
		return "redirect:/";
	}

	@GetMapping(value = "/")
	public String findPaginated(@RequestParam Map<String, Object> params, Model model) {
		int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
		PageRequest pageRequest = PageRequest.of(page, 10);
		Page<Usuario> pagePersona = servicio.getByPaginate(pageRequest);
		int totalPage = pagePersona.getTotalPages();
		if (totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		model.addAttribute("emp", pagePersona.getContent());
		model.addAttribute("current", page + 1);
		model.addAttribute("next", page + 2);
		model.addAttribute("prev", page);
		model.addAttribute("last", totalPage);
		return "index";
	}
}
