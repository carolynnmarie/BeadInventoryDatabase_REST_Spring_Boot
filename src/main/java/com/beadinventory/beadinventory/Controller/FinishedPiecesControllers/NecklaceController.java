package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.NecklaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class NecklaceController implements AllFinishedPiecesContInterface<Necklace> {

    private NecklaceService necklaceService;

    @Autowired
    public NecklaceController(NecklaceService necklaceService){
        this.necklaceService = necklaceService;
    }


    @Override
    @RequestMapping(value = "/necklaces", method = GET)
    public List<Necklace> findAllItems() {
        return null;
    }


    public List<Necklace> findAllOfStringWireCategory(StringWireCategory category){
        return null;
    }

    public List<Necklace> findAllWithNaturalStones(){
        return null;
    }

    public List<Necklace> findAllWithSwarovski(){
        return null;
    }

    public List<Necklace> findAllWithClasp(FindingCategory clasp){
        return null;
    }

    @Override
    public Necklace findItemById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<Necklace> createItem(Necklace item) {
        return null;
    }

    @Override
    public Necklace updateItem(long id, Necklace item) {
        return null;
    }

    public Necklace updatePriceOfOne(double price){
        return null;
    }

    @Override
    public List<Necklace> updatePriceOfAll(double amountToAdd) {
        return null;
    }

    @Override
    public Necklace updateDescription(long id, String description) {
        return null;
    }

    public Necklace updateNecklaceBeads(long id, LinkedHashMap<Bead,Integer> beads){
        return null;
    }

    @Override
    public ResponseEntity deleteItem(Necklace item) {
        return null;
    }

    public int getTotalItemCount() {
        return findAllItems().size();
    }
}
