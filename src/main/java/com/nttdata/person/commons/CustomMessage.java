package com.nttdata.person.commons;

public enum CustomMessage implements ValueObject<CustomMessage>{
	
	ERR_APPLICATION_ERROR("1012.An internal error has occurred in the application");

	private String value;

	private CustomMessage(String value) {
		this.value = value;
	}

	public String getValue() {
		return value.substring(0, 4);
	}

	@Override
	public String toString() {

		return value.substring(5);
	}

	@Override
	public boolean sameValueAs(CustomMessage other) {
		// TODO Auto-generated method stub
		return false;
	}

}
