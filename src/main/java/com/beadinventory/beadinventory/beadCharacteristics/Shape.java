package com.beadinventory.beadinventory.beadCharacteristics;

public enum Shape {
    ROUND("round"),
    OVAL("oval"),
    RONDELLE("rondelle"),
    FLAT_ROUND("flat round"),
    FLAT_OVAL("flat oval"),
    SQUARE("square"),
    RECTANGLE("rectangle"),
    CUBE("cube"),
    BICONE("bicone"),
    DONUT("donut"),
    DIAMOND("diamond"),
    TEARDROP("teardrop"),
    TUBE("tube"),
    HEART("heart"),
    FACETED_ROUND("faceted round"),
    FACETED_RONDELLE("faceted rondelle"),
    FACETED_OVAL("faceted oval"),
    FACETED_BICONE("faceted bicone"),
    FACETED_TEARDROP("faceted teardrop"),
    TOP_DRILLED_FACETED_TEARDROP("top drilled faceted teardrop"),
    CHIP("chip"),
    IRREGULAR("irregular"),

    OTHER("other");


    String shape;

    Shape(String shape){
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
