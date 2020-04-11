package org.loose.fis.registration.example.controllers;

import org.loose.fis.registration.example.RegistrationView;
import org.loose.fis.registration.example.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.registration.example.services.UserService;

public class RegistrationController {
    private RegistrationView view;

    public RegistrationController(RegistrationView view) {
        this.view = view;
    }

    public boolean checkAvailability(String username, String password, String role) {
        try {
            UserService.addUser(username, password, role);
            return true;
        } catch (UsernameAlreadyExistsException e) {
            return false;
        }
    }
}
