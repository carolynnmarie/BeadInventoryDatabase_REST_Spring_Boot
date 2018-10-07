package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;
import com.beadinventory.beadinventory.Controller.SuppliesControllers.FindingController;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
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
        headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,brands);
        lobsterClasp = new Finding(LOBSTER_CLASP,BRIGHT_SILVER_PLATED,"small",2,0.1,10,brands);
        lobsterClasp2 = new Finding(LOBSTER_CLASP,DULL_SILVER_PLATED,"medium",4,.1,10,brands);
        splitRing = new Finding(SPLIT_RING,BRASS,"smallest",1,.01,25,brands);
    }

    @Test
    public void findAllFindingsTest(){

    }

    @Test
    public void findAllOfCategoryTest(){

    }

    @Test
    public void findAllOfMaterial(){

    }

    @Test
    public void findAllOfCategoryAndMaterialTest(){

    }

    @Test
    public void findAllOfCategoryAndLengthTest(){

    }

    @Test
    public void getFindingByIdTest(){

    }

}
/*
ResponseEntity<List<Finding>> findAllFindings()
ResponseEntity<List<Finding>> findAllOfCategory(@RequestParam(value = "findingCategory")FindingCategory findingCategory)
ResponseEntity<List<Finding>> findAllOfMaterial(@RequestParam(value = "material")Material material)
ResponseEntity<List<Finding>> findAllOfCategoryAndMaterial(@RequestParam(value = "category") FindingCategory category,
                                                                      @RequestParam(value = "material") Material material)
ResponseEntity<List<Finding>> findAllOfCategoryAndLength(@RequestParam(value = "category") FindingCategory category,
                                                                    @RequestParam(value = "length") double length)
ResponseEntity<Finding> getFindingById(@PathVariable("id") long id)
ResponseEntity<Finding> createFinding(@RequestBody Finding finding)
ResponseEntity<Finding> updateFinding(@PathVariable("id")long id, @RequestBody Finding finding)
ResponseEntity deleteFindingById(@PathVariable("id") long id)
ResponseEntity deleteFinding(@RequestBody Finding finding)
 */