package com.beadinventory.beadinventory.Managers;

import com.beadinventory.beadinventory.Controller.SuppliesControllers.*;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;

import java.util.*;
import java.util.stream.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory.*;
import org.springframework.beans.factory.annotation.Autowired;

public class SuppliesManager {

    @Autowired
    private BeadController beadController;
    @Autowired
    private FindingController findingController;
    @Autowired
    private StringWireController stringController;


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
            builder.append("\ncolor: ")
                    .append(bead.getColor())
                    .append(", size:")
                    .append(bead.getSizeMM())
                    .append(", quantity: ")
                    .append(bead.getQuantity());
        }
        return builder.toString();
    }

    public String beadPrintCurrentNtrlAndSPStones(){
        List<Material> presentMaterialList = beadController.findAllBeads()
                .stream()
                .map(e->e.getMaterial())
                .filter(e->e.getCategory().equals(NATURAL_STONE)||e.getCategory().equals(SEMI_PRECIOUS_STONE))
                .collect(Collectors.toList());
        StringBuilder builder = new StringBuilder("Current: ");
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
                    .append(") size: ")
                    .append(beads.get(i).getSizeMM())
                    .append(", quantity: ")
                    .append(beads.get(i).getQuantity())
                    .append("\n");
        }
        return builder.toString();
    }


    public String beadPrintAllOfMaterialCategory(MaterialCategory category){
        List<Bead> list = beadController.findAllBeads()
                .stream()
                .filter(e-> e.getMaterial().getCategory().equals(category))
                .sorted(Comparator.comparing(Bead::getMaterial))
                .collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        list.stream().forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String beadPrintLowQuantity(long quantity){
        List<Bead> beads = beadController.findAllWithQuantityLessThan(quantity);
        StringBuilder builder = new StringBuilder();
        beads.stream().forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String printAllBeads(){
        List<Bead> beads = beadController.findAllBeads();
        StringBuilder builder = new StringBuilder("Full Bead Inventory:\n");
        beads.stream().forEach(bead->builder.append(bead.toString()).append("\n"));
        return builder.toString();
    }

    public void addBead(Bead bead){
        List<Bead> beads = beadController.findAllBeads();
        if(!beads.contains(bead)) beadController.createBead(bead);
    }

    public void updateBeadQuantity(long id, long quantity){
        beadController.updateBeadQuantity(id, quantity);
    }

    public void deleteBead(Bead bead){
        beadController.deleteBead(bead);
    }

    public String findingPrint(Finding finding){
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

    public String printAllFindings(){
        List<Finding> findings = findingController.findAllFindings();
        StringBuilder builder = new StringBuilder("Findings: \n");
        findings.stream().forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public void addFinding(Finding finding){
        findingController.createFinding(finding);
    }

    public void updateFindingQuantity(long id, long quantity){
        Finding finding = findingController.getFindingById(id);
        finding.setQuantity(quantity);
        finding.setId(id);
        findingController.updateFinding(id, finding);
    }

    public void deleteFinding(Finding finding){
        findingController.deleteFinding(finding);
    }

    public String printStringWire(StringWire string){
        return string.toString();
    }

    public String printStringWireById(long id){
        return stringController.findById(id).toString();
    }

    public String printAllStringWire(){
        List<StringWire> sWList = stringController.findAllStringWire();
        StringBuilder builder = new StringBuilder("Stringing Materials:");
        sWList.forEach(e->builder.append("\n").append(e.toString()));
        return builder.toString();
    }

    public void addStringWire(StringWire stringMaterial){
        stringController.createStringWire(stringMaterial);
    }

    public void deleteStringWire(StringWire stringWire){
        stringController.deleteStringWire(stringWire);
    }

}

