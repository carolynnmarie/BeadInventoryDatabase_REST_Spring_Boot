package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.InventoryManager;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.NecklaceRepo;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class NecklaceService extends AllFinishedPiecesService<Necklace> {

    private NecklaceRepo necklaceRepo;


    @Autowired
    public NecklaceService(NecklaceRepo necklaceRepo, BeadRepo beadRepo){
        this.necklaceRepo = necklaceRepo;
    }



    @Override
    ResponseEntity<List<Necklace>> getAllItems() {
        return null;
    }

    @Override
    ResponseEntity<Necklace> getItemById(long id) {
        return null;
    }

    @Override
    long getQuantity(long id) {
        return 0;
    }

    @Override
    public ResponseEntity<Necklace> createItem(Necklace necklace){
        updateBeadRepoCount(necklace);
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
    ResponseEntity<Necklace> updateItem(long id, Necklace item) {
        return null;
    }

    @Override
    ResponseEntity<Necklace> updatePrice(long id, int price) {
        return null;
    }

    @Override
    ResponseEntity<Necklace> updateDescription(long id, String description) {
        return null;
    }

    @Override
    ResponseEntity deleteItem(Necklace item) {
        return null;
    }
}
