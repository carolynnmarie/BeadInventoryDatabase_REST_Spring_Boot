package com.beadinventory.beadinventory.DomainTest;

import com.beadinventory.beadinventory.Domain.Bead;
import com.beadinventory.beadinventory.Domain.beadCharacteristics.MaterialCategory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.beadinventory.beadinventory.Domain.beadCharacteristics.Material.*;
import static com.beadinventory.beadinventory.Domain.beadCharacteristics.MaterialCategory.*;

public class BeadTest {

    private Bead bead1 = new Bead(AMETHYST, "light purple", 4, "good", 15, "");
    private Bead bead2 = new Bead(JASPER, "black", 6, "good", 10, "");
    private Bead bead3 = new Bead(STONE, "tan", 6, "ok", 7, "with design cut into bead");

    @Before
    public void before(){
        bead1.setId(1);
        bead2.setId(2);
        bead3.setId(3);
    }

    @Test
    public void getMaterialCategoryTest(){
        MaterialCategory expected = SEMI_PRECIOUS_STONE;
        MaterialCategory actual = bead1.getMaterialCategory();
        Assert.assertEquals(expected,actual);
    }


}
