package com.beadinventory.beadinventory.DomainTest.SuppliesDomainTest;

import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory;
import org.junit.Assert;
import org.junit.Test;


import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory.*;

public class StringingMaterialTest {

    private StringingMaterial beadingWire = new StringingMaterial(BEADING_WIRE,BRIGHT_SILVER_PLATED,".5 mm",7,"good",.5,"Beadalon");
    private StringingMaterial brassChain = new StringingMaterial(CHAIN,BRASS,"thin",1,"okay",.5,"bead landing");
    private StringingMaterial leatherCord = new StringingMaterial(CORD,LEATHER,"medium",1,"okay",.5,"bead landing");

    @Test
    public void getStringingCategoryTest(){
        StringingMaterialCategory expected = BEADING_WIRE;
        StringingMaterialCategory actual = beadingWire.getsMCategory();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getMaterialTest(){
        Material expected = LEATHER;
        Material actual = leatherCord.getMaterial();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getWidthTest(){
        String expected = "thin";
        String actual = brassChain.getWidth();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getStrandsTest(){
        int expected = 7;
        int actual = beadingWire.getStrands();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getQualityTest(){
        String expected = "okay";
        String actual = leatherCord.getQuality();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPricePerFootTest(){
        double expected = 0.5;
        double actual = beadingWire.getPricePerFoot();
        Assert.assertEquals(expected,actual,.001);
    }

    @Test
    public void getBrandTest(){
        String expected = "Beadalon";
        String actual = beadingWire.getBrand();
        Assert.assertEquals(expected,actual);
    }

}
/*
StringingMaterialCategory getStringingMaterialCategory()
Material getMaterial()
String getWidth()
int getStrands()
String getQuality()
double getPricePerFoot()
String getBrand()
 */