package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;

import com.beadinventory.beadinventory.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.beadCharacteristics.Material;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.beadCharacteristics.Material.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.*;

public class BeadControllerTest {

    @Mock
    private BeadService mockBeadService;

    @InjectMocks
    private BeadController mockBeadController;

    private Bead bead1;
    private Bead bead2;
    private Bead bead3;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        bead1 = new Bead(AMETHYST, "light purple", 4, "good", 15, "");
        bead1.setId(1);
        bead2 = new Bead(JASPER, "black", 6, "good", 10, "");
        bead2.setId(2);
        bead3 = new Bead(STONE,"tan",6,"ok",7,"with design cut into bead");
        bead3.setId(3);
    }

    @Test
    public void testGetAllBeads(){
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2,bead1));
        given(mockBeadService.getAllBeads()).willReturn(new ResponseEntity<>(list,OK));
        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list,OK);
        ResponseEntity<List<Bead>> actual = mockBeadController.getAllBeads();

        verify(mockBeadService).getAllBeads();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllBeadsOrganizeByMaterial(){
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2,bead3,bead1));
        List<Bead> organizedList = new ArrayList<>(Arrays.asList(bead3,bead1,bead2));
        given(mockBeadService.getAllOrderByMaterial()).willReturn(new ResponseEntity<>(organizedList,OK));

        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list,OK);
        ResponseEntity<List<Bead>> actual = mockBeadController.getAllBeadsOrganizeByMaterial();

        verify(mockBeadService).getAllOrderByMaterial();
        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void testGetAllBeadsOrganizeByMaterial2(){
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2,bead3,bead1));
        Collections.sort(list,Comparator.comparing(Bead::getMaterial));
        List<Bead> organizedList = new ArrayList<>(Arrays.asList(bead3,bead1,bead2));
        given(mockBeadService.getAllOrderByMaterial()).willReturn(new ResponseEntity<>(organizedList,OK));

        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list,OK);
        ResponseEntity<List<Bead>> actual = mockBeadController.getAllBeadsOrganizeByMaterial();

        verify(mockBeadService).getAllOrderByMaterial();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetAllOfMaterial(){
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2));
        given(mockBeadService.getAllOfMaterial(JASPER)).willReturn(new ResponseEntity<>(list,OK));

        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list,OK);
        ResponseEntity<List<Bead>> actual = mockBeadController.getAllOfMaterial(JASPER);

        verify(mockBeadService).getAllOfMaterial(any(Material.class));
        Assert.assertEquals(expected, actual);
    }

}
