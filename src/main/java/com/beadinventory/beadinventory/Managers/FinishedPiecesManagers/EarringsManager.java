package com.beadinventory.beadinventory.Managers.FinishedPiecesManagers;

import com.beadinventory.beadinventory.Controller.FinishedPiecesControllers.EarringsController;
import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

public class EarringsManager {

    @Autowired
    private EarringsController earringsController;

    public String printEarringSet(Earrings earrings){
        return earrings.toString();
    }

    public String printEarringSetById(long id){
        return earringsController.findItemById(id).toString();
    }

    public String printAllEarrings(){
        List<Earrings> allEarrings = earringsController.findAllItems();
        StringBuilder builder = new StringBuilder();
        allEarrings.stream().forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String printEarringsQuantity(){
        return "Current earrings inventory count: " + earringsController.findAllItems().size();
    }

    public void createEarrings(){

    }

    public void archiveEarrings(){

    }

}
