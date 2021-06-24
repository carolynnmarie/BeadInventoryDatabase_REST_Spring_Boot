package com.beadinventory.beadinventory.REST.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.AllFinishedPieces;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AllFinishedPiecesContInterface<T extends AllFinishedPieces> {

    List<T> findAllItems();
    T findItemById(long id);
    ResponseEntity<T> createItem(T item);
    T updateItem(long id, T item);
    T updateDescription(long id, String description);
    ResponseEntity deleteItem(T item);
}
/*
    ResponseEntity<List<T>> getAllItems();
    ResponseEntity<Long> getTotalCount();
    ResponseEntity<T> getItemById(long id);
    ResponseEntity<T> createItem(T item);
    ResponseEntity<T> updateItem(long id, T item);
    ResponseEntity<List<T>> increasePriceOfAll(double amountToAdd);
    ResponseEntity<T> updateDescription(long id, String description);
    ResponseEntity deleteItem(T item);
 */