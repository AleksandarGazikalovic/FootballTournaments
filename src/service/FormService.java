/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import service.FormService;
import components.IView;

/**
 *
 * @author Gazi
 */
public class FormService { 
    
    private List<IView> openedForms;
    private JPanel activePanel;

    public FormService() {
        this.openedForms = new ArrayList<>();
    }
   
    public void addForm(IView form) {
        openedForms.add(form);
        form.updateView();
    }

    
    public void removeForm(IView form) {
        openedForms.remove(form);
    }

    
    public void setActivePanel(JPanel panel) {
        this.activePanel = panel;
        for (IView openedForm : openedForms) {
            openedForm.updateView();
        }
    }

    
    public JPanel getActivePanel() {
        return activePanel;
    }


}
