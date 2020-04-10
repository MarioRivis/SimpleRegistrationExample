package org.loose.fis.registration.example.controllers;

import org.loose.fis.registration.example.RegistrationView;
import org.loose.fis.registration.example.exceptions.UsernameAlreadyExists;
import org.loose.fis.registration.example.services.UserService;

public class RegistrationController {
	private RegistrationView view;
	
	public RegistrationController(RegistrationView view){
        this.view = view;
	}
	
	public boolean checkAvailibility(String username, String password, String role) {
		try {
            UserService.addUser(username, password, role);
            return true;
        } catch (UsernameAlreadyExists e) {
            return false;
        }
	}
}
