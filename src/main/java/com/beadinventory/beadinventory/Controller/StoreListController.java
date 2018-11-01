package com.beadinventory.beadinventory.Controller;

import com.beadinventory.beadinventory.Domain.StoreList;
import com.beadinventory.beadinventory.Service.StoreListService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/store_list")
@CrossOrigin(origins = {"http://localhost:8080","http://localhost:8100"})
public class StoreListController {

    private StoreListService generalListService;

    @Autowired
    public StoreListController(StoreListService generalListService){
        this.generalListService = generalListService;
    }

    @GetMapping()
    public List<StoreList> getAllLists(){
        return generalListService.getAllLists().getBody();
    }

    @GetMapping(value = "/{id}")
    public StoreList getListById(@PathVariable("id") long id){
        return generalListService.getOneById(id).getBody();
    }

    @GetMapping(params = "title")
    public StoreList getListByTitle(@RequestAttribute(value = "title") String title){
        return generalListService.getByTitle(title).getBody();
    }

    @PostMapping()
    public StoreList createList(@RequestBody StoreList storeList){
        return generalListService.createList(storeList).getBody();
    }

    @PutMapping(value = "/{id}")
    public StoreList updateList(@PathVariable("id") long id, @RequestBody StoreList storeList){
        return generalListService.updateList(id,storeList).getBody();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteListById(@PathVariable("id") long id){
        return generalListService.deleteListById(id);
    }

    @DeleteMapping()
    public ResponseEntity deleteList(@RequestBody StoreList storeList){
        return generalListService.deleteList(storeList);
    }

}
