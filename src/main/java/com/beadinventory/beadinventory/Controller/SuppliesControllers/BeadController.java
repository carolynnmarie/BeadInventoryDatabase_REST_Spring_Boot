package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class BeadController {

    private BeadService beadService;

    @Autowired
    public BeadController(BeadService beadService){
        this.beadService = beadService;
    }

    @RequestMapping(value = "/beads", method = GET)
    public ResponseEntity<List<Bead>> getAllBeads(){
        return beadService.getAllBeads();
    }

    @RequestMapping(value = "/beads/{material_category}", method = GET)
    public ResponseEntity<List<Bead>> getAllOfCategory(@PathVariable("material_category") MaterialCategory material_category){
        return beadService.getAllOfCategory(material_category);
    }

    @RequestMapping(value = "/beads/{material}", method = GET)
    public ResponseEntity<List<Bead>> getAllOfMaterial(@PathVariable("material")Material material){
        return beadService.getAllOfMaterial(material);
    }



    @RequestMapping(value = "/beads", method = POST)
    public ResponseEntity<Bead> createBead(@RequestBody Bead bead){
        return beadService.createBead(bead);
    }

}
