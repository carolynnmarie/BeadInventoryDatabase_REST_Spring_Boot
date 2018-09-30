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

import static org.springframework.http.HttpStatus.*;

@Service
public class BeadService {

    private BeadRepo beadRepository;

    @Autowired
    public BeadService(BeadRepo beadRepository){
        this.beadRepository = beadRepository;
    }


    public ResponseEntity<Iterable<Bead>> getAllBeads(){
        Iterable<Bead> beads = beadRepository.findAll();
        return new ResponseEntity<>(beads,OK);
    }

//    public ResponseEntity<Iterable<Bead>> getAllOfMaterialCategory(MaterialCategory materialCategory){
//       Iterable<Bead> beads = beadRepository.findBeadsByMaterial_Category(materialCategory);
//        return new ResponseEntity<>(beads,OK);
//    }

    public ResponseEntity<Iterable<Bead>> getAllOfMaterial(Material material){
        Iterable<Bead> beads = beadRepository.findBeadsByMaterial(material);
        return new ResponseEntity<>(beads, OK);
    }

    public ResponseEntity<Iterable<Bead>> getAllOfMaterialAndColor(Material material, String color){
        Iterable<Bead> beads = beadRepository.findBeadsByMaterialAndColor(material,color);
        return new ResponseEntity<>(beads, OK);
    }

    public ResponseEntity<Iterable<Bead>> getAllOfMaterialAndSize(Material material, int size){
        Iterable<Bead> beads = beadRepository.findBeadsByMaterialAndSize(material, size);
        return new ResponseEntity<>(beads,OK);
    }

    public ResponseEntity<Iterable<Bead>> getAllOfShape(Shape shape){
        Iterable<Bead> beads = beadRepository.findBeadsByShape(shape);
        return new ResponseEntity<>(beads,OK);
    }

    public ResponseEntity<Iterable<Bead>> getAllQuantityLessThan(long quantity){
        Iterable<Bead> beads = beadRepository.findByQuantityIsLessThan(quantity);
        return new ResponseEntity<>(beads, OK);
    }

    public ResponseEntity<Bead> getBeadById(long id){
        Bead bead = beadRepository.findById(id).get();
        return new ResponseEntity<>(bead,OK);
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

    public ResponseEntity<Bead> updateBeadQuantity(Bead bead, long quantity){
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
