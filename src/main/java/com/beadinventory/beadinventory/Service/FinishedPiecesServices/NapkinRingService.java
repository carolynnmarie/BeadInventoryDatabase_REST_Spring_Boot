package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import com.beadinventory.beadinventory.Domain.FinishedPieces.NapkinRingSet;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.NapkinRingSetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import static org.springframework.http.HttpStatus.*;

@Service
public class NapkinRingService extends AllFinishedPiecesService<NapkinRingSet> implements AllFinishedPiecesSvsInterface<NapkinRingSet> {

    private NapkinRingSetRepo napkinRingSetRepo;

    @Autowired
    public NapkinRingService(NapkinRingSetRepo napkinRingSetRepo){
        this.napkinRingSetRepo = napkinRingSetRepo;
    }

    @Override
    public ResponseEntity<List<NapkinRingSet>> getAllItems() {
        List<NapkinRingSet> list = napkinRingSetRepo.findAll();
        return new ResponseEntity<>(list,OK);
    }


    @Override
    public ResponseEntity<NapkinRingSet> getItemById(long id) {
        try{
            NapkinRingSet set = napkinRingSetRepo.findById(id);
            return new ResponseEntity<>(set, OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<>(new NapkinRingSet(),BAD_REQUEST);
        }
    }

    public int getQuantityOfItemsInSet(long id) {
        try{
            NapkinRingSet set = napkinRingSetRepo.findById(id);
            return set.getQuantity();
        } catch(NoSuchElementException e){
            return 0;
        }
    }

    @Override
    public ResponseEntity<NapkinRingSet> createItem(NapkinRingSet item) {
        item.setBeads(updateBeadRepoCount(item));
        item.setFindings(updateFindingRepoCount(item));
        NapkinRingSet napkinRingSet = napkinRingSetRepo.save(item);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(napkinRingSet.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(napkinRingSet,responseHeaders,CREATED);
    }

    @Override
    public ResponseEntity<NapkinRingSet> updateItem(long id, NapkinRingSet item) {
        item.setId(id);
        NapkinRingSet set = napkinRingSetRepo.save(item);
        return new ResponseEntity<>(set, OK);
    }

    @Override
    public ResponseEntity<List<NapkinRingSet>> increasePriceOfAll(double amountToAdd) {
        Iterable<NapkinRingSet> iSet = napkinRingSetRepo.findAll();
        iSet.forEach(e-> e.setPrice(e.getPrice() + amountToAdd));
        iSet = napkinRingSetRepo.saveAll(iSet);
        List<NapkinRingSet> list= new ArrayList<>();
        iSet.forEach(e->list.add(e));
        return new ResponseEntity<>(list,OK);
    }

    @Override
    public ResponseEntity<NapkinRingSet> updateDescription(long id, String description) {
        try{
            NapkinRingSet set1 = napkinRingSetRepo.findById(id);
            set1.setDescription(description);
            NapkinRingSet set = napkinRingSetRepo.save(set1);
            return new ResponseEntity<>(set, OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<>(new NapkinRingSet(),BAD_REQUEST);
        }
    }

    public ResponseEntity<NapkinRingSet> updateQuantityOfItemsInSet(long id, int quantity){
        try{
            NapkinRingSet set1 = napkinRingSetRepo.findById(id);
            set1.setQuantity(quantity);
            NapkinRingSet set = napkinRingSetRepo.save(set1);
            return new ResponseEntity<>(set, OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<>(new NapkinRingSet(),BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity deleteItem(NapkinRingSet item) {
        napkinRingSetRepo.delete(item);
        return new ResponseEntity(OK);
    }
}
