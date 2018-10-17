package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;


import com.beadinventory.beadinventory.Controller.SuppliesControllers.StringWireController;
import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@WebMvcTest(StringWireController.class)
public class StringWireContIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StringWireController mockController;

    private ObjectMapper mapper = new ObjectMapper();

    private StringWire beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm",7, "good",.5,"Beadalon");
    private StringWire brassChain = new StringWire(CHAIN,BRASS,"brass","thin",1,"okay",0.5,"bead landing");
    private StringWire leatherCord = new StringWire(CORD,LEATHER,"black","medium",1,"okay",0.5, "bead landing");

    @Test
    public void getAllStringWireIntegTest()throws Exception{
        List<StringWire> list = new ArrayList<>(Arrays.asList(beadingWire,brassChain,leatherCord));
        given(mockController.getAllStringWire()).willReturn(list);

        mockMvc.perform(get("/stringing_materials")
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllOfCategoryIntegTest() throws Exception{
        List<StringWire> list = new ArrayList<>(Arrays.asList(leatherCord));
        given(mockController.getAllOfCategory(CORD)).willReturn(list);

        mockMvc.perform(get("/stringing_materials/category")
                .requestAttr("category",CORD)
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllOfMaterialIntegTest() throws Exception{
        List<StringWire> list = new ArrayList<>(Arrays.asList(leatherCord));
        given(mockController.getAllOfMaterial(LEATHER)).willReturn(list);

        mockMvc.perform(get("/stringing_materials/material")
                .requestAttr("material", LEATHER)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

}
/*
List<StringWire> getAllOfCategory(@RequestParam(value = "category")StringWireCategory category)
List<StringWire> getAllOfMaterial(@RequestParam(value = "material")Material material)
StringWire getById(@PathVariable("id")long id)
StringWire createStringWire(@RequestBody StringWire stringWire)
StringWire updateStringWire(@PathVariable("id")long id,
                                       @RequestBody StringWire stringWire)
ResponseEntity deleteStringWireById(@PathVariable("id") long id)
 */