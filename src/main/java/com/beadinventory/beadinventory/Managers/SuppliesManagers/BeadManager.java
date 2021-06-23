package com.beadinventory.beadinventory.Managers.SuppliesManagers;

import com.beadinventory.beadinventory.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;


public class BeadManager {


    private BeadController beadController;
    private BeadService beadService;
    private BeadRepo repo;
    private Bead bead;
    private EnumSet<Material> materialList;

    private EnumSet<Shape> shapeList;

    @Autowired
    public BeadManager(){
        this.bead = new Bead();
        this.beadService = new BeadService(repo);
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


}


/*
    private Material material;
    private Shape shape;
    private String color;
    private int sizeMM;
    private String quality;
    private long quantity;
    private String description;
    private double pricePoint;
    private String brands;
 */