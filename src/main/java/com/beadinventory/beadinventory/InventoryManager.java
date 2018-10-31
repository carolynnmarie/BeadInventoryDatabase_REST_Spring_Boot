package com.beadinventory.beadinventory;

import com.beadinventory.beadinventory.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;

import java.util.*;
import java.util.stream.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory.*;

public class InventoryManager  {

    private BeadController beadController;

    public InventoryManager(BeadController beadController){
        this.beadController = beadController;
    }

    public List<Bead> getAllOfMaterialCategory(MaterialCategory category){
        List<Bead> list = beadController.findAllBeads()
                .stream()
                .filter(e-> e.getMaterial().getCategory().equals(category))
                .sorted(Comparator.comparing(Bead::getMaterial))
                .collect(Collectors.toList());
        return list;
    }


    public long findBeadQuantity(Bead bead){
        return bead.getQuantity();
    }

    public String printBeadById(long id){
        Bead bead = beadController.findBeadById(id);
        StringBuilder builder = new StringBuilder();
        builder.append("Material: ")
                .append(bead.getMaterial().toString())
                .append("\nShape: ")
                .append(bead.getShape().toString())
                .append("\nColor: ")
                .append(bead.getColor());
        if(!bead.getMaterial().toString().equals("seed bead")){
            builder.append("\nSize in millimeters")
                    .append(bead.getSizeMM());
        }
        builder.append("\nCurrent Quantity: ")
                .append(bead.getQuantity());
        return builder.toString();
    }

    public String printAllSwarovskiQuantitiesByColorThenSize(){
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

    public String printMissingNaturalAndSemiPreciousStones(){
        Material[] allMaterials = Material.values();
        List<Material> presentMaterialList = beadController.findAllBeads()
                .stream()
                .map(e->e.getMaterial())
                .filter(e->e.getCategory().equals(NATURAL_STONE)||e.getCategory().equals(SEMI_PRECIOUS_STONE))
                .collect(Collectors.toList());
        ArrayList<Material> missingMaterials = new ArrayList<>();
        for(Material material: allMaterials){
            if(!presentMaterialList.contains(material)){
                missingMaterials.add(material);
            }
        }
        StringBuilder builder = new StringBuilder("Missing:");
        for(Material material: missingMaterials){
            builder.append("\n  ")
                    .append(material.toString());
        }
        return builder.toString();
    }

    public ArrayList<Bead> findAllOfMaterialOrderBySize(Material material){
        return new ArrayList<>(beadController.findAllOfMaterial(material)
                .stream()
                .sorted(Comparator.comparing(Bead::getSizeMM))
                .collect(Collectors.toList()));
    }

    public String printSizesQuantitiesOfMaterial(Material material){
        StringBuilder builder = new StringBuilder();
        List<Bead> beads = findAllOfMaterialOrderBySize(material);
        builder.append(material.toString())
                .append(": ")
                .append("\n");
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


}
