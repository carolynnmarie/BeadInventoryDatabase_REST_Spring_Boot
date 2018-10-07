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
import static org.mockito.ArgumentMatchers.anyLong;
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
        bead1.setId(1L);
        bead2.setId(2L);
        bead3.setId(3L);
    }

    @Test
    public void testGetAllBeads() {
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2, bead1));
        given(mockBeadService.getAllBeads()).willReturn(new ResponseEntity<>(list, OK));
        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list, OK);
        ResponseEntity<List<Bead>> actual = mockBeadController.findAllBeads();

        verify(mockBeadService).getAllBeads();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testFindAllOfMaterial(){
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2));
        given(mockBeadService.getAllOfMaterial(JASPER)).willReturn(new ResponseEntity<>(list,OK));

        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list,OK);
        ResponseEntity<List<Bead>> actual = mockBeadController.findAllOfMaterial(JASPER);

        verify(mockBeadService).getAllOfMaterial(any(Material.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllOfMaterialAndColorTest(){
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2));
        given(mockBeadService.getAllOfMaterialAndColor(any(Material.class),any(String.class))).willReturn(new ResponseEntity<>(list,OK));

        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list, OK);
        ResponseEntity<List<Bead>> actual = mockBeadController.findAllOfMaterialAndColor(JASPER,"black");

        verify(mockBeadService).getAllOfMaterialAndColor(any(Material.class),any(String.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllOfMaterialAndSizeTest(){

    }

    @Test
    public void findAllWithQuantityLessThanTest(){

    }

    @Test
    public void findBeadByIdTest(){
        Optional<Bead> oBead = Optional.of(bead1);
        given(mockBeadService.getBeadById(anyLong())).willReturn(new ResponseEntity<>(oBead,OK));
        ResponseEntity<Optional<Bead>> expected = new ResponseEntity<>(oBead,OK);
        ResponseEntity<Optional<Bead>> actual = mockBeadController.findBeadById(1L);

        verify(mockBeadService).getBeadById(anyLong());
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void createBeadTest(){
        given(mockBeadService.createBead(bead2)).willReturn(new ResponseEntity<>(bead2, CREATED));
        ResponseEntity<Bead> expected = new ResponseEntity<>(bead2, CREATED);
        ResponseEntity<Bead> actual = mockBeadController.createBead(bead2);

        verify(mockBeadService).createBead(any(Bead.class));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateBeadQuantityTest(){
        given(mockBeadService.updateBeadQuantity(anyLong(),anyLong())).willReturn(new ResponseEntity<>(bead3,OK));
        ResponseEntity<Bead> expected = new ResponseEntity<>(bead3,OK);
        ResponseEntity<Bead> actual = mockBeadController.updateBeadQuantity(bead3.getId(),20L);
        verify(mockBeadService).updateBeadQuantity(anyLong(),anyLong());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateBeadTest(){

    }

    @Test
    public void deleteBeadByIdTest(){
        ResponseEntity expected = new ResponseEntity(OK);
        given(mockBeadService.deleteBeadById(2L)).willReturn(expected);
        ResponseEntity actual = mockBeadController.deleteBeadById(2L);

        verify(mockBeadService).deleteBeadById(anyLong());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void deleteBeadTest(){

    }

}
