package com.beadinventory.beadinventory.ProgramManagers.Managers.FinishedPiecesManagers;

import com.beadinventory.beadinventory.REST.Controller.FinishedPiecesControllers.BookmarkController;
import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Bookmark;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BookmarkManager {

    @Autowired
    private BookmarkController bookmarkController;

    public String printBookmark(Bookmark bookmark){
        return bookmark.toString();
    }

    public String printBookmarkById(long id){
        return bookmarkController.findItemById(id).toString();
    }

    public String printAllBookMarks(){
        StringBuilder builder = new StringBuilder();
        List<Bookmark> bookmarks = bookmarkController.findAllItems();
        bookmarks.stream().forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String printBookMarksQuantity(){
        return "Current bookmark count: " + bookmarkController.findAllItems().size();
    }

    public void createBookmark(){

    }

    public void archiveBookmark(){

    }

}
