package com.vlsystem.cadastrarveiculos.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlsystem.cadastrarveiculos.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
