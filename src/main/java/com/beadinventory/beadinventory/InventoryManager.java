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


//    public ArrayList<Bead> findAllOfMaterialOrderByColor(Material material){
//        return new ArrayList<>(beadController.findAllOfMaterial(material)
//                .stream()
//                .sorted(Comparator.comparing(Bead::getColor))
//                .collect(Collectors.toList()));
//    }
//
//    public ArrayList<Bead> findAllOfMaterialOrderBySize(Material material){
//        return new ArrayList<>(beadController.findAllOfMaterial(material)
//                .stream()
//                .sorted(Comparator.comparing(Bead::getSize))
//                .collect(Collectors.toList()));
//    }
//
//    public long findBeadQuantity(Bead bead){
//        return bead.getQuantity();
//    }
//
//    public String printAllSwarovskiQuantitiesOrderByColorThenSize(){
//        ArrayList<Bead> beads = new ArrayList<>(beadController.findAllOfMaterial(Material.SWAROVSKI_CRYSTAL)
//                .stream()
//                .sorted(Comparator.comparing(Bead::getColor).thenComparing(Bead::getSize))
//                .collect(Collectors.toList()));
//        StringBuilder builder = new StringBuilder("Swarovski crystals:");
//        for(Bead bead: beads){
//            builder.append("color: ").append(bead.getColor())
//                    .append(", size:")
//                    .append(bead.getSize())
//                    .append(", quantity: ")
//                    .append(bead.getQuantity())
//                    .append("\n");
//        }
//        return builder.toString();
//    }

    public String printAllMissingNaturalAndSemiPreciousStone(){
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
//
//    public String printQuantityAndSizeOfMaterial(Material material){
//        StringBuilder builder = new StringBuilder();
//        List<Bead> beads = findAllOfMaterialOrderBySize(material);
//        builder.append(material.toString())
//                .append(": ")
//                .append("\n");
//        for(int i = 0; i< beads.size(); i++){
//            builder.append(i+1)
//                    .append("size: ")
//                    .append(beads.get(i).getSize())
//                    .append(", quantity: ")
//                    .append(beads.get(i).getQuantity())
//                    .append("\n");
//        }
//        return builder.toString();
//    }


}
