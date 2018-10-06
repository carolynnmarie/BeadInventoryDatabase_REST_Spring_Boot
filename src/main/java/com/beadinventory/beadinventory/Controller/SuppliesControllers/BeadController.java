package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class BeadController {

    private BeadService beadService;

    @Autowired
    public BeadController(BeadService beadService){
        this.beadService = beadService;
    }


    @RequestMapping(value = "/beads", method = GET)
    public ResponseEntity<List<Bead>> findAllBeads(){
        return beadService.getAllBeads();
    }

    @RequestMapping(value = "/beads/material", method = GET)
    public ResponseEntity<List<Bead>> findAllOfMaterial(@RequestParam(value = "material")Material material){
        return beadService.getAllOfMaterial(material);
    }

    @RequestMapping(value = "/beads/material/color",method = GET)
    public ResponseEntity<List<Bead>> findAllOfMaterialAndColor(@RequestParam(value = "material") Material material, @RequestParam(value = "color") String color){
        return beadService.getAllOfMaterialAndColor(material,color);
    }

    @RequestMapping(value = "/beads/material/size",method = GET)
    public ResponseEntity<List<Bead>> findAllOfMaterialAndSize(@RequestParam(value ="material") Material material,
                                                               @RequestParam(value = "size") int size){
        return beadService.getAllOfMaterialAndSize(material,size);
    }

    @RequestMapping(value = "/beads/quantity", method = RequestMethod.GET)
    public ResponseEntity<List<Bead>> findAllWithQuantityLessThan(@RequestParam(value = "quantity") long quantity){
        return beadService.getAllQuantityLessThan(quantity);
    }

    @RequestMapping(value = "/beads/{id}", method = GET)
    public ResponseEntity<Optional<Bead>> findBeadById(@PathVariable("id") long id){
        return beadService.getBeadById(id);
    }

    @RequestMapping(value = "/beads", method = POST)
    public ResponseEntity<Bead> createBead(@RequestBody Bead bead){
        return beadService.createBead(bead);
    }

    @RequestMapping(value = "/beads/{id}/quantity", method = PUT)
    public ResponseEntity<Bead> updateBeadQuantity(@PathVariable("id") long id, @RequestParam(value = "quantity") long quantity){
        return beadService.updateBeadQuantity(id,quantity);
    }

    @RequestMapping(value = "/beads/{id}", method = PUT)
    public ResponseEntity<Bead> updateBead(@PathVariable("id") long id, @RequestBody Bead bead){
        return beadService.updateBead(id,bead);
    }

    @RequestMapping(value = "/beads/{id}", method = DELETE)
    public ResponseEntity deleteBeadById(@PathVariable("id") long id){
        return beadService.deleteBeadById(id);
    }

    @RequestMapping(value = "/beads",method = DELETE)
    public ResponseEntity deleteBead(@RequestBody Bead bead){
        return beadService.deleteBead(bead);
    }

}
