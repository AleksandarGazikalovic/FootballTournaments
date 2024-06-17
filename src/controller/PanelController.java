/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Gazi
 */
public class PanelController {

    private static PanelController instance;
    private JPanel container;

    private PanelController() {
    }

    public static PanelController getInstance() {
        if (instance == null) {
            instance = new PanelController();
        }
        return instance;
    }

    public JPanel getContainer() {
        return container;
    }

    public void setContainer(JPanel aContainer) {
        container = aContainer;
    }

    public void updatePanel(String panelName) {
        CardLayout cardLayout = (CardLayout) container.getLayout();
        cardLayout.show(container, panelName);
    }

}
