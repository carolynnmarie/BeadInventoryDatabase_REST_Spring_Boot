package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.WineCharmSet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WineCharmSetController implements AllFinishedPiecesContInterface<WineCharmSet> {


    @Override
    public List<WineCharmSet> findAllItems() {
        return null;
    }

    @Override
    public WineCharmSet findItemById(long id) {
        return null;
    }

    @Override
    public WineCharmSet createItem(WineCharmSet item) {
        return null;
    }

    @Override
    public WineCharmSet updateItem(long id, WineCharmSet item) {
        return null;
    }

    @Override
    public List<WineCharmSet> updatePriceOfAll(double amountToAdd) {
        return null;
    }

    @Override
    public WineCharmSet updateDescription(long id, String description) {
        return null;
    }

    @Override
    public ResponseEntity deleteItem(WineCharmSet item) {
        return null;
    }

    public int getTotalItemCount() {
        return findAllItems().size();
    }
}
