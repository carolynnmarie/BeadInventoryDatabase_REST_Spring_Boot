package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.WineCharmSet;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.WineCharmSetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import static org.springframework.http.HttpStatus.*;

@Service
public class WineCharmService extends AllFinishedPiecesService implements AllFinishedPiecesSvsInterface<WineCharmSet>  {

    private WineCharmSetRepo wineCharmSetRepo;

    @Autowired
    public WineCharmService(WineCharmSetRepo wineCharmSetRepo){
        this.wineCharmSetRepo = wineCharmSetRepo;
    }


    @Override
    public ResponseEntity<List<WineCharmSet>> getAllItems() {
        List<WineCharmSet> list = wineCharmSetRepo.findAll();
        return new ResponseEntity<>(list,OK);
    }

    @Override
    public ResponseEntity<WineCharmSet> getItemById(long id) {
        WineCharmSet set = wineCharmSetRepo.findById(id);
        return new ResponseEntity<>(set,OK);
    }

    @Override
    public ResponseEntity<WineCharmSet> createItem(WineCharmSet item) {
        item.setBeads(updateBeadRepoCount(item));
        item.setFindings(updateFindingRepoCount(item));
        WineCharmSet set = wineCharmSetRepo.save(item);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(set.getAllId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(set, responseHeaders, CREATED);
    }

    @Override
    public ResponseEntity<WineCharmSet> updateItem(long id, WineCharmSet item) {
        item.setBeads(updateBeadRepoCount(item));
        item.setFindings(updateFindingRepoCount(item));
        item.setAllId(id);
        WineCharmSet set = wineCharmSetRepo.save(item);
        return new ResponseEntity<>(set,OK);
    }

    @Override
    public ResponseEntity<List<WineCharmSet>> increasePriceOfAll(double amountToAdd) {
        Iterable<WineCharmSet> iSet = wineCharmSetRepo.findAll();
        iSet.forEach(e-> e.setPrice(e.getPrice() + amountToAdd));
        iSet = wineCharmSetRepo.saveAll(iSet);
        List<WineCharmSet> list = new ArrayList<>();
        iSet.forEach(e->list.add(e));
        return new ResponseEntity<>(list,OK);
    }

    @Override
    public ResponseEntity<WineCharmSet> updateDescription(long id, String description) {
        WineCharmSet set = wineCharmSetRepo.findById(id);
        set.setDescription(description);
        set = wineCharmSetRepo.save(set);
        return new ResponseEntity<>(set,OK);
    }

    public ResponseEntity<WineCharmSet> updateQuantityOfItemsInSet(long id, int quantity){
        WineCharmSet set = wineCharmSetRepo.findById(id);
        set.setQuantity(quantity);
        set = wineCharmSetRepo.save(set);
        return new ResponseEntity<>(set,OK);
    }

    @Override
    public ResponseEntity deleteItem(WineCharmSet item) {
        wineCharmSetRepo.delete(item);
        return new ResponseEntity(OK);
    }
}
