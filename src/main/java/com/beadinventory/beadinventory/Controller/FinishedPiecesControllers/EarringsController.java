package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.EarringsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/earrings")
public class EarringsController implements AllFinishedPiecesContInterface<Earrings> {

    private EarringsService earringsService;

    @Autowired
    public EarringsController(EarringsService earringsService){
        this.earringsService = earringsService;
    }

    @Override
    @GetMapping()
    public List<Earrings> findAllItems() {
        return null;
    }

    @GetMapping(path = "/findAllSterlingSilver")
    public List<Earrings> findAllSterlingSilver(){
        return earringsService.getAllSterlingSilver().getBody();
    }

    @Override
    @GetMapping(value = "/{id}")
    public Earrings findItemById(@PathVariable("id") long id) {
        return earringsService.getItemById(id).getBody();
    }

    @Override
    @PostMapping(value = "")
    public ResponseEntity<Earrings> createItem(@RequestBody Earrings item) {
        return earringsService.createItem(item);
    }

    @Override
    @PutMapping(value = "/{id}")
    public Earrings updateItem(@PathVariable("id") long id, @RequestBody Earrings item) {
        return earringsService.updateItem(id, item).getBody();
    }

    @PutMapping(value = "/{id}",params = "price")
    public Earrings updatePriceOfOne(@PathVariable("id") long id, @RequestAttribute(value = "price") double price){
        return earringsService.updatePriceOfOne(id, price).getBody();
    }

    @Override
    @PutMapping(value = "",params = "price")
    public List<Earrings> increaseAllPrices(@RequestAttribute(value = "price") double amountToAdd) {
        return earringsService.increasePriceOfAll(amountToAdd).getBody();
    }

    @Override
    @PutMapping(value = "/{id}", params = "description")
    public Earrings updateDescription(@PathVariable("id") long id, @RequestAttribute("description") String description) {
        return earringsService.updateDescription(id,description).getBody();
    }

    @Override
    @DeleteMapping(value = "")
    public ResponseEntity deleteItem(@RequestBody Earrings item) {
        return earringsService.deleteItem(item);
    }

    public int getTotalItemCount(){
        return findAllItems().size();
    }
}
