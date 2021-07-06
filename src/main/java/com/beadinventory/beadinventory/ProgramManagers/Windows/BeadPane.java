package com.beadinventory.beadinventory.ProgramManagers.Windows;

import com.beadinventory.beadinventory.REST.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Shape;
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

public class BeadPane extends JPanel {

    @Autowired
    private BeadController beadController;
    @Autowired
    private BeadService beadService;
    private JPanel panel;
    private JTable beadTable;
    private JButton createButton;
    private JButton searchMaterialButton;
    private DefaultTableModel defaultModel;

    public BeadPane(){
        this.beadController = new BeadController(beadService);
        setVisible(true);
        this.panel = new JPanel();
        panel.setVisible(true);

        JLabel beadInventory = new JLabel("Bead Inventory:\n");
        panel.add(beadInventory);

        this.beadTable = new JTable();
        defaultModel = new DefaultTableModel();
//        populateTable();
        beadTable.setModel(defaultModel);
        beadTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        beadTable.setFillsViewportHeight(true);
        JScrollPane scrollTable = new JScrollPane(beadTable);
        scrollTable.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollTable);

        this.createButton = new JButton("Create New Bead");
        createButton.addActionListener(new CreateBead());
        panel.add(createButton);

        this.searchMaterialButton = new JButton("Search by Material");
        searchMaterialButton.addActionListener(new SearchByMaterial());
        panel.add(searchMaterialButton);

        add(panel);
    }

//Issue:getting null pointer exception on beadController.findAllBeads.
//data-h2.sql not seeding db upon startup of SpringBoot program. Switch to MySQL
//    public void populateTable(){
//        List<Bead> beadList = beadController.findAllBeads();
//        ArrayList<String> beadString = new ArrayList<>();
//        for(Bead bead: beadList){
//            defaultModel.addRow(new Bead[]{bead});
//OR, IF THAT DOESN'T WORK AS I WANT, try changing bead to String [] and add that to defaultModel row
//            long id = bead.getBeadId();
//            String idString = String.valueOf(id);
//            beadString.add(idString);
//            String matString = bead.getMaterial().toString();
//            beadString.add(matString);
//            etc.
//        }
//    }


//IMPLEMENT
    private class CreateBead implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

//Implement
    private class SearchByMaterial implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){

        }
    }

}
