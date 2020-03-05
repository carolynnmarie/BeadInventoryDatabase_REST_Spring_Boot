package com.beadinventory.beadinventory;

import com.beadinventory.beadinventory.Controller.FinishedPiecesControllers.*;
import com.beadinventory.beadinventory.Domain.FinishedPieces.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class FinishedPiecesManager {

    @Autowired
    private NecklaceController necklaceController;
    @Autowired
    private BraceletController braceletController;
    @Autowired
    private EarringsController earringsController;
    @Autowired
    private BookmarkController bookmarkController;
    @Autowired
    private NapkinRingSetController napkinRingController;
    @Autowired
    private WineCharmSetController wineCharmController;

    public String printNecklace(Necklace necklace){
        return necklace.toString();
    }

    public String printNecklaceById(long id){
        return necklaceController.findItemById(id).toString();
    }

    public String printAllNecklaces(){
        List<Necklace> necklaces = necklaceController.findAllItems();
        StringBuilder builder = new StringBuilder();
        necklaces.stream().forEach(e-> builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String printNecklacesQuantity(){
        Integer quantity = necklaceController.findAllItems().size();
        return "Current necklace inventory count: " +  quantity;
    }

    public String printBracelet(Bracelet bracelet){
        return bracelet.toString();
    }

    public String printBraceletById(long id){
        return  braceletController.findItemById(id).toString();
    }

    public String printAllBracelets(){
        List<Bracelet> bracelets = braceletController.findAllItems();
        StringBuilder builder = new StringBuilder();
        bracelets.stream().forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String printBraceletsQuantity(){
        Integer quantity = braceletController.findAllItems().size();
        return "Current bracelet inventory count: " + quantity;
    }

    public String printEarringSet(Earrings earrings){
        return earrings.toString();
    }

    public String printEarringSetById(long id){
        return earringsController.findItemById(id).toString();
    }

    public String printAllEarrings(){
        List<Earrings> allEarrings = earringsController.findAllItems();
        StringBuilder builder = new StringBuilder();
        allEarrings.stream().forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String printEarringsQuantity(){
        return "Current earrings inventory count: " + earringsController.findAllItems().size();
    }

    public String printWineCharm(WineCharmSet wineCharm){
        return wineCharm.toString();
    }

    public String printWineCharmById(long id){
        return wineCharmController.findItemById(id).toString();
    }

    public String printAllWineCharms(){
        List<WineCharmSet> allWineCharms = wineCharmController.findAllItems();
        StringBuilder builder = new StringBuilder();
        allWineCharms.stream().forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String printNapkinRingSetQuantity(){
        return "Current wine charm set count: " +  wineCharmController.findAllItems().size();
    }

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


    public String printNapkinRings(NapkinRingSet napkinRings){
        return napkinRings.toString();
    }

    public String printNapkinRingsById(long id){
        return napkinRingController.findItemById(id).toString();
    }

    public String printAllNapkinRings(){
        List<NapkinRingSet> napkinRings = napkinRingController.findAllItems();
        StringBuilder builder = new StringBuilder();
        napkinRings.stream().forEach(e->builder.append(e.toString()).append("\n"));
        return builder.toString();
    }

    public String printNapkinRingsQuantity(){
        return "Current napkin ring set count: " + napkinRingController.findAllItems().size();
    }

    public String printTotalInventory(){
        List<Necklace> necklaces = necklaceController.findAllItems();
        List<Bracelet> bracelets = braceletController.findAllItems();
        List<Earrings> allEarrings = earringsController.findAllItems();
        List<Bookmark> bookmarks = bookmarkController.findAllItems();
        List<WineCharmSet> wineCharms = wineCharmController.findAllItems();
        List<NapkinRingSet> napkinRings = napkinRingController.findAllItems();
        StringBuilder builder = new StringBuilder("Current Inventory: \nNecklaces:\n");
        necklaces.stream().forEach(necklace->builder.append(necklace.toString()).append("\n"));
        builder.append("\nBracelets:\n");
        bracelets.stream().forEach(bracelet->builder.append(bracelet.toString()).append("\n"));
        builder.append("\nEarrings:\n");
        allEarrings.stream().forEach(earrings->builder.append(earrings.toString()).append("\n"));
        builder.append("\nBookmarks:\n");
        bookmarks.stream().forEach(bookmark -> builder.append(bookmark.toString()).append("\n"));
        builder.append("\nNapkin Ring Sets:\n");
        napkinRings.stream().forEach(n->builder.append(n.toString()).append("\n"));
        builder.append("\nWine Charm Sets:\n");
        wineCharms.stream().forEach(w->builder.append(w.toString()).append("\n"));
        return builder.toString();
    }

    public String printAllQuantities(){
        StringBuilder builder = new StringBuilder("Current Inventory Quantities:\nNecklaces:\n");
        builder.append(necklaceController.findAllItems().size())
                .append("\nBracelets: ")
                .append(braceletController.findAllItems().size())
                .append("\nEarrings: ")
                .append(earringsController.findAllItems().size())
                .append("\nBookmarks: ")
                .append(bookmarkController.findAllItems().size())
                .append("\nWine Charm Sets: ")
                .append(wineCharmController.findAllItems().size())
                .append("\nNapkin Ring Sets: ")
                .append(napkinRingController.findAllItems().size());
        return builder.toString();
    }

}