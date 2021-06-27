package com.beadinventory.beadinventory.ProgramManagers.Windows;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BeadPane extends JPanel {

    private JPanel panel;

    public BeadPane(){
        setVisible(true);
        this.panel = new JPanel();
        panel.setVisible(true);
        //choose new layout
        panel.setLayout(new GridLayout(15,1));

        JLabel chooseType = new JLabel("Bead Inventory:\n");
        panel.add(chooseType);
        add(panel);
    }


}
