package com.beadinventory.beadinventory.ProgramManagers.Windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainWindowPane extends JPanel {

    private JPanel panel;

    private JButton beadButton;
    private JButton findingsButton;
    private JButton sWButton;
    private JButton bookmarkButton;
    private JButton braceletButton;
    private JButton earringsButton;
    private JButton napkinRingsButton;
    private JButton necklaceButton;
    private JButton wineCharmButton;

    public MainWindowPane(){
        setVisible(true);
        ActionListener listener = new chooseInventoryType();
        this.panel = new JPanel();
        panel.setVisible(true);
        panel.setLayout(new GridLayout(15,1));

        JLabel chooseType = new JLabel("Which type of inventory would you like to go to?");
        panel.add(chooseType);
        JLabel supplies = new JLabel("Supplies");
        panel.add(supplies);

        this.beadButton = new JButton("Beads");
        beadButton.addActionListener(listener);
        panel.add(beadButton);

        this.findingsButton = new JButton("Findings");
        findingsButton.addActionListener(listener);
        panel.add(findingsButton);

        this.sWButton = new JButton("Cording, Wire, and Chains");
        sWButton.addActionListener(listener);
        panel.add(sWButton);

        JLabel finishedItems = new JLabel("Finished Products");
        panel.add(finishedItems);

        this.necklaceButton = new JButton("Necklaces");
        necklaceButton.addActionListener(listener);
        panel.add(necklaceButton);

        this.earringsButton = new JButton("Earrings");
        earringsButton.addActionListener(listener);
        panel.add(earringsButton);

        this.braceletButton = new JButton("Bracelets");
        braceletButton.addActionListener(listener);
        panel.add(braceletButton);

        this.bookmarkButton = new JButton("Bookmarks");
        bookmarkButton.addActionListener(listener);
        panel.add(bookmarkButton);

        this.napkinRingsButton = new JButton("Napkin Ring Sets");
        napkinRingsButton.addActionListener(listener);
        panel.add(napkinRingsButton);

        this.wineCharmButton = new JButton("Wine Charm Sets");
        wineCharmButton.addActionListener(listener);
        panel.add(wineCharmButton);

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

/*
private class chooseGame implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            String gameChoice = e.getActionCommand();
            while(gameChoice.equals("blackjack")||gameChoice.equals("go fish")||gameChoice.equals("war")) {
                Game game = GameFactory.goToGame(gameChoice, player);
                game.start();
            }
        }
    }
 */