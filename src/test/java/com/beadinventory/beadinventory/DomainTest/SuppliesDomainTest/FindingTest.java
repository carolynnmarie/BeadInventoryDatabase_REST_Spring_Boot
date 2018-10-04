package com.beadinventory.beadinventory.DomainTest.SuppliesDomainTest;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;

public class FindingTest {
    private TreeSet<String> brands = new TreeSet<>(Arrays.asList("Beadalon","bead landing"));
    private Finding eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,0.02,20,
            brands);
    private Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,0.02,20,
            brands);
    private Finding lobsterClasp = new Finding(LOBSTER_CLASP,BRIGHT_SILVER_PLATED,"small",.5,0.1,
            10,brands);




    @Test
    public void getFindingCategoryTest() {
        FindingCategory expected = LOBSTER_CLASP;
        FindingCategory actual = lobsterClasp.getFindingCategory();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getMaterialTest() {
        Material expected = BRIGHT_SILVER_PLATED;
        Material actual = headPin.getMaterial();
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void getDetailsTest() {
        String expected = "thin";
        String actual = eyePin.getDetails();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPricePointTest() {
        double expected = .1;
        double actual = lobsterClasp.getPricePoint();
        Assert.assertEquals(expected,actual,.05);
    }

    @Test
    public void getQuantityTest() {
        long expected = 20L;
        long actual = headPin.getQuantity();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getLengthTest() {
        double expected = 5.08;
        double actual = headPin.getLengthCM();
        Assert.assertEquals(expected,actual, .01);
    }

    @Test
    public void getBrandTest() {
        String expected = "bead landing";
        String actual = lobsterClasp.getBrand().last();
        Assert.assertEquals(expected,actual);
    }
}
