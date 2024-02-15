package com.aws.demo.excecoes;

public class TarefaExistenteException extends RuntimeException {
	
	public TarefaExistenteException() {
		super();
	}
	
	public TarefaExistenteException(String mensagem) {
		super(mensagem);
	}

}
