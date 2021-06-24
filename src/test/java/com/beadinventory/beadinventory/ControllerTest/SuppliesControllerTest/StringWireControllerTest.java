package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;

import com.beadinventory.beadinventory.REST.Controller.SuppliesControllers.StringWireController;
import com.beadinventory.beadinventory.REST.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.StringWireCategory;
import com.beadinventory.beadinventory.REST.Service.SuppliesServices.StringWireService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.StringWireCategory.BEADING_WIRE;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.StringWireCategory.CHAIN;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.StringWireCategory.CORD;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.*;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
public class StringWireControllerTest {

    @Mock
    StringWireService mockService;

    @InjectMocks
    StringWireController mockController;

    private StringWire beadingWire;
    private StringWire brassChain;
    private StringWire leatherCord;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        this.beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm","good",.5,"Beadalon", "7 strand");
        beadingWire.setId(1L);
        this.brassChain = new StringWire(CHAIN,BRASS,"brass","thin","okay",.5,"bead landing","");
        brassChain.setId(2L);
        this.leatherCord = new StringWire(CORD,LEATHER,"black","medium","okay",.5,"bead landing", "");
        leatherCord.setId(3L);
    }

    @Test
    public void getAllStringWireTest(){
        List<StringWire> list = new ArrayList<>(Arrays.asList(beadingWire,brassChain,leatherCord));
        given(mockService.getAllStringWire()).willReturn(new ResponseEntity<>(list,OK));
        List<StringWire> actual = mockController.findAllStringWire();

        verify(mockService).getAllStringWire();
        Assert.assertEquals(list,actual);
    }

    @Test
    public void getAllOfCategoryTest(){
        List<StringWire> expected = new ArrayList<>(Arrays.asList(leatherCord));
        given(mockService.getAllOfCategory(any(StringWireCategory.class))).willReturn(new ResponseEntity<>(expected,OK));
        List<StringWire> actual = mockController.findAllOfCategory(CORD);

        verify(mockService).getAllOfCategory(any(StringWireCategory.class));
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getAllOfMaterialTest(){
        List<StringWire> expected = new ArrayList<>(Arrays.asList(leatherCord));
        given(mockService.getAllOfMaterial(LEATHER)).willReturn(new ResponseEntity<>(expected,OK));
        List<StringWire> actual = mockController.findAllOfMaterial(LEATHER);

        verify(mockService).getAllOfMaterial(any(Material.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getByIdTest(){
        StringWire expected = leatherCord;
        given(mockService.getById(anyLong())).willReturn(new ResponseEntity<>(expected,OK));
        StringWire actual = mockController.findById(3L);

        verify(mockService).getById(anyLong());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void createStringWireTest(){
        StringWire expected = leatherCord;
        given(mockService.createStringWire(leatherCord)).willReturn(new ResponseEntity<>(expected,CREATED));
        StringWire actual = mockController.createStringWire(leatherCord).getBody();

        verify(mockService).createStringWire(any(StringWire.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateStringWireTest(){
        StringWire expected = leatherCord;
        given(mockService.updateStringWire(leatherCord.getId(),leatherCord)).willReturn(new ResponseEntity<>(leatherCord,OK));
        StringWire actual = mockController.updateStringWire(leatherCord.getId(),leatherCord);

        verify(mockService).updateStringWire(anyLong(),any(StringWire.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void deleteStringWireByIdTest(){
        ResponseEntity expected = new ResponseEntity(OK);
        given(mockService.deleteById(leatherCord.getId())).willReturn(expected);
        ResponseEntity actual = mockController.deleteStringWireById(leatherCord.getId());

        verify(mockService).deleteById(anyLong());
        Assert.assertEquals(expected,actual);
    }

}