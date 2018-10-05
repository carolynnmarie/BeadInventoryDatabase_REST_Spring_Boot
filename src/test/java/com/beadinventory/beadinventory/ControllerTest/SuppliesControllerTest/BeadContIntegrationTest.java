package com.beadinventory.beadinventory.ControllerTest.SuppliesControllerTest;

import com.beadinventory.beadinventory.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.ROUND;
import static org.springframework.http.HttpStatus.*;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@WebMvcTest(BeadController.class)
public class BeadContIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BeadController mockBeadController;

    TreeSet<String> brands = new TreeSet<>(Arrays.asList("Bead Gallery"));
    private Bead bead1 = new Bead(AMETHYST, ROUND, "purple", 4, "good", 20,
            "translucent purple with some white", 0.2, brands);
    private Bead bead2 = new Bead(JASPER, ROUND, "black", 4, "good", 10, "",
            0.1, brands);
    private Bead bead3 = new Bead(STONE, ROUND, "tan", 6, "ok", 7,
            "with design cut into bead", 0.05, brands);
    private Bead bead4 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white",
            0.2,brands);
    private Bead bead5 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple with some white",
            0.2,brands);

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        bead1.setId(1L);
        bead2.setId(2L);
        bead3.setId(3L);
        bead4.setId(4L);
        bead5.setId(5L);
    }
    /*
            Iterable<Account> accounts = singletonList(account);
        ResponseEntity<Iterable<Account>> expected = new ResponseEntity<>(accounts, HttpStatus.OK);
        given(accountController.getAllAccounts()).willReturn(expected);

        mockMvc.perform(get("/accounts")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
     */
    @Test
    public void getAllBeadsIntegTest() throws Exception{
        List<Bead> list = new ArrayList<>(Arrays.asList(bead1,bead2,bead3,bead4,bead5));
        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list, OK);
        given(mockBeadController.findAllBeads()).willReturn(expected);

        mockMvc.perform(get("/beads")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getBeadByIdTest() throws Exception{
        Optional<Bead> oBead = Optional.of(bead1);
        ResponseEntity<Optional<Bead>> expected = new ResponseEntity<>(oBead,OK);
        given(mockBeadController.findBeadById(1L)).willReturn(expected);

        mockMvc.perform(get("/beads/{id}",1L).contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
