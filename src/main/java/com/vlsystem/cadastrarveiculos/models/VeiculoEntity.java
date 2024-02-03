package com.vlsystem.cadastrarveiculos.models;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastrarveiculos.dto.VeiculoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "veiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	@Column(nullable = false)
	private String marca;
	@Column(nullable = false)
	private String modelo;
	@Column(nullable = false)
	private String ano;
	@Column(nullable = false)
	private String cor;
	@Column(nullable = false)
	private String placa;
	public VeiculoEntity(VeiculoDTO veiculo) {
		BeanUtils.copyProperties(veiculo, this);
	

	}
}
