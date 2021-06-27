package com.beadinventory.beadinventory.ProgramManagers.Windows;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {

    Toolkit toolkit;

    public Window(){
        this.toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        setSize(new Dimension(size.width/2, size.height/2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(20,20);
        setResizable(true);
    }


    public void addPanel(JPanel panel) {

        getContentPane().add(panel);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            Window window = new Window();
            window.setTitle("Main Inventory Page");
            window.addPanel(new MainWindowPane());
        });
    }

}
/*
public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            Window window = new Window();
            window.setTitle("Casino");
            window.setBackground(Color.WHITE);
            window.addPanel(new SignInPane());
        });
    }
 */