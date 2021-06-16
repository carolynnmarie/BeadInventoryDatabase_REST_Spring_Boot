package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import com.beadinventory.beadinventory.Service.SuppliesServices.FindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/findings")
@CrossOrigin(origins = {"http://localhost:8080","http://localhost:8100"})
public class FindingController {

    private FindingService findingService;

    @Autowired
    public FindingController(FindingService findingService){
        this.findingService = findingService;
    }

    @GetMapping()
    public List<Finding> findAllFindings(){
        return findingService.getAllFindings().getBody();
    }

    @GetMapping(params = "findingCategory")
    public List<Finding> findAllOfCategory(@RequestAttribute(value = "findingCategory")FindingCategory findingCategory){
        return findingService.getAllOfCategory(findingCategory).getBody();
    }

    @GetMapping(params = "material")
    public List<Finding> findAllOfMaterial(@RequestAttribute(value = "material")Material material){
        return findingService.getAllOfMaterial(material).getBody();
    }

    @GetMapping(params = {"findingCategory","material"})
    public List<Finding> findAllOfCategoryAndMaterial(@RequestAttribute(value = "findingCategory") FindingCategory category,
                                                                      @RequestAttribute(value = "material") Material material){
        return findingService.getAllOfCategoryAndMaterial(category,material).getBody();
    }

    @GetMapping(value = "/{id}")
    public Finding getFindingById(@PathVariable("id") long id){
        return findingService.getById(id).getBody();
    }

    @PostMapping()
    public ResponseEntity<Finding> createFinding(@RequestBody Finding finding){
        return findingService.createFinding(finding);
    }

    @PutMapping(value = "/{id}/quantity")
    public Long updateQuantity(@PathVariable("id") long id, @RequestAttribute(value = "quantity") long quantity){
        return findingService.updateFindingQuantity(id, quantity).getBody().getQuantity();
    }

    @PutMapping(value = "/{id}")
    public Finding updateFinding(@PathVariable("id")long id, @RequestBody Finding finding){
        return findingService.updateFinding(id,finding).getBody();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteFindingById(@PathVariable("id") long id){
        return findingService.deleteById(id);
    }

    @DeleteMapping()
    public ResponseEntity deleteFinding(@RequestBody Finding finding){
        return findingService.deleteFinding(finding);
    }

}
