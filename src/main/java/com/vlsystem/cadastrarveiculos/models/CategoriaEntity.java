package com.vlsystem.cadastrarveiculos.models;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastrarveiculos.dto.CategoriaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name ="categoria")
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String caminhao;
	@Column(nullable = false)
	private String carro;
	@Column(nullable = false)
	private String van;
	@Column(nullable = false)
	private String suv;
	@Column(nullable = false)
	private String caminhonete;
	@Column(nullable = false)
	private String moto;
	//uma categoria possui varios veiculos
	@JoinColumn(name = "id_categoria")
	@OneToMany
	private List<VeiculoEntity>veiculos;
	
	public CategoriaEntity(CategoriaDTO categoria) {
		BeanUtils.copyProperties(categoria, this);

	}

}
