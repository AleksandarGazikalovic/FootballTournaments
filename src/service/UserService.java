/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domain.Administrator;
import dto.DTO;

/**
 *
 * @author Gazi
 */
public interface UserService {
    DTO login(Administrator administrator);
}
