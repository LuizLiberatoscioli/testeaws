package com.aws.demo.validation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aws.demo.response.ErrorResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.ConstraintViolation;

@ControllerAdvice
public class ValidacaoCamposHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> tratarValidacoes(MethodArgumentNotValidException ex) {
	    List<Map<String, String>> listaErros = ex.getBindingResult()
	            .getFieldErrors()
	            .stream()
	            .map(erro -> {
	                Map<String, String> erros = new HashMap<>();
	                erros.put("Campo", erro.getField()); // Adicione o nome da propriedade corretamente
	                erros.put("Descricao", erro.getDefaultMessage());
	                return erros; // Retorne o mapa de erros
	            })
	            .collect(Collectors.toList()); // Coleta os mapas em uma lista

	    ErrorResponse response = new ErrorResponse.ErrorResponseBuilder()
	            .setStatus(HttpStatus.BAD_REQUEST.toString())
	            .setErros(listaErros)
	            .build();

	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
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
			
		}
		return error.getField();
		
	}

} 
