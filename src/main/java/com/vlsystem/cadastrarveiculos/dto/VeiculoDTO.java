package com.vlsystem.cadastrarveiculos.dto;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastrarveiculos.models.VeiculoEntity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class VeiculoDTO {
	private UUID codigo;
	@NotBlank
	private String marca;
	@NotBlank
	private String modelo;
	@NotBlank
	private String ano;
	@NotBlank
	private String cor;
	@NotBlank
	private String placa;

	public VeiculoDTO() {
		
	}

	public VeiculoDTO(VeiculoEntity veiculoEntity) {
		BeanUtils.copyProperties(veiculoEntity, this);
	}

}
