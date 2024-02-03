package com.vlsystem.cadastrarveiculos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlsystem.cadastrarveiculos.dto.VeiculoDTO;
import com.vlsystem.cadastrarveiculos.models.VeiculoEntity;
import com.vlsystem.cadastrarveiculos.repositorys.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	VeiculoRepository vr;

	public void adicionarVeiculo(VeiculoDTO veiculo) {

		VeiculoEntity veiculoEntity = new VeiculoEntity(veiculo);
		vr.save(veiculoEntity);

	}

	public List<VeiculoDTO> listarVeiculos() {
		List<VeiculoEntity> veiculos = vr.findAll();
		return veiculos.stream().map(VeiculoDTO::new).toList();

	}

	public VeiculoDTO atualizarVeiculo(VeiculoDTO veiculo) {
		VeiculoEntity veiculoEntity = new VeiculoEntity(veiculo);
		return new VeiculoDTO(vr.save(veiculoEntity));

	}

	public void excluirVeiculo(Long codigo) {
		VeiculoEntity veiculoEntity = vr.findById(codigo).get();
		vr.delete(veiculoEntity);

	}
}
