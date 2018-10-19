package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.NapkinRing;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.NapkinRingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(value = "/napkin_ring")
public class NapkinRingController implements AllFinishedPiecesContInterface<NapkinRing> {


    @Override
    @GetMapping()
    public List<NapkinRing> findAllItems() {
        return null;
    }

    @Override
    @GetMapping(value = "/{id}")
    public NapkinRing findItemById(@PathVariable("id") long id) {
        return null;
    }

    @Override
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public NapkinRing createItem(@RequestBody NapkinRing item) {
        return null;
    }

    @Override
    @PutMapping(value = "/{id}")
    public NapkinRing updateItem(@PathVariable("id") long id, @RequestBody NapkinRing item) {
        return null;
    }

    @Override
    @PutMapping( params = "price")
    public List<NapkinRing> updatePriceOfAll(@RequestAttribute(value = "price") double amountToAdd) {
        return null;
    }

    @Override
    @PutMapping(value = "/{id}", params = "description")
    public NapkinRing updateDescription(@PathVariable("id") long id, @RequestAttribute(value = "description") String description) {
        return null;
    }

    @PutMapping(value = "/{id}", params = "quantity")
    public NapkinRing updateQuantity(@PathVariable("id") long id, @RequestAttribute(value = "quantity") int quantity){
        return null;
    }

    @Override
    @DeleteMapping()
    public ResponseEntity deleteItem(NapkinRing item) {
        return null;
    }

    public int getTotalItemCount(){
        return findAllItems().size();
    }
}
