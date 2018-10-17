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
@RequestMapping(value = "/findings")
public class FindingController {

    private FindingService findingService;

    @Autowired
    public FindingController(FindingService findingService){
        this.findingService = findingService;
    }

    @RequestMapping(value = "", method = GET)
    public List<Finding> findAllFindings(){
        return findingService.getAllFindings().getBody();
    }

    @RequestMapping(value = "/type", method = GET)
    public List<Finding> findAllOfCategoryType(@RequestBody String type){
        return findingService.getAllOfCategoryType(type).getBody();
    }

    @RequestMapping(value = "/findingCategory", method = GET)
    public List<Finding> findAllOfCategory(@RequestAttribute(value = "findingCategory")FindingCategory findingCategory){
        return findingService.getAllOfCategory(findingCategory).getBody();
    }

    @RequestMapping(value = "/material", method = GET)
    public List<Finding> findAllOfMaterial(@RequestAttribute(value = "material")Material material){
        return findingService.getAllOfMaterial(material).getBody();
    }

    @RequestMapping(value = "/findingCategory/material", method = GET)
    public List<Finding> findAllOfCategoryAndMaterial(@RequestAttribute(value = "findingCategory") FindingCategory category,
                                                                      @RequestAttribute(value = "material") Material material){
        return findingService.getAllOfCategoryAndMaterial(category,material).getBody();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Finding getFindingById(@PathVariable("id") long id){
        return findingService.findById(id).getBody();
    }

    @RequestMapping(value = "", method = POST)
    public ResponseEntity<Finding> createFinding(@RequestBody Finding finding){
        return findingService.createFinding(finding);
    }

    @RequestMapping(value = "/{id}/quantity", method = PUT)
    public Long updateQuantity(@PathVariable("id") long id, @RequestAttribute(value = "quantity") long quantity){
        return findingService.updateFindingQuantity(id, quantity).getBody().getQuantity();
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public Finding updateFinding(@PathVariable("id")long id, @RequestBody Finding finding){
        return findingService.updateFinding(id,finding).getBody();
    }

    @RequestMapping(value = "/{id}",method = DELETE)
    public ResponseEntity deleteFindingById(@PathVariable("id") long id){
        return findingService.deleteById(id);
    }

    @RequestMapping(value = "", method = DELETE)
    public ResponseEntity deleteFinding(@RequestBody Finding finding){
        return findingService.deleteFinding(finding);
    }

}
