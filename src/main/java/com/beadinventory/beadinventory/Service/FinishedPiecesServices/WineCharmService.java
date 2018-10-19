package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.WineCharmSet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineCharmService extends AllFinishedPiecesService implements AllFinishedPiecesSvsInterface<WineCharmSet>  {


    @Override
    public ResponseEntity<List<WineCharmSet>> getAllItems() {
        return null;
    }

    @Override
    public ResponseEntity<WineCharmSet> getItemById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<WineCharmSet> createItem(WineCharmSet item) {
        return null;
    }

    @Override
    public ResponseEntity<WineCharmSet> updateItem(long id, WineCharmSet item) {
        return null;
    }

    @Override
    public ResponseEntity<List<WineCharmSet>> updatePriceOfAll(double amountToAdd) {
        return null;
    }

    @Override
    public ResponseEntity<WineCharmSet> updateDescription(long id, String description) {
        return null;
    }

    public ResponseEntity<WineCharmSet> updateQuantity(long id, int quantity){
        return null;
    }

    @Override
    public ResponseEntity deleteItem(WineCharmSet item) {
        return null;
    }
}
