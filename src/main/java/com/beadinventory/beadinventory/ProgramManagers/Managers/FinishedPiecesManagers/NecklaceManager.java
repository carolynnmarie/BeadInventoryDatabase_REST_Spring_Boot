package com.beadinventory.beadinventory.ProgramManagers.Managers.FinishedPiecesManagers;

import com.beadinventory.beadinventory.REST.Controller.FinishedPiecesControllers.NecklaceController;
import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Necklace;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

public class NecklaceManager {

    @Autowired
    private NecklaceController necklaceController;

    public String printNecklace(Necklace necklace){
        return necklace.toString();
    }

    public String printNecklaceById(long id){
        return necklaceController.findItemById(id).toString();
    }

    public String printAllNecklaces(){
        List<Necklace> necklaces = necklaceController.findAllItems();
        StringBuilder builder = new StringBuilder();
        necklaces.stream().forEach(e-> builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String printNecklacesQuantity(){
        Integer quantity = necklaceController.findAllItems().size();
        return "Current necklace inventory count: " +  quantity;
    }


    public void createNecklace(){

    }

    public void archiveNecklace(){

    }
}
