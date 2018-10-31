package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;


import com.beadinventory.beadinventory.Controller.SuppliesControllers.StringWireController;
import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.HttpStatus.OK;
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

    private StringWire beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm","good",.5,"Beadalon", "7 strand");
    private StringWire brassChain = new StringWire(CHAIN,BRASS,"brass","thin","okay",.5,"bead landing","");
    private StringWire leatherCord = new StringWire(CORD,LEATHER,"black","medium","okay",.5,"bead landing", "");

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

    @Test
    public void getByIdIntegTest() throws Exception{
        given(mockController.getById(brassChain.getId())).willReturn(brassChain);

        mockMvc.perform(get("/stringing_materials/{id}",brassChain.getId())
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createStringWireIntegTest() throws Exception{
        given(mockController.createStringWire(brassChain)).willReturn(mock(ResponseEntity.class));

        String body = mapper.writeValueAsString(brassChain);
        mockMvc.perform(post("/stringing_materials")
                .content(body)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateStringWireIntegTest() throws Exception{
        given(mockController.updateStringWire(beadingWire.getId(),beadingWire)).willReturn(beadingWire);

        String body = mapper.writeValueAsString(beadingWire);
        mockMvc.perform(put("/stringing_materials/{id}",beadingWire.getId())
                .content(body)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteStringWireByIdIntegTest() throws Exception{
        given(mockController.deleteStringWireById(beadingWire.getId())).willReturn(new ResponseEntity(OK));

        mockMvc.perform(delete("/stringing_materials/{id}",beadingWire.getId())
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
