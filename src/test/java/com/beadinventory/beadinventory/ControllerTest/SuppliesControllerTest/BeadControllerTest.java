package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;

import com.beadinventory.beadinventory.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.ROUND;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.*;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
public class BeadControllerTest {

    @Mock
    private BeadService mockBeadService;

    @InjectMocks
    private BeadController mockBeadController;
    TreeSet<String> brands = new TreeSet<>(Arrays.asList("Bead Gallery"));
    private Bead bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20,
            "translucent purple with some white", 0.2, brands);
    private Bead bead2 = new Bead(JASPER, ROUND, "black", 4, "good", 10, "",
            0.1, brands);
    private Bead bead3 = new Bead(STONE, ROUND, "tan", 6, "ok", 7,
            "with design cut into bead", 0.05, brands);


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        bead1.setId(1);
        bead2.setId(2);
        bead3.setId(3);
    }

    @Test
    public void testGetAllBeads() {
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2, bead1));
        given(mockBeadService.getAllBeads()).willReturn(new ResponseEntity<>(list, OK));
        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list, OK);
        ResponseEntity<List<Bead>> actual = mockBeadController.getAllBeads();

        verify(mockBeadService).getAllBeads();
        Assert.assertEquals(expected, actual);
    }


//    @Test
//    public void testGetAllBeadsOrganizeByMaterial(){
//        List<Bead> list = new ArrayList<>(Arrays.asList(bead2,bead3,bead1));
//        List<Bead> organizedList = new ArrayList<>(Arrays.asList(bead3,bead1,bead2));
//        given(mockBeadService.getAllOrderByMaterial()).willReturn(new ResponseEntity<>(organizedList,OK));
//
//        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list,OK);
//        ResponseEntity<List<Bead>> actual = mockBeadController.getAllBeadsOrganizeByMaterial();
//
//        verify(mockBeadService).getAllOrderByMaterial();
//        Assert.assertNotEquals(expected,actual);
//    }
//
//    @Test
//    public void testGetAllBeadsOrganizeByMaterial2(){
//        List<Bead> list = new ArrayList<>(Arrays.asList(bead2,bead3,bead1));
//        Collections.sort(list,Comparator.comparing(Bead::getMaterial));
//        List<Bead> organizedList = new ArrayList<>(Arrays.asList(bead3,bead1,bead2));
//        given(mockBeadService.getAllOrderByMaterial()).willReturn(new ResponseEntity<>(organizedList,OK));
//
//        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list,OK);
//        ResponseEntity<List<Bead>> actual = mockBeadController.getAllBeadsOrganizeByMaterial();
//
//        verify(mockBeadService).getAllOrderByMaterial();
//        Assert.assertEquals(expected,actual);
//    }

//    @Test
//    public void testGetAllOfMaterial(){
//        List<Bead> list = new ArrayList<>(Arrays.asList(bead2));
//        given(mockBeadService.getAllOfMaterial(JASPER)).willReturn(new ResponseEntity<>(list,OK));
//
//        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list,OK);
//        ResponseEntity<List<Bead>> actual = mockBeadController.getAllOfMaterial(JASPER);
//
//        verify(mockBeadService).getAllOfMaterial(any(Material.class));
//        Assert.assertEquals(expected, actual);
//    }

}
