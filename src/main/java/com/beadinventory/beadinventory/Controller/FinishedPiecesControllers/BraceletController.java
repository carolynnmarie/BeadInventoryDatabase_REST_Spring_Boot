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
        return null;
    }

    @GetMapping(value = "/bracelet_type")
    public List<Bracelet> findAllOfBraceletType(@RequestAttribute (value = "bracelet_type")BraceletType bracelet_type){
        return null;
    }


    @Override
    @GetMapping(value = "/{id}")
    public Bracelet findItemById(@PathVariable("id") long id) {
        return null;
    }

    @Override
    @PostMapping()
    public ResponseEntity<Bracelet> createItem(@RequestBody Bracelet item) {
        return null;
    }

    @Override
    @PutMapping(value = "/{id}")
    public Bracelet updateItem(@PathVariable("id") long id, @RequestBody Bracelet item) {
        return null;
    }

    //ResponseEntity<Bracelet> updatePriceOfOne(long id, double price)

    @Override
    @PutMapping(params = "price")
    public List<Bracelet> updatePriceOfAll(@RequestAttribute(value = "price") double amountToAdd) {
        return null;
    }

    @Override
    @PutMapping(value = "/{id}", params = "description")
    public Bracelet updateDescription(@PathVariable("id") long id, @RequestAttribute(value = "description") String description) {
        return null;
    }

    @Override
    @DeleteMapping()
    public ResponseEntity deleteItem(@RequestBody Bracelet item) {
        return null;
    }

    public int getTotalItemCount(){
        return findAllItems().size();
    }
}
