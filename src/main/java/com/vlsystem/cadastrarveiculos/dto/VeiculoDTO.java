package com.vlsystem.cadastrarveiculos.dto;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastrarveiculos.models.VeiculoEntity;

import lombok.Data;

@Data
public class VeiculoDTO {
	private Long id;
	
	private String caminhao;
	
	private String carro;
	
	private String van;
	
	private String suv;
	
	private String caminhonete;
	
	private String moto;
	public VeiculoDTO(VeiculoEntity veiculoEntity) {
		
		BeanUtils.copyProperties(veiculoEntity, this);
	}

}
