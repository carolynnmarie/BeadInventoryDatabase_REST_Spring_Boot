package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.NapkinRingSet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NapkinRingService extends AllFinishedPiecesService<NapkinRingSet> implements AllFinishedPiecesSvsInterface<NapkinRingSet> {
    @Override
    public ResponseEntity<List<NapkinRingSet>> getAllItems() {
        return null;
    }


    @Override
    public ResponseEntity<NapkinRingSet> getItemById(long id) {
        return null;
    }

    public long getQuantity(long id) {
        return 0;
    }

    @Override
    public ResponseEntity<NapkinRingSet> createItem(NapkinRingSet item) {
        return null;
    }

    @Override
    public ResponseEntity<NapkinRingSet> updateItem(long id, NapkinRingSet item) {
        return null;
    }

    @Override
    public ResponseEntity<List<NapkinRingSet>> updatePriceOfAll(double amountToAdd) {
        return null;
    }

    @Override
    public ResponseEntity<NapkinRingSet> updateDescription(long id, String description) {
        return null;
    }

    public ResponseEntity<NapkinRingSet> updateQuantity(long id, int quantity){
        return null;
    }

    @Override
    public ResponseEntity deleteItem(NapkinRingSet item) {
        return null;
    }
}
