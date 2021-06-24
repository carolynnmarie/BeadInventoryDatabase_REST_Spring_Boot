package com.beadinventory.beadinventory.REST.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.WineCharmSet;
import com.beadinventory.beadinventory.REST.Service.FinishedPiecesServices.WineCharmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/wine_charm")
public class WineCharmSetController implements AllFinishedPiecesContInterface<WineCharmSet> {

    private WineCharmService wineCharmService;

    @Autowired
    public WineCharmSetController(WineCharmService wineCharmService){
        this.wineCharmService = wineCharmService;
    }

    @Override
    @GetMapping()
    public List<WineCharmSet> findAllItems() {
        return wineCharmService.getAllItems().getBody();
    }

    @Override
    @GetMapping(value = "/{id}")
    public WineCharmSet findItemById(@PathVariable("id") long id) {
        return wineCharmService.getItemById(id).getBody();
    }

    @Override
    @PostMapping()
    public ResponseEntity<WineCharmSet> createItem(@RequestBody  WineCharmSet item) {
        return wineCharmService.createItem(item);
    }

    @Override
    @PutMapping(value = "/{id}")
    public WineCharmSet updateItem(@PathVariable("id") long id, @RequestBody WineCharmSet item) {
        return wineCharmService.updateItem(id,item).getBody();
    }

    @Override
    @PutMapping(value = "/{id}", params = "description")
    public WineCharmSet updateDescription(@PathVariable("id") long id, @RequestAttribute("description") String description) {
        return wineCharmService.updateDescription(id,description).getBody();
    }

    @Override
    @DeleteMapping()
    public ResponseEntity deleteItem(@RequestBody WineCharmSet item) {
        return wineCharmService.deleteItem(item);
    }

}
