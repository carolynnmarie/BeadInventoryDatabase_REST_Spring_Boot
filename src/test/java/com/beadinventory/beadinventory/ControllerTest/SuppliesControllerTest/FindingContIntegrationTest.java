package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;


import com.beadinventory.beadinventory.Controller.SuppliesControllers.FindingController;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
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

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;
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

    private ObjectMapper mapper = new ObjectMapper();


    private List<String> brands = new ArrayList<>(Arrays.asList("beadalon"));
    private Finding eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,25,"Beadalon");
    private Finding eyePin2 = new Finding(EYE_PIN, BRASS,"thin",5.08,5.08,25,"Beadalon");
    private Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,"Beadalon");


    @Test
    public void findAllFindingsIntegTest() throws Exception{
        List<Finding> list = new ArrayList<>(Arrays.asList(eyePin,headPin));
        given(mockFindingController.findAllFindings()).willReturn(list);

        mockMvc.perform(get("/findings")
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void findAllOfCategoryTypeIntegTest() throws Exception{
        List<Finding> list = new ArrayList<>(Arrays.asList(eyePin,headPin));
        given(mockFindingController.findAllOfCategoryType("pin")).willReturn(list);

        mockMvc.perform(get("/findings")
                .param("type","pin")
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void findAllOfCategoryIntegTest() throws Exception{
        List<Finding> list = new ArrayList<>(Arrays.asList(eyePin, eyePin2));
        given(mockFindingController.findAllOfCategory(EYE_PIN)).willReturn(list);

        mockMvc.perform(get("/findings")
                .requestAttr("findingCategory",EYE_PIN)
                .param("findingCategory", String.valueOf(FindingCategory.class))
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void findAllOfMaterialIntegTest() throws Exception{
        List<Finding> list = new ArrayList<>(Arrays.asList(eyePin,headPin));
        given(mockFindingController.findAllOfMaterial(BRIGHT_SILVER_PLATED)).willReturn(list);

        String mParam = mapper.writeValueAsString(BRIGHT_SILVER_PLATED);
        mockMvc.perform(get("/findings")
                .param("material", String.valueOf(Material.class))
                .requestAttr("material",BRIGHT_SILVER_PLATED)
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findAllOfCategoryAndMaterialIntegTest() throws Exception{
        List<Finding> list = new ArrayList<>(Arrays.asList(eyePin));
        given(mockFindingController.findAllOfCategoryAndMaterial(EYE_PIN,BRIGHT_SILVER_PLATED)).willReturn(list);

        mockMvc.perform((get("/findings")
                .param("findingCategory", String.valueOf(FindingCategory.class))
                .param("material", String.valueOf(Material.class))
                .requestAttr("findingCategory",EYE_PIN)
                .requestAttr("material",BRIGHT_SILVER_PLATED)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8")))
                .andExpect(status().isOk());
    }

    @Test
    public void getFindingByIdIntegTest() throws Exception {
        headPin.setId(2L);
        given(mockFindingController.getFindingById(headPin.getId())).willReturn(headPin);

        mockMvc.perform(get("/findings/{id}",2L)
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createFindingIntegTest() throws Exception{
        given(mockFindingController.createFinding(headPin)).willReturn(mock(ResponseEntity.class));

        String body = mapper.writeValueAsString(headPin);
        mockMvc.perform(post("/findings")
                .content(body)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateFindingIntegTest() throws Exception{
        headPin.setId(3L);
        given(mockFindingController.updateFinding(headPin.getId(),headPin)).willReturn(headPin);

        String body = mapper.writeValueAsString(headPin);
        mockMvc.perform(put("/findings/{id}",3L)
                .content(body)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteFindingByIdIntegTest() throws Exception{
        eyePin.setId(1L);
        given(mockFindingController.deleteFindingById(1L)).willReturn(new ResponseEntity(OK));

        mockMvc.perform(delete("/findings/{id}",1L)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteFindingIntegTest() throws Exception {
        given(mockFindingController.deleteFinding(headPin)).willReturn(new ResponseEntity(OK));

        String body = mapper.writeValueAsString(headPin);
        mockMvc.perform(delete("/findings")
                .contentType(APPLICATION_JSON)
                .content(body)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }
}
