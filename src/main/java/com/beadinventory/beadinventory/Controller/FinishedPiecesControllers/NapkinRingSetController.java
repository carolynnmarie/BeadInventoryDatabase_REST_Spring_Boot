package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.NapkinRingSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/napkin_ring")
public class NapkinRingSetController implements AllFinishedPiecesContInterface<NapkinRingSet> {


    @Override
    @GetMapping()
    public List<NapkinRingSet> findAllItems() {
        return null;
    }

    @Override
    @GetMapping(value = "/{id}")
    public NapkinRingSet findItemById(@PathVariable("id") long id) {
        return null;
    }

    //int getQuantityOfItemsInSet(long id)

    @Override
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public NapkinRingSet createItem(@RequestBody NapkinRingSet item) {
        return null;
    }

    @Override
    @PutMapping(value = "/{id}")
    public NapkinRingSet updateItem(@PathVariable("id") long id, @RequestBody NapkinRingSet item) {
        return null;
    }

    @Override
    @PutMapping( params = "price")
    public List<NapkinRingSet> updatePriceOfAll(@RequestAttribute(value = "price") double amountToAdd) {
        return null;
    }

    @Override
    @PutMapping(value = "/{id}", params = "description")
    public NapkinRingSet updateDescription(@PathVariable("id") long id, @RequestAttribute(value = "description") String description) {
        return null;
    }

    @PutMapping(value = "/{id}", params = "quantity")
    public NapkinRingSet updateQuantity(@PathVariable("id") long id, @RequestAttribute(value = "quantity") int quantity){
        return null;
    }

    @Override
    @DeleteMapping()
    public ResponseEntity deleteItem(NapkinRingSet item) {
        return null;
    }

    public int getTotalItemCount(){
        return findAllItems().size();
    }
}
