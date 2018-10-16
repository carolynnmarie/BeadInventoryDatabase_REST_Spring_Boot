package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Bracelet;
import com.beadinventory.beadinventory.Domain.FinishedPieces.BraceletType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class BraceletController implements AllFinishedPiecesContInterface<Bracelet> {

    @Override
    @RequestMapping(value = "/bracelets", method = GET)
    public List<Bracelet> findAllItems() {
        return null;
    }

    @Override
    @RequestMapping(value = "/bracelets.count", method = GET)
    public Long getTotalItemCount() {
        return null;
    }

    @RequestMapping(value = "/bracelets/bracelet_type", method = GET)
    public List<Bracelet> findAllOfBraceletType(@RequestParam (value = "bracelet_type")BraceletType bracelet_type){
        return null;
    }

    @Override
    @RequestMapping(value = "/bracelets/{id}",method = GET)
    public Bracelet findItemById(@PathVariable("id") long id) {
        return null;
    }

    @Override
    @RequestMapping(value = "/bracelets", method = POST)
    public Bracelet createItem(@RequestBody Bracelet item) {
        return null;
    }

    @Override
    @RequestMapping(value = "/bracelets/{id}")
    public Bracelet updateItem(@PathVariable("id") long id, @RequestBody Bracelet item) {
        return null;
    }

    @Override
    @RequestMapping(value = "/bracelets/price", method = PUT)
    public List<Bracelet> updatePriceOfAll(@RequestParam(value = "price") double amountToAdd) {
        return null;
    }

    @Override
    @RequestMapping(value = "/bracelets/{id}/description", method = PUT)
    public Bracelet updateDescription(@PathVariable("id") long id, @RequestParam(value = "description") String description) {
        return null;
    }

    @Override
    @RequestMapping(value = "/bracelets", method = DELETE)
    public ResponseEntity deleteItem(@RequestBody Bracelet item) {
        return null;
    }
}
