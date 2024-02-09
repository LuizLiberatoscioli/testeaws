package com.aws.demo.validation;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;
import jakarta.validation.ConstraintViolation;

@ControllerAdvice
public class ValidacaoCamposHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> tratarValidacoes(MethodArgumentNotValidException ex) {
		ex.getBindingResult()
		.getFieldError()
		.stream()
		.map(erro -> {
			Map<String ,String> erros = new HashMap<>();

		}).collect(Collectors.toList());

	}

	// pegar o nome do campo da exception
	private String obterNomePropriedade(final FieldError error) {

		if (error.contains(ConstraintViolation.class)) {
			try {
				final ConstraintViolation<?> violacao = error.unwrap(ConstraintViolation.class);
				final Field campo;

				campo = violacao.getRootBeanClass().getDeclaredField(error.getField());

				final JsonProperty anotacao = campo.getAnnotation(JsonProperty.class);

				if (anotacao != null && anotacao.value() != null && anotacao.value().isEmpty()) {
					return anotacao.value();

				}

			} catch (Exception e) {
			}
			return error.getField();
		}
		return null;
		
	}

}
