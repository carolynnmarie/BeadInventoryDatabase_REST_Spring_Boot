package com.beadinventory.beadinventory;

import com.beadinventory.beadinventory.Controller.StoreListController;
import org.springframework.beans.factory.annotation.Autowired;
import com.beadinventory.beadinventory.Domain.StoreList;

public class StoreListManager {

    @Autowired
    private StoreListController listController;

    public String printList(StoreList list){
        return list.toString();
    }

    public String printListById(long id){
        return listController.getListById(id).toString();
    }


}
