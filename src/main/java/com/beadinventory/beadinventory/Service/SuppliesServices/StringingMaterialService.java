package com.beadinventory.beadinventory.Service.SuppliesServices;

import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.StringingMaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<List<StringingMaterial>> getAllMaterials(){
        Iterable<StringingMaterial> iList = strMtrlRepo.findAll();
        List<StringingMaterial> list = new ArrayList<>();
        iList.forEach(e->list.add(e));
        return new ResponseEntity<>(list, OK);
    }

    public ResponseEntity<List<StringingMaterial>> getAllOfCategory(StringingMaterialCategory category){
        Iterable<StringingMaterial> iList = strMtrlRepo.findStringingMaterialsByCategory(category);
        List<StringingMaterial> list = new ArrayList<>();
        iList.forEach(e->list.add(e));
        return new ResponseEntity<>(list, OK);
    }

    public ResponseEntity<StringingMaterial> getById(Long sMId){
        Optional<StringingMaterial> oStrMtrl = strMtrlRepo.findById(sMId);
        StringingMaterial stringingMaterial = oStrMtrl.get();
        return new ResponseEntity<>(stringingMaterial,OK);
    }



}
