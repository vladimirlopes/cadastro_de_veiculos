package com.vlsystem.cadastrarveiculos.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastrarveiculos.dto.CategoriaDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_categoria")

public class CategoriaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_categoria")
	private UUID id;
	@NotBlank(message = "campo não informado")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "Primeira letra do nome deve ser maiúscula")
	private String nome;

	// uma categoria possui varios veiculos,ao excluir a categoria ,exclui tambem os veiculos
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private List<VeiculoEntity> veiculos = new ArrayList<>();
	public CategoriaEntity() {
		
	}

	public CategoriaEntity(CategoriaDTO categoria) {
		BeanUtils.copyProperties(categoria, this);

	}

}
