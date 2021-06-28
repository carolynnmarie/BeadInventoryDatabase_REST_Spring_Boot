package com.beadinventory.beadinventory.REST.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Service.FinishedPiecesServices.NecklaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedHashMap;
import java.util.List;

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
    public List<Necklace> findAllWithSwarovski(){
        return necklaceService.getAllWithSwarovski().getBody();
    }

    @Override
    @GetMapping(value = "{id}")
    public Necklace findItemById(@PathVariable("id") long id) {
        return necklaceService.getItemById(id).getBody();
    }

    @Override
    @PostMapping()
    public ResponseEntity<Necklace> createItem(@RequestBody Necklace item) {
        return necklaceService.createItem(item);
    }

    @Override
    @PutMapping(value = "/{id}")
    public Necklace updateItem(@PathVariable("id") long id, @RequestBody Necklace item) {
        return necklaceService.updateItem(id,item).getBody();
    }

    @PutMapping(value = "/{id}", params = "price")
    public Necklace updatePriceOfOne(@PathVariable("id") long id,@RequestAttribute( value = "price") double price){
        return necklaceService.updatePriceOfOne(id,price).getBody();
    }

    @Override
    @PutMapping(value = "/{id}",params = "description")
    public Necklace updateDescription(@PathVariable("id") long id, @RequestAttribute(value = "description") String description) {
        return necklaceService.updateDescription(id,description).getBody();
    }



    @PutMapping()
    public Necklace archiveNecklace(@RequestBody Necklace necklace){
        return necklaceService.archiveItem(necklace).getBody();
    }


    @Override
    @DeleteMapping()
    public ResponseEntity deleteItem(@RequestBody Necklace item) {
        return necklaceService.deleteItem(item);
    }

}
