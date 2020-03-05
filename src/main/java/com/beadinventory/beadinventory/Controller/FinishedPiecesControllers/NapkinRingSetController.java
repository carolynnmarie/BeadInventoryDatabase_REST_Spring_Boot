package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.NapkinRingSet;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.NapkinRingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/napkin_ring")
public class NapkinRingSetController implements AllFinishedPiecesContInterface<NapkinRingSet> {

    private NapkinRingService napkinRingService;

    @Autowired
    public NapkinRingSetController(NapkinRingService napkinRingService){
        this.napkinRingService = napkinRingService;
    }


    @Override
    @GetMapping()
    public List<NapkinRingSet> findAllItems() {
        return napkinRingService.getAllItems().getBody();
    }

    @Override
    @GetMapping(value = "/{id}")
    public NapkinRingSet findItemById(@PathVariable(value = "id") long id) {
        return napkinRingService.getItemById(id).getBody();
    }


    public int getSetSize(long id){
        return findItemById(id).getQuantity();
    }

    @Override
    @PostMapping()
    public ResponseEntity<NapkinRingSet> createItem(@RequestBody NapkinRingSet item) {
        return napkinRingService.createItem(item);
    }

    @Override
    @PutMapping(value = "/{id}")
    public NapkinRingSet updateItem(@PathVariable( value = "id") long id, @RequestBody NapkinRingSet item) {
        return napkinRingService.updateItem(id,item).getBody();
    }

    @Override
    @PutMapping(params = "price")
    public List<NapkinRingSet> increaseAllPrices(@RequestAttribute(value = "price") double amountToAdd) {
        return napkinRingService.increasePriceOfAll(amountToAdd).getBody();
    }

    @Override
    @PutMapping(value = "/{id}", params = "description")
    public NapkinRingSet updateDescription(@PathVariable(value = "id") long id, @RequestAttribute(value = "description") String description) {
        return napkinRingService.updateDescription(id,description).getBody();
    }

    @PutMapping(value = "/{id}", params = "quantity")
    public NapkinRingSet updateQuantity(@PathVariable(value = "id") long id, @RequestAttribute(value = "quantity") int quantity){
        return napkinRingService.updateQuantityOfItemsInSet(id,quantity).getBody();
    }

    @Override
    @DeleteMapping()
    public ResponseEntity deleteItem(NapkinRingSet item) {
        return napkinRingService.deleteItem(item);
    }

}
