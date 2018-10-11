package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.WineCharm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineCharmService extends AllFinishedPiecesService<WineCharm> {
    @Override
    ResponseEntity<List<WineCharm>> getAllItems() {
        return null;
    }

    @Override
    ResponseEntity<WineCharm> getItemById(long id) {
        return null;
    }

    @Override
    long getQuantity(long id) {
        return 0;
    }

    @Override
    ResponseEntity<WineCharm> createItem(WineCharm item) {
        return null;
    }

    @Override
    ResponseEntity<WineCharm> updateItem(long id, WineCharm item) {
        return null;
    }

    @Override
    ResponseEntity<WineCharm> updatePrice(long id, int price) {
        return null;
    }

    @Override
    ResponseEntity<WineCharm> updateDescription(long id, String description) {
        return null;
    }

    @Override
    ResponseEntity deleteItem(WineCharm item) {
        return null;
    }
}
