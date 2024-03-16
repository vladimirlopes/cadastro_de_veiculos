package com.vlsystem.cadastrarveiculos.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlsystem.cadastrarveiculos.models.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, UUID> {


}
