package com.beadinventory.beadinventory.ProgramManagers.Windows;

import com.beadinventory.beadinventory.REST.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material.AMETHYST;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Shape;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Shape.ROUND;
import com.beadinventory.beadinventory.REST.Repository.SuppliesRepos.BeadRepo;
import com.beadinventory.beadinventory.REST.Service.SuppliesServices.BeadService;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

//Problem One: Null Pointer Exception on controller

public class BeadPane extends JPanel {


    private BeadController beadController;
    private BeadService beadService;
    private BeadRepo repo;
    private JPanel panel;
    private JTable beadTable;
    private JButton createButton;
    private JLabel searchMaterialLabel;
    private JComboBox<Material> searchMaterialDropDown;
    private JLabel searchLessThanLbl;
    private JTextField lessThanSearch;
    private DefaultTableModel defaultModel;

    @Autowired
    public BeadPane(){
        this.beadService = new BeadService(repo);
        this.beadController = new BeadController(beadService);
//        Bead bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20, "translucent purple", 0.2, "Beadalon");
//        beadController.createBead(bead1);
        setVisible(true);
        this.panel = new JPanel();
        panel.setVisible(true);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;


        JLabel beadInventory = new JLabel("Bead Inventory:\n");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        panel.add(beadInventory, constraints);

        this.createButton = new JButton("Create New Bead");
        createButton.addActionListener(new CreateBead());
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(createButton, constraints);

        this.searchMaterialLabel = new JLabel("Search by Material");
        constraints.weightx = 0.5;
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(searchMaterialLabel, constraints);

        this.searchMaterialDropDown = new JComboBox<>(Material.values());
        searchMaterialDropDown.addActionListener(new SearchByMaterial());
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(searchMaterialDropDown, constraints);

        this.searchLessThanLbl = new JLabel("Search all less than quantity:");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(searchLessThanLbl, constraints);

        this.lessThanSearch = new JTextField(5);
        lessThanSearch.addActionListener(new SearchLessThan());
        constraints.weightx = 0.5;
        constraints.gridx = 5;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(lessThanSearch,constraints);

        this.beadTable = new JTable();
        String [] columnNames = new String [] {"Material","Color","Shape","Size mm","Quality","Quantity","Description",
        "Price Point","Brand"};
        defaultModel = new DefaultTableModel(columnNames, 0);
        beadTable.setModel(defaultModel);
        beadTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        beadTable.setFillsViewportHeight(true);
        JScrollPane scrollTable = new JScrollPane(beadTable);
        scrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        populateTable();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 6;
        panel.add(scrollTable, constraints);

        add(panel);
    }

//Issue:getting null pointer exception on beadController.findAllBeads.
//Problem is not H2, I checked on Postman
    public void populateTable() {
//        List<Bead> beadList = beadController.findAllBeads();
//        for (Bead bead : beadList) {
//            String[] beadAsArray = bead.toArray();
//            defaultModel.addRow(beadAsArray);
//        }
        Bead bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20, "translucent purple", 0.2, "Beadalon");
        String[] beadAsArray = bead1.toArray();
        defaultModel.addRow(beadAsArray);

    }



//IMPLEMENT
    //make a new screen popup
    private class CreateBead implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

//Implement
    //made a drop down list
    private class SearchByMaterial implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){

        }
    }

//Implement
    //made a search box
    private class SearchLessThan implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){

        }
    }

}
