package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory;
import com.beadinventory.beadinventory.Service.SuppliesServices.StringingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class StringingMaterialController {

    private StringingMaterialService sMService;

    @Autowired
    public StringingMaterialController(StringingMaterialService sMService){
        this.sMService = sMService;
    }

    @RequestMapping(value = "/stringing_materials",method = GET)
    public ResponseEntity<List<StringingMaterial>> getAllStringingMaterials(){
        return sMService.getAllStringingMaterials();
    }

    @RequestMapping(value = "/stringing_materials/category", method = GET)
    public ResponseEntity<List<StringingMaterial>> getAllOfCategory(@RequestParam(value = "category")StringingMaterialCategory category){
        return sMService.getAllOfCategory(category);
    }

    @RequestMapping(value = "/stringing_materials/material", method = GET)
    public ResponseEntity<List<StringingMaterial>> getAllOfMaterial(@RequestParam(value = "material")Material material){
        return sMService.getAllOfMaterial(material);
    }

    @RequestMapping(value = "/stringing_materials/{id}",method = GET)
    public ResponseEntity<StringingMaterial> getById(@PathVariable("id")long id){
        return sMService.getById(id);
    }

    @RequestMapping(value = "/stringing_materials", method = POST)
    public ResponseEntity<StringingMaterial> createStringingMaterial(@RequestBody StringingMaterial stringingMaterial){
        return sMService.createStringingMaterial(stringingMaterial);
    }

    @RequestMapping(value = "/stringing_materials/{id}",method = PUT)
    public ResponseEntity<StringingMaterial> updateStringingMaterial(@PathVariable("id")long id, @RequestBody StringingMaterial stringingMaterial){
        return sMService.updateStringingMaterial(id,stringingMaterial);
    }

    @RequestMapping(value = "/stringing_materials/{id}", method = DELETE)
    public ResponseEntity deleteStringingMaterialById(@PathVariable("id") long id){
        return sMService.deleteById(id);
    }

}
