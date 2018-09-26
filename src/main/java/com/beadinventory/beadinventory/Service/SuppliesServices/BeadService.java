package com.beadinventory.beadinventory.Service.SuppliesServices;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.beadCharacteristics.Material;
import com.beadinventory.beadinventory.Domain.Supplies.beadCharacteristics.MaterialCategory;
import com.beadinventory.beadinventory.Domain.Supplies.beadCharacteristics.Shape;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Service
public class BeadService {

    BeadRepo beadRepository;

    @Autowired
    public BeadService(BeadRepo beadRepository){
        this.beadRepository = beadRepository;
    }

    public ResponseEntity<List<Bead>> getAllBeads(){
        List<Bead> beads = beadRepository.findAll();
        return new ResponseEntity<>(beads,OK);
    }

    public ResponseEntity<List<Bead>> getAllOrderByCategory(){
        List<Bead> beads = beadRepository.findAll();
        return new ResponseEntity<>(beads,OK);
    }

    public ResponseEntity<List<Bead>> getAllOrderByMaterial(){
        List<Bead> beads = beadRepository.findAll();
        Collections.sort(beads, Comparator.comparing(Bead::getMaterial));
        return new ResponseEntity<>(beads,OK);
    }

    public ResponseEntity<List<Bead>> getAllOfMaterialCategory(MaterialCategory materialCategory){
        List<Bead> beads = beadRepository.findBeadsByBeadCategory(materialCategory);
        Collections.sort(beads, Comparator.comparing(Bead::getMaterial));
        return new ResponseEntity<>(beads,OK);
    }

    public ResponseEntity<List<Bead>> getAllOfMaterial(Material material){
        List<Bead> beads = beadRepository.findBeadsByMaterial(material);
        return new ResponseEntity<>(beads, OK);
    }

    public ResponseEntity<List<Bead>> getAllOfMaterialAndColor(Material material, String color){
        List<Bead> beads = beadRepository.findBeadsByMaterialAndColor(material,color);
        return new ResponseEntity<>(beads, OK);
    }

    public ResponseEntity<List<Bead>> getAllOfMaterialAndSize(Material material, int size){
        List<Bead> beads = beadRepository.findBeadsByMaterialAndSize(material, size);
        return new ResponseEntity<>(beads,OK);
    }

    public ResponseEntity<List<Bead>> getAllOfShape(Shape shape){
        List<Bead> beads = beadRepository.findBeadsByShape(shape);
        Collections.sort(beads,Comparator.comparing(Bead::getMaterial));
        return new ResponseEntity<>(beads,OK);
    }

    public ResponseEntity<List<Bead>> getAllQuantityLessThan(long quantity){
        List<Bead> beads = beadRepository.findBeadsByQuantityIsLessThan(quantity);
        Collections.sort(beads,Comparator.comparing(Bead::getMaterial));
        return new ResponseEntity<>(beads, OK);
    }

    public ResponseEntity<Bead> getBeadById(long id){
        Bead bead = beadRepository.findById(id);
        return new ResponseEntity<>(bead,OK);
    }

    public ResponseEntity<Bead> createBead(Bead bead){
        try{
            Bead bead1 = beadRepository.save(bead);
            return new ResponseEntity<>(bead1,CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(new Bead(),BAD_REQUEST);
        }
    }

    public ResponseEntity<Bead> updateBeadQuantity(long beadId, long quantity){
        Bead bead = beadRepository.findById(beadId);
        bead.setQuantity(quantity);
        bead = beadRepository.save(bead);
        return new ResponseEntity<>(bead,OK);
    }

    public ResponseEntity<Bead> updateBead(Long id, Bead bead){
        Optional<Bead> bead1 = beadRepository.findById(id);
        Long bead1Id = bead1.get().getId();
        bead.setId(bead1Id);
        Bead bead2 = beadRepository.save(bead);
        return new ResponseEntity<>(bead2, OK);
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
