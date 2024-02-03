package com.vlsystem.cadastrarveiculos.dto;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastrarveiculos.models.CategoriaEntity;

import lombok.Data;

@Data
public class CategoriaDTO {
	private Long id;

	private String caminhao;
	
	private String carro;
	
	private String van;
	
	private String suv;
	
	private String caminhonete;
	
	private String moto;
	
	public CategoriaDTO(CategoriaEntity categoriaEntity) {
		BeanUtils.copyProperties(categoriaEntity, this);

	}
}
