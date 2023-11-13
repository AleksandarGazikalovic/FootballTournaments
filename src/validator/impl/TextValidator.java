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
public class TextValidator implements Validator{

    @Override
    public void validate(Object value) throws Exception {
        String text = value.toString();
        if (text.length() < 3) {
            throw new Exception("Ime mora da sadrzi vise od 3 karaktera.");
        }
    }
    
}
