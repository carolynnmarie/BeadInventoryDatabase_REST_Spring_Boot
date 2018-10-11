package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Bracelet;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.BraceletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class BraceletService extends AllFinishedPiecesService<Bracelet> {

    private BraceletRepo braceletRepo;

    @Autowired
    public BraceletService(BraceletRepo braceletRepo){
        this.braceletRepo = braceletRepo;
    }


    public ResponseEntity<Bracelet> createBracelet(Bracelet bracelet){
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
    ResponseEntity<List<Bracelet>> getAllItems() {
        return null;
    }

    @Override
    ResponseEntity<Bracelet> getItemById(long id) {
        return null;
    }

    @Override
    long getQuantity(long id) {
        return 0;
    }

    @Override
    ResponseEntity<Bracelet> createItem(Bracelet item) {
        return null;
    }

    @Override
    ResponseEntity<Bracelet> updateItem(long id, Bracelet item) {
        return null;
    }

    @Override
    ResponseEntity<Bracelet> updatePrice(long id, int price) {
        return null;
    }

    @Override
    ResponseEntity<Bracelet> updateDescription(long id, String description) {
        return null;
    }

    @Override
    ResponseEntity deleteItem(Bracelet item) {
        return null;
    }
}
