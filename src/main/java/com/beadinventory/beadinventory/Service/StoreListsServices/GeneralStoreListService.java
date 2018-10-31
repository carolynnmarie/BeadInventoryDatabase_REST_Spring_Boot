package com.beadinventory.beadinventory.Service.StoreListsServices;

import com.beadinventory.beadinventory.Repository.StoreListsRepos.GeneralStoreListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralStoreListService {

    private GeneralStoreListRepo listRepo;

    @Autowired
    public GeneralStoreListService(GeneralStoreListRepo listRepo){
        this.listRepo = listRepo;
    }

}
