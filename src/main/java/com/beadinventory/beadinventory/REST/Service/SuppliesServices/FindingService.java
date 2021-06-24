package com.beadinventory.beadinventory.REST.Service.SuppliesServices;

import com.beadinventory.beadinventory.REST.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.*;
import com.beadinventory.beadinventory.REST.Repository.SuppliesRepos.FindingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import static org.springframework.http.HttpStatus.*;

@Service
public class FindingService {

    private FindingRepo findingRepo;

    @Autowired
    public FindingService(FindingRepo findingRepo){
        this.findingRepo = findingRepo;
    }

    public ResponseEntity<List<Finding>> getAllFindings(){
        List<Finding> list = findingRepo.findAll();
        return new ResponseEntity<>(list, OK);
    }

    public ResponseEntity<List<Finding>> getAllOfCategory(FindingCategory findingCategory){
        List<Finding> list = findingRepo.findFindingsByCategory(findingCategory);
        return new ResponseEntity<>(list,OK);
    }

    public ResponseEntity<List<Finding>> getAllOfMaterial(Material material){
        List<Finding> list = findingRepo.findFindingsByMaterial(material);
        return new ResponseEntity<>(list,OK);
    }

    public ResponseEntity<List<Finding>> getAllOfCategoryAndMaterial(FindingCategory category, Material material){
        List<Finding> list = findingRepo.findFindingsByCategoryAndMaterial(category,material);
        return new ResponseEntity<>(list,OK);
    }

    public ResponseEntity<Finding> getById(long id){
        Finding finding = findingRepo.findById(id);
        return new ResponseEntity<>(finding,OK);
    }


    public ResponseEntity<Finding> createFinding(Finding finding){
        finding = findingRepo.save(finding);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(finding.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(finding,responseHeaders,HttpStatus.CREATED);
    }

    public ResponseEntity<Long> getFindingQuantity(long id){
        Finding finding = findingRepo.findById(id);
        return new ResponseEntity<>(finding.getQuantity(), OK);
    }

    public ResponseEntity<Finding> updateFindingQuantity(long findingId, long quantity){
        Finding finding = findingRepo.findById(findingId);
        finding.setQuantity(quantity);
        finding.setId(findingId);
        Finding finding1 = findingRepo.save(finding);
        return new ResponseEntity<>(finding1,OK);
    }

    public ResponseEntity<Finding> removeFindingQuantity(long findingId, long quantityToRemove){
        Finding finding = findingRepo.findById(findingId);
        long lowerQuantity = finding.getQuantity()-quantityToRemove;
        finding.setQuantity(lowerQuantity);
        Finding finding1 = findingRepo.save(finding);
        return new ResponseEntity<>(finding1,OK);
    }


    public ResponseEntity<Finding> updateFinding(long id, Finding finding){
        finding.setId(id);
        findingRepo.save(finding);
        return new ResponseEntity<>(finding,OK);
    }

    public ResponseEntity deleteFinding(Finding finding){
        findingRepo.delete(finding);
        return new ResponseEntity(OK);
    }

    public ResponseEntity deleteById(long id){
        findingRepo.deleteById(id);
        return new ResponseEntity(OK);
    }

}
