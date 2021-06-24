package com.beadinventory.beadinventory.ProgramManagers.Managers.FinishedPiecesManagers;

import com.beadinventory.beadinventory.REST.Controller.FinishedPiecesControllers.*;
import org.springframework.beans.factory.annotation.Autowired;

public class FinishedPiecesPrinter {

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


    public String printTotalInventory(){
        StringBuilder builder = new StringBuilder("Current Inventory: \nNecklaces:\n");
        necklaceController.findAllItems().stream().forEach(necklace->builder.append(necklace.toString()).append("\n"));
        builder.append("\nBracelets:\n");
        braceletController.findAllItems().stream().forEach(bracelet->builder.append(bracelet.toString()).append("\n"));
        builder.append("\nEarrings:\n");
        earringsController.findAllItems().stream().forEach(earrings->builder.append(earrings.toString()).append("\n"));
        builder.append("\nBookmarks:\n");
        bookmarkController.findAllItems().stream().forEach(bookmark -> builder.append(bookmark.toString()).append("\n"));
        builder.append("\nNapkin Ring Sets:\n");
        napkinRingController.findAllItems().stream().forEach(n->builder.append(n.toString()).append("\n"));
        builder.append("\nWine Charm Sets:\n");
        wineCharmController.findAllItems().stream().forEach(w->builder.append(w.toString()).append("\n"));
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