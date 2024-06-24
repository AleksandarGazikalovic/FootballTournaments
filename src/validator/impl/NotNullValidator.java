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
public class NotNullValidator implements Validator {

    @Override
    public void validate(Object value) throws Exception {
        if (value == null) {
            throw new Exception("Field can't be empty!");
        }
        String text = String.valueOf(value);
        if (text.length() == 0) {
            throw new Exception("Field can't be empty!");
        }
    }

}
