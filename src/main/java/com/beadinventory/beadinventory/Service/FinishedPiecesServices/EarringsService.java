package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarringsService extends AllFinishedPiecesService<Earrings> {
    @Override
    public ResponseEntity<List<Earrings>> getAllItems() {
        return null;
    }

    @Override
    public ResponseEntity<Earrings> getItemById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<Earrings> createItem(Earrings item) {
        return null;
    }

    @Override
    public ResponseEntity<Earrings> updateItem(long id, Earrings item) {
        return null;
    }

    @Override
    public ResponseEntity<Earrings> updatePriceOfOne(long id, double price) {
        return null;
    }

    @Override
    public ResponseEntity<Earrings> updateDescription(long id, String description) {
        return null;
    }

    @Override
    public ResponseEntity deleteItem(Earrings item) {
        return null;
    }
}
