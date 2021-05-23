package com.beadinventory.beadinventory.Managers.FinishedPiecesManagers;

import com.beadinventory.beadinventory.Controller.FinishedPiecesControllers.NapkinRingSetController;
import com.beadinventory.beadinventory.Domain.FinishedPieces.NapkinRingSet;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

public class NapkinRingManager {

    @Autowired
    private NapkinRingSetController napkinRingController;

    public String printNapkinRings(NapkinRingSet napkinRings){
        return napkinRings.toString();
    }

    public String printNapkinRingsById(long id){
        return napkinRingController.findItemById(id).toString();
    }

    public String printAllNapkinRings(){
        List<NapkinRingSet> napkinRings = napkinRingController.findAllItems();
        StringBuilder builder = new StringBuilder();
        napkinRings.stream().forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String printNapkinRingsQuantity(){
        return "Current napkin ring set count: " + napkinRingController.findAllItems().size();
    }

    public void createNapkinRings(){

    }

    public void archiveNapkinRings(){

    }
}
