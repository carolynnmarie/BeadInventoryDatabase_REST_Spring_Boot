package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.AllFinishedPieces;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AllFinishedPiecesSvsInterface<T extends AllFinishedPieces> {
    ResponseEntity<List<T>> getAllItems();
    ResponseEntity<T> getItemById(long id);
    ResponseEntity<T> createItem(T item);
    ResponseEntity<T> updateItem(long id, T item);
    ResponseEntity<List<T>> increasePriceOfAll(double amountToAdd);
    ResponseEntity<T> updateDescription(long id, String description);
    ResponseEntity deleteItem(T item);
}
