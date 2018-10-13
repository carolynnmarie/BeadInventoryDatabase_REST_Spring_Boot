package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Bookmark;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.BookmarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService extends AllFinishedPiecesService<Bookmark> implements AllFinishedPiecesSvsInterface<Bookmark> {

    private BookmarkRepo bookmarkRepo;

    @Autowired
    public BookmarkService(BookmarkRepo bookmarkRepo){
        this.bookmarkRepo = bookmarkRepo;
    }

    @Override
    public ResponseEntity<List<Bookmark>> getAllItems() {
        return null;
    }

    @Override
    public ResponseEntity<Long> getTotalCount() {
        return null;
    }

    @Override
    public ResponseEntity<Bookmark> getItemById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<Bookmark> createItem(Bookmark item) {
        return null;
    }

    @Override
    public ResponseEntity<Bookmark> updateItem(long id, Bookmark item) {
        return null;
    }

    @Override
    public ResponseEntity<List<Bookmark>> updatePriceOfAll(double amountToAdd) {
        return null;
    }

    @Override
    public ResponseEntity<Bookmark> updateDescription(long id, String description) {
        return null;
    }

    @Override
    public ResponseEntity deleteItem(Bookmark item) {
        return null;
    }
}
