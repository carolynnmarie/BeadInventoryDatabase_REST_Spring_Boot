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
@RequestMapping(value = "/stringing_materials")
public class StringWireController {

    private StringWireService sMService;

    @Autowired
    public StringWireController(StringWireService sMService){
        this.sMService = sMService;
    }

    @RequestMapping(value = "",method = GET)
    public List<StringWire> getAllStringWire(){
        return sMService.getAllStringWire().getBody();
    }

    @RequestMapping(value = "/category", method = GET)
    public List<StringWire> getAllOfCategory(@RequestParam(value = "category")StringWireCategory category){
        return sMService.getAllOfCategory(category).getBody();
    }

    @RequestMapping(value = "/material", method = GET)
    public List<StringWire> getAllOfMaterial(@RequestParam(value = "material")Material material){
        return sMService.getAllOfMaterial(material).getBody();
    }

    @RequestMapping(value = "/{id}",method = GET)
    public StringWire getById(@PathVariable("id")long id){
        return sMService.getById(id).getBody();
    }

    @RequestMapping(value = "", method = POST)
    public StringWire createStringWire(@RequestBody StringWire stringWire){
        return sMService.createStringWire(stringWire).getBody();
    }

    @RequestMapping(value = "/{id}",method = PUT)
    public StringWire updateStringWire(@PathVariable("id")long id,
                                       @RequestBody StringWire stringWire){
        return sMService.updateStringWire(id, stringWire).getBody();
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity deleteStringWireById(@PathVariable("id") long id){
        return sMService.deleteById(id);
    }

}
