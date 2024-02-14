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

import com.vlsystem.cadastrarveiculos.dto.VeiculoDTO;
import com.vlsystem.cadastrarveiculos.services.VeiculoService;

@RestController
@RequestMapping("/cadastrar_veiculo")
public class VeiculoController {
	@Autowired
	VeiculoService vs;

	@PostMapping
	
	public void cadastarVeiculo(@RequestBody VeiculoDTO veiculo) {
		vs.adicionarVeiculo(veiculo);

	}

	@GetMapping
	public List<VeiculoDTO> listarVeiculos() {
		return vs.listarVeiculos();

	}

	@PutMapping
	public VeiculoDTO atualizarCadastroDoVeiculo(@RequestBody VeiculoDTO veiculo) {
		return vs.atualizarVeiculo(veiculo);

	}

	public ResponseEntity<Void> excluirVeiculo(@PathVariable Long codigo) {
		vs.excluirVeiculo(codigo);
		return ResponseEntity.ok().build();

	}
}
