package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.WineCharm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineCharmService extends AllFinishedPiecesService<WineCharm> {
    @Override
    public ResponseEntity<List<WineCharm>> getAllItems() {
        return null;
    }

    @Override
    public ResponseEntity<WineCharm> getItemById(long id) {
        return null;
    }

    public long getQuantity(long id) {
        return 0;
    }

    @Override
    public ResponseEntity<WineCharm> createItem(WineCharm item) {
        return null;
    }

    @Override
    public ResponseEntity<WineCharm> updateItem(long id, WineCharm item) {
        return null;
    }


    public ResponseEntity<WineCharm> updatePriceOfOne(long id, double price) {
        return null;
    }

    @Override
    public ResponseEntity<WineCharm> updateDescription(long id, String description) {
        return null;
    }

    @Override
    public ResponseEntity deleteItem(WineCharm item) {
        return null;
    }
}
