package com.beadinventory.beadinventory.ProgramManagers.Windows;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {

    static JPanel panel;
    static JLabel label;

    public MainWindow(){
        //setSize
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.label = new JLabel();
        label.setVisible(true);
        label.setBackground(Color.WHITE);

        this.panel = new JPanel();
        //setBounds

        Container container = getContentPane();
        container.add(label);
        container.add(panel);
        container.setVisible(true);
        label.setVisible(true);
        panel.setVisible(true);
    }


}
