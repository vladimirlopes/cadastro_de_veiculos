package com.vlsystem.cadastrarveiculos.validacao.constrains;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.vlsystem.cadastrarveiculos.validacao.PlacaValidacao;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = PlacaValidacao.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Placa {
	 String message() default "Placa de carro inválida";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};


}
