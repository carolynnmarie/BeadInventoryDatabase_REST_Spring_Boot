package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Service.SuppliesServices.FindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
public class FindingController {

    private FindingService findingService;

    @Autowired
    public FindingController(FindingService findingService){
        this.findingService = findingService;
    }

    @RequestMapping(value = "/findings", method = GET)
    public ResponseEntity<List<Finding>> findAllFindings(){
        return findingService.getAllFindings();
    }

    @RequestMapping(value = "/findings/findingCategory", method = GET)
    public ResponseEntity<List<Finding>> findAllOfCategory(@RequestParam(value = "findingCategory")FindingCategory findingCategory){
        return findingService.getAllOfCategory(findingCategory);
    }

    @RequestMapping(value = "/findings/material", method = GET)
    public ResponseEntity<List<Finding>> findAllOfMaterial(@RequestParam(value = "material")Material material){
        return findingService.getAllOfMaterial(material);
    }

    @RequestMapping(value = "/findings/category/material", method = GET)
    public ResponseEntity<List<Finding>> findAllOfCategoryAndMaterial(@RequestParam(value = "category") FindingCategory category,
                                                                      @RequestParam(value = "material") Material material){
        return findingService.getAllOfCategoryAndMaterial(category,material);
    }

    @RequestMapping(value = "/findings/type", method = GET)
    public ResponseEntity<List<Finding>> findAllOfCategoryType(@RequestBody String type){
        return findingService.getAllOfCategoryType(type);
    }

    @RequestMapping(value = "/findings/{id}", method = GET)
    public ResponseEntity<Finding> getFindingById(@PathVariable("id") long id){
        return findingService.findById(id);
    }

    @RequestMapping(value = "/findings", method = POST)
    public ResponseEntity<Finding> createFinding(@RequestBody Finding finding){
        return findingService.createFinding(finding);
    }

    @RequestMapping(value = "/findings/{id}", method = PUT)
    public ResponseEntity<Finding> updateFinding(@PathVariable("id")long id, @RequestBody Finding finding){
        return findingService.updateFinding(id,finding);
    }

    @RequestMapping(value = "/findings/{id}",method = DELETE)
    public ResponseEntity deleteFindingById(@PathVariable("id") long id){
        return findingService.deleteById(id);
    }

    @RequestMapping(value = "/findings", method = DELETE)
    public ResponseEntity deleteFinding(@RequestBody Finding finding){
        return findingService.deleteFinding(finding);
    }

}
