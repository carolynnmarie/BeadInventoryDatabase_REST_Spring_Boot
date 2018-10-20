package com.beadinventory.beadinventory.ServiceTest.FinishedPiecesServiceTest;


import com.beadinventory.beadinventory.Domain.FinishedPieces.Bookmark;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.BookmarkRepo;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.FindingRepo;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.BookmarkService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;


import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.HEAD_PIN;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.AMETHYST;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.BRIGHT_SILVER_PLATED;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.COTTON;
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

    private Bookmark bookmark;

    Bead bead1;
    Bead bead2;
    Finding headPin;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        TreeSet<String> beadBrands = new TreeSet<>(Arrays.asList("Bead Gallery"));
        bead1 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white",
                0.2,beadBrands);
        bead2 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple with some white",
                0.2,beadBrands);
        TreeSet<String> findingBrands = new TreeSet<>(Arrays.asList("bead landing"));
        headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,"thin",5.08,5.08,20,findingBrands);

        LinkedHashMap<Bead, Integer> beads = new LinkedHashMap<>();
        beads.put(bead1,1);
        beads.put(bead2,1);
        LinkedHashMap<Finding, Integer> findings = new LinkedHashMap<>();
        findings.put(headPin,2);

        bookmark = new Bookmark(beads,findings,12.0,"Amethyst on black cord", COTTON,"black",10);
    }

    @Test
    public void createBookmarkTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bookmark.getId())
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

}

/*
ResponseEntity<List<Bookmark>> getAllItems()
ResponseEntity<Bookmark> getItemById(long id)
ResponseEntity<Bookmark> updateItem(long id, Bookmark item)
ResponseEntity<List<Bookmark>> updatePriceOfAll(double amountToAdd)
ResponseEntity<Bookmark> updateDescription(long id, String description)
ResponseEntity deleteItem(Bookmark item)
 */