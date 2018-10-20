package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Bookmark;
import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.BookmarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import static org.springframework.http.HttpStatus.*;

@Service
public class BookmarkService extends AllFinishedPiecesService<Bookmark> implements AllFinishedPiecesSvsInterface<Bookmark> {


    private BookmarkRepo bookmarkRepo;

    @Autowired
    public BookmarkService(BookmarkRepo bookmarkRepo){
        this.bookmarkRepo = bookmarkRepo;
    }

    @Override
    public ResponseEntity<List<Bookmark>> getAllItems() {
        List<Bookmark> list = bookmarkRepo.findAll();
        return new ResponseEntity<>(list, OK);
    }

    @Override
    public ResponseEntity<Bookmark> getItemById(long id) {
        Bookmark bookmark = bookmarkRepo.findById(id);
        return new ResponseEntity<>(bookmark,OK);
    }

    @Override
    public ResponseEntity<Bookmark> createItem(Bookmark item) {
        item.setBeads(updateBeadRepoCount(item));
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        Bookmark bookmark = bookmarkRepo.save(item);
        return new ResponseEntity<>(bookmark,responseHeaders,CREATED);
    }

    @Override
    public ResponseEntity<Bookmark> updateItem(long id, Bookmark item) {
        item.setId(id);
        Bookmark bookmark = bookmarkRepo.save(item);
        return new ResponseEntity<>(bookmark,OK);
    }

    @Override
    public ResponseEntity<List<Bookmark>> updatePriceOfAll(double amountToAdd) {
        List<Bookmark> bookmarks = bookmarkRepo.findAll();
        for(Bookmark bookmark:bookmarks){
            bookmark.setPrice(bookmark.getPrice()+ amountToAdd);
        }
        Iterable<Bookmark> iBookmark = bookmarks;
        iBookmark = bookmarkRepo.saveAll(iBookmark);
        List<Bookmark> list = new ArrayList<>();
        iBookmark.forEach(e->list.add(e));
        return new ResponseEntity<>(list,OK);
    }

    @Override
    public ResponseEntity<Bookmark> updateDescription(long id, String description) {
        Bookmark bookmark = bookmarkRepo.findById(id);
        bookmark.setDescription(description);
        bookmark = bookmarkRepo.save(bookmark);
        return new ResponseEntity<>(bookmark,OK);
    }

    @Override
    public ResponseEntity deleteItem(Bookmark item) {
        bookmarkRepo.delete(item);
        return new ResponseEntity(OK);
    }


}
