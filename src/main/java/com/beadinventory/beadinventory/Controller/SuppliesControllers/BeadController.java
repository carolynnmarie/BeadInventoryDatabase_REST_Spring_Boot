package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class BeadController {

    private BeadService beadService;

    @Autowired
    public BeadController(BeadService beadService){
        this.beadService = beadService;
    }


    @RequestMapping(value = "/beads", method = GET)
    public List<Bead> findAllBeads(){
        return beadService.getAllBeads().getBody();
    }

    @RequestMapping(value = "/beads.getAllOrderByMaterial", method = GET)
    public List<Bead> findAllOrderByMaterial(){
        return beadService.getAllOrderByMaterial().getBody();
    }

    @RequestMapping(value = "/beads/material", method = GET)
    public List<Bead> findAllOfMaterial(@RequestParam(value = "material")Material material){
        return beadService.getAllOfMaterial(material).getBody();
    }

    @RequestMapping(value = "/beads/material/color",method = GET)
    public List<Bead> findAllOfMaterialAndColor(@RequestParam(value = "material") Material material,
                                                @RequestParam(value = "color") String color){
        return beadService.getAllOfMaterialAndColor(material,color).getBody();
    }

    @RequestMapping(value = "/beads/material/size",method = GET)
    public List<Bead> findAllOfMaterialAndSize(@RequestParam(value ="material") Material material,
                                               @RequestParam(value = "size") int size){
        return beadService.getAllOfMaterialAndSize(material,size).getBody();
    }

    @RequestMapping(value = "/beads/quantity", method = RequestMethod.GET)
    public List<Bead> findAllWithQuantityLessThan(@RequestParam(value = "quantity") long quantity){
        ResponseEntity<List<Bead>> response = beadService.getAllQuantityLessThan(quantity);
        return response.getBody();
    }

    @RequestMapping(value = "/beads/{id}", method = GET)
    public Bead findBeadById(@PathVariable("id") long id){
        ResponseEntity<Bead> response = beadService.getBeadById(id);
        return response.getBody();
    }

    @RequestMapping(value = "/beads", method = POST)
    public ResponseEntity<Bead> createBead(@RequestBody Bead bead){
        return beadService.createBead(bead);
    }

    @RequestMapping(value = "/beads/{id}/quantity", method = PUT)
    public Long updateBeadQuantity(@PathVariable("id") long id, @RequestParam(value = "quantity") long quantity){
        return beadService.updateBeadQuantity(id,quantity).getBody().getQuantity();
    }

    @RequestMapping(value = "/beads/{id}", method = PUT)
    public Bead updateBead(@PathVariable("id") long id, @RequestBody Bead bead){
        ResponseEntity<Bead> response = beadService.updateBead(id,bead);
        return response.getBody();
    }

    @RequestMapping(value = "/beads/{id}", method = DELETE)
    public ResponseEntity deleteBeadById(@PathVariable("id") long id){
        return beadService.deleteBeadById(id);
    }

    @RequestMapping(value = "/beads",method = DELETE)
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
