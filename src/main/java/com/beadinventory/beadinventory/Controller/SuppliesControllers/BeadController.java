package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.*;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/beads")
public class BeadController {

    private BeadService beadService;

    @Autowired
    public BeadController(BeadService beadService){
        this.beadService = beadService;
    }

    @GetMapping()
    public List<Bead> findAllBeads(){
        return beadService.getAllBeads().getBody();
    }

    @GetMapping(value = "/getAllOrderByMaterial")
    public List<Bead> findAllOrderByMaterial(){
        return beadService.getAllOrderByMaterial().getBody();
    }

    @GetMapping(params = "material")
    public List<Bead> findAllOfMaterial(@RequestAttribute(value = "material") Material material){
        return beadService.getAllOfMaterial(material).getBody();
    }

    @GetMapping(params = {"material", "color"})
    public List<Bead> findAllOfMaterialAndColor(@RequestAttribute(value = "material") Material material,
                                                @RequestAttribute(value = "color") String color){
        return beadService.getAllOfMaterialAndColor(material,color).getBody();
    }

    @GetMapping(params = {"material","size"})
    public List<Bead> findAllOfMaterialAndSize(@RequestAttribute(value ="material") Material material,
                                               @RequestAttribute(value = "size") int size){
        return beadService.getAllOfMaterialAndSize(material,size).getBody();
    }

    @GetMapping(params = "quantity")
    public List<Bead> findAllWithQuantityLessThan(@RequestAttribute(value = "quantity") long quantity){
        ResponseEntity<List<Bead>> response = beadService.getAllQuantityLessThan(quantity);
        return response.getBody();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Bead findBeadById(@PathVariable("id") long id){
        ResponseEntity<Bead> response = beadService.getBeadById(id);
        return response.getBody();
    }

    @PostMapping()
    public ResponseEntity<Bead> createBead(@RequestBody Bead bead){
        return beadService.createBead(bead);
    }

    @PutMapping(value = "/{id}", params = "quantity")
    public Bead updateBeadQuantity(@PathVariable("id") long id, @RequestAttribute(value = "quantity") long quantity){
        return beadService.updateBeadQuantity(id,quantity).getBody();
    }

    @PutMapping(value = "/{id}")
    public Bead updateBead(@PathVariable("id") long id, @RequestBody Bead bead){
        ResponseEntity<Bead> response = beadService.updateBead(id,bead);
        return response.getBody();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteBeadById(@PathVariable("id") long id){
        return beadService.deleteBeadById(id);
    }

    @DeleteMapping()
    public ResponseEntity deleteBead(@RequestBody Bead bead){
        return beadService.deleteBead(bead);
    }




}
