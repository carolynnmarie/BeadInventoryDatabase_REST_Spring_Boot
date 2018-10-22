package com.beadinventory.beadinventory.ControllerTest.FinishedPiecesControllerTest;

import com.beadinventory.beadinventory.Controller.FinishedPiecesControllers.BookmarkController;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.FinishedPieces.Bookmark;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.BookmarkService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.*;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
public class BookmarkControllerTest {

    @InjectMocks
    BookmarkController mockController;

    @Mock
    BookmarkService mockService;

    List<String> beadBrands = new ArrayList<>(Arrays.asList("Bead Gallery"));
    private Bead bead1 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white", 0.2,beadBrands);
    private Bead bead2 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple with some white", 0.2,beadBrands);
    private Bead bead3  = new Bead(STONE, ROUND,"tan",6,"ok",7,"with design cut into bead",0.05, beadBrands);
    private Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,beadBrands);
    LinkedHashMap<Bead, Integer> beads = new LinkedHashMap<>();
    LinkedHashMap<Finding, Integer> findings = new LinkedHashMap<>();
    LinkedHashMap<Bead,Integer> beads2 = new LinkedHashMap<>();
    private Bookmark bookmark;
    private Bookmark bookmark2;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        beads.put(bead1,1);
        beads.put(bead2,1);
        findings.put(headPin,2);
        beads2.put(bead3,2);
        bookmark = new Bookmark(beads,findings,10.0,"Amethyst on black cord", COTTON,"black",10);
        bookmark2 = new Bookmark(beads2,findings,10.0,"Tan stone on black leather", LEATHER,"black",10);
        bookmark.setId(1);
        bookmark2.setId(2);
    }

    @Test
    public void findAllItemsTest(){
        List<Bookmark> list = new ArrayList<>(Arrays.asList(bookmark,bookmark2));
        given(mockService.getAllItems()).willReturn(new ResponseEntity<>(list, OK));

        List<Bookmark> actual = mockController.findAllItems();

        verify(mockService).getAllItems();
        Assert.assertEquals(list, actual);
    }

    @Test
    public void findItemByIdTest(){
        given(mockService.getItemById(1)).willReturn(new ResponseEntity<>(bookmark,OK));
        Bookmark actual = mockController.findItemById(bookmark.getId());

        verify(mockService).getItemById(anyLong());
        Assert.assertEquals(bookmark,actual);
    }

    @Test
    public void createItemTest(){
        ResponseEntity<Bookmark> expected = new ResponseEntity<>(bookmark2, CREATED);
        given(mockService.createItem(bookmark2)).willReturn(expected);
        ResponseEntity<Bookmark> actual = mockController.createItem(bookmark2);

        verify(mockService).createItem(any(Bookmark.class));
        Assert.assertEquals(expected,actual);
    }



}
/*
ResponseEntity<Bookmark> createItem(@RequestBody Bookmark item)
Bookmark updateItem(@PathVariable("id") long id, @RequestBody Bookmark item)
List<Bookmark> updatePriceOfAll(@RequestAttribute(value = "price") double price)
Bookmark updateDescription(@PathVariable("id") long id, @RequestAttribute(value = "description") String description)
ResponseEntity deleteItem(@RequestBody Bookmark item)
int getTotalItemCount()
 */