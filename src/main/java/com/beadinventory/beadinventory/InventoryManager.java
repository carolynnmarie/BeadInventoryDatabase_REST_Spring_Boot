package com.beadinventory.beadinventory;

import com.beadinventory.beadinventory.Controller.FinishedPiecesControllers.NecklaceController;
import com.beadinventory.beadinventory.Controller.SuppliesControllers.*;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;

import java.util.*;
import java.util.stream.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory.*;
import org.springframework.beans.factory.annotation.Autowired;

public class InventoryManager  {

    @Autowired
    private BeadController beadController;
    @Autowired
    private FindingController findingController;
    @Autowired
    private StringWireController stringController;



//    @Autowired
//    public InventoryManager(BeadController beadController, FindingController findingController,
//                            StringWireController stringController, StoreListController storeListController){
//        this.beadController = beadController;
//        this.findingController = findingController;
//        this.stringController = stringController;
//
//    }


    public String beadPrintBead(Bead bead){
        return bead.toString();
    }

    public String beadPrintBeadById(long id){
        Bead bead = beadController.findBeadById(id);
        return bead.toString();
    }

    public long beadGetQuantityById(long id){
        Bead bead = beadController.findBeadById(id);
        return bead.getQuantity();
    }

    public String beadPrintAllOrderByMaterial(){
        StringBuilder builder = new StringBuilder();
        List<Bead> beadList = beadController.findAllOrderByMaterial();
        beadList.forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String beadPrintAllSwarovskiQuantityColorSize(){
        ArrayList<Bead> beads = new ArrayList<>(beadController.findAllOfMaterial(Material.SWAROVSKI_CRYSTAL)
                .stream()
                .sorted(Comparator.comparing(Bead::getColor).thenComparing(Bead::getSizeMM))
                .collect(Collectors.toList()));
        StringBuilder builder = new StringBuilder("Swarovski crystals:");
        for(Bead bead: beads){
            builder.append("\ncolor: ").append(bead.getColor())
                    .append(", size:")
                    .append(bead.getSizeMM())
                    .append(", quantity: ")
                    .append(bead.getQuantity());
        }
        return builder.toString();
    }

    public String beadPrintMissingNtrlAndSPStones(){
        Material[] allMaterials = Material.values();
        List<Material> presentMaterialList = beadController.findAllBeads()
                .stream()
                .map(e->e.getMaterial())
                .filter(e->e.getCategory().equals(NATURAL_STONE)||e.getCategory().equals(SEMI_PRECIOUS_STONE))
                .collect(Collectors.toList());
        StringBuilder builder = new StringBuilder("Missing:");
        presentMaterialList.forEach(e->builder.append("\n").append(e.toString()));
        return builder.toString();
    }

    public String beadPrintSizeQuantityOfMaterial(Material material){
        StringBuilder builder = new StringBuilder();
        List<Bead> beads = beadController.findAllOfMaterial(material)
                .stream()
                .sorted(Comparator.comparing(Bead::getSizeMM))
                .collect(Collectors.toList());
        builder.append(material.toString())
                .append(": \n");
        for(int i = 0; i< beads.size(); i++){
            builder.append(i+1)
                    .append("size: ")
                    .append(beads.get(i).getSizeMM())
                    .append(", quantity: ")
                    .append(beads.get(i).getQuantity())
                    .append("\n");
        }
        return builder.toString();
    }

    public String findingPrintFinding(Finding finding){
        return finding.toString();
    }

    public String findingPrintById(long id){
        Finding finding = findingController.getFindingById(id);
        return finding.toString();
    }

    public String findingPrintAllOfCategory(FindingCategory category){
        List<Finding> findings = findingController.findAllOfCategory(category);
        StringBuilder builder = new StringBuilder("Findings: \n");
        findings.forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String stringWirePrintAll(){
        List<StringWire> sWList = stringController.findAllStringWire();
        StringBuilder builder = new StringBuilder("Stringing Materials:");
        sWList.forEach(e->builder.append("\n").append(e.toString()));
        return builder.toString();
    }

}

