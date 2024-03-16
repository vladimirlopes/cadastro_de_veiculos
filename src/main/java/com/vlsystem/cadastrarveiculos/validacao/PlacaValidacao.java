package com.vlsystem.cadastrarveiculos.validacao;

import com.vlsystem.cadastrarveiculos.validacao.constrains.Placa;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaValidacao implements ConstraintValidator<Placa, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String placa = value == null ?"" : value;
		return placa.matches("[a-zA-Z]{3}[0-9][A-Za-z0-9][0-9]{2}|[a-zA-Z]{3}[0-9]{4}");
	}

}
