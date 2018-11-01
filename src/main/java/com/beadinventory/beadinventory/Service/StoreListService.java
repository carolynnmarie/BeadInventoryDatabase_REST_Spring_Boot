package com.beadinventory.beadinventory.Service;

import com.beadinventory.beadinventory.Domain.StoreList;
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

    public ResponseEntity deleteListById(long id){
        listRepo.deleteById(id);
        return new ResponseEntity<>(OK);
    }

    public ResponseEntity deleteList(StoreList list){
        listRepo.delete(list);
        return new ResponseEntity(OK);
    }

}
