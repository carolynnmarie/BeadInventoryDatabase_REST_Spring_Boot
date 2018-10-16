package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.NapkinRing;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.NapkinRingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class NapkinRingController implements AllFinishedPiecesContInterface<NapkinRing> {


    @Override
    @RequestMapping(value = "/napkin_ring", method = GET)
    public List<NapkinRing> findAllItems() {
        return null;
    }

    @Override
    @RequestMapping(value = "napkin_ring.count")
    public Long getTotalItemCount() {
        return null;
    }

    @Override
    @RequestMapping(value = "/napkin_ring/{id}", method = GET)
    public NapkinRing findItemById(@PathVariable("id") long id) {
        return null;
    }

    @Override
    @RequestMapping(value = "/napkin_ring", method = POST)
    public NapkinRing createItem(@RequestBody NapkinRing item) {
        return null;
    }

    @Override
    @RequestMapping(value = "/napkin_ring/{id}")
    public NapkinRing updateItem(@PathVariable("id") long id, @RequestBody NapkinRing item) {
        return null;
    }

    @Override
    @RequestMapping(value = "/napkin_ring/price", method = PUT)
    public List<NapkinRing> updatePriceOfAll(@RequestParam(value = "price") double amountToAdd) {
        return null;
    }

    @Override
    @RequestMapping(value = "/napkin_ring/{id}/description", method = PUT)
    public NapkinRing updateDescription(@PathVariable("id") long id, @RequestParam(value = "description") String description) {
        return null;
    }

    @RequestMapping(value = "/napkin_ring/{id}/quantity", method = PUT)
    public NapkinRing updateQuantity(@PathVariable("id") long id, @RequestParam(value = "quantity") int quantity){
        return null;
    }

    @Override
    public ResponseEntity deleteItem(NapkinRing item) {
        return null;
    }
}
