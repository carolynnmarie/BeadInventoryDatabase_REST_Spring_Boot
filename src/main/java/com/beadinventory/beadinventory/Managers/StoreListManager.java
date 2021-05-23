package com.beadinventory.beadinventory.Managers;

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
        StoreList list = listController.getListById(id);
        List<Bead> beadList = list.getBeads();
        if(beadList.contains(bead)) beadList.remove(bead);
        list.setBeads(beadList);
        list.setId(id);
        listController.updateList(id, list);
    }

    public void addFinding(long id, Finding finding){
        StoreList list = listController.getListById(id);
        List<Finding> findings = list.getFindings();
        if(!findings.contains(finding))
            findings.add(finding);
        list.setFindings(findings);
        list.setId(id);
        listController.updateList(id, list);
    }

    public void deleteFinding(long id, Finding finding){
        StoreList list = listController.getListById(id);
        List<Finding> findings = list.getFindings();
        if(findings.contains(finding)) findings.remove(finding);
        list.setFindings(findings);
        list.setId(id);
        listController.updateList(id, list);
    }

    public void addStringingMaterial(long id, StringWire stringWire){
        StoreList list = listController.getListById(id);
        List<StringWire> stringingMaterials = list.getStringWire();
        if(!stringingMaterials.contains(stringWire)) stringingMaterials.add(stringWire);
        list.setStringWire(stringingMaterials);
        list.setId(id);
        listController.updateList(id, list);
    }

    public void deleteStringingMaterial(long id, StringWire stringWire){
        StoreList list = listController.getListById(id);
        List<StringWire> stringingMaterials = list.getStringWire();
        if(stringingMaterials.contains(stringWire)) stringingMaterials.remove(stringWire);
        list.setStringWire(stringingMaterials);
        list.setId(id);
        listController.updateList(id, list);
    }

    public void addOtherItem(long id, String otherItem){
        StoreList list = listController.getListById(id);
        List<String> otherItems = list.getOtherItems();
        if(!otherItems.contains(otherItem)) otherItems.add(otherItem);
        list.setOtherItems(otherItems);
        list.setId(id);
        listController.updateList(id, list);

    }

    public void deleteOtherItem(long id, String otherItem){
        StoreList list = listController.getListById(id);
        List<String> otherItems = list.getOtherItems();
        if(otherItems.contains(otherItem)) otherItems.remove(otherItem);
        list.setOtherItems(otherItems);
        list.setId(id);
        listController.updateList(id, list);
    }



}
