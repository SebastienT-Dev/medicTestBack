package fr.move.in.med.status;

public class RestApiStatus {

	private String code;

	private String messsage;

	public RestApiStatus(String code, String messsage) {
		this.code = code;
		this.messsage = messsage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

}
