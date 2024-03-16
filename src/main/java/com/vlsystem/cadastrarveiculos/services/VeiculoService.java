package com.vlsystem.cadastrarveiculos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlsystem.cadastrarveiculos.dto.VeiculoDTO;
import com.vlsystem.cadastrarveiculos.models.VeiculoEntity;
import com.vlsystem.cadastrarveiculos.repositorys.VeiculoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Service
public class VeiculoService {

	@Autowired
	private  VeiculoRepository veiculoRepository;


@Transactional
	public void adicionarVeiculo(VeiculoDTO veiculo)  {
		VeiculoEntity veiculoEntity = new VeiculoEntity(veiculo);
		veiculoRepository.save(veiculoEntity);

		}


	public List<VeiculoDTO> listarVeiculos() {
		List<VeiculoEntity> veiculos = veiculoRepository.findAll();
		return veiculos.stream().map(VeiculoDTO::new).toList();
	}

	public VeiculoDTO atualizarVeiculo(VeiculoDTO veiculo) {
		VeiculoEntity veiculoEntity = new VeiculoEntity(veiculo);
		return new VeiculoDTO(veiculoRepository.save(veiculoEntity));
	}

	public void excluirVeiculo(Long codigo) {
		VeiculoEntity veiculoEntity = veiculoRepository.findById(codigo).get();
		veiculoRepository.delete(veiculoEntity);





	}
}
