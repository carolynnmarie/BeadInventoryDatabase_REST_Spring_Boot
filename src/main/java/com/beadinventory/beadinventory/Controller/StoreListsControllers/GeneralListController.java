package com.beadinventory.beadinventory.Controller.StoreListsControllers;

import com.beadinventory.beadinventory.Service.StoreListsServices.GeneralStoreListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralListController {

    private GeneralStoreListService generalListService;

    @Autowired
    public GeneralListController(GeneralStoreListService generalListService){
        this.generalListService = generalListService;
    }
}
