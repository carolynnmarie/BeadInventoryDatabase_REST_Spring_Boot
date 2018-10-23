package com.beadinventory.beadinventory.ControllerTest.FinishedPiecesControllerTest;

import com.beadinventory.beadinventory.Controller.FinishedPiecesControllers.BookmarkController;
import com.beadinventory.beadinventory.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.FinishedPieces.Bookmark;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@WebMvcTest(BookmarkController.class)
public class BookmarkContIntegratonTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookmarkController mockController;

    @MockBean
    private BeadController mockBeadController;

    private ObjectMapper mapper = new ObjectMapper();

    List<String> beadBrands = new ArrayList<>(Arrays.asList("Bead Gallery"));
    private Bead bead1 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white", 0.2,"Bead Gallery");
    private Bead bead2 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple with some white", 0.2,"Bead Gallery");
    private Bead bead3  = new Bead(STONE, ROUND,"tan",6,"ok",7,"with design cut into bead",0.05, "Bead Gallery");
    private Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,"Bead Gallery");

    HashMap<Bead, Integer> beads = new HashMap<>();
    HashMap<Finding, Integer> findings = new HashMap<>();
    HashMap<Bead,Integer> beads2 = new HashMap<>();

    private Bookmark bookmark;
    private Bookmark bookmark2;

    @Before
    public void setUp(){
        beads.put(bead1,1);
        beads.put(bead2,1);
        findings.put(headPin,2);
        beads2.put(bead3,2);
        bookmark = new Bookmark(beads,findings,10.0,"Amethyst on black cord", COTTON,CORD,"black",10);
        bookmark2 = new Bookmark(beads2,findings,10.0,"Tan stone on black leather", LEATHER,CORD,"black",10);
        bookmark.setId(1);
        bookmark2.setId(2);
    }

    @Test
    public void findAllItemsIntegTest() throws Exception{
        List<Bookmark> list = new ArrayList<>(Arrays.asList(bookmark,bookmark2));
        given(mockController.findAllItems()).willReturn(list);

        mockMvc.perform(get("/bookmarks")
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findItemByIdIntegTest() throws Exception{
        given(mockController.findItemById(1)).willReturn(bookmark);

        mockMvc.perform(get("/bookmarks/{id}",1)
                .contentType(APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void createItemIntegTest() throws Exception{
        given(mockController.createItem(bookmark)).willReturn(mock(ResponseEntity.class));

        String body = mapper.writeValueAsString(bookmark);
        mockMvc.perform(post("/bookmarks")
                .characterEncoding("utf-8")
                .contentType(APPLICATION_JSON)
                .content(body)).andExpect(status().isOk());
    }

}
/*
ResponseEntity<Bookmark> createItem(@RequestBody Bookmark item)
Bookmark updateItem(@PathVariable("id") long id, @RequestBody Bookmark item)
List<Bookmark> updatePriceOfAll(@RequestAttribute(value = "price") double price)
Bookmark updateDescription(@PathVariable("id") long id, @RequestAttribute(value = "description") String description)
ResponseEntity deleteItem(@RequestBody Bookmark item)
 */