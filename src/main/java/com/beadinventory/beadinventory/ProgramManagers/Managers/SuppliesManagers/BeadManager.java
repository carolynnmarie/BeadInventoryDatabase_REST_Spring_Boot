package com.beadinventory.beadinventory.ProgramManagers.Managers.SuppliesManagers;

import com.beadinventory.beadinventory.REST.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Shape;
import com.beadinventory.beadinventory.REST.Service.SuppliesServices.BeadService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;


public class BeadManager {

    @Autowired
    private BeadController beadController;
    @Autowired
    private BeadService beadService;
    private EnumSet<Material> materialList;
    private EnumSet<Shape> shapeList;


    public BeadManager(){
        this.beadController = new BeadController(beadService);
        this.materialList = materialList;
        for(Material each: Material.values()){
            materialList.add(each);
        }
        this.shapeList = shapeList;
        for(Shape shape: Shape.values()){
            shapeList.add(shape);
        }
    }

    public void createBead(){
        Bead bead = new Bead();
        bead.setMaterial(chooseMaterial());
        bead.setShape(chooseShape());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter color: \n");
        bead.setColor(scanner.nextLine());
        System.out.println("Enter size as integer: \n");
        bead.setSizeMM(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter quality:\n");
        bead.setQuality(scanner.nextLine());
        System.out.println("Enter quantity:\n");
        bead.setQuantity(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Enter price point with decimal point:\n");
        bead.setPricePoint(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Enter brand:\n");
        bead.setBrands(scanner.nextLine());
        System.out.println("Enter description:\n");
        bead.setDescription(scanner.nextLine());
        beadController.createBead(bead);
    }


    private Material chooseMaterial(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose material from list: ");
        StringBuilder builder = new StringBuilder();
        for(Material each: materialList){
            builder.append(each.getMaterial())
                    .append("\n");
        }
        System.out.println(builder.toString());
        String inputMaterial = scanner.nextLine();
        Material beadMaterial = Material.SHELL;
        for(Material each: materialList){
            if(each.toString().equals(inputMaterial)){
                beadMaterial = each;
            }
        }
        return beadMaterial;
    }

    private Shape chooseShape(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose shape from list: ");
        StringBuilder builder = new StringBuilder();
        for(Shape each: shapeList){
            builder.append(each.toString())
                    .append("\n");
        }
        System.out.println(builder.toString());
        String inputShape = scanner.nextLine();
        Shape beadShape = Shape.valueOf("round");
        for(Shape each: shapeList){
            if(each.toString().equals(inputShape)){
                 beadShape = each;
            }
        }
        return beadShape;
    }

    public String printAllBeads(){
        List<Bead> beads = beadController.findAllBeads();
        StringBuilder builder = new StringBuilder();
        for(Bead each: beads){
            builder.append(each.toString())
                    .append("\n");
        }
        return builder.toString();
    }

    public String printAllBeadsOfMaterial(Material material){
        List<Bead> beadList = beadController.findAllOfMaterial(material);
        StringBuilder builder = new StringBuilder();
        for(Bead each: beadList){
            builder.append(each.toString())
                    .append("\n");
        }
        return builder.toString();
    }

    public Long getQuantityOfBead(Bead bead){
        return bead.getQuantity();
    }

    public void updateQuantity(Bead bead1, Long updatedQuantity){
        Long id = bead1.getBeadId();
        beadController.updateBeadQuantity(id, updatedQuantity);
    }

    public String findLowQuantities(long quantity1){
        List<Bead> beadList = beadController.findAllWithQuantityLessThan(quantity1);
        StringBuilder builder = new StringBuilder("Beads with quantity less than " + quantity1 + ":\n");
        for(Bead each: beadList){
            builder.append(each.toString())
                    .append("\n");
        }
        return builder.toString();
    }



    public void deleteBeadFromDB(Bead bead){
        beadController.deleteBead(bead);
    }

}


