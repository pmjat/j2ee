package pmj.mvcdemo.controller;

import java.util.ArrayList;

public class ActionError {
	public void addError(Exception e) {
		errors.add(e);
	}
	public ArrayList<Exception> getErrors() {
		return errors;
	}	
	ArrayList<Exception> errors = new ArrayList<>();
}
