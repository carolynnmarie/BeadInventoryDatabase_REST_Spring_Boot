package com.beadinventory.beadinventory.Service;

import com.beadinventory.beadinventory.Domain.StoreList;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.beadinventory.beadinventory.Repository.StoreListRepo;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.*;

@Service

public class StoreListService {

    private StoreListRepo listRepo;

    @Autowired
    public StoreListService(StoreListRepo listRepo){
        this.listRepo = listRepo;
    }

    public ResponseEntity<List<StoreList>> getAllLists(){
        List<StoreList> lists = (List<StoreList>)listRepo.findAll();
        return new ResponseEntity<>(lists, OK);
    }

    public ResponseEntity<StoreList> getOneById(long id){
        Optional<StoreList> oList = listRepo.findById(id);
        StoreList list = new StoreList();
        if(oList.isPresent()) list = oList.get();
        return new ResponseEntity<>(list,OK);
    }

    public ResponseEntity<StoreList> getByTitle(String title){
        StoreList list = listRepo.findStoreListsByProjectTitle(title);
        return new ResponseEntity<>(list,OK);
    }

    public ResponseEntity<StoreList> createList(StoreList list){
        StoreList list1 = listRepo.save(list);
        return new ResponseEntity<>(list1,CREATED);
    }

    public ResponseEntity<StoreList> updateList(long id, StoreList list){
        list.setId(id);
        StoreList list1 = listRepo.save(list);
        return new ResponseEntity<>(list1, OK);
    }

    public ResponseEntity<StoreList> addBead(long id, Bead bead){
        Optional<StoreList> oList = listRepo.findById(id);
        StoreList list = new StoreList();
        if(oList.isPresent()) list = oList.get();
        List<Bead> beads = list.getBeads();
        if(!beads.contains(bead)){
            beads.add(bead);
        }
        list.setBeads(beads);
        list.setId(id);
        StoreList list1 = listRepo.save(list);
        return new ResponseEntity<>(list1,OK);
    }

    public ResponseEntity<StoreList> deleteBead(long id, Bead bead){
        Optional<StoreList> oList = listRepo.findById(id);
        StoreList list = new StoreList();
        if(oList.isPresent()) list = oList.get();
        List<Bead> beads = list.getBeads();
        if(beads.contains(bead)){
            beads.remove(bead);
        }
        list.setBeads(beads);
        list.setId(id);
        StoreList list1 = listRepo.save(list);
        return new ResponseEntity<>(list1, OK);
    }

    public ResponseEntity<StoreList> addFinding(long id, Finding finding){
        Optional<StoreList> oList = listRepo.findById(id);
        StoreList list = new StoreList();
        if(oList.isPresent()) list = oList.get();
        List<Finding> findings = list.getFindings();
        if(!findings.contains(finding)){
            findings.add(finding);
        }
        list.setFindings(findings);
        list.setId(id);
        StoreList list1 = listRepo.save(list);
        return new ResponseEntity<>(list1,OK);
    }

    public ResponseEntity<StoreList> deleteFinding(long id, Finding finding){
        return null;
    }

    public ResponseEntity<StoreList> addStringingMaterial(long id, StringWire stringWire){
        return null;
    }

    public ResponseEntity<StoreList> deleteStringingMaterial(long id, StringWire stringWire){
        return null;
    }

    public ResponseEntity<StoreList> addOtherItem(long id, String otherItem){
        return null;
    }

    public ResponseEntity<StoreList> deleteOtherItem(long id, String otherItem){
        return null;
    }

    public ResponseEntity deleteListById(long id){
        listRepo.deleteById(id);
        return new ResponseEntity<>(OK);
    }

    public ResponseEntity deleteList(StoreList list){
        listRepo.delete(list);
        return new ResponseEntity(OK);
    }

}
