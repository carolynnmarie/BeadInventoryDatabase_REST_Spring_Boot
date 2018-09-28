package com.beadinventory.beadinventory.Service.SuppliesServices;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.FindingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<Finding>> getAllOfCategoryAndMaterialAndLength(FindingCategory category, Material material, int length){
        List<Finding> list = findingRepo.findFindingsByCategoryAndMaterialAndLength(category, material, length);
        return new ResponseEntity<>(list,OK);
    }

    public ResponseEntity<List<Finding>> getAllOfCategoryAndLength(FindingCategory category, int length){
        List<Finding> list = findingRepo.findFindingsByCategoryAndLength(category, length);
        return new ResponseEntity<>(list,OK);
    }

    public ResponseEntity<Finding> findById(long id){
        Optional<Finding> find = findingRepo.findById(id);
        Finding finding = find.get();
        return new ResponseEntity<>(finding,OK);
    }

    public ResponseEntity<Finding> createFinding(Finding finding){
        try{
            Finding finding1 = findingRepo.save(finding);
            return new ResponseEntity<>(finding1,CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(BAD_REQUEST);
        }
    }

    public ResponseEntity<Finding> updateFindingQuantity(long findingId, int quantity){
        Optional<Finding> f = findingRepo.findById(findingId);
        Finding finding = f.get();
        finding.setQuantity(quantity);
        finding.setId(findingId);
        return new ResponseEntity<>(finding,OK);
    }

    public ResponseEntity<Finding> updateFinding(Long id, Finding finding){
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
