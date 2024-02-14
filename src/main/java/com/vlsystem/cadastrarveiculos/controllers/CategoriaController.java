package com.vlsystem.cadastrarveiculos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlsystem.cadastrarveiculos.dto.CategoriaDTO;
import com.vlsystem.cadastrarveiculos.services.CategoriaService;

@RestController
@RequestMapping("/cadastrar_categoria")
public class CategoriaController {
	@Autowired
	CategoriaService cs;

	@PostMapping
	
	public void cadastarCategoria(@RequestBody CategoriaDTO categoria) {
		cs.adicionarCategoria(categoria);

	}

	@GetMapping
	public List<CategoriaDTO> listarCategorias() {
		return cs.listarCategorias();

	}

	@PutMapping
	public CategoriaDTO atualizarCategoria(@RequestBody CategoriaDTO categoria) {
		return cs.atualizarCategoria(categoria);

	}

	public ResponseEntity<Void> excluirCategoria(@PathVariable Long id) {
		cs.excluirCategoria(id);
		return ResponseEntity.ok().build();

	}
}



