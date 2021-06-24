package com.beadinventory.beadinventory.REST.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Bookmark;
import com.beadinventory.beadinventory.REST.Repository.FinishedPiecesRepos.BookmarkRepo;
import com.beadinventory.beadinventory.REST.Repository.SuppliesRepos.BeadRepo;
import com.beadinventory.beadinventory.REST.Repository.SuppliesRepos.FindingRepo;
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
    public BookmarkService(BookmarkRepo bookmarkRepo, BeadRepo beadRepo, FindingRepo findingRepo){
        this.bookmarkRepo = bookmarkRepo;
        this.beadRepo = beadRepo;
        this.findingRepo = findingRepo;
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
        item.setFindings(updateFindingRepoCount(item));
        Bookmark bookmark = bookmarkRepo.save(item);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getAllId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(bookmark,responseHeaders,CREATED);
    }

    @Override
    public ResponseEntity<Bookmark> updateItem(long id, Bookmark item) {
        item.setBeads(updateBeadRepoCount(item));
        item.setFindings(updateFindingRepoCount(item));
        item.setAllId(id);
        Bookmark bookmark = bookmarkRepo.save(item);
        return new ResponseEntity<>(bookmark,OK);
    }

    @Override
    public ResponseEntity<List<Bookmark>> increasePriceOfAll(double amountToAdd) {
        Iterable<Bookmark> bookmarks = bookmarkRepo.findAll();
        bookmarks.forEach(bookmark -> bookmark.setPrice(bookmark.getPrice()+ amountToAdd));
        bookmarkRepo.saveAll(bookmarks);
        List<Bookmark> list = new ArrayList<>();
        bookmarks.forEach(e->list.add(e));
        return new ResponseEntity<>(list,OK);
    }

    @Override
    public ResponseEntity<Bookmark> updateDescription(long id, String description) {
        Bookmark bookmark = bookmarkRepo.findById(id);
        bookmark.setDescription(description);
        bookmarkRepo.save(bookmark);
        return new ResponseEntity<>(bookmark ,OK);
    }

    @Override
    public ResponseEntity deleteItem(Bookmark item) {
        bookmarkRepo.delete(item);
        return new ResponseEntity(OK);
    }


}
