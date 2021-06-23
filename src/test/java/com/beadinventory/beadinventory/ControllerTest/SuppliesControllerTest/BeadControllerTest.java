package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;

import com.beadinventory.beadinventory.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;
import static org.mockito.ArgumentMatchers.*;
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

    List<String> brands = new ArrayList<>(Arrays.asList("Bead Gallery"));
    private Bead bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20, "translucent purple with some white", 0.2, "Beadalon");
    private Bead bead2 = new Bead(JASPER, ROUND, "black", 4, "good", 10, "", 0.1, "Beadalon");
    private Bead bead3 = new Bead(STONE, ROUND, "tan", 6, "ok", 7, "with design cut into bead", 0.05, "Beadalon");
    private Bead bead4 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple", 0.2,"Beadalon");
    private Bead bead5 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple", 0.2,"Beadalon");


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        bead1.setBeadId(1L);
        bead2.setBeadId(2L);
        bead3.setBeadId(3L);
    }

    @Test
    public void testGetAllBeads() {
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2, bead1));
        given(mockBeadService.getAllBeads()).willReturn(new ResponseEntity<>(list, OK));
        List<Bead> actual = mockBeadController.findAllBeads();

        verify(mockBeadService).getAllBeads();
        Assert.assertEquals(list, actual);
    }

    @Test
    public void testOrderByMaterial(){
        List<Bead> list = new ArrayList<>(Arrays.asList(bead1,bead4,bead5,bead2,bead3));
        given(mockBeadService.getAllOrderByMaterial()).willReturn(new ResponseEntity<>(list,OK));
        List<Bead> actual = mockBeadController.findAllOrderByMaterial();

        verify(mockBeadService).getAllOrderByMaterial();
        Assert.assertEquals(list, actual);
    }


    @Test
    public void testFindAllOfMaterial(){
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2));
        given(mockBeadService.getAllOfMaterial(JASPER)).willReturn(new ResponseEntity<>(list,OK));
        List<Bead> actual = mockBeadController.findAllOfMaterial(JASPER);

        verify(mockBeadService).getAllOfMaterial(any(Material.class));
        Assert.assertEquals(list, actual);
    }

    @Test
    public void findAllOfMaterialAndSizeTest(){
        List<Bead> expected = new ArrayList<>(Arrays.asList(bead1));
        given(mockBeadService.getAllOfMaterialAndSize(AMETHYST,4)).willReturn(new ResponseEntity<>(expected,OK));
        List<Bead> actual = mockBeadController.findAllOfMaterialAndSize(AMETHYST,4);

        verify(mockBeadService).getAllOfMaterialAndSize(any(Material.class),anyInt());
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void findAllWithQuantityLessThanTest(){
        List<Bead> expected = new ArrayList<>(Arrays.asList(bead2,bead3));
        given(mockBeadService.getAllQuantityLessThan(12)).willReturn(new ResponseEntity<>(expected,OK));
        List<Bead> actual = mockBeadController.findAllWithQuantityLessThan(12);

        verify(mockBeadService).getAllQuantityLessThan(anyLong());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findBeadByIdTest(){
        given(mockBeadService.getBeadById(anyLong())).willReturn(new ResponseEntity<>(bead1,OK));
        Bead expected = bead1;
        Bead actual = mockBeadController.findBeadById(1L);

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
        Bead bead4 = bead3;
        bead4.setQuantity(20L);
        given(mockBeadService.updateBeadQuantity(bead3.getBeadId(),20L)).willReturn(new ResponseEntity<>(bead4,OK));
        Long expected = 20L;
        Long actual = mockBeadController.updateBeadQuantity(bead3.getBeadId(),20L).getQuantity();

        verify(mockBeadService).updateBeadQuantity(anyLong(),anyLong());
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void deleteBeadByIdTest(){
        ResponseEntity expected = new ResponseEntity(OK);
        given(mockBeadService.deleteBeadById(anyLong())).willReturn(expected);
        ResponseEntity actual = mockBeadController.deleteBeadById(2L);

        verify(mockBeadService).deleteBeadById(anyLong());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void deleteBeadTest(){
        ResponseEntity expected = new ResponseEntity(OK);
        given(mockBeadService.deleteBead(any(Bead.class))).willReturn(expected);
        ResponseEntity actual = mockBeadController.deleteBead(bead3);

        verify(mockBeadService).deleteBead(any(Bead.class));
        Assert.assertEquals(expected,actual);
    }

//    @Test
//    public void getAllOfMaterialCategoryTest(){
//        MaterialCategory category = MaterialCategory.SEMI_PRECIOUS_STONE;
//        List<Bead> list = new ArrayList<>(Arrays.asList(bead1,bead2,bead3,bead4,bead5));
//        given(mockBeadService.getAllBeads()).willReturn(new ResponseEntity<>(list, OK));
//
//        List<Bead> expected = new ArrayList<>(Arrays.asList(bead1,bead4,bead5,bead2));
//        List<Bead> actual = mockBeadController.getAllOfMaterialCategory(category);
//
//        verify(mockBeadService).getAllBeads();
//        Assert.assertEquals(expected,actual);
//    }
//
//    @Test
//    public void findBeadQuantityTest(){
//        long expected = 20L;
//        long actual = mockBeadController.findBeadQuantity(bead1);
//        Assert.assertEquals(expected,actual);
//    }
}