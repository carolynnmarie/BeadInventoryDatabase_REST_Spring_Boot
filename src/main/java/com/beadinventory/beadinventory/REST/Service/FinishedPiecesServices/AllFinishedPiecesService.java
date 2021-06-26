package com.beadinventory.beadinventory.REST.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.*;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.REST.Repository.SuppliesRepos.BeadRepo;
import com.beadinventory.beadinventory.REST.Repository.SuppliesRepos.FindingRepo;
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

    public void updateBeadRepoNewItem(T item) {
        Map<Bead, Integer> beads = item.getBeads();
        for(Map.Entry<Bead, Integer> each: beads.entrySet()){
            Integer toReduceBy = each.getValue();
            Bead bead = beadRepo.findById(each.getKey().getBeadId());
            bead.setQuantity(bead.getQuantity() - toReduceBy);
            beadRepo.save(bead);
        }
    }

    public void updateBeadRepoExistItem(T original, T updatedItem){
        for(Map.Entry<Bead, Integer> each: original.getBeads().entrySet()){
            Integer toBeAdded = each.getValue();
            Bead bead = beadRepo.findById(each.getKey().getBeadId());
            bead.setQuantity(bead.getQuantity() + toBeAdded);
            beadRepo.save(bead);
        }
        for(Map.Entry<Bead, Integer> each: updatedItem.getBeads().entrySet()){
            Integer toBeReduced = each.getValue();
            Bead bead = beadRepo.findById(each.getKey().getBeadId());
            bead.setQuantity(bead.getQuantity() - toBeReduced);
            beadRepo.save(bead);
        }
    }

    public void updateFindingRepoNewItem(T item){
        Map<Finding, Integer> findings = item.getFindings();
        for(Map.Entry<Finding,Integer> entry: findings.entrySet()){
            Finding finding = entry.getKey();
            finding.setQuantity(finding.getQuantity()-entry.getValue());
            findingRepo.save(finding);
        }
    }


    public void updateFindingRepoExistItem(T original, T updatedItem){
        for(Map.Entry<Finding, Integer> each: original.getFindings().entrySet()){
            Integer toBeAdded = each.getValue();
            Finding finding = findingRepo.findById(each.getKey().getId());
            finding.setQuantity(finding.getQuantity() + toBeAdded);
            findingRepo.save(finding);
        }
        for(Map.Entry<Finding, Integer> each: updatedItem.getFindings().entrySet()){
            Integer toBeReduced = each.getValue();
            Finding finding = findingRepo.findById(each.getKey().getId());
            finding.setQuantity(finding.getQuantity() - toBeReduced);
            findingRepo.save(finding);
        }
    }


}
