package com.vlsystem.cadastrarveiculos.dto;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastrarveiculos.models.VeiculoEntity;

import lombok.Data;

@Data
public class VeiculoDTO {
	private Long codigo;
	
	private String marca;
	
	private String modelo;
	
	private String ano;
	
	private String cor;
	
	private String placa;
	
	
	public VeiculoDTO(VeiculoEntity veiculoEntity) {
		
		BeanUtils.copyProperties(veiculoEntity, this);
	}

}
