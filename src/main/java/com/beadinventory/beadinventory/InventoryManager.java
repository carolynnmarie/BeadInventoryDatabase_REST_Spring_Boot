package com.beadinventory.beadinventory;

import com.beadinventory.beadinventory.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.Domain.FinishedPieces.AllFinishedPieces;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class InventoryManager <T extends AllFinishedPieces> {

//    private BeadRepo beadRepo;
//
//    public void removeFromBeadRepo(T item){
//        LinkedHashMap<Bead, Integer> beads = item.getBeads();
//        for(Map.Entry<Bead,Integer> bEntry: beads.entrySet()){
//            Long id = bEntry.getKey().getId();
//            Optional<Bead> oBead = beadRepo.findById(id);
//            Bead bead = oBead.get();
//            Long oldQuantity = bead.getQuantity();
//            Long quantity = oldQuantity - bEntry.getValue();
//            bead.setQuantity(quantity);
//            beadRepo.save(bead);
//        }
//    }


}
