package com.beadinventory.beadinventory.REST.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.AllFinishedPieces;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AllFinishedPiecesSvsInterface<T extends AllFinishedPieces> {
    ResponseEntity<List<T>> getAllItems();
    ResponseEntity<T> getItemById(long id);
    ResponseEntity<T> createItem(T item);
    ResponseEntity<T> updateItem(long id, T item);
    ResponseEntity<T> updateDescription(long id, String description);
    ResponseEntity<T> archiveItem(T item);
    ResponseEntity deleteItem(T item);
}
