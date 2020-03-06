package com.beadinventory.beadinventory;

import com.beadinventory.beadinventory.Controller.StoreListController;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import java.util.*;
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

    public void addBead(long id, Bead bead){
        StoreList list = listController.getListById(id);
        List<Bead> beadList = list.getBeads();
        if(!beadList.contains(bead)){
            beadList.add(bead);
        }
        list.setBeads(beadList);
        list.setId(id);
        listController.updateList(id,list);
    }

    public void deleteBead(long id, Bead bead){

    }

    public void addFinding(long id, Finding finding){

    }

    public void deleteFinding(long id, Finding finding){

    }

    public void addStringingMaterial(long id, StringWire stringWire){

    }

    public void deleteStringingMaterial(long id, StringWire stringWire){

    }

    public void addOtherItem(long id, String otherItem){

    }

    public void deleteOtherItem(long id, String otherItem){

    }



}
