package com.beadinventory.beadinventory.DomainTest.SuppliesDomainTest;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import org.junit.Before;
import org.junit.Test;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;

public class FindingTest {

    private Finding finding;
    private Finding finding2;

    @Before
    public void before(){
        finding = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,"thin",2,0.02,20,"Beadalon");
        finding2  = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",2,0.02,20,"Beadalon");
    }



    @Test
    public void getIdTest(){
        System.out.println(finding.getId() + " " + finding2.getId());
    }

}

/*
long getId()
FindingCategory getFindingCategory()
Material getMaterial()
String getDetails()
double getPricePoint()
int getQuantity()
int getLength()
String getBrand()
 */
