package com.beadinventory.beadinventory.REST.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.REST.Repository.FinishedPiecesRepos.NecklaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import static org.springframework.http.HttpStatus.*;

@Service
public class NecklaceService extends AllFinishedPiecesService<Necklace> implements AllFinishedPiecesSvsInterface<Necklace> {

    private NecklaceRepo necklaceRepo;

    @Autowired
    public NecklaceService(NecklaceRepo necklaceRepo){
        this.necklaceRepo = necklaceRepo;
    }


    @Override
    public ResponseEntity<List<Necklace>> getAllItems() {
        List<Necklace> necklaces = necklaceRepo.findAll();
        return new ResponseEntity<>(necklaces,OK);
    }

    public ResponseEntity<List<Necklace>> getAllWithNaturalStones(){
        List<Necklace> necklaces = necklaceRepo.findNecklacesByHasNaturalStonesTrue();
        return new ResponseEntity<>(necklaces,OK);
    }

    public ResponseEntity<List<Necklace>> getAllWithSwarovski(){
        List<Necklace> necklaces = necklaceRepo.findNecklacesByHasSwarovskiTrue();
        return new ResponseEntity<>(necklaces,OK);
    }


    @Override
    public ResponseEntity<Necklace> getItemById(long id) {
        Necklace necklace = necklaceRepo.findById(id);
        return new ResponseEntity<>(necklace,OK);
    }

    @Override
    public ResponseEntity<Necklace> createItem(Necklace necklace){
        updateBeadRepoNewItem(necklace);
        updateFindingRepoNewItem(necklace);
        Necklace necklace1 = necklaceRepo.save(necklace);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(necklace.getAllId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(necklace1, CREATED);
    }


    @Override
    public ResponseEntity<Necklace> updateItem(long id, Necklace item) {
        Necklace oldNecklace = necklaceRepo.findById(item.getAllId());
        updateBeadRepoExistItem(oldNecklace, item);
        updateFindingRepoExistItem(oldNecklace, item);
        item.setAllId(id);
        Necklace necklace = necklaceRepo.save(item);
        return new ResponseEntity<>(necklace, OK);
    }


    public ResponseEntity<Necklace> updatePriceOfOne(long id, double price) {
        Necklace necklace = necklaceRepo.findById(id);
        necklace.setPrice(price);
        necklaceRepo.save(necklace);
        return new ResponseEntity<>(necklace,OK);
    }

    @Override
    public ResponseEntity<Necklace> updateDescription(long id, String description) {
        Necklace necklace = necklaceRepo.findById(id);
        necklace.setDescription(description);
        necklaceRepo.save(necklace);
        return new ResponseEntity<>(necklace,OK);
    }



    @Override
    public ResponseEntity<Necklace> archiveItem(Necklace necklace){
        necklace.setIsArchived(true);
        necklaceRepo.save(necklace);
        return new ResponseEntity<>(necklace, OK);
    }




    @Override
    public ResponseEntity deleteItem(Necklace item) {
        necklaceRepo.delete(item);
        return new ResponseEntity(OK);
    }
}
