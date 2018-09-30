package com.beadinventory.beadinventory.ServiceTest.SuppliesServiceTest;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory;
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

import javax.persistence.Table;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        List<Bead> beads = new ArrayList<>(Arrays.asList(bead1,bead2));
        given(mockBeadRepo.findAll()).willReturn(beads);

        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(beads,OK);
        ResponseEntity<List<Bead>> actual = mockBeadService.getAllBeads();

        verify(mockBeadRepo).findAll();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllOrderByMaterialTest(){
        List<Bead> beadsSorted = new ArrayList<>(Arrays.asList(bead3,bead1,bead4,bead5,bead2));
        List<Bead> beads = new ArrayList<>(Arrays.asList(bead1,bead2,bead3,bead4,bead5));
        given(mockBeadRepo.findAll()).willReturn(beads);

        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(beadsSorted,OK);
        ResponseEntity<List<Bead>> actual = mockBeadService.getAllOrderByMaterial();

        verify(mockBeadRepo).findAll();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getAllOrderByCategorytest(){
        List<Bead> beadsSorted = new ArrayList<>(Arrays.asList(bead3,bead1,bead2,bead4,bead5));
        List<Bead> beads = new ArrayList<>(Arrays.asList(bead1,bead2,bead3,bead4,bead5));
        given(mockBeadRepo.findAll()).willReturn(beads);

        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(beadsSorted,OK);
        ResponseEntity<List<Bead>> actual = mockBeadService.getAllOrderByCategory();

        verify(mockBeadRepo).findAll();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllOfMaterialCategoryTest(){
        List<Bead> beads = new ArrayList<>(Arrays.asList(bead1,bead2,bead3,bead4,bead5));
        List<Bead> beads2 = new ArrayList<>(Arrays.asList(bead1,bead2,bead4,bead5));
        given(mockBeadRepo.findAll()).willReturn(beads);
        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(beads2,OK);
        ResponseEntity<List<Bead>> actual = mockBeadService.getAllOfCategory(MaterialCategory.SEMI_PRECIOUS_STONE);

        verify(mockBeadRepo).findAll();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllOfMaterialTest(){
        List<Bead> beads = new ArrayList<>(Arrays.asList(bead1,bead4,bead5));
        given(mockBeadRepo.findByMaterial(AMETHYST)).willReturn(beads);
        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(beads,OK);
        ResponseEntity<List<Bead>> actual = mockBeadService.getAllOfMaterial(AMETHYST);

        verify(mockBeadRepo).findByMaterial(any(Material.class));
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void getAllOfMaterialAndColorTest(){
        List<Bead> responseList = new ArrayList<>(Arrays.asList(bead1,bead4,bead5));

        given(mockBeadRepo.findByMaterialAndColor(AMETHYST,"purple")).willReturn(responseList);
        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(responseList,OK);
        ResponseEntity<List<Bead>> actual = mockBeadService.getAllOfMaterialAndColor(AMETHYST,"purple");

        verify(mockBeadRepo).findByMaterialAndColor(any(Material.class),any(String.class));
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void getAllOfMaterialAndSizeTest(){
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2));
        given(mockBeadRepo.findByMaterialAndSize(any(Material.class),anyInt())).willReturn(list);
        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list,OK);
        ResponseEntity<List<Bead>> actual = mockBeadService.getAllOfMaterialAndSize(JASPER,4);
        Assert.assertEquals(expected,actual);
    }

    /*
    ResponseEntity<List<Bead>> getAllOfShape(Shape shape)
    ResponseEntity<List<Bead>> getAllQuantityLessThan(long quantity)
     */

    @Test
    public void getBeadByIdTest(){
        Optional<Bead> oBead = Optional.ofNullable(bead1);
        given(mockBeadRepo.findById(anyLong())).willReturn(oBead);
        ResponseEntity<Optional<Bead>> expected = new ResponseEntity<>(oBead,OK);
        ResponseEntity<Optional<Bead>> actual = mockBeadService.getBeadById(bead1.getId());

        verify(mockBeadRepo).findById(anyLong());
        Assert.assertEquals(expected,actual);
    }

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
