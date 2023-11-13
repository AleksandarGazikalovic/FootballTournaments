/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator.impl;

import validator.Validator;

/**
 *
 * @author Gazi
 */
public class PasswordValidator implements Validator{

    @Override
    public void validate(Object value) throws Exception {
        String password = value.toString();
        if (password.length() < 3) {
            throw new Exception("Šifra mora da sadrži više od 3 znaka.");
        }
    }
    
}
