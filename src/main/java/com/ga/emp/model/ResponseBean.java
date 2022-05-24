package com.ga.emp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean success;

	private String message;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object data;

	private List<Errors> errors = new ArrayList<>();

	public ResponseBean() {
	}

	public ResponseBean(Boolean success, String message, List<Errors> errors) {

		this.success = success;
		this.message = message;
		this.errors = errors;
	}

	public ResponseBean(Boolean success, String message) {

		this.success = success;
		this.message = message;
	}

	public ResponseBean(Boolean success, String message, Object data, List<Errors> errors) {

		this.success = success;
		this.message = message;
		this.data = data;
		this.errors = errors;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<Errors> getErrors() {
		return errors;
	}

	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}

}
