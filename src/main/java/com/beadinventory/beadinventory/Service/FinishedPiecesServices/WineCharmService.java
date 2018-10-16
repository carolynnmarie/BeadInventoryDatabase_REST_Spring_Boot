package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.WineCharm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineCharmService extends AllFinishedPiecesService implements AllFinishedPiecesSvsInterface<WineCharm>  {


    @Override
    public ResponseEntity<List<WineCharm>> getAllItems() {
        return null;
    }

    @Override
    public ResponseEntity<Long> getTotalCount(long count) {
        return null;
    }

    @Override
    public ResponseEntity<WineCharm> getItemById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<WineCharm> createItem(WineCharm item) {
        return null;
    }

    @Override
    public ResponseEntity<WineCharm> updateItem(long id, WineCharm item) {
        return null;
    }

    @Override
    public ResponseEntity<List<WineCharm>> updatePriceOfAll(double amountToAdd) {
        return null;
    }

    @Override
    public ResponseEntity<WineCharm> updateDescription(long id, String description) {
        return null;
    }

    public ResponseEntity<WineCharm> updateQuantity(long id, int quantity){
        return null;
    }

    @Override
    public ResponseEntity deleteItem(WineCharm item) {
        return null;
    }
}
