package com.beadinventory.beadinventory.ServiceTest.SuppliesServiceTest;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.ROUND;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;


@RunWith(SpringRunner.class)
public class BeadServiceTest {


    @InjectMocks
    private BeadService mockBeadService;

    @Mock
    private BeadRepo mockBeadRepo;

    private Bead bead1;
    private Bead bead2;
    private Bead bead3;
    private Bead bead4;
    private Bead bead5;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        bead1 = new Bead(AMETHYST, ROUND,"purple",4,"good",20,"translucent purple with some white",
                0.2,"Bead Gallery");
        bead2 = new Bead(JASPER,ROUND, "black", 4, "good", 10, "",0.1,"Bead Gallery");
        bead3  = new Bead(STONE, ROUND,"tan",6,"ok",7,"with design cut into bead",0.05,
                "Bead Gallery");
        bead4 = new Bead(AMETHYST, ROUND,"purple",6,"good",15,"translucent purple with some white",
                0.2,"Bead Gallery");
        bead5 = new Bead(AMETHYST, ROUND,"purple",4,"poor",10,"translucent purple with some white",
                0.2,"Bead Gallery");
    }

    @Test
    public void getAllBeadsTest(){
        Iterable<Bead> beads = Arrays.asList(bead1,bead2);
        given(mockBeadRepo.findAll()).willReturn(beads);

        ResponseEntity<Iterable<Bead>> expected = new ResponseEntity<>(beads,OK);
        ResponseEntity<Iterable<Bead>> actual = mockBeadService.getAllBeads();

        verify(mockBeadRepo).findAll();
        Assert.assertEquals(expected,actual);
    }

/*
    ResponseEntity<List<Bead>> getAllOrderByCategory()
    ResponseEntity<List<Bead>> getAllOrderByMaterial()
    ResponseEntity<List<Bead>> getAllOfMaterialCategory(MaterialCategory materialCategory)
    ResponseEntity<List<Bead>> getAllOfMaterial(Material material)

 */


//    @Test
//    public void getAllOfMaterialAndColorTest(){
//        Iterable<Bead> responseList = Arrays.asList(bead1,bead4,bead5);
//
//        given(mockBeadRepo.findBeadsByMaterialAndColor(AMETHYST,"purple")).willReturn(responseList);
//        ResponseEntity<Iterable<Bead>> expected = new ResponseEntity<>(responseList,OK);
//        ResponseEntity<Iterable<Bead>> actual = mockBeadService.getAllOfMaterialAndColor(AMETHYST,"purple");
//
//        verify(mockBeadRepo).findBeadsByMaterialAndColor(any(Material.class),any(String.class));
//        Assert.assertEquals(expected,actual);
//    }
    /*
    ResponseEntity<List<Bead>> getAllOfMaterialAndColor(Material material, String color)
    ResponseEntity<List<Bead>> getAllOfMaterialAndSize(Material material, int size)
    ResponseEntity<List<Bead>> getAllOfShape(Shape shape)
    ResponseEntity<List<Bead>> getAllQuantityLessThan(long quantity)
    ResponseEntity<Bead> getBeadById(long id)
     */

    @Test
    public void createBeadTest(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bead1.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);

        given(mockBeadRepo.save(any(Bead.class))).willReturn(bead1);

        ResponseEntity<Bead> expected = new ResponseEntity<>(bead1,responseHeaders,CREATED);
        ResponseEntity<Bead> actual = mockBeadService.createBead(bead1);
        verify(mockBeadRepo).save(any(Bead.class));
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void updateBeadQuantityTest(){
        given(mockBeadRepo.save(any(Bead.class))).willReturn(bead1);
        ResponseEntity<Bead> expected = new ResponseEntity<>(bead1,OK);
        ResponseEntity<Bead> actual = mockBeadService.updateBeadQuantity(bead1,10);

        verify(mockBeadRepo).save(any(Bead.class));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateBeadTest(){
        given(mockBeadRepo.save(any(Bead.class))).willReturn(bead1);

        ResponseEntity<Bead> expected = new ResponseEntity<>(bead1,OK);
        ResponseEntity<Bead> actual = mockBeadService.updateBead(bead1.getId(),bead1);

        verify(mockBeadRepo).save(any(Bead.class));
        Assert.assertEquals(expected,actual);
    }

}
