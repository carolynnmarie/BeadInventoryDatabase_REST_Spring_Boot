package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;


import com.beadinventory.beadinventory.Controller.SuppliesControllers.FindingController;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.HttpStatus.*;
import static org.mockito.Mockito.mock;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@WebMvcTest(FindingController.class)
public class FindingContIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private FindingController mockFindingController;


    private TreeSet<String> brands;
    private Finding eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,25,brands);
    private Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,brands);
//    private Finding lobsterClasp;
//    private Finding lobsterClasp2;
//    private Finding splitRing;

    @Test
    public void findAllOfCategoryTypeIntegTest() throws Exception{
        List<Finding> list = new ArrayList<>(Arrays.asList(eyePin,headPin));
        ResponseEntity<List<Finding>> expected = new ResponseEntity<>(list,OK);
        given(mockFindingController.findAllOfCategoryType("pin")).willReturn(expected);
        mockMvc.perform(get("/findings")
                .characterEncoding("utf-8")
                .content("pin")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
