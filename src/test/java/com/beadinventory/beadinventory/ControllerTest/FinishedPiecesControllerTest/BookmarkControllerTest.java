package com.beadinventory.beadinventory.ControllerTest.FinishedPiecesControllerTest;

import com.beadinventory.beadinventory.REST.Controller.FinishedPiecesControllers.BookmarkController;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Bookmark;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.StringWireCategory;
import com.beadinventory.beadinventory.REST.Service.FinishedPiecesServices.BookmarkService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.*;

import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Shape.*;
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

    private Bead bead1 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white", 0.2,"Beadalon");
    private Bead bead2 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple with some white", 0.2,"Beadalon");
    private Bead bead3  = new Bead(STONE, ROUND,"tan",6,"ok",7,"with design cut into bead",0.05, "Beadalon");
    private Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,5.08,5.08,20,"Beadalon","thin");
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
        bookmark = new Bookmark(beads,findings,10.0,"Amethyst on black cord", COTTON,StringWireCategory.CORD,"black",10, false, "");
        bookmark2 = new Bookmark(beads2,findings,10.0,"Tan stone on black leather", LEATHER,StringWireCategory.CORD,"black",10, false, "");
        bookmark.setAllId(1);
        bookmark2.setAllId(2);
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
        Bookmark actual = mockController.findItemById(bookmark.getAllId());

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

    @Test
    public void updateItemTest(){
        given(mockService.updateItem(bookmark2.getAllId(),bookmark2)).willReturn(new ResponseEntity<>(bookmark2,OK));
        Bookmark actual = mockController.updateItem(bookmark2.getAllId(),bookmark2);

        verify(mockService).updateItem(anyLong(),any(Bookmark.class));
        Assert.assertEquals(bookmark2, actual);
    }


    @Test
    public void updateDescriptionTest(){
        given(mockService.updateDescription(bookmark2.getAllId(),"description")).willReturn(new ResponseEntity<>(bookmark2,OK));
        Bookmark actual = mockController.updateDescription(bookmark2.getAllId(),"description");
        verify(mockService).updateDescription(anyLong(),anyString());
        Assert.assertEquals(bookmark2,actual);
    }

    @Test
    public void deleteItemTest(){
        ResponseEntity expected = new ResponseEntity(OK);
        given(mockService.deleteItem(bookmark)).willReturn(expected);
        ResponseEntity actual = mockController.deleteItem(bookmark);
        verify(mockService).deleteItem(any(Bookmark.class));
        Assert.assertEquals(expected,actual);
    }




}
