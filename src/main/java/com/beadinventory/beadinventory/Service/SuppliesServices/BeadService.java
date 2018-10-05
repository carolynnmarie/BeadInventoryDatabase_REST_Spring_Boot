package com.beadinventory.beadinventory.Service.SuppliesServices;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@Service
public class BeadService {

    private BeadRepo beadRepository;

    @Autowired
    public BeadService(BeadRepo beadRepository){
        this.beadRepository = beadRepository;
    }


    public ResponseEntity<List<Bead>> getAllBeads(){
        List<Bead> beads = (List<Bead>)beadRepository.findAll();
        return new ResponseEntity<>(beads,OK);
    }


    public ResponseEntity<List<Bead>> getAllOfMaterial(Material material){
        List<Bead> beads = beadRepository.findByMaterial(material);
        return new ResponseEntity<>(beads, OK);
    }

    public ResponseEntity<List<Bead>> getAllOfMaterialAndColor(Material material, String color){
        List<Bead> beads = beadRepository.findByMaterialAndColor(material,color);
        return new ResponseEntity<>(beads, OK);
    }

    public ResponseEntity<List<Bead>> getAllOfMaterialAndSize(Material material, int size){
        List<Bead> beads = beadRepository.findByMaterialAndSize(material, size);
        return new ResponseEntity<>(beads,OK);
    }

    public ResponseEntity<List<Bead>> getAllOfShape(Shape shape){
        List<Bead> beads = beadRepository.findByShape(shape);
        return new ResponseEntity<>(beads,OK);
    }

    public ResponseEntity<List<Bead>> getAllQuantityLessThan(long quantity){
        List<Bead> beads = beadRepository.findByQuantityIsLessThan(quantity);
        return new ResponseEntity<>(beads, OK);
    }


    public ResponseEntity<Optional<Bead>> getBeadById(long id){
        try {
            Optional<Bead> bead = beadRepository.findById(id);
            return new ResponseEntity<>(bead, OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(Optional.of(new Bead()), NOT_FOUND);
        }
    }

    public ResponseEntity<Bead> createBead(Bead bead){
        Bead bead1 = beadRepository.save(bead);
        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bead.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newAccountUri);
        return new ResponseEntity<>(bead1, responseHeaders, CREATED);
    }

    public ResponseEntity<Bead> updateBeadQuantity(long beadId, long quantity){
        Optional<Bead> oBead = beadRepository.findById(beadId);
        Bead bead = oBead.get();
        bead.setQuantity(quantity);
        bead = beadRepository.save(bead);
        return new ResponseEntity<>(bead, OK);
    }

    public ResponseEntity<Bead> updateBead(Long id, Bead bead){
        bead.setId(id);
        Bead bead1 = beadRepository.save(bead);
        return new ResponseEntity<>(bead1,OK);
    }

    public ResponseEntity deleteBeadById(Long beadId){
        beadRepository.deleteById(beadId);
        return new ResponseEntity(OK);
    }

    public ResponseEntity deleteBead(Bead bead){
        beadRepository.delete(bead);
        return new ResponseEntity(OK);
    }


}
