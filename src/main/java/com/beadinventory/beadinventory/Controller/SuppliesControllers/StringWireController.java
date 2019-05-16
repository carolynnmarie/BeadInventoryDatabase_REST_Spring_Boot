package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import com.beadinventory.beadinventory.Service.SuppliesServices.StringWireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stringing_materials")
@CrossOrigin(origins = {"http://localhost:8080","http://localhost:8100"})
public class StringWireController {

    private StringWireService sMService;

    @Autowired
    public StringWireController(StringWireService sMService){
        this.sMService = sMService;
    }

    @GetMapping()
    public List<StringWire> findAllStringWire(){
        return sMService.getAllStringWire().getBody();
    }

    @GetMapping(params = "category")
    public List<StringWire> findAllOfCategory(@RequestAttribute(name = "category") StringWireCategory category){
        return sMService.getAllOfCategory(category).getBody();
    }

    @GetMapping(params = "material")
    public List<StringWire> findAllOfMaterial(@RequestAttribute(name = "material") Material material){
        return sMService.getAllOfMaterial(material).getBody();
    }

    @GetMapping(value = "/{id}")
    public StringWire findById(@PathVariable("id")long id){
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

    @DeleteMapping()
    public ResponseEntity deleteStringWire(@RequestBody StringWire stringWire){
        return sMService.deleteStringWire(stringWire);
    }

}
