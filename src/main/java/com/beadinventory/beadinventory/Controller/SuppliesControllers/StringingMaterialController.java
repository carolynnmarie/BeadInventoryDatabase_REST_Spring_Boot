package com.beadinventory.beadinventory.Controller.SuppliesControllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringingMaterialController {
}
/*
ResponseEntity<List<StringingMaterial>> getAllStringingMaterials()
ResponseEntity<List<StringingMaterial>> getAllOfCategory(StringingMaterialCategory category)
ResponseEntity<List<StringingMaterial>> getAllOfMaterial(Material material)
ResponseEntity<StringingMaterial> getById(Long sMId)
ResponseEntity<StringingMaterial> createStringingMaterial(StringingMaterial stringingMaterial)
ResponseEntity<StringingMaterial> updateStringingMaterial(long id, StringingMaterial stringingMaterial)
ResponseEntity deleteById(long id)
 */