package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.AllFinishedPieces;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.FindingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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



    public HashMap<Bead, Integer> updateBeadRepoCount(T item){
        ArrayList<Bead> beadList = new ArrayList<>();
        HashMap<Bead,Integer> beadMap = new HashMap<>();
        Map<Bead, Integer> beads = item.getBeads();
        for(Map.Entry<Bead,Integer> beadEntry: beads.entrySet()){
            Bead bead = beadEntry.getKey();
            bead.setQuantity(bead.getQuantity()-beadEntry.getValue());
            beadList.add(bead);
            beadMap.put(bead,beadEntry.getValue());
        }
        beadRepo.saveAll(beadList);
        return beadMap;
    }

    public HashMap<Finding,Integer> updateFindingRepoCount(T item){
        HashMap<Finding,Integer> findingMap = new HashMap<>();
        Map<Finding, Integer> findings = item.getFindings();
        for(Map.Entry<Finding,Integer> entry: findings.entrySet()){
            Finding finding = entry.getKey();
            finding.setQuantity(finding.getQuantity()-entry.getValue());
            findingRepo.save(finding);
            findingMap.put(finding,entry.getValue());
        }
        return findingMap;
    }






}
