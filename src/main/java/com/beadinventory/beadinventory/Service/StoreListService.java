package com.beadinventory.beadinventory.Service;

import com.beadinventory.beadinventory.Repository.StoreListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreListService {

    private StoreListRepo listRepo;

    @Autowired
    public StoreListService(StoreListRepo listRepo){
        this.listRepo = listRepo;
    }

}
