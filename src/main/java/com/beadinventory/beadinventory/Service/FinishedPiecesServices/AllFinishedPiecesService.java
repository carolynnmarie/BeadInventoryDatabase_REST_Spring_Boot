package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.AllFinishedPieces;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.AllFinishedPiecesRepo;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Service
public abstract class AllFinishedPiecesService<T extends AllFinishedPieces> {

    @Autowired
    private BeadService beadService;

    public ResponseEntity<T> updateBeadRepoCount(T item){
        LinkedHashMap<Bead, Integer> beads = item.getBeads();
        for(Map.Entry<Bead,Integer> beadEntry: beads.entrySet()){
            Long beadId = beadEntry.getKey().getId();
            beadService.removeBeadQuantity(beadId,beadEntry.getValue());
        }
        return new ResponseEntity<>(item,OK);
    }



}
/*
private BeadRepo beadRepo;

    public void removeFromBeadRepo(T item){
        LinkedHashMap<Bead, Integer> beads = item.getBeads();
        for(Map.Entry<Bead,Integer> bEntry: beads.entrySet()){
            Long id = bEntry.getKey().getId();
            Optional<Bead> oBead = beadRepo.findById(id);
            Bead bead = oBead.get();
            Long oldQuantity = bead.getQuantity();
            Long quantity = oldQuantity - bEntry.getValue();
            bead.setQuantity(quantity);
            beadRepo.save(bead);
        }
    }
 */