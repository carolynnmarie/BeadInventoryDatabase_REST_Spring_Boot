package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.NapkinRing;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NapkinRingService extends AllFinishedPiecesService<NapkinRing> {
    @Override
    ResponseEntity<List<NapkinRing>> getAllItems() {
        return null;
    }

    @Override
    ResponseEntity<NapkinRing> getItemById(long id) {
        return null;
    }

    @Override
    long getQuantity(long id) {
        return 0;
    }

    @Override
    ResponseEntity<NapkinRing> createItem(NapkinRing item) {
        return null;
    }

    @Override
    ResponseEntity<NapkinRing> updateItem(long id, NapkinRing item) {
        return null;
    }

    @Override
    ResponseEntity<NapkinRing> updatePrice(long id, int price) {
        return null;
    }

    @Override
    ResponseEntity<NapkinRing> updateDescription(long id, String description) {
        return null;
    }

    @Override
    ResponseEntity deleteItem(NapkinRing item) {
        return null;
    }
}
