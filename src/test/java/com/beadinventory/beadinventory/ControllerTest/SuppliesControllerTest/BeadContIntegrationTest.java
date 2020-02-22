package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;

import com.beadinventory.beadinventory.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.HttpStatus.*;


@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@WebMvcTest(BeadController.class)
public class BeadContIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BeadController mockBeadController;

    private ObjectMapper mapper = new ObjectMapper();

    List<String> brands = new ArrayList<>(Arrays.asList("Bead Gallery"));
    private Bead bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20, "translucent purple", 0.2, "Beadalon");
    private Bead bead2 = new Bead(JASPER, ROUND, "black", 4, "good", 10, "", 0.1, "Beadalon");
    private Bead bead3 = new Bead(STONE, ROUND, "tan", 6, "ok", 7, "with design cut into bead", 0.05, "Beadalon");
    private Bead bead4 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple", 0.2,"Beadalon");
    private Bead bead5 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple", 0.2,"Beadalon");



    @Before
    public void setUp(){
        bead1.setBeadId(1L);
    }

    @Test
    public void findAllBeadsIntegTest() throws Exception{
        List<Bead> list = new ArrayList<>(Arrays.asList(bead1,bead2,bead3,bead4,bead5));
        given(mockBeadController.findAllBeads()).willReturn(list);

        mockMvc.perform(get("/beads")
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllOrderByMaterialIntegTest() throws Exception {
        List<Bead> list = new ArrayList<>(Arrays.asList(bead1,bead4,bead5,bead2,bead3));
        given(mockBeadController.findAllOrderByMaterial()).willReturn(list);

        mockMvc.perform(get("/beads/getAllOrderByMaterial")
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void findAllOfMaterialIntegTest() throws Exception{
        List<Bead> list = new ArrayList<>(Arrays.asList(bead1,bead4,bead5));
        given(mockBeadController.findAllOfMaterial(any(Material.class))).willReturn(list);

        mockMvc.perform(get("/beads")
                .param("material",String.valueOf(AMETHYST))
                .requestAttr("material",AMETHYST)
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }



    @Test
    public void findAllOfMaterialAndColorIntegTest() throws Exception{
        List<Bead> list = new ArrayList<>(Arrays.asList(bead1,bead4,bead5));
        given(mockBeadController.findAllOfMaterialAndColor(AMETHYST,"purple")).willReturn(list);

        mockMvc.perform(get("/beads")
                .param("material", String.valueOf(Material.class))
                .param("color", "purple")
                .requestAttr("material", AMETHYST)
                .requestAttr("color","purple")
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findAllOfMaterialAndSizeIntegTest() throws Exception{
        List<Bead> list = new ArrayList<>(Arrays.asList(bead1,bead5));
        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list,OK);
        given(mockBeadController.findAllOfMaterialAndSize(AMETHYST,4)).willReturn(list);

        mockMvc.perform(get("/beads")
                .param("material", String.valueOf(Material.class))
                .param("size", String.valueOf(Integer.class))
                .requestAttr("material",AMETHYST)
                .requestAttr("size", 4)
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findAllWithQuantityLessThanIntegTest() throws Exception{
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2,bead3,bead5));
        given(mockBeadController.findAllWithQuantityLessThan(12L)).willReturn(list);

        mockMvc.perform(get("/beads")
                .param("quantity", String.valueOf(12L))
                .requestAttr("quantity",12L)
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getBeadByIdIntegTest() throws Exception{
        given(mockBeadController.findBeadById(1L)).willReturn(bead1);

        mockMvc.perform(get("/beads/{id}",1L)
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void createBeadIntegTest() throws Exception{
        given(mockBeadController.createBead(bead1)).willReturn(mock(ResponseEntity.class));

        String body = mapper.writeValueAsString(bead1);
        mockMvc.perform(post("/beads")
                .content(body)
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateBeadQuantityIntegTest() throws Exception{
        bead1.setQuantity(10);
        given(mockBeadController.updateBeadQuantity(bead1.getBeadId(),10)).willReturn(bead1);

        mockMvc.perform(put("/beads/{id}",bead1.getBeadId())
                .param("quantity",String.valueOf(10L))
                .requestAttr("quantity",10L)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }


    @Test
    public void deleteBeadByIdIntegTest() throws Exception{
        given(mockBeadController.deleteBeadById(bead1.getBeadId())).willReturn(new ResponseEntity(OK));

        mockMvc.perform(delete("/beads/{id}",bead1.getBeadId())
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteBeadIntegTest() throws Exception{
        given(mockBeadController.deleteBead(bead1)).willReturn(new ResponseEntity(OK));

        String body = mapper.writeValueAsString(bead1);
        mockMvc.perform(delete("/beads")
                .content(body)
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
