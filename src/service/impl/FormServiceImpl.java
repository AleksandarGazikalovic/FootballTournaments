/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import service.FormService;
import components.IView;

/**
 *
 * @author Gazi
 */
public class FormServiceImpl implements FormService{ 
    
    private List<IView> openedForms;
    private JPanel activePanel;

    public FormServiceImpl() {
        this.openedForms = new ArrayList<>();
    }
   
    @Override
    public void addForm(IView form) {
        openedForms.add(form);
        form.updateView();
    }

    @Override
    public void removeForm(IView form) {
        openedForms.remove(form);
    }

    @Override
    public void setActivePanel(JPanel panel) {
        this.activePanel = panel;
        for (IView openedForm : openedForms) {
            openedForm.updateView();
        }
    }

    @Override
    public JPanel getActivePanel() {
        return activePanel;
    }


}
