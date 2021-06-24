package com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums;

import java.io.Serializable;

import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.MaterialCategory.*;
public enum Material implements Serializable {

    SHELL("shell", NATURAL_STONE),
    HOWLITE("howlite", NATURAL_STONE),
    TURQUISE("turquise", NATURAL_STONE),
    BONE("bone", NATURAL_STONE),
    UNAKITE("unakite", NATURAL_STONE),
    PEARL("pearl", NATURAL_STONE),
    MOTHER_OF_PEARL("mother of pearl", NATURAL_STONE),
    BAMBOO_CORAL("bamboo coral", NATURAL_STONE),
    HEMATITE("hematite", NATURAL_STONE),
    TIGER_EYE("tiger eye", NATURAL_STONE),
    MAGNESITE("magnesite", NATURAL_STONE),
    STONE("stone", NATURAL_STONE),

    AMETHYST("amethyst", SEMI_PRECIOUS_STONE),
    ADVENTURINE("adventurine", SEMI_PRECIOUS_STONE),
    BLUE_ADVENTURINE("blue adventurine", SEMI_PRECIOUS_STONE),
    SERPENTINE("serpentine", SEMI_PRECIOUS_STONE),
    JASPER("jasper", SEMI_PRECIOUS_STONE),
    QUARTZITE("quartzite", SEMI_PRECIOUS_STONE),
    AGATE("agate", SEMI_PRECIOUS_STONE),

    COPPER("copper", METAL),
    BRASS("brass", METAL),
    GUN_METAL_GREY("gun metal grey", METAL),
    DULL_SILVER_PLATED("dull silver plated", METAL),
    BRIGHT_SILVER_PLATED("bright silver plated", METAL),
    GOLD_TONED_PLATED("gold toned plated", METAL),

    STERLING_SILVER_PLATED("925 sterling silver plated", PRECIOUS_METAL),
    FULL_STERLING_SILVER("925 sterling silver plated", PRECIOUS_METAL),
    GOLD("gold", PRECIOUS_METAL),
    GOLD_PLATED("gold plated", PRECIOUS_METAL),
    STAINLESS_STEEL("stainless steel", METAL),

    GLASS("glass", MaterialCategory.GLASS),
    CRYSTAL("crystal", MaterialCategory.GLASS),
    SWAROVSKI_CRYSTAL("swarovski crystal", MaterialCategory.GLASS),
    GLASS_PEARL("glass pearl", MaterialCategory.GLASS),

    SEED("seed bead",MaterialCategory.SEED),

    PAPER("paper", MaterialCategory.OTHER),
    CERAMIC("ceramic", MaterialCategory.OTHER),
    ACRYLIC("acrylic", MaterialCategory.OTHER),
    WOOD("wood", MaterialCategory.OTHER),
    PLASTIC("plastic", MaterialCategory.OTHER),

    COTTON("cotton", STRINGING),
    POLYESTER("polyester",STRINGING),
    WAXED_COTTON("waxed cotton", STRINGING),
    LEATHER("leather", STRINGING),
    FAUX_LEATHER("faux leather", STRINGING),
    HEMP("HEMP",STRINGING),
    OTHER("other",MaterialCategory.OTHER);



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
