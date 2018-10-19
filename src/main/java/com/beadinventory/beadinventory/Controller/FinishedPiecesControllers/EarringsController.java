package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.EarringsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class EarringsController implements AllFinishedPiecesContInterface<Earrings> {

    private EarringsService earringsService;

    @Autowired
    public EarringsController(EarringsService earringsService){
        this.earringsService = earringsService;
    }

    @Override
    @RequestMapping(value = "/earrings", method = GET)
    public List<Earrings> findAllItems() {
        return null;
    }

    @RequestMapping(value = "/earrings.getAllSterlingSilver", method = GET)
    public List<Earrings> findAllSterlingSilver(){
        return null;
    }

    @Override
    @RequestMapping(value = "/earrings/{id}", method = GET)
    public Earrings findItemById(@PathVariable("id") long id) {
        return null;
    }

    @Override
    @RequestMapping(value = "/earrings", method = POST)
    public Earrings createItem(@RequestBody Earrings item) {
        return null;
    }

    @Override
    @RequestMapping(value = "/earrings/{id}", method = PUT)
    public Earrings updateItem(@PathVariable("id") long id, @RequestBody Earrings item) {
        return null;
    }

    @RequestMapping(value = "/earrings/{id}",params = "price", method = PUT)
    public Earrings updatePriceOfOne(@PathVariable("id") long id, @RequestAttribute(value = "price") double price){
        return null;
    }

    @Override
    @RequestMapping(value = "/earrings",params = "price", method = PUT)
    public List<Earrings> updatePriceOfAll(@RequestAttribute(value = "price") double amountToAdd) {
        return null;
    }

    @Override
    @RequestMapping(value = "/earrings/{id}", params = "description", method = PUT)
    public Earrings updateDescription(@PathVariable("id") long id, @RequestAttribute("description") String description) {
        return null;
    }

    @Override
    @RequestMapping(value = "/earrings", method = DELETE)
    public ResponseEntity deleteItem(@RequestBody Earrings item) {
        return null;
    }

    public int getTotalItemCount(){
        return findAllItems().size();
    }
}
