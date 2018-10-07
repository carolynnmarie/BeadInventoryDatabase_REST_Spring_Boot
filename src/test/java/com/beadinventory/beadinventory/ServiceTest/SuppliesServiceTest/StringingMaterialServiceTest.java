package com.beadinventory.beadinventory.ServiceTest.SuppliesServiceTest;

import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.StringingMaterialRepo;
import com.beadinventory.beadinventory.Service.SuppliesServices.StringingMaterialService;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class StringingMaterialServiceTest {

    @InjectMocks
    StringingMaterialService mockSMService;

    @Mock
    StringingMaterialRepo mockSMRepo;

    private StringingMaterial beadingWire = new StringingMaterial(BEADING_WIRE,BRIGHT_SILVER_PLATED,".5 mm",7,"good",.5,"Beadalon");
    private StringingMaterial brassChain = new StringingMaterial(CHAIN,BRASS,"thin",1,"okay",.5,"bead landing");
    private StringingMaterial leatherCord = new StringingMaterial(CORD,LEATHER,"medium",1,"okay",.5,"bead landing");

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        beadingWire.setId(1L);
    }


    @Test
    public void getAllMaterialsTest() {
        List<StringingMaterial> list = new ArrayList<>(Arrays.asList(beadingWire,brassChain,leatherCord));
        Iterable<StringingMaterial> iList = Arrays.asList(beadingWire,brassChain,leatherCord);
        given(mockSMRepo.findAll()).willReturn(iList);

        ResponseEntity<List<StringingMaterial>> expected = new ResponseEntity<>(list, OK);
        ResponseEntity<List<StringingMaterial>> actual = mockSMService.getAllStringingMaterials();

        verify(mockSMRepo).findAll();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllOfCategoryTest() {
        List<StringingMaterial> list = new ArrayList<>(Arrays.asList(beadingWire));
        given(mockSMRepo.findStringingMaterialsBySMCategory(BEADING_WIRE)).willReturn(list);

        ResponseEntity<List<StringingMaterial>> expected = new ResponseEntity<>(list, OK);
        ResponseEntity<List<StringingMaterial>> actual = mockSMService.getAllOfCategory(BEADING_WIRE);

        verify(mockSMRepo).findStringingMaterialsBySMCategory(any(StringingMaterialCategory.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllOfMaterialTest() {
        List<StringingMaterial> list = new ArrayList<>(Arrays.asList(beadingWire));
        given(mockSMRepo.findStringingMaterialsByMaterial(BRIGHT_SILVER_PLATED)).willReturn(list);

        ResponseEntity<List<StringingMaterial>> expected = new ResponseEntity<>(list, OK);
        ResponseEntity<List<StringingMaterial>> actual = mockSMService.getAllOfMaterial(BRIGHT_SILVER_PLATED);

        verify(mockSMRepo).findStringingMaterialsByMaterial(any(Material.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getByIdTest() {

        given(mockSMRepo.findById(anyLong())).willReturn(Optional.of(beadingWire));

        ResponseEntity<StringingMaterial> expected = new ResponseEntity<>(beadingWire,OK);
        ResponseEntity<StringingMaterial> actual = mockSMService.getById(beadingWire.getId());

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

        given(mockSMRepo.save(any(StringingMaterial.class))).willReturn(beadingWire);

        ResponseEntity<StringingMaterial> expected = new ResponseEntity<>(beadingWire,responseHeaders,CREATED);
        ResponseEntity<StringingMaterial> actual = mockSMService.createStringingMaterial(beadingWire);

        verify(mockSMRepo).save(any(StringingMaterial.class));
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void updateStringingMaterialTest() {
        given(mockSMRepo.save(any(StringingMaterial.class))).willReturn(beadingWire);
        ResponseEntity<StringingMaterial> expected = new ResponseEntity<>(beadingWire,OK);
        ResponseEntity<StringingMaterial> actual = mockSMService.updateStringingMaterial(beadingWire.getId(),beadingWire);
        verify(mockSMRepo).save(any(StringingMaterial.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void deleteByIdTest() {
        ResponseEntity expected = new ResponseEntity(OK);
        ResponseEntity actual = mockSMService.deleteById(1L);

        verify(mockSMRepo).deleteById(anyLong());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void deleteStringingMaterialTest() {
        ResponseEntity expected = new ResponseEntity(OK);
        ResponseEntity actual = mockSMService.deleteStringingMaterial(beadingWire);
        verify(mockSMRepo).delete(any(StringingMaterial.class));
        Assert.assertEquals(expected,actual);
    }
}