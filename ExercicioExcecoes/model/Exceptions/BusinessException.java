package model.Exceptions;

public class BusinessException extends RuntimeException{
	  
	private static final long serialVersionUID = 1L;

	public BusinessException(String msg) { //throw foi armazenado aqui 
		super(msg);
	}
}
