package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.EarringsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        List<Earrings> list = earringsRepo.findAll();
        return new ResponseEntity<>(list,OK);
    }


    public ResponseEntity<List<Earrings>> getAllSterlingSilver(){
        List<Earrings> list = earringsRepo.findEarringsBySterlingSilverYorNIsTrue();
        return new ResponseEntity<>(list,OK);
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
        item.setBeads(updateBeadRepoCount(item));
        item.setFindings(updateFindingRepoCount(item));
        Earrings earrings = earringsRepo.save(item);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(earrings.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(earrings,responseHeaders,CREATED);
    }

    @Override
    public ResponseEntity<Earrings> updateItem(long id, Earrings item) {
        item.setId(id);
        Earrings earrings = earringsRepo.save(item);
        return new ResponseEntity<>(earrings,OK);
    }


    public ResponseEntity<Earrings> updatePriceOfOne(long id, double price) {
        try{
            Earrings earrings = earringsRepo.findById(id);
            earrings.setPrice(price);
            Earrings earrings1 = earringsRepo.save(earrings);
            return new ResponseEntity<>(earrings1,OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<>(new Earrings(),BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Earrings>> increasePriceOfAll(double amountToAdd) {
        Iterable<Earrings> iEarrings = earringsRepo.findAll();
        iEarrings.forEach(earrings -> earrings.setPrice(earrings.getPrice() + amountToAdd));
        iEarrings = earringsRepo.saveAll(iEarrings);
        List<Earrings> list = new ArrayList<>();
        iEarrings.forEach(e-> list.add(e));
        return new ResponseEntity<>(list,OK);
    }

    @Override
    public ResponseEntity<Earrings> updateDescription(long id, String description) {
        try{
            Earrings earrings = earringsRepo.findById(id);
            earrings.setDescription(description);
            Earrings earrings1 = earringsRepo.save(earrings);
            return new ResponseEntity<>(earrings1,OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<>(new Earrings(),BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity deleteItem(Earrings item) {
        earringsRepo.delete(item);
        return new ResponseEntity(OK);
    }
}
