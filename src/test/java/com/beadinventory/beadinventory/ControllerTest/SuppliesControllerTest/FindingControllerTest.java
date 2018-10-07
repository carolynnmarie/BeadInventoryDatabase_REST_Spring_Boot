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

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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



}
