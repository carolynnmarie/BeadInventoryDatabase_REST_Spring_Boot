package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import com.beadinventory.beadinventory.Service.SuppliesServices.FindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
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
    public List<Finding> findAllFindings(){
        return findingService.getAllFindings().getBody();
    }

    @RequestMapping(value = "/findings/type", method = GET)
    public List<Finding> findAllOfCategoryType(@RequestBody String type){
        return findingService.getAllOfCategoryType(type).getBody();
    }

    @RequestMapping(value = "/findings/findingCategory", method = GET)
    public List<Finding> findAllOfCategory(@RequestParam(value = "findingCategory")FindingCategory findingCategory){
        return findingService.getAllOfCategory(findingCategory).getBody();
    }

    @RequestMapping(value = "/findings/material", method = GET)
    public List<Finding> findAllOfMaterial(@RequestParam(value = "material")Material material){
        return findingService.getAllOfMaterial(material).getBody();
    }

    @RequestMapping(value = "/findings/category/material", method = GET)
    public List<Finding> findAllOfCategoryAndMaterial(@RequestParam(value = "category") FindingCategory category,
                                                                      @RequestParam(value = "material") Material material){
        return findingService.getAllOfCategoryAndMaterial(category,material).getBody();
    }

    @RequestMapping(value = "/findings/{id}", method = GET)
    public Finding getFindingById(@PathVariable("id") long id){
        return findingService.findById(id).getBody();
    }

    @RequestMapping(value = "/findings", method = POST)
    public ResponseEntity<Finding> createFinding(@RequestBody Finding finding){

        return findingService.createFinding(finding);
    }

    @RequestMapping(value = "/findings/{id}/quantity", method = PUT)
    public Long updateQuantity(@PathVariable("id") long id, @RequestParam(value = "quantity") long quantity){
        return findingService.updateFindingQuantity(id, quantity).getBody().getQuantity();
    }

    @RequestMapping(value = "/findings/{id}", method = PUT)
    public Finding updateFinding(@PathVariable("id")long id, @RequestBody Finding finding){
        return findingService.updateFinding(id,finding).getBody();
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
