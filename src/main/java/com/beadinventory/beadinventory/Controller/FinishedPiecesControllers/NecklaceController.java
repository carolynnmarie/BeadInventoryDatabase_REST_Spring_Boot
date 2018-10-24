package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.NecklaceService;
import org.hibernate.annotations.NamedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/necklaces")
public class NecklaceController implements AllFinishedPiecesContInterface<Necklace> {

    private NecklaceService necklaceService;

    @Autowired
    public NecklaceController(NecklaceService necklaceService){
        this.necklaceService = necklaceService;
    }


    @Override
    @GetMapping()
    public List<Necklace> findAllItems() {
        return necklaceService.getAllItems().getBody();
    }

    @GetMapping(path = "/findAllWithNaturalStones")
    public List<Necklace> findAllWithNaturalStones(){
        return necklaceService.getAllWithNaturalStones().getBody();
    }

    @GetMapping(path = "/findAllWithSwarovski")
    @ResponseBody
    public List<Necklace> findAllWithSwarovski(){
        return necklaceService.getAllWithSwarovski().getBody();
    }

    @GetMapping(params = "clasp")
    public List<Necklace> findAllWithClasp(@RequestAttribute(value = "clasp") FindingCategory clasp){
        return null;
    }

    @Override
    @GetMapping(value = "{id}")
    public Necklace findItemById(@PathVariable("id") long id) {
        return null;
    }

    @Override
    @PostMapping()
    public ResponseEntity<Necklace> createItem(@RequestBody Necklace item) {
        return null;
    }

    @Override
    @PutMapping(value = "/{id}")
    public Necklace updateItem(@PathVariable("id") long id, @RequestBody Necklace item) {
        return null;
    }

    @PutMapping(value = "/{id}", params = "price")
    public Necklace updatePriceOfOne(@PathVariable("id") long id,@RequestAttribute( value = "price") double price){
        return null;
    }

    @Override
    @PutMapping(params = "price")
    public List<Necklace> increaseAllPrices(@RequestAttribute(value = "price") double amountToAdd) {
        return null;
    }

    @Override
    @PutMapping(value = "/{id}",params = "description")
    public Necklace updateDescription(@PathVariable("id") long id, @RequestAttribute(value = "description") String description) {
        return null;
    }

    @PutMapping(value = "/{id}", params = "beads")
    public Necklace updateNecklaceBeads(@PathVariable("id") long id, @RequestAttribute(value = "beads") LinkedHashMap<Bead,Integer> beads){
        return null;
    }

    @Override
    @DeleteMapping()
    public ResponseEntity deleteItem(@RequestBody Necklace item) {
        return null;
    }

    public int getTotalItemCount() {
        return findAllItems().size();
    }
}
