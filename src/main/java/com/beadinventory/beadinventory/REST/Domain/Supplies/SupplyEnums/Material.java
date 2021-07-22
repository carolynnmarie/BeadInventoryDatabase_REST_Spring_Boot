package com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums;

import java.io.Serializable;

import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.MaterialCategory.*;
public enum Material implements Serializable {

    SHELL("Shell", NATURAL_STONE),
    HOWLITE("Howlite", NATURAL_STONE),
    TURQUOISE("Turquoise", NATURAL_STONE),
    BONE("Bone", NATURAL_STONE),
    UNAKITE("Unakite", NATURAL_STONE),
    PEARL("Pearl", NATURAL_STONE),
    MOTHER_OF_PEARL("Mother of Pearl", NATURAL_STONE),
    BAMBOO_CORAL("Bamboo Coral", NATURAL_STONE),
    HEMATITE("Hematite", NATURAL_STONE),
    TIGER_EYE("Tiger Eye", NATURAL_STONE),
    MAGNESITE("Magnesite", NATURAL_STONE),
    STONE("Stone", NATURAL_STONE),

    AMETHYST("Amethyst", SEMI_PRECIOUS_STONE),
    ADVENTURINE("Adventurine", SEMI_PRECIOUS_STONE),
    BLUE_ADVENTURINE("Blue Adventurine", SEMI_PRECIOUS_STONE),
    SERPENTINE("Serpentine", SEMI_PRECIOUS_STONE),
    JASPER("Jasper", SEMI_PRECIOUS_STONE),
    QUARTZITE("Quartzite", SEMI_PRECIOUS_STONE),
    AGATE("Agate", SEMI_PRECIOUS_STONE),

    COPPER("Copper", METAL),
    BRASS("Brass", METAL),
    GUN_METAL_GREY("Gun Metal Grey", METAL),
    DULL_SILVER_PLATED("Dull Silver Plated", METAL),
    BRIGHT_SILVER_PLATED("Bright Silver Plated", METAL),
    GOLD_TONED_PLATED("Gold Toned Plated", METAL),

    STERLING_SILVER_PLATED("925 Sterling Silver Plated", PRECIOUS_METAL),
    FULL_STERLING_SILVER("925 Sterling Silver", PRECIOUS_METAL),
    GOLD("Gold", PRECIOUS_METAL),
    GOLD_PLATED("Gold Plated", PRECIOUS_METAL),
    STAINLESS_STEEL("Stainless Steel", METAL),

    GLASS("Glass", MaterialCategory.GLASS),
    CRYSTAL("Crystal", MaterialCategory.GLASS),
    SWAROVSKI_CRYSTAL("Swarovski Crystal", MaterialCategory.GLASS),
    GLASS_PEARL("Glass Pearl", MaterialCategory.GLASS),

    SEED("Seed Bead",MaterialCategory.SEED),

    PAPER("Paper", MaterialCategory.OTHER),
    CERAMIC("Ceramic", MaterialCategory.OTHER),
    ACRYLIC("Acrylic", MaterialCategory.OTHER),
    WOOD("Wood", MaterialCategory.OTHER),
    PLASTIC("Plastic", MaterialCategory.OTHER),

    COTTON("Cotton", STRINGING),
    POLYESTER("Polyester",STRINGING),
    WAXED_COTTON("Waxed Cotton", STRINGING),
    LEATHER("Leather", STRINGING),
    FAUX_LEATHER("Faux Leather", STRINGING),
    HEMP("Hemp",STRINGING),
    OTHER("Other",MaterialCategory.OTHER);



    String material;
    MaterialCategory category;

    Material(String material, MaterialCategory category){
        this.material = material;
        this.category = category;
    }

    @Override
    public String toString(){
        return material;
    }

    public String getMaterial(){
        return material;
    }

    public MaterialCategory getCategory() {
        return category;
    }


}
