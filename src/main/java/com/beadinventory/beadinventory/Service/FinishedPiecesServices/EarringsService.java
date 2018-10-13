package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.EarringsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.springframework.http.HttpStatus.*;

@Service
public class EarringsService extends AllFinishedPiecesService<Earrings> implements AllFinishedPiecesSvsInterface<Earrings> {

    private EarringsRepo earringsRepo;

    @Autowired
    public EarringsService(EarringsRepo earringsRepo){
        this.earringsRepo = earringsRepo;
    }

    @Override
    public ResponseEntity<List<Earrings>> getAllItems() {
        return null;
    }

    @Override
    public ResponseEntity<Long> getTotalCount() {
        return new ResponseEntity<>(earringsRepo.count(),OK) ;
    }

    @Override
    public ResponseEntity<Earrings> getItemById(long id) {
        try {
            Earrings earrings = earringsRepo.findById(id);
            return new ResponseEntity<>(earrings, OK);
        } catch (NullPointerException e){
            return new ResponseEntity<>(new Earrings(), BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Earrings> createItem(Earrings item) {
        return null;
    }

    @Override
    public ResponseEntity<Earrings> updateItem(long id, Earrings item) {
        return null;
    }


    public ResponseEntity<Earrings> updatePriceOfOne(long id, double price) {
        return null;
    }

    @Override
    public ResponseEntity<List<Earrings>> updatePriceOfAll(double amountToAdd) {
        return null;
    }

    @Override
    public ResponseEntity<Earrings> updateDescription(long id, String description) {
        return null;
    }

    @Override
    public ResponseEntity deleteItem(Earrings item) {
        return null;
    }
}
