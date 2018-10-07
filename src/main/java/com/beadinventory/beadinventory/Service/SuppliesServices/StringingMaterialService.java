package com.beadinventory.beadinventory.Service.SuppliesServices;

import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.StringingMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Service
public class StringingMaterialService {

    private StringingMaterialRepo strMtrlRepo;

    @Autowired
    public StringingMaterialService(StringingMaterialRepo stringingMaterialRepo){
        this.strMtrlRepo = stringingMaterialRepo;
    }

    public ResponseEntity<List<StringingMaterial>> getAllStringingMaterials(){
        Iterable<StringingMaterial> iList = strMtrlRepo.findAll();
        List<StringingMaterial> list = new ArrayList<>();
        iList.forEach(e->list.add(e));
        return new ResponseEntity<>(list, OK);
    }

    public ResponseEntity<List<StringingMaterial>> getAllOfCategory(StringingMaterialCategory category){
        List<StringingMaterial> iList = strMtrlRepo.findStringingMaterialsBySMCategory(category);
        return new ResponseEntity<>(iList, OK);
    }

    public ResponseEntity<List<StringingMaterial>> getAllOfMaterial(Material material){
        List<StringingMaterial> list = strMtrlRepo.findStringingMaterialsByMaterial(material);
        return new ResponseEntity<>(list,OK);
    }

    public ResponseEntity<StringingMaterial> getById(Long sMId){
        Optional<StringingMaterial> oStrMtrl = strMtrlRepo.findById(sMId);
        StringingMaterial stringingMaterial = oStrMtrl.get();
        return new ResponseEntity<>(stringingMaterial,OK);
    }

    public ResponseEntity<StringingMaterial> createStringingMaterial(StringingMaterial stringingMaterial){
        StringingMaterial sM1 = strMtrlRepo.save(stringingMaterial);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(stringingMaterial.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(sM1,responseHeaders,CREATED);
    }

    public ResponseEntity<StringingMaterial> updateStringingMaterial(long id, StringingMaterial stringingMaterial){
        stringingMaterial.setId(id);
        StringingMaterial sM = strMtrlRepo.save(stringingMaterial);
        return new ResponseEntity<>(sM,OK);
    }

    public ResponseEntity deleteById(long id){
        strMtrlRepo.deleteById(id);
        return new ResponseEntity(OK);
    }

    public ResponseEntity deleteStringingMaterial(StringingMaterial stringingMaterial){
        strMtrlRepo.delete(stringingMaterial);
        return new ResponseEntity(OK);
    }
}
