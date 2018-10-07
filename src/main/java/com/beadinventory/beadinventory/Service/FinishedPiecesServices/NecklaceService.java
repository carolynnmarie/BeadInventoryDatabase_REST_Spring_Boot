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

import static org.springframework.http.HttpStatus.*;

@Service
public class NecklaceService extends AllFinishedPiecesService<Necklace> {

    private NecklaceRepo necklaceRepo;



    @Autowired
    public NecklaceService(NecklaceRepo necklaceRepo, BeadRepo beadRepo){
        this.necklaceRepo = necklaceRepo;
    }

    public ResponseEntity<Necklace> createNecklace(Necklace necklace){
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


}
