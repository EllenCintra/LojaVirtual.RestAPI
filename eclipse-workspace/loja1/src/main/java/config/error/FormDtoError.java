package config.error;

public class FormDtoError {
	
	private String field;
	private String error;
	
	public FormDtoError(String campo, String erro) {
		this.field = campo;
		this.error = erro;
	}

	public String getCampo() {
		return field;
	}

	public String getErro() {
		return error;
	}


}
