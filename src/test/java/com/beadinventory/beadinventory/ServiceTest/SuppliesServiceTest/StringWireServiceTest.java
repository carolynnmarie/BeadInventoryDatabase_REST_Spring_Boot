package com.beadinventory.beadinventory.ServiceTest.SuppliesServiceTest;

import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.StringWireRepo;
import com.beadinventory.beadinventory.Service.SuppliesServices.StringWireService;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class StringWireServiceTest {

    @InjectMocks
    private StringWireService mockSMService;

    @Mock
    private StringWireRepo mockSMRepo;

    private StringWire beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm",7,"good",.5,"Beadalon");
    private StringWire brassChain = new StringWire(CHAIN,BRASS,"brass","thin",1,"okay",.5,"bead landing");
    private StringWire leatherCord = new StringWire(CORD,LEATHER,"black","medium",1,"okay",.5,"bead landing");

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        beadingWire.setId(1L);
    }


    @Test
    public void getAllMaterialsTest() {
        List<StringWire> list = new ArrayList<>(Arrays.asList(beadingWire,brassChain,leatherCord));
        Iterable<StringWire> iList = Arrays.asList(beadingWire,brassChain,leatherCord);
        given(mockSMRepo.findAll()).willReturn(iList);

        ResponseEntity<List<StringWire>> expected = new ResponseEntity<>(list, OK);
        ResponseEntity<List<StringWire>> actual = mockSMService.getAllStringWire();

        verify(mockSMRepo).findAll();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllOfCategoryTest() {
        List<StringWire> list = new ArrayList<>(Arrays.asList(beadingWire));
        given(mockSMRepo.findAllByStringWireCategory(BEADING_WIRE)).willReturn(list);

        ResponseEntity<List<StringWire>> expected = new ResponseEntity<>(list, OK);
        ResponseEntity<List<StringWire>> actual = mockSMService.getAllOfCategory(BEADING_WIRE);

        verify(mockSMRepo).findAllByStringWireCategory(any(StringWireCategory.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllOfMaterialTest() {
        List<StringWire> list = new ArrayList<>(Arrays.asList(beadingWire));
        given(mockSMRepo.findAllByMaterial(BRIGHT_SILVER_PLATED)).willReturn(list);

        ResponseEntity<List<StringWire>> expected = new ResponseEntity<>(list, OK);
        ResponseEntity<List<StringWire>> actual = mockSMService.getAllOfMaterial(BRIGHT_SILVER_PLATED);

        verify(mockSMRepo).findAllByMaterial(any(Material.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getByIdTest() {

        given(mockSMRepo.findById(anyLong())).willReturn(Optional.of(beadingWire));

        ResponseEntity<StringWire> expected = new ResponseEntity<>(beadingWire,OK);
        ResponseEntity<StringWire> actual = mockSMService.getById(beadingWire.getId());

        verify(mockSMRepo).findById(anyLong());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void createStringingMaterialTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(beadingWire.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);

        given(mockSMRepo.save(any(StringWire.class))).willReturn(beadingWire);

        ResponseEntity<StringWire> expected = new ResponseEntity<>(beadingWire,responseHeaders,CREATED);
        ResponseEntity<StringWire> actual = mockSMService.createStringWire(beadingWire);

        verify(mockSMRepo).save(any(StringWire.class));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void updateStringingMaterialTest() {
        given(mockSMRepo.save(any(StringWire.class))).willReturn(beadingWire);
        ResponseEntity<StringWire> expected = new ResponseEntity<>(beadingWire,OK);
        ResponseEntity<StringWire> actual = mockSMService.updateStringWire(beadingWire.getId(),beadingWire);
        verify(mockSMRepo).save(any(StringWire.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void deleteByIdTest() {
        ResponseEntity expected = new ResponseEntity(OK);
        ResponseEntity actual = mockSMService.deleteById(1L);

        verify(mockSMRepo).deleteById(anyLong());
        Assert.assertEquals(expected,actual);
    }

}