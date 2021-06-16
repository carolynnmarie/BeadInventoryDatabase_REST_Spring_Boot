package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;

import com.beadinventory.beadinventory.Controller.SuppliesControllers.FindingController;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import com.beadinventory.beadinventory.Service.SuppliesServices.FindingService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.*;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
public class FindingControllerTest {

    @Mock
    private FindingService mockFindingService;

    @InjectMocks
    private FindingController mockFindingController;

    private Finding eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,5.08,5.08,25,"Beadalon","thin");
    private Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,5.08,5.08,20,"Beadalon","thin");
    private Finding lobsterClasp = new Finding(LOBSTER_CLASP,BRIGHT_SILVER_PLATED,2,0.1,10,"Beadalon","small");
    private Finding lobsterClasp2 = new Finding(LOBSTER_CLASP,DULL_SILVER_PLATED,4,.1,10,"Beadalon","medium");
    private Finding splitRing = new Finding(SPLIT_RING,BRASS,1,.01,25,"Beadalon","smallest");

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        eyePin.setId(1L);
        headPin.setId(2L);
        lobsterClasp.setId(3L);
        lobsterClasp2.setId(4L);
        splitRing.setId(5L);
    }

    @Test
    public void findAllFindingsTest(){
        List<Finding> list = new ArrayList<>(Arrays.asList(headPin,eyePin,lobsterClasp,lobsterClasp2,splitRing));
        ResponseEntity<List<Finding>> expected = new ResponseEntity<>(list, OK);
        given(mockFindingService.getAllFindings()).willReturn(expected);
        List<Finding> actual = mockFindingController.findAllFindings();

        verify(mockFindingService).getAllFindings();
        Assert.assertEquals(list,actual);
    }

    @Test
    public void findAllOfCategoryTypeTest(){
        List<Finding> list = new ArrayList<>(Arrays.asList(headPin,eyePin));
        ResponseEntity<List<Finding>> expected = new ResponseEntity<>(list,OK);
        given(mockFindingService.getAllOfCategoryType("pin")).willReturn(expected);
        List<Finding> actual = mockFindingController.findAllOfCategoryType("pin");

        verify(mockFindingService).getAllOfCategoryType(any(String.class));
        Assert.assertEquals(list,actual);
    }

    @Test
    public void findAllOfCategoryTest(){
        List<Finding> list = new ArrayList<>(Arrays.asList(lobsterClasp2,lobsterClasp));
        ResponseEntity<List<Finding>> expected = new ResponseEntity<>(list,OK);
        given(mockFindingService.getAllOfCategory(LOBSTER_CLASP)).willReturn(expected);
        List<Finding> actual = mockFindingController.findAllOfCategory(LOBSTER_CLASP);

        verify((mockFindingService)).getAllOfCategory(any(FindingCategory.class));
        Assert.assertEquals(list,actual);
    }

    @Test
    public void findAllOfMaterial(){
        List<Finding> list = new ArrayList<>(Arrays.asList(headPin,eyePin,lobsterClasp));
        ResponseEntity<List<Finding>> expected = new ResponseEntity<>(list,OK);
        given(mockFindingService.getAllOfMaterial(BRIGHT_SILVER_PLATED)).willReturn(expected);
        List<Finding> actual = mockFindingController.findAllOfMaterial(BRIGHT_SILVER_PLATED);

        verify((mockFindingService)).getAllOfMaterial(any(Material.class));
        Assert.assertEquals(list,actual);
    }

    @Test
    public void findAllOfCategoryAndMaterialTest(){
        List<Finding> list = new ArrayList<>(Arrays.asList(headPin));
        ResponseEntity<List<Finding>> expected = new ResponseEntity<>(list,OK);
        given(mockFindingService.getAllOfCategoryAndMaterial(HEAD_PIN,BRIGHT_SILVER_PLATED)).willReturn(expected);
        List<Finding> actual = mockFindingController.findAllOfCategoryAndMaterial(HEAD_PIN,BRIGHT_SILVER_PLATED);

        verify(mockFindingService).getAllOfCategoryAndMaterial(any(FindingCategory.class),any(Material.class));
        Assert.assertEquals(list,actual);
    }



    @Test
    public void getFindingByIdTest(){
        ResponseEntity<Finding> expected = new ResponseEntity<>(eyePin,OK);
        given(mockFindingService.getById(anyLong())).willReturn(expected);
        Finding actual = mockFindingController.getFindingById(eyePin.getId());

        verify(mockFindingService).getById(anyLong());
        Assert.assertEquals(eyePin,actual);
    }

    @Test
    public void createFindingTest(){
        ResponseEntity<Finding> expected = new ResponseEntity<>(eyePin,CREATED);
        given(mockFindingService.createFinding(any(Finding.class))).willReturn(expected);
        ResponseEntity<Finding> actual = mockFindingController.createFinding(eyePin);

        verify(mockFindingService).createFinding(any(Finding.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateFindingTest(){
        ResponseEntity<Finding> expected = new ResponseEntity<>(eyePin,OK);
        given(mockFindingService.updateFinding(eyePin.getId(),eyePin)).willReturn(expected);
        Finding actual = mockFindingController.updateFinding(eyePin.getId(),eyePin);

        verify(mockFindingService).updateFinding(anyLong(),any(Finding.class));
        Assert.assertEquals(eyePin,actual);
    }

    @Test
    public void deleteFindingByIdTest(){
        ResponseEntity expected = new ResponseEntity(OK);
        given(mockFindingService.deleteById(headPin.getId())).willReturn(expected);
        ResponseEntity actual = mockFindingController.deleteFindingById(headPin.getId());

        verify(mockFindingService).deleteById(anyLong());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void deleteFindingTest(){
        ResponseEntity expected = new ResponseEntity(OK);
        given(mockFindingService.deleteFinding(headPin)).willReturn(expected);
        ResponseEntity actual = mockFindingController.deleteFinding(headPin);

        verify(mockFindingService).deleteFinding(any(Finding.class));
        Assert.assertEquals(expected,actual);
    }

}
