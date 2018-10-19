package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.WineCharm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WineCharmController implements AllFinishedPiecesContInterface<WineCharm> {


    @Override
    public List<WineCharm> findAllItems() {
        return null;
    }

    @Override
    public WineCharm findItemById(long id) {
        return null;
    }

    @Override
    public WineCharm createItem(WineCharm item) {
        return null;
    }

    @Override
    public WineCharm updateItem(long id, WineCharm item) {
        return null;
    }

    @Override
    public List<WineCharm> updatePriceOfAll(double amountToAdd) {
        return null;
    }

    @Override
    public WineCharm updateDescription(long id, String description) {
        return null;
    }

    @Override
    public ResponseEntity deleteItem(WineCharm item) {
        return null;
    }

    public int getTotalItemCount() {
        return findAllItems().size();
    }
}
