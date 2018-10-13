package com.beadinventory.beadinventory.Service.SuppliesServices;

import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.StringWireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import static org.springframework.http.HttpStatus.*;

@Service
public class StringWireService {

    private StringWireRepo strMtrlRepo;

    @Autowired
    public StringWireService(StringWireRepo stringWireRepo){
        this.strMtrlRepo = stringWireRepo;
    }

    public ResponseEntity<List<StringWire>> getAllStringingMaterials(){
        Iterable<StringWire> iList = strMtrlRepo.findAll();
        List<StringWire> list = new ArrayList<>();
        iList.forEach(e->list.add(e));
        return new ResponseEntity<>(list, OK);
    }

    public ResponseEntity<List<StringWire>> getAllOfCategory(StringWireCategory category){
        List<StringWire> iList = strMtrlRepo.findStringingMaterialsByStringWireCategory(category);
        return new ResponseEntity<>(iList, OK);
    }

    public ResponseEntity<List<StringWire>> getAllOfMaterial(Material material){
        List<StringWire> list = strMtrlRepo.findStringingMaterialsByMaterial(material);
        return new ResponseEntity<>(list,OK);
    }

    public ResponseEntity<StringWire> getById(Long sMId){
        Optional<StringWire> oStrMtrl = strMtrlRepo.findById(sMId);
        StringWire stringWire = oStrMtrl.get();
        return new ResponseEntity<>(stringWire,OK);
    }

    public ResponseEntity<StringWire> createStringingMaterial(StringWire stringWire){
        StringWire sM1 = strMtrlRepo.save(stringWire);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(stringWire.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(sM1,responseHeaders,CREATED);
    }

    public ResponseEntity<StringWire> updateStringingMaterial(long id, StringWire stringWire){
        stringWire.setId(id);
        StringWire sM = strMtrlRepo.save(stringWire);
        return new ResponseEntity<>(sM,OK);
    }

    public ResponseEntity deleteById(long id){
        strMtrlRepo.deleteById(id);
        return new ResponseEntity(OK);
    }
}
