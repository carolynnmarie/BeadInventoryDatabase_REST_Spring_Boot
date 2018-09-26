package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.beadCharacteristics.Material;
import com.beadinventory.beadinventory.Domain.Supplies.beadCharacteristics.MaterialCategory;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class BeadController {

    private BeadService beadService;

    @Autowired
    BeadController(BeadService beadService){
        this.beadService = beadService;
    }

    @RequestMapping(value = "/beads", method = GET)
    public ResponseEntity<List<Bead>> getAllBeads(){
        return beadService.getAllBeads();
    }

    @RequestMapping(value = "/beads",method = GET)
    public ResponseEntity<List<Bead>> getAllBeadsOrganizeByMaterial(){
        return beadService.getAllOrderByMaterial();
    }

    @RequestMapping(value = "/beads",method = GET)
    public ResponseEntity<List<Bead>> getAllBeadsOrganizeByMaterialCategory(){
        return beadService.getAllOrderByCategory();
    }

    @RequestMapping(value = "/beads/{material}", method = GET)
    public ResponseEntity<List<Bead>> getAllOfMaterial(@PathVariable("material")Material material){
        return beadService.getAllOfMaterial(material);
    }


    @RequestMapping(value = "/beads/{materialCategory}",method = GET)
    public ResponseEntity<List<Bead>> getAllBeadsOfCategory(@PathVariable("materialCategory")MaterialCategory materialCategory){
        return beadService.getAllOfMaterialCategory(materialCategory);
    }

}
