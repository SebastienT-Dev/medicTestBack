package fr.move.in.med.exceptions;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5773022406544992425L;

	private String code;

	private String message;

	public CustomException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
