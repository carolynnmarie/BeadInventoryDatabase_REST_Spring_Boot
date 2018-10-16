package com.beadinventory.beadinventory.Controller.FinishedPiecesControllers;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Bookmark;
import com.beadinventory.beadinventory.Service.FinishedPiecesServices.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class BookmarkController implements AllFinishedPiecesContInterface<Bookmark> {

    private BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(BookmarkService bookmarkService){
        this.bookmarkService = bookmarkService;
    }

    @Override
    @RequestMapping(value = "/bookmarks", method = GET)
    public List<Bookmark> findAllItems() {
        return null;
    }

    @Override
    @RequestMapping(value = "/bookmarks.count",method = GET)
    public Long getTotalItemCount() {
        return null;
    }

    @Override
    @RequestMapping(value = "/bookmarks/{id}", method = GET)
    public Bookmark findItemById(@PathVariable("id") long id) {
        return null;
    }

    @Override
    @RequestMapping(value = "/bookmarks", method = POST)
    public Bookmark createItem(@RequestBody Bookmark item) {
        return null;
    }

    @Override
    @RequestMapping(value = "/bookmarks/{id}", method = PUT)
    public Bookmark updateItem(@PathVariable("id") long id, Bookmark item) {
        return null;
    }

    @Override
    @RequestMapping(value = "/bookmarks/price", method = PUT)
    public List<Bookmark> updatePriceOfAll(@RequestParam(value = "price") double price) {
        return null;
    }

    @Override
    @RequestMapping(value = "/bookmarks/{id}/description", method = PUT)
    public Bookmark updateDescription(@PathVariable("id") long id, @RequestParam(value = "description") String description) {
        return null;
    }

    @Override
    @RequestMapping(value = "/bookmarks", method = DELETE)
    public ResponseEntity deleteItem(@RequestBody Bookmark item) {
        return null;
    }
}
