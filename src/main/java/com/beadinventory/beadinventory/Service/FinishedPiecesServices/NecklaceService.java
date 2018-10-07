package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.InventoryManager;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.NecklaceRepo;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.*;

@Service
public class NecklaceService extends AllFinishedPiecesService {

    private NecklaceRepo necklaceRepo;
    private BeadRepo beadRepo;


    @Autowired
    public NecklaceService(NecklaceRepo necklaceRepo, BeadRepo beadRepo){
        this.necklaceRepo = necklaceRepo;
        this.beadRepo = beadRepo;
    }

    public ResponseEntity<Necklace> createNecklace(Necklace necklace){
        InventoryManager<Necklace> manager = new InventoryManager<>();
        manager.removeFromBeadRepo(necklace);
        Necklace necklace1 = necklaceRepo.save(necklace);
        return new ResponseEntity<>(necklace1, CREATED);
    }

//    public void removeFromBeadRepo(Necklace necklace){
//        LinkedHashMap<Bead, Integer> beads = necklace.getBeads();
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
