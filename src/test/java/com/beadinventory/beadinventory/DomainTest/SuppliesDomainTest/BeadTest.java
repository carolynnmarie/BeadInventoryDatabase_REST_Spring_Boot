package com.beadinventory.beadinventory.DomainTest.SuppliesDomainTest;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;

public class BeadTest {

    private Bead bead1;
    private Bead bead2;
    private Bead bead3;


    @Before
    public void before(){
        TreeSet<String> brands = new TreeSet<>(Arrays.asList("Bead Gallery"));
        bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,
                "translucent purple with some white",0.2,brands);
        bead2 = new Bead(JASPER,ROUND, "black", 4, "good", 10, "",0.1,brands);
        bead3 = new Bead(STONE, ROUND,"tan",6,"ok",7,"with design cut into bead",
                0.05,brands);

//        bead1.setId(1);
//        bead2.setId(2);
//        bead3.setId(3);
    }

    @Test
    public void getIdTest(){
        System.out.println(bead2.getId());
//        long expected = 3L;
//        long actual = bead3.getId();
//        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getMaterialTest(){
        Material expected = AMETHYST;
        Material actual = bead1.getMaterial();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getShapeTest(){
        String expected = "round";
        String actual = bead2.getShapeString();
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
        int actual = bead1.getSize();
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
        TreeSet<String> setExpected = new TreeSet<>(Arrays.asList("Bead Gallery"));
        String expected = setExpected.first();
        TreeSet<String> setActual = bead2.getBrands();
        String actual = setActual.first();
        Assert.assertEquals(expected,actual);
    }

}
