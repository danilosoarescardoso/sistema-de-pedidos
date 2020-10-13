package br.com.danilocardoso.sistemadepedidos.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	
	private static final long serialVersionUID = 1L;
	
	
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(int value, String message, long currentTimeMillis) {
		super(value, message, currentTimeMillis);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void setList(List<FieldMessage> list) {
		this.errors = list;
	}
	
	public void AddError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
		
	}
	
}
