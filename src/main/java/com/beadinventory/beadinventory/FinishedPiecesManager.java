package com.beadinventory.beadinventory;

import com.beadinventory.beadinventory.Controller.FinishedPiecesControllers.*;
import com.beadinventory.beadinventory.Domain.FinishedPieces.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.*;

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
        for(Necklace necklace: necklaces){
            builder.append(necklace.toString())
                    .append("\n");
        }
        return builder.toString();
    }

    public String printNecklaceQuantity(){
        Integer quantity = necklaceController.getTotalItemCount();
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
        for (Bracelet bracelet: bracelets) {
            builder.append(bracelet.toString())
                    .append("\n");
        }
        return builder.toString();
    }

    public String printBraceletQuantity(){
        Integer quantity = braceletController.getTotalItemCount();
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
        for(Earrings earrings: allEarrings){
            builder.append(earrings.toString())
                    .append("\n");
        }
        return builder.toString();
    }

    public String printEarringsQuantity(){
        Integer quantity = earringsController.getTotalItemCount();
        return "Current earrings inventory count: " + quantity;
    }

    public String printTotalInventory(){
        List<Necklace> necklaces = necklaceController.findAllItems();
        List<Bracelet> bracelets = braceletController.findAllItems();
        List<Earrings> allEarrings = earringsController.findAllItems();
        List<Bookmark> bookmarks = bookmarkController.findAllItems();
        List<WineCharmSet> wineCharms = wineCharmController.findAllItems();
        List<NapkinRingSet> napkinRings = napkinRingController.findAllItems();
        StringBuilder builder = new StringBuilder();
        builder.append("Necklaces:\n");
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
        Integer necklaces = necklaceController.getTotalItemCount();
        Integer bracelets = braceletController.getTotalItemCount();
        Integer earrings = earringsController.getTotalItemCount();
        Integer bookmarks = bookmarkController.getTotalItemCount();
        Integer wineCharms = wineCharmController.getTotalItemCount();
        Integer napkinRings = napkinRingController.getTotalItemCount();
        StringBuilder builder = new StringBuilder();
        builder.append("Necklaces: ")
                .append(necklaces)
                .append("\nBracelets: ")
                .append(bracelets)
                .append("\nEarrings: ")
                .append(earrings)
                .append("\nBookmarks: ")
                .append(bookmarks)
                .append("\nWine Charm Sets: ")
                .append(wineCharms)
                .append("\nNapkin Ring Sets: ")
                .append(napkinRings);
        return builder.toString();
    }

}