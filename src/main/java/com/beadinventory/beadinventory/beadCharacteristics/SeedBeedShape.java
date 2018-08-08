package com.beadinventory.beadinventory.beadCharacteristics;

public enum SeedBeedShape {

    REGULAR("regular"),
    E("E"),
    E_LARGE("large E"),
    TUBE("tube"),
    OTHER("other");

    String shape;

    SeedBeedShape(String shape){
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
