package com.beadinventory.beadinventory.ServiceTest.FinishedPiecesServiceTest;


import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.FinishedPieces.Bookmark;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.BookmarkRepo;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.*;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.BookmarkService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.HEAD_PIN;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.ROUND;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;


@RunWith(SpringRunner.class)
public class BookmarkServiceTest {

    @InjectMocks
    BookmarkService bookmarkService;

    @Mock
    BookmarkRepo bookmarkRepo;

    @Mock
    BeadRepo beadRepo;
    @Mock
    FindingRepo findingRepo;

    private Bead bead1= new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white", 0.2,"Bead Gallery");
    private Bead bead2 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple with some white", 0.2,"Bead Gallery");
    private Bead bead3 = new Bead(STONE, ROUND,"tan",6,"ok",7,"with design cut into bead",0.05, "Bead Gallery");
    private Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,5.08,5.08,20,"Bead Gallery","thin");
    private Bookmark bookmark;
    private Bookmark bookmark2;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        HashMap<Bead, Integer> beads = new HashMap<>();
        beads.put(bead1,1);
        beads.put(bead2,1);
        HashMap<Finding, Integer> findings = new HashMap<>();
        findings.put(headPin,2);
        HashMap<Bead,Integer> beads2 = new HashMap<>();
        beads2.put(bead3,2);
        this.bookmark = new Bookmark(beads,findings,10.0,"Amethyst on black cord", COTTON,StringWireCategory.CORD,"black",10);
        this.bookmark2 = new Bookmark(beads2,findings,10.0,"Tan stone on black leather", LEATHER,StringWireCategory.CORD,"black",10);
    }


    @Test
    public void getAllItemsTest(){
        List<Bookmark> list = new ArrayList<>(Arrays.asList(bookmark,bookmark2));
        given(bookmarkRepo.findAll()).willReturn(list);

        ResponseEntity<List<Bookmark>> expected = new ResponseEntity<>(list,OK);
        ResponseEntity<List<Bookmark>> actual = bookmarkService.getAllItems();

        verify(bookmarkRepo).findAll();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getItemByIdTest(){
        given(bookmarkRepo.findById(bookmark.getAllId())).willReturn(bookmark);

        ResponseEntity<Bookmark> expected = new ResponseEntity<>(bookmark,OK);
        ResponseEntity<Bookmark> actual = bookmarkService.getItemById(bookmark.getAllId());

        verify(bookmarkRepo).findById(anyLong());
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void createItemTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bookmark.getAllId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);

        given(bookmarkRepo.save(any(Bookmark.class))).willReturn(bookmark);
        given(beadRepo.save(any(Bead.class))).willReturn(bead1);
        given(findingRepo.save(any(Finding.class))).willReturn(headPin);

        ResponseEntity<Bookmark> expected = new ResponseEntity<>(bookmark,responseHeaders,CREATED);
        ResponseEntity<Bookmark> actual = bookmarkService.createItem(bookmark);

        verify(bookmarkRepo).save(any(Bookmark.class));
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void updateItemTest(){
        given(bookmarkRepo.save(bookmark2)).willReturn(bookmark2);

        ResponseEntity<Bookmark> expected = new ResponseEntity<>(bookmark2,OK);
        ResponseEntity<Bookmark> actual = bookmarkService.updateItem(bookmark2.getAllId(),bookmark2);

        verify(bookmarkRepo).save(any(Bookmark.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updatePriceOfAllTest(){
        Iterable<Bookmark> iBookmark = Arrays.asList(bookmark,bookmark2);
        List<Bookmark> list = new ArrayList<>(Arrays.asList(bookmark,bookmark2));
        given(bookmarkRepo.findAll()).willReturn(list);
        given(bookmarkRepo.saveAll(iBookmark)).willReturn(iBookmark);

        double expected = 12.0;
        ResponseEntity<List<Bookmark>> actualResponse = bookmarkService.increasePriceOfAll(2);
        double actual = actualResponse.getBody().get(0).getPrice();

        verify(bookmarkRepo).findAll();
        verify(bookmarkRepo).saveAll(anyIterable());
        Assert.assertEquals(expected,actual, 0.05);
    }

    @Test
    public void updateDescriptionTest(){
        bookmark2.setAllId(1);
        given(bookmarkRepo.findById(1)).willReturn(bookmark2);
        given(bookmarkRepo.save(bookmark2)).willReturn(bookmark2);

        String expected = "Carved tan stone on black leather cord";
        ResponseEntity<Bookmark> actualResponse = bookmarkService.updateDescription(1, "Carved tan stone on black leather cord");
        String actual = actualResponse.getBody().getDescription();

        verify(bookmarkRepo).findById(anyLong());
        verify(bookmarkRepo).save(any(Bookmark.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void deleteItemTest(){
        ResponseEntity expected = new ResponseEntity(OK);
        ResponseEntity actual = bookmarkService.deleteItem(bookmark2);

        verify(bookmarkRepo).delete(any(Bookmark.class));
        Assert.assertEquals(expected,actual);
    }

}
