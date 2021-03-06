package com.beadinventory.beadinventory.ProgramManagers.Managers.FinishedPiecesManagers;

import com.beadinventory.beadinventory.REST.Controller.FinishedPiecesControllers.NecklaceController;
import com.beadinventory.beadinventory.REST.Controller.SuppliesControllers.*;
import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.REST.Service.FinishedPiecesServices.NecklaceService;
import com.beadinventory.beadinventory.REST.Service.SuppliesServices.BeadService;
import com.beadinventory.beadinventory.REST.Service.SuppliesServices.FindingService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

public class NecklaceManager {


    @Autowired
    private NecklaceController nController;
    private NecklaceService nService;
    private BeadController beadController;
    private BeadService bService;
    private FindingController findingController;
    private FindingService fService;
    private StringWireController stringWireController;


    @Autowired
    public NecklaceManager(){
        this.nController = new NecklaceController(nService);
        this.beadController = new BeadController(bService);
        this.findingController = new FindingController(fService);

    }

    public String printNecklace(Necklace necklace){
        return necklace.toString();
    }

    public String printNecklaceById(long id){
        return nController.findItemById(id).toString();
    }

    public String printAllNecklaces(){
        List<Necklace> necklaces = nController.findAllItems();
        StringBuilder builder = new StringBuilder();
        necklaces.stream().forEach(e-> builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String printNecklacesQuantity(){
        Integer quantity = nController.findAllItems().size();
        return "Current necklace inventory count: " +  quantity;
    }

    //don't forget to ask if it is new or already part of inventory
    private void createNecklace(){
        //create necklace, scanner, sout, etc.
        //if new, just nController.createItem
        //else if already created,
        //after nController.createItem increase # of beads & findings in findings db to counter
    }

    public void editNecklace(){

    }

    public void archiveNecklace(Necklace necklace){


    }
}
