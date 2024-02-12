package com.aws.demo.response;

import java.util.List;
import java.util.Map;


public class ErrorResponse {
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Map<String, String>> getErros() {
		return erros;
	}
	public void setErros(List<Map<String, String>> erros) {
		this.erros = erros;
	}
	private String status; //400 - bad request
	private List<Map<String ,String>> erros; // campo // decricao
	
	private ErrorResponse (ErrorResponseBuilder builder) {
		this.erros = builder.erros;
		this.status = builder.status;
		
	}
	
	public static class ErrorResponseBuilder  {
		private String status;
		private List<Map<String ,String>> erros;
		
		public ErrorResponseBuilder setStatus (String status) {
			this.status = status;
			return this;
		}
		public ErrorResponseBuilder setErros (List<Map<String ,String>> erros) {
			this.erros = erros;
			return this;
		}
		public ErrorResponse build() {
			return new ErrorResponse(this);
		}
		
	}

}
