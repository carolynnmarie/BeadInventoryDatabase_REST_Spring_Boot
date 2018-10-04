package com.beadinventory.beadinventory.ServiceTest.SuppliesServiceTest;

import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.StringingMaterialRepo;
import com.beadinventory.beadinventory.Service.SuppliesServices.StringingMaterialService;

import org.junit.*;
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
import java.util.*;


import static org.junit.Assert.*;

public class StringingMaterialServiceTest {

    @InjectMocks
    StringingMaterialService mockSMService;

    @Mock
    StringingMaterialRepo mockSMRepo;

    private StringingMaterial beadWire;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void getAllMaterialsTest() {
    }

    @Test
    public void getAllOfCategoryTest() {
    }

    @Test
    public void getAllOfMaterialTest() {
    }

    @Test
    public void getByIdTest() {
    }

    @Test
    public void updateStringingMaterialTest() {
    }

    @Test
    public void deleteByIdTest() {
    }

    @Test
    public void deleteStringingMaterialTest() {
    }
}