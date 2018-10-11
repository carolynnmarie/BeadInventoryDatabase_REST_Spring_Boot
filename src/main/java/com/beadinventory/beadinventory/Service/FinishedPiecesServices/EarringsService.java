package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarringsService extends AllFinishedPiecesService<Earrings> {
    @Override
    ResponseEntity<List<Earrings>> getAllItems() {
        return null;
    }

    @Override
    ResponseEntity<Earrings> getItemById(long id) {
        return null;
    }

    @Override
    long getQuantity(long id) {
        return 0;
    }

    @Override
    ResponseEntity<Earrings> createItem(Earrings item) {
        return null;
    }

    @Override
    ResponseEntity<Earrings> updateItem(long id, Earrings item) {
        return null;
    }

    @Override
    ResponseEntity<Earrings> updatePrice(long id, int price) {
        return null;
    }

    @Override
    ResponseEntity<Earrings> updateDescription(long id, String description) {
        return null;
    }

    @Override
    ResponseEntity deleteItem(Earrings item) {
        return null;
    }
}
