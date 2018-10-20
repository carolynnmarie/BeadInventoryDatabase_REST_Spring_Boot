package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.AllFinishedPieces;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.AllFinishedPiecesRepo;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.FindingRepo;
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
    BeadRepo beadRepo;

    @Autowired
    FindingRepo findingRepo;

//    @Autowired
//    public AllFinishedPiecesService(BeadRepo beadRepo, FindingRepo findingRepo){
//        this.beadRepo = beadRepo;
//        this.findingRepo = findingRepo;
//    }



    public LinkedHashMap<Bead, Integer> updateBeadRepoCount(T item){
        LinkedHashMap<Bead,Integer> beadMap = new LinkedHashMap<>();
        LinkedHashMap<Bead,Integer> beads = item.getBeads();
        for(Map.Entry<Bead,Integer> beadEntry: beads.entrySet()){
            Bead bead = beadEntry.getKey();
            bead.setQuantity(bead.getQuantity()-beadEntry.getValue());
            Bead bead1 = beadRepo.save(bead);
            beadMap.put(bead1,beadEntry.getValue());
        }
        return beadMap;
    }

    public LinkedHashMap<Finding,Integer> updateFindingRepoCount(T item){
        LinkedHashMap<Finding,Integer> findingMap = new LinkedHashMap<>();
        LinkedHashMap<Finding,Integer> findings = item.getFindings();
        for(Map.Entry<Finding,Integer> entry: findings.entrySet()){
            Finding finding = entry.getKey();
            finding.setQuantity(finding.getQuantity()-entry.getValue());
            Finding finding1 = findingRepo.save(finding);
            findingMap.put(finding1,entry.getValue());
        }
        return findingMap;
    }






}
