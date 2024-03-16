package com.vlsystem.cadastrarveiculos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.vlsystem.cadastrarveiculos.dto.CategoriaDTO;
import com.vlsystem.cadastrarveiculos.services.CategoriaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	private  CategoriaService cs;
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

	public void cadastarCategoria(@RequestBody @Valid CategoriaDTO categoria) {
		cs.adicionarCategoria(categoria);

	}

	@GetMapping
	public List<CategoriaDTO> listarCategorias() {
		return cs.listarCategorias();

	}

	@PutMapping
	public CategoriaDTO atualizarCategoria(@RequestBody @Valid CategoriaDTO categoria) {
		return cs.atualizarCategoria(categoria);

	}

	public ResponseEntity<Void> excluirCategoria(@PathVariable UUID id) {
		cs.excluirCategoria(id);
		return ResponseEntity.ok().build();

	}
}



