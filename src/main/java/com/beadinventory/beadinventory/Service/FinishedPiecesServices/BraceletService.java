package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Bracelet;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.BraceletRepo;
import org.mockito.internal.util.collections.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

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

    public ResponseEntity<Long> getTotalCount(){
        Long count = braceletRepo.count();
        return new ResponseEntity<>(count, OK);
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
        Iterable<Bracelet> iBracelets = list;
        Iterable<Bracelet> iterable = braceletRepo.saveAll(iBracelets);
        List<Bracelet> braceletList = new ArrayList<>();
        iterable.forEach(e->braceletList.add(e));
        return new ResponseEntity<>(braceletList,OK);
    }

    @Override
    public ResponseEntity<Bracelet> updateDescription(long id, String description) {
        return null;
    }

    @Override
    public ResponseEntity deleteItem(Bracelet item) {
        return null;
    }
}
