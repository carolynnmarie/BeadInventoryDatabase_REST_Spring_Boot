package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;
import com.beadinventory.beadinventory.Controller.SuppliesControllers.FindingController;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Service.SuppliesServices.FindingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Array;
import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
public class FindingControllerTest {

    @Mock
    private FindingService mockFindingService;

    @InjectMocks
    private FindingController mockFindingController;

    private TreeSet<String> brands;
    private Finding eyePin;
    private Finding headPin;
    private Finding lobsterClasp;
    private Finding lobsterClasp2;
    private Finding splitRing;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        brands = new TreeSet<>(Arrays.asList("Beadalon","bead landing"));
        eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,25,brands);
        eyePin.setId(1L);
        headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,brands);
        headPin.setId(2L);
        lobsterClasp = new Finding(LOBSTER_CLASP,BRIGHT_SILVER_PLATED,"small",2,0.1,10,brands);
        lobsterClasp.setId(3L);
        lobsterClasp2 = new Finding(LOBSTER_CLASP,DULL_SILVER_PLATED,"medium",4,.1,10,brands);
        lobsterClasp2.setId(4L);
        splitRing = new Finding(SPLIT_RING,BRASS,"smallest",1,.01,25,brands);
        splitRing.setId(5L);
    }

    @Test
    public void findAllFindingsTest(){
        List<Finding> list = new ArrayList<>(Arrays.asList(headPin,eyePin,lobsterClasp,lobsterClasp2,splitRing));
        ResponseEntity<List<Finding>> expected = new ResponseEntity<>(list, OK);
        given(mockFindingService.getAllFindings()).willReturn(expected);
        ResponseEntity<List<Finding>> actual = mockFindingController.findAllFindings();

        verify(mockFindingService).getAllFindings();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findAllOfCategoryTest(){
        List<Finding> list = new ArrayList<>(Arrays.asList(lobsterClasp2,lobsterClasp));
        ResponseEntity<List<Finding>> expected = new ResponseEntity<>(list,OK);
        given(mockFindingService.getAllOfCategory(LOBSTER_CLASP)).willReturn(expected);
        ResponseEntity<List<Finding>> actual = mockFindingController.findAllOfCategory(LOBSTER_CLASP);

        verify((mockFindingService)).getAllOfCategory(any(FindingCategory.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findAllOfMaterial(){
        List<Finding> list = new ArrayList<>(Arrays.asList(headPin,eyePin,lobsterClasp));
        ResponseEntity<List<Finding>> expected = new ResponseEntity<>(list,OK);
        given(mockFindingService.getAllOfMaterial(BRIGHT_SILVER_PLATED)).willReturn(expected);
        ResponseEntity<List<Finding>> actual = mockFindingController.findAllOfMaterial(BRIGHT_SILVER_PLATED);

        verify((mockFindingService)).getAllOfMaterial(any(Material.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findAllOfCategoryAndMaterialTest(){
        List<Finding> list = new ArrayList<>(Arrays.asList(headPin));
        ResponseEntity<List<Finding>> expected = new ResponseEntity<>(list,OK);
        given(mockFindingService.getAllOfCategoryAndMaterial(HEAD_PIN,BRIGHT_SILVER_PLATED)).willReturn(expected);
        ResponseEntity<List<Finding>> actual = mockFindingController.findAllOfCategoryAndMaterial(HEAD_PIN,BRIGHT_SILVER_PLATED);

        verify(mockFindingService).getAllOfCategoryAndMaterial(any(FindingCategory.class),any(Material.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findAllOfCategoryTypeTest(){
        List<Finding> list = new ArrayList<>(Arrays.asList(headPin,eyePin));
        ResponseEntity<List<Finding>> expected = new ResponseEntity<>(list,OK);
        given(mockFindingService.getAllOfCategoryType("pin")).willReturn(expected);
        ResponseEntity<List<Finding>> actual = mockFindingController.findAllOfCategoryType("pin");

        verify(mockFindingService).getAllOfCategoryType(any(String.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getFindingByIdTest(){
        ResponseEntity<Finding> expected = new ResponseEntity<>(eyePin,OK);
        given(mockFindingService.findById(anyLong())).willReturn(expected);
        ResponseEntity<Finding> actual = mockFindingController.getFindingById(eyePin.getId());

        verify(mockFindingService).findById(anyLong());
        Assert.assertEquals(expected,actual);
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
        ResponseEntity<Finding> actual = mockFindingController.updateFinding(eyePin.getId(),eyePin);

        verify(mockFindingService).updateFinding(anyLong(),any(Finding.class));
        Assert.assertEquals(expected,actual);
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
