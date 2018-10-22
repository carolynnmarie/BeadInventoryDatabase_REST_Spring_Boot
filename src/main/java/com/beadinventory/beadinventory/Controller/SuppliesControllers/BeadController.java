package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class BeadController {

    private BeadService beadService;

    @Autowired
    public BeadController(BeadService beadService){
        this.beadService = beadService;
    }


    @GetMapping(value = "/beads")
    public List<Bead> findAllBeads(){
        return beadService.getAllBeads().getBody();
    }

    @GetMapping(value = "/beads.getAllOrderByMaterial")
    public List<Bead> findAllOrderByMaterial(){
        return beadService.getAllOrderByMaterial().getBody();
    }

    @GetMapping(value = "/beads", params = "material")
    public List<Bead> findAllOfMaterial(@RequestAttribute(value = "material")Material material){
        return beadService.getAllOfMaterial(material).getBody();
    }

    @GetMapping(value = "/beads", params = {"material", "color"})
    public List<Bead> findAllOfMaterialAndColor(@RequestAttribute(value = "material") Material material,
                                                @RequestAttribute(value = "color") String color){
        return beadService.getAllOfMaterialAndColor(material,color).getBody();
    }

    @GetMapping(value = "/beads", params = {"material","size"})
    public List<Bead> findAllOfMaterialAndSize(@RequestAttribute(value ="material") Material material,
                                               @RequestAttribute(value = "size") int size){
        return beadService.getAllOfMaterialAndSize(material,size).getBody();
    }

    @GetMapping(value = "/beads", params = "quantity")
    public List<Bead> findAllWithQuantityLessThan(@RequestAttribute(value = "quantity") long quantity){
        ResponseEntity<List<Bead>> response = beadService.getAllQuantityLessThan(quantity);
        return response.getBody();
    }

    @GetMapping(value = "/beads/{id}")
    public Bead findBeadById(@PathVariable("id") long id){
        ResponseEntity<Bead> response = beadService.getBeadById(id);
        return response.getBody();
    }

    @PostMapping(value = "/beads")
    public ResponseEntity<Bead> createBead(@RequestBody Bead bead){
        return beadService.createBead(bead);
    }

    @PutMapping(value = "/beads/{id}", params = "quantity")
    public Bead updateBeadQuantity(@PathVariable("id") long id, @RequestAttribute(value = "quantity") long quantity){
        return beadService.updateBeadQuantity(id,quantity).getBody();
    }

    @PutMapping(value = "/beads/{id}")
    public Bead updateBead(@PathVariable("id") long id, @RequestBody Bead bead){
        ResponseEntity<Bead> response = beadService.updateBead(id,bead);
        return response.getBody();
    }

    @DeleteMapping(value = "/beads/{id}")
    public ResponseEntity deleteBeadById(@PathVariable("id") long id){
        return beadService.deleteBeadById(id);
    }

    @DeleteMapping(value = "/beads")
    public ResponseEntity deleteBead(@RequestBody Bead bead){
        return beadService.deleteBead(bead);
    }


    public List<Bead> getAllOfMaterialCategory(MaterialCategory category){
        List<Bead> list = findAllBeads()
                .stream()
                .filter(e-> e.getMaterial().getCategory().equals(category))
                .sorted(Comparator.comparing(Bead::getMaterial))
                .collect(Collectors.toList());
        return list;
    }

    public long findBeadQuantity(Bead bead){
        return bead.getQuantity();
    }

}
