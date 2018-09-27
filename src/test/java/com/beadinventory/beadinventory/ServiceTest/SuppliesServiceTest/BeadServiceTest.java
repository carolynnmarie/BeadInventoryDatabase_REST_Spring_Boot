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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.beadinventory.beadinventory.Domain.Supplies.beadAspects.Material.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

@RunWith(SpringRunner.class)
public class BeadServiceTest {

    @Mock
    private BeadRepo mockBeadRepo;

    @InjectMocks
    private BeadService mockBeadService;

    private Bead bead1;
    private Bead bead2;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        bead1 = new Bead(AMETHYST, "light purple", 4, "good", 15, "");
        bead1.setId(1);
        bead2 = new Bead(JASPER, "black", 4, "good", 10, "");
        bead2.setId(2);
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



}
