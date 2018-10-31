package com.beadinventory.beadinventory.DomainTest.SuppliesDomainTest;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import org.junit.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;

public class BeadTest {

    private Bead bead1;
    private Bead bead2;
    private Bead bead3;


    @Before
    public void before(){
        bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20, "translucent purple with some white",0.2,"Bead Gallery");
        bead2 = new Bead(JASPER,ROUND, "black", 4, "good", 10, "",0.1,"Bead Gallery");
        bead3 = new Bead(STONE, ROUND,"tan",6,"ok",7,"with design cut into bead", 0.05,"Bead Gallery");

        bead1.setBeadId(1);
        bead2.setBeadId(2);
        bead3.setBeadId(3);
    }

    @Test
    public void getIdTest(){
        long expected = 3L;
        long actual = bead3.getBeadId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getMaterialTest(){
        Material expected = AMETHYST;
        Material actual = bead1.getMaterial();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getColorTest(){
        String expected = "purple";
        String actual = bead1.getColor();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getSizeTest(){
        int expected = 4;
        int actual = bead1.getSizeMM();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getQualityTest(){
        String expected = "good";
        String actual = bead1.getQuality();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getQuantityTest(){
        long expected = 20L;
        long actual = bead1.getQuantity();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getDescriptionTest(){
        String expected = "translucent purple with some white";
        String actual = bead1.getDescription();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPricePointTest(){
        double expected = 0.05;
        double actual = bead3.getPricePoint();
        Assert.assertEquals(expected,actual, 0.01);
    }

    @Test
    public void getBrandsTest(){
        String setExpected = "Bead Gallery";
        String setActual = bead2.getBrands();
        Assert.assertEquals(setExpected,setActual);
    }

}
