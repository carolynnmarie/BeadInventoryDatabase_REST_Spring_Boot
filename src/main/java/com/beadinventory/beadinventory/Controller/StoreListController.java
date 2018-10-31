package com.beadinventory.beadinventory.Controller;

import com.beadinventory.beadinventory.Service.StoreListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreListController {

    private StoreListService generalListService;

    @Autowired
    public StoreListController(StoreListService generalListService){
        this.generalListService = generalListService;
    }
}
