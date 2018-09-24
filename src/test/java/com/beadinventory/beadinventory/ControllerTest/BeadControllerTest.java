package com.beadinventory.beadinventory.ControllerTest;

import com.beadinventory.beadinventory.Controller.BeadController;
import com.beadinventory.beadinventory.Domain.Bead;
import com.beadinventory.beadinventory.Domain.beadCharacteristics.Material;
import com.beadinventory.beadinventory.Service.BeadService;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.beadinventory.beadinventory.Domain.beadCharacteristics.Material.*;
import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class BeadControllerTest {

    @Mock
    private BeadService mockService;

    @InjectMocks
    private BeadController mockController;

    private Bead bead1;
    private Bead bead2;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        bead1 = new Bead(AMETHYST, "light purple", 4, "good", 15, "");
        bead1.setId(1);
        bead2 = new Bead(JASPER, "black", 6, "good", 10, "");
        bead2.setId(2);
    }

    @Test
    public void testGetAllOfMaterial(){
        List<Bead> list = new ArrayList<>(Arrays.asList(bead2));
        given(mockService.getAllOfMaterial(JASPER)).willReturn(new ResponseEntity<>(list,HttpStatus.OK));
        ResponseEntity<List<Bead>> expected = new ResponseEntity<>(list,HttpStatus.OK);
        ResponseEntity<List<Bead>> actual = mockController.getAllOfMaterial(JASPER);

        verify(mockService).getAllOfMaterial(any(Material.class));
        Assert.assertEquals(expected, actual);
    }

}
