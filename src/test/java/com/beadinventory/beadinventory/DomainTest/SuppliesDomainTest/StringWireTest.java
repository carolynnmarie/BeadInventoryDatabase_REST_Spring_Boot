package com.beadinventory.beadinventory.DomainTest.SuppliesDomainTest;

import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import org.junit.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.*;

public class StringWireTest {

    private StringWire beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm","good",.5,"Beadalon", "7 strand");
    private StringWire brassChain = new StringWire(CHAIN,BRASS,"brass","thin","okay",.5,"bead landing","");
    private StringWire leatherCord = new StringWire(CORD,LEATHER,"black","medium","okay",.5,"bead landing", "");

    @Test
    public void getStringingCategoryTest(){
        StringWireCategory expected = BEADING_WIRE;
        StringWireCategory actual = beadingWire.getStringWireCategory();
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
