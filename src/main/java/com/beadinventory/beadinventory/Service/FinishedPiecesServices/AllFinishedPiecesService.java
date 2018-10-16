package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.AllFinishedPieces;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.AllFinishedPiecesRepo;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import com.beadinventory.beadinventory.Service.SuppliesServices.FindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.springframework.http.HttpStatus.*;

@Service
public abstract class AllFinishedPiecesService<T extends AllFinishedPieces> {

    @Autowired
    private BeadService beadService;

    @Autowired
    private FindingService findingService;

    public void updateBeadRepoCount(T item){
        HashMap<Bead, Integer> beads = item.getBeads();
        for(Map.Entry<Bead,Integer> beadEntry: beads.entrySet()){
            Long beadId = beadEntry.getKey().getId();
            beadService.removeBeadQuantity(beadId,beadEntry.getValue());
        }
    }

    public void updateFindingRepoCount(T item){
        HashMap<Finding,Integer> findings = item.getFindings();
        for(Map.Entry<Finding,Integer> entry: findings.entrySet()){
            long findingId = entry.getKey().getId();
            findingService.removeFindingQuantity(findingId,entry.getValue());
        }
    }






}
