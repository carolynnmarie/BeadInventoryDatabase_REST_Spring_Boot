package com.beadinventory.beadinventory.ProgramManagers.Windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class MainPane extends JPanel {

    private JPanel panel;
    private JButton button;

    public MainPane(){
        setVisible(true);
        ActionListener listener = new chooseInventoryType();
        this.panel = new JPanel();
        panel.setVisible(true);
        panel.setLayout(new GridLayout(15,1));

        JLabel chooseType = new JLabel("Which type of inventory would you like to go to?");
        panel.add(chooseType);
        JLabel supplies = new JLabel("Supplies");
        panel.add(supplies);

        ArrayList<String> supplyTypes = new ArrayList(Arrays.asList("Beads","Findings","Cording, Wire, and Chains"));
        for(String each: supplyTypes){
            this.button = new JButton(each);
            button.addActionListener(listener);
            panel.add(button);
        }

        JLabel finishedItems = new JLabel("Finished Products");
        panel.add(finishedItems);

        ArrayList<String> finishedTypes = new ArrayList(Arrays.asList("Necklaces","Earrings","Bracelets","Bookmarks",
                "Napkin Ring Sets","Wine Charm Sets"));
        for(String each: finishedTypes){
            button = new JButton(each);
            button.addActionListener(listener);
            panel.add(button);
        }

        add(panel);

    }


    private class chooseInventoryType implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            String choice = e.getActionCommand();
            JPanel inventoryChosen = (choice.equals("Beads"))? new BeadPane() :
                    (choice.equals("Findings"))? new FindingsPane():
                    (choice.equals("Cording, Wire, and Chains"))? new StringWirePane():
                    (choice.equals("Necklace"))? new NecklacePane():
                    (choice.equals("Earrings"))? new EarringsPane():
                    (choice.equals("Bracelets"))? new BraceletPane():
                    (choice.equals("Bookmarks"))? new BookmarkPane():
                    (choice.equals("Napkin Ring Sets"))? new NapkinRingPane():
                    new WineCharmPane();
            getParent().add(inventoryChosen);

//more code here, you are not finished this method yet
        }
    }
}

