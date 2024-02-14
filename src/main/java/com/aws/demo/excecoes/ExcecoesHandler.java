package com.aws.demo.excecoes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aws.demo.response.ErrorResponse;
import com.aws.demo.response.ErrorResponse.ErrorResponseBuilder;

@ControllerAdvice
public class ExcecoesHandler {
	
	@ExceptionHandler(NaoPermitirExcluirException.class)
	public ResponseEntity<ErrorResponse> naoPermitirExcluirExceptionHandler (NaoPermitirExcluirException ex){
		
		Map<String, String> response = new HashMap<>();
		response.put("codigo", ErrosEnum.NAO_PERMITIDO_EXCLUIR.toString());
		response.put("mensagem", "Nao permitido excluir uma tarefa com o status diferente de CRIADA");
		
		ErrorResponseBuilder errorResponseBuilder = new ErrorResponseBuilder();
		errorResponseBuilder.setErros(Collections.singletonList(response));
		errorResponseBuilder.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.toString());
		
		;
		
		return new ResponseEntity<>(errorResponseBuilder.build() ,HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
