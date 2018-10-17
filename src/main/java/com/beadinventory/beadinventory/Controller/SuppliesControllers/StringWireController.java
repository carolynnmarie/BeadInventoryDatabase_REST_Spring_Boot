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
@RequestMapping(value = "")
public class StringWireController {

    private StringWireService sMService;

    @Autowired
    public StringWireController(StringWireService sMService){
        this.sMService = sMService;
    }

    @RequestMapping(value = "/stringing_materials",method = GET)
    public List<StringWire> getAllStringWire(){
        return sMService.getAllStringWire().getBody();
    }

    @RequestMapping(value = "/stringing_materials/category", method = GET)
    public List<StringWire> getAllOfCategory(@RequestAttribute(name = "category") StringWireCategory category){
        return sMService.getAllOfCategory(category).getBody();
    }

    @RequestMapping(value = "/stringing_materials/material", method = GET)
    public List<StringWire> getAllOfMaterial(@RequestAttribute(name = "material") Material material){
        return sMService.getAllOfMaterial(material).getBody();
    }

    @RequestMapping(value = "/stringing_materials/{id}",method = GET)
    public StringWire getById(@PathVariable("id")long id){
        return sMService.getById(id).getBody();
    }

    @RequestMapping(value = "/stringing_materials", method = POST)
    public ResponseEntity<StringWire> createStringWire(@RequestBody StringWire stringWire){
        return sMService.createStringWire(stringWire);
    }

    @RequestMapping(value = "/stringing_materials/{id}",method = PUT)
    public StringWire updateStringWire(@PathVariable("id")long id,
                                       @RequestBody StringWire stringWire){
        return sMService.updateStringWire(id, stringWire).getBody();
    }

    @RequestMapping(value = "/stringing_materials/{id}", method = DELETE)
    public ResponseEntity deleteStringWireById(@PathVariable("id") long id){
        return sMService.deleteById(id);
    }

}
