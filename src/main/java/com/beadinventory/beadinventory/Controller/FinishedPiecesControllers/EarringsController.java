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
    @GetMapping(value = "/earrings")
    public List<Earrings> findAllItems() {
        return null;
    }

    @GetMapping(value = "/earrings/", path = "/findAllSterlingSilver")
    public List<Earrings> findAllSterlingSilver(){
        return earringsService.getAllSterlingSilver().getBody();
    }

    @Override
    @GetMapping(value = "/earrings/{id}")
    public Earrings findItemById(@PathVariable("id") long id) {
        return null;
    }

    @Override
    @PostMapping(value = "/earrings")
    public ResponseEntity<Earrings> createItem(@RequestBody Earrings item) {
        return null;
    }

    @Override
    @PutMapping(value = "/earrings/{id}")
    public Earrings updateItem(@PathVariable("id") long id, @RequestBody Earrings item) {
        return null;
    }

    @PutMapping(value = "/earrings/{id}",params = "price")
    public Earrings updatePriceOfOne(@PathVariable("id") long id, @RequestAttribute(value = "price") double price){
        return null;
    }

    @Override
    @PutMapping(value = "/earrings",params = "price")
    public List<Earrings> increaseAllPrices(@RequestAttribute(value = "price") double amountToAdd) {
        return null;
    }

    @Override
    @PutMapping(value = "/earrings/{id}", params = "description")
    public Earrings updateDescription(@PathVariable("id") long id, @RequestAttribute("description") String description) {
        return null;
    }

    @Override
    @DeleteMapping(value = "/earrings")
    public ResponseEntity deleteItem(@RequestBody Earrings item) {
        return null;
    }

    public int getTotalItemCount(){
        return findAllItems().size();
    }
}
