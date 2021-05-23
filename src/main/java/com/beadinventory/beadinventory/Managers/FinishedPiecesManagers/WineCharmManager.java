package com.beadinventory.beadinventory.Managers.FinishedPiecesManagers;

import com.beadinventory.beadinventory.Controller.FinishedPiecesControllers.WineCharmSetController;
import com.beadinventory.beadinventory.Domain.FinishedPieces.WineCharmSet;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

public class WineCharmManager {

    @Autowired
    private WineCharmSetController wineCharmController;


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

    public String printWineCharmSetQuantity(){
        return "Current wine charm set count: " +  wineCharmController.findAllItems().size();
    }

    public void createWineCharms(){

    }

    public void archiveWineCharms(){

    }

}
