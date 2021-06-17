package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Bracelet;
import com.beadinventory.beadinventory.Domain.FinishedPieces.BraceletType;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.BraceletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/bracelets")
public class BraceletController implements AllFinishedPiecesContInterface<Bracelet> {

    private BraceletService braceletService;

    @Autowired
    public BraceletController(BraceletService braceletService){
        this.braceletService = braceletService;
    }

    @Override
    @GetMapping()
    public List<Bracelet> findAllItems() {
        return braceletService.getAllItems().getBody();
    }

    @GetMapping(params = "type")
    public List<Bracelet> findAllOfBraceletType(@RequestAttribute BraceletType type){
        return braceletService.findByBraceletType(type).getBody();
    }


    @Override
    @GetMapping(value = "/{id}")
    public Bracelet findItemById(@PathVariable("id") long id) {
        return braceletService.getItemById(id).getBody();
    }

    @Override
    @PostMapping()
    public ResponseEntity<Bracelet> createItem(@RequestBody Bracelet item) {
        return braceletService.createItem(item);
    }

    @Override
    @PutMapping(value = "/{id}")
    public Bracelet updateItem(@PathVariable("id") long id, @RequestBody Bracelet item) {
        return braceletService.updateItem(id,item).getBody();
    }


    @PutMapping(value = "/{id}",params = "price")
    public Bracelet updatePriceOfOne(@PathVariable("id")long id,@RequestAttribute double price){
        return braceletService.updatePriceOfOne(id,price).getBody();
    }

    @Override
    @PutMapping(value = "/{id}", params = "description")
    public Bracelet updateDescription(@PathVariable("id") long id, @RequestAttribute(value = "description") String description) {
        return braceletService.updateDescription(id,description).getBody();
    }

    @Override
    @DeleteMapping()
    public ResponseEntity deleteItem(@RequestBody Bracelet item) {
        return braceletService.deleteItem(item);
    }

}
