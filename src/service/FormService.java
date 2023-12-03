/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import javax.swing.JPanel;
import components.IView;

/**
 *
 * @author Gazi
 */
public interface FormService {
    void addForm(IView form);
    void removeForm(IView form);
    void setActivePanel(JPanel panel);
    JPanel getActivePanel();
}
