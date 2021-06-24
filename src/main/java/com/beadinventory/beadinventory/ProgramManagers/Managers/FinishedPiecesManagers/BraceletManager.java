package com.beadinventory.beadinventory.ProgramManagers.Managers.FinishedPiecesManagers;

import com.beadinventory.beadinventory.REST.Controller.FinishedPiecesControllers.BraceletController;
import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Bracelet;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BraceletManager {

    @Autowired
    private BraceletController braceletController;

    public String printBracelet(Bracelet bracelet){
        return bracelet.toString();
    }

    public String printBraceletById(long id){
        return  braceletController.findItemById(id).toString();
    }

    public String printAllBracelets(){
        List<Bracelet> bracelets = braceletController.findAllItems();
        StringBuilder builder = new StringBuilder();
        bracelets.stream().forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String printBraceletsQuantity(){
        Integer quantity = braceletController.findAllItems().size();
        return "Current bracelet inventory count: " + quantity;
    }


    public void createBracelet(){

    }

    public void archiveBracelet(){

    }

}
