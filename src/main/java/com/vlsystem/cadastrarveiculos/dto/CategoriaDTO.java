package com.vlsystem.cadastrarveiculos.dto;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastrarveiculos.models.CategoriaEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {
	private Long id;

	private String nome;
	
	public CategoriaDTO() {
		
	}

	public CategoriaDTO(CategoriaEntity categoriaEntity) {
		BeanUtils.copyProperties(categoriaEntity, this);

	}
}
