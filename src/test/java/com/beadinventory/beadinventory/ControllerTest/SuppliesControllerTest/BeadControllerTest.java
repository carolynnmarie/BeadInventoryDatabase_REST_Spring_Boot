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

    TreeSet<String> brands = new TreeSet<>(Arrays.asList("Bead Gallery"));
    private Bead bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20,
            "translucent purple with some white", 0.2, brands);
    private Bead bead2 = new Bead(JASPER, ROUND, "black", 4, "good", 10, "",
            0.1, brands);
    private Bead bead3 = new Bead(STONE, ROUND, "tan", 6, "ok", 7,
            "with design cut into bead", 0.05, brands);
    private Bead bead4 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple",
            0.2,brands);
    private Bead bead5 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple",
            0.2,brands);


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
    public void findAllOfMaterialAndColorTest(){
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2));
        given(mockBeadService.getAllOfMaterialAndColor(any(Material.class),any(String.class))).willReturn(new ResponseEntity<>(list,OK));
        List<Bead> actual = mockBeadController.findAllOfMaterialAndColor(JASPER,"black");

        verify(mockBeadService).getAllOfMaterialAndColor(any(Material.class),any(String.class));
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
        given(mockBeadService.updateBeadQuantity(bead3.getId(),20L)).willReturn(new ResponseEntity<>(bead4,OK));
        Long expected = 20L;
        Long actual = mockBeadController.updateBeadQuantity(bead3.getId(),20L);

        verify(mockBeadService).updateBeadQuantity(anyLong(),anyLong());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateBeadTest(){
        given(mockBeadService.updateBead(bead3.getId(),bead3)).willReturn(new ResponseEntity<>(bead3,OK));
        Bead expected = bead3;
        Bead actual = mockBeadController.updateBead(bead3.getId(),bead3);

        verify(mockBeadService).updateBead(anyLong(),any(Bead.class));
        Assert.assertEquals(expected,actual);
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
