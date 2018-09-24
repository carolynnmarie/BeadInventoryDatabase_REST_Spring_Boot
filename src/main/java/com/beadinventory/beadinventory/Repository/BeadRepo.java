package com.beadinventory.beadinventory.Repository;

import com.beadinventory.beadinventory.Domain.Bead;
import com.beadinventory.beadinventory.Domain.beadCharacteristics.MaterialCategory;
import com.beadinventory.beadinventory.Domain.beadCharacteristics.Material;
import com.beadinventory.beadinventory.Domain.beadCharacteristics.Shape;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeadRepo extends CrudRepository<Bead,Long> {
    List<Bead> findBeadsByBeadCategory(MaterialCategory beadCategory);
    List<Bead> findBeadsByMaterial(Material material);
    List<Bead> findBeadsByMaterialAndColor(Material material, String color);
    List<Bead> findBeadsByMaterialAndSize(Material material, int size);
    List<Bead> findBeadsByShape(Shape shape);
    List<Bead> findBeadsByQuantityIsLessThan(long quantity);
    List<Bead> findAll();
    Bead findById(long id);

}
