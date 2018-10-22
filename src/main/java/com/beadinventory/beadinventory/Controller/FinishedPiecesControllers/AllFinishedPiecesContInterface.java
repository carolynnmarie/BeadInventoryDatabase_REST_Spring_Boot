package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.AllFinishedPieces;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.AllFinishedPiecesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AllFinishedPiecesContInterface<T extends AllFinishedPieces> {

    List<T> findAllItems();
    T findItemById(@PathVariable("id") long id);
    ResponseEntity<T> createItem(@RequestBody T item);
    T updateItem(@PathVariable("id")long id, @RequestBody T item);
    List<T> updatePriceOfAll(@RequestParam(value = "price") double amountToAdd);
    T updateDescription(@PathVariable("id") long id, @RequestParam(value = "description") String description);
    ResponseEntity deleteItem(@RequestBody T item);
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