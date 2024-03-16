package com.vlsystem.cadastrarveiculos.models;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastrarveiculos.dto.VeiculoDTO;
import com.vlsystem.cadastrarveiculos.validacao.constrains.Placa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
@Entity
@Table(name = "tb_veiculo")

public class VeiculoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	@NotBlank(message = "campo não informado")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
	private String marca;
	@NotBlank(message = "campo não informado")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
	private String modelo;
	@NotBlank(message = "campo não informado")
	@Min(value = 1900)
	private String ano;
	@NotBlank(message = "campo não informado")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
	private String cor;
	@NotBlank(message = "campo não informado ou invalido")
	@Placa
	private String placa;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoriaEntity categoria;
	
	public VeiculoEntity() {
		
	}

	public VeiculoEntity(VeiculoDTO veiculo) {
		BeanUtils.copyProperties(veiculo, this);

	}
}
