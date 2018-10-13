package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import com.beadinventory.beadinventory.Service.SuppliesServices.StringWireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class StringingMaterialController {

    private StringWireService sMService;

    @Autowired
    public StringingMaterialController(StringWireService sMService){
        this.sMService = sMService;
    }

    @RequestMapping(value = "/stringing_materials",method = GET)
    public List<StringWire> getAllStringingMaterials(){
        return sMService.getAllStringingMaterials().getBody();
    }

    @RequestMapping(value = "/stringing_materials/category", method = GET)
    public List<StringWire> getAllOfCategory(@RequestParam(value = "category")StringWireCategory category){
        return sMService.getAllOfCategory(category).getBody();
    }

    @RequestMapping(value = "/stringing_materials/material", method = GET)
    public List<StringWire> getAllOfMaterial(@RequestParam(value = "material")Material material){
        return sMService.getAllOfMaterial(material).getBody();
    }

    @RequestMapping(value = "/stringing_materials/{id}",method = GET)
    public StringWire getById(@PathVariable("id")long id){
        return sMService.getById(id).getBody();
    }

    @RequestMapping(value = "/stringing_materials", method = POST)
    public StringWire createStringingMaterial(@RequestBody StringWire stringWire){
        return sMService.createStringingMaterial(stringWire).getBody();
    }

    @RequestMapping(value = "/stringing_materials/{id}",method = PUT)
    public StringWire updateStringingMaterial(@PathVariable("id")long id,
                                                              @RequestBody StringWire stringWire){
        return sMService.updateStringingMaterial(id, stringWire).getBody();
    }

    @RequestMapping(value = "/stringing_materials/{id}", method = DELETE)
    public ResponseEntity deleteStringingMaterialById(@PathVariable("id") long id){
        return sMService.deleteById(id);
    }

}
