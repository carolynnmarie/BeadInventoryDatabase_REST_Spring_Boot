package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Bracelet;
import com.beadinventory.beadinventory.Domain.FinishedPieces.BraceletType;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.BraceletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import static org.springframework.http.HttpStatus.*;

@Service
public class BraceletService extends AllFinishedPiecesService<Bracelet> implements AllFinishedPiecesSvsInterface<Bracelet> {

    private BraceletRepo braceletRepo;

    @Autowired
    public BraceletService(BraceletRepo braceletRepo){
        this.braceletRepo = braceletRepo;
    }


    @Override
    public ResponseEntity<List<Bracelet>> getAllItems() {
        List<Bracelet> list = braceletRepo.findAll();
        return new ResponseEntity<>(list,OK);
    }

    public ResponseEntity<Long> getTotalCount(long count){
        count = braceletRepo.count();
        return new ResponseEntity<>(count, OK);
    }

    public ResponseEntity<List<Bracelet>> findByBraceletType(BraceletType braceletType){
        List<Bracelet> bracelets = braceletRepo.findBraceletsByBraceletType(braceletType);
        return new ResponseEntity<>(bracelets,OK);
    }

    @Override
    public ResponseEntity<Bracelet> getItemById(long id) {
        try {
            Bracelet bracelet = braceletRepo.findById(id);
            return new ResponseEntity<>(bracelet, OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<>(new Bracelet(),BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<Bracelet> createItem(Bracelet bracelet){
        Bracelet bracelet1 = braceletRepo.save(bracelet);
        updateBeadRepoCount(bracelet);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bracelet.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(bracelet1,responseHeaders,CREATED);
    }

    @Override
    public ResponseEntity<Bracelet> updateItem(long id, Bracelet item) {
        item.setId(id);
        Bracelet bracelet = braceletRepo.save(item);
        return new ResponseEntity<>(bracelet, OK);
    }


    public ResponseEntity<Bracelet> updatePriceOfOne(long id, double price) {
        Bracelet bracelet = braceletRepo.findById(id);
        bracelet.setPrice(price);
        Bracelet bracelet1 = braceletRepo.save(bracelet);
        return new ResponseEntity<>(bracelet1,OK);
    }


    public ResponseEntity<List<Bracelet>> updatePriceOfAll(double amountToAdd){
        List<Bracelet> list = braceletRepo.findAll();
        for(Bracelet bracelet: list){
            bracelet.setPrice(bracelet.getPrice()+amountToAdd);
        }
        Iterable<Bracelet> iterable = list;
        iterable = braceletRepo.saveAll(iterable);
        List<Bracelet> braceletList = new ArrayList<>();
        iterable.forEach(e->braceletList.add(e));
        return new ResponseEntity<>(list,OK);
    }

    @Override
    public ResponseEntity<Bracelet> updateDescription(long id, String description) {
        Bracelet bracelet = braceletRepo.findById(id);
        bracelet.setDescription(description);
        bracelet = braceletRepo.save(bracelet);
        return new ResponseEntity<>(bracelet,OK);
    }

    @Override
    public ResponseEntity deleteItem(Bracelet item) {
        braceletRepo.delete(item);
        return new ResponseEntity(OK);
    }
}
