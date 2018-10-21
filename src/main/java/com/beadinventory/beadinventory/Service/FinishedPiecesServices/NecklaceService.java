package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.NecklaceRepo;
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
        necklace.setBeads(updateBeadRepoCount(necklace));
        necklace.setFindings(updateFindingRepoCount(necklace));
        Necklace necklace1 = necklaceRepo.save(necklace);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(necklace.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(necklace1, CREATED);
    }


    @Override
    public ResponseEntity<Necklace> updateItem(long id, Necklace item) {
        Necklace necklace = necklaceRepo.findById(id);
        item.setId(necklace.getId());
        necklaceRepo.save(item);
        return new ResponseEntity<>(necklace, OK);
    }


    public ResponseEntity<Necklace> updatePriceOfOne(long id, double price) {
        Necklace necklace = necklaceRepo.findById(id);
        necklace.setPrice(price);
        necklaceRepo.save(necklace);
        return new ResponseEntity<>(necklace,OK);
    }

    @Override
    public ResponseEntity<List<Necklace>> increasePriceOfAll(double amountToAdd) {
        Iterable<Necklace> necklaces = necklaceRepo.findAll();
        necklaces.forEach(necklace -> necklace.setPrice(necklace.getPrice() + amountToAdd));
        necklaceRepo.saveAll(necklaces);
        List<Necklace> list = new ArrayList<>();
        necklaces.forEach(necklace -> list.add(necklace));
        return new ResponseEntity<>(list,OK);
    }

    public ResponseEntity<Necklace> updateBeads(long id, LinkedHashMap<Bead,Integer> beads){
        Necklace necklace = necklaceRepo.findById(id);
        necklace.setBeads(beads);
        necklace.setBeads(updateBeadRepoCount(necklace));
        necklaceRepo.save(necklace);
        return new ResponseEntity<>(necklace, OK);
    }

    @Override
    public ResponseEntity<Necklace> updateDescription(long id, String description) {
        Necklace necklace = necklaceRepo.findById(id);
        necklace.setDescription(description);
        necklaceRepo.save(necklace);
        return new ResponseEntity<>(necklace,OK);
    }

    @Override
    public ResponseEntity deleteItem(Necklace item) {
        necklaceRepo.delete(item);
        return new ResponseEntity(OK);
    }
}
