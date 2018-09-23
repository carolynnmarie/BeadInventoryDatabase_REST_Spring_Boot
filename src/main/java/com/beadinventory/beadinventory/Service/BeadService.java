package com.beadinventory.beadinventory.Service;

import com.beadinventory.beadinventory.Domain.Bead;
import com.beadinventory.beadinventory.Domain.beadCharacteristics.Material;
import com.beadinventory.beadinventory.Domain.beadCharacteristics.MaterialCategory;
import com.beadinventory.beadinventory.Domain.beadCharacteristics.Shape;
import com.beadinventory.beadinventory.Repository.BeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class BeadService {

    BeadRepository beadRepository;

    @Autowired
    public BeadService(BeadRepository beadRepository){
        this.beadRepository = beadRepository;
    }

    public ResponseEntity<List<Bead>> getAllBeads(){
        List<Bead> beads = beadRepository.findAll();
        return new ResponseEntity<>(beads,HttpStatus.OK);
    }

    public ResponseEntity<List<Bead>> getAllOrderByCategory(){
        List<Bead> beads = beadRepository.findAll();
        Collections.sort(beads, Comparator.comparing(Bead::getMaterialCategory));
        return new ResponseEntity<>(beads,HttpStatus.OK);
    }

    public ResponseEntity<List<Bead>> getAllOrderByMaterial(){
        List<Bead> beads = beadRepository.findAll();
        Collections.sort(beads, Comparator.comparing(Bead::getMaterial));
        return new ResponseEntity<>(beads,HttpStatus.OK);
    }

    public ResponseEntity<List<Bead>> getAllOfMaterialCategory(MaterialCategory materialCategory){
        List<Bead> beads = beadRepository.findBeadsByBeadCategory(materialCategory);
        Collections.sort(beads, Comparator.comparing(Bead::getMaterial));
        return new ResponseEntity<>(beads,HttpStatus.OK);
    }

    public ResponseEntity<List<Bead>> getAllOfMaterial(Material material){
        List<Bead> beads = beadRepository.findBeadsByMaterial(material);
        return new ResponseEntity<>(beads, HttpStatus.OK);
    }

    public ResponseEntity<List<Bead>> getAllOfMaterialAndColor(Material material, String color){
        List<Bead> beads = beadRepository.findBeadsByMaterialAndColorOrderByMaterial(material,color);
        return new ResponseEntity<>(beads, HttpStatus.OK);
    }

    public ResponseEntity<List<Bead>> getAllOfMaterialAndSize(Material material, int size){
        List<Bead> beads = beadRepository.findBeadsByMaterialAndSize(material, size);
        return new ResponseEntity<>(beads,HttpStatus.OK);
    }

    public ResponseEntity<List<Bead>> getAllOfShape(Shape shape){
        List<Bead> beads = beadRepository.findBeadsByShape(shape);
        return new ResponseEntity<>(beads,HttpStatus.OK);
    }

    public ResponseEntity<List<Bead>> getAllQuantityLessThan(long quantity){
        List<Bead> beads = beadRepository.findBeadsByQuantityIsLessThan(quantity);
        return new ResponseEntity<>(beads, HttpStatus.OK);
    }

    public ResponseEntity<Bead> getBeadById(long id){
        Bead bead = beadRepository.findById(id);
        return new ResponseEntity<>(bead,HttpStatus.OK);
    }

}
