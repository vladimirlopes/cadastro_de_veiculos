package com.vlsystem.cadastrarveiculos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vlsystem.cadastrarveiculos.dto.VeiculoDTO;
import com.vlsystem.cadastrarveiculos.services.VeiculoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	@Autowired
	private  VeiculoService veiculoService;
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getAllErrors().forEach((error) -> {
	            String fieldName = ((FieldError) error).getField();
	            String errorMessage = error.getDefaultMessage();
	            errors.put(fieldName, errorMessage);
	        });
	        return errors;
	    }


	@PostMapping("/cadastrar")
	public void cadastarVeiculo(@RequestBody  @Valid VeiculoDTO veiculo)  {
		veiculoService.adicionarVeiculo(veiculo);
	}
	@GetMapping
	public List<VeiculoDTO> listarVeiculos() {
		return veiculoService.listarVeiculos();
	}
	@PutMapping
	public VeiculoDTO atualizarCadastroDoVeiculo(@RequestBody @Valid VeiculoDTO veiculo) {
		return veiculoService.atualizarVeiculo(veiculo);
	}
	public ResponseEntity<Void> excluirVeiculo(@PathVariable Long codigo) {
		veiculoService.excluirVeiculo(codigo);
		return ResponseEntity.ok().build();
	}
}
