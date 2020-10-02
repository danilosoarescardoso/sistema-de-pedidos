package br.com.danilocardoso.sistemadepedidos.services.exceptions;

public class DataIntegrityException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException() {
		
	}
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
