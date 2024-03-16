package com.vlsystem.cadastrarveiculos.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlsystem.cadastrarveiculos.dto.CategoriaDTO;
import com.vlsystem.cadastrarveiculos.models.CategoriaEntity;
import com.vlsystem.cadastrarveiculos.repositorys.CategoriaRepository;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class CategoriaService {

	@Autowired
	private CategoriaRepository cr;

	public CategoriaService(CategoriaRepository cr) {
		this.cr = cr;
	}
	@Transactional
	public void adicionarCategoria(CategoriaDTO categoria) {

		CategoriaEntity categoriaEntity = new CategoriaEntity(categoria);
		cr.save(categoriaEntity);
	}

	public List<CategoriaDTO> listarCategorias() {
		List<CategoriaEntity> categoria = cr.findAll();
		return categoria.stream().map(CategoriaDTO::new).toList();
	}

	public CategoriaDTO atualizarCategoria(CategoriaDTO categoria) {
		CategoriaEntity categoriaEntity = new CategoriaEntity(categoria);
		return new CategoriaDTO(cr.save(categoriaEntity));
	}

	public void excluirCategoria(UUID id) {
		CategoriaEntity categoriaEntity = cr.findById(id).get();
		cr.delete(categoriaEntity);
	}
}
