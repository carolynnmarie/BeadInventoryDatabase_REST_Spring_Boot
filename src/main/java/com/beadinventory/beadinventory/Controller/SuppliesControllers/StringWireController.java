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

    @GetMapping()
    public List<StringWire> getAllStringWire(){
        return sMService.getAllStringWire().getBody();
    }

    @GetMapping(params = "category")
    public List<StringWire> getAllOfCategory(@RequestAttribute(name = "category") StringWireCategory category){
        return sMService.getAllOfCategory(category).getBody();
    }

    @GetMapping(params = "material")
    public List<StringWire> getAllOfMaterial(@RequestAttribute(name = "material") Material material){
        return sMService.getAllOfMaterial(material).getBody();
    }

    @GetMapping(value = "/{id}")
    public StringWire getById(@PathVariable("id")long id){
        return sMService.getById(id).getBody();
    }

    @PostMapping()
    public ResponseEntity<StringWire> createStringWire(@RequestBody StringWire stringWire){
        return sMService.createStringWire(stringWire);
    }

    @PutMapping(value = "/{id}")
    public StringWire updateStringWire(@PathVariable("id")long id,
                                       @RequestBody StringWire stringWire){
        return sMService.updateStringWire(id, stringWire).getBody();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteStringWireById(@PathVariable("id") long id){
        return sMService.deleteById(id);
    }

}
