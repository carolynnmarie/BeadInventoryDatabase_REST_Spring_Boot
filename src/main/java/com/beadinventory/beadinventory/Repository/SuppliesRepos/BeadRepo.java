package com.beadinventory.beadinventory.Repository.SuppliesRepos;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.beadAspects.MaterialCategory;
import com.beadinventory.beadinventory.Domain.Supplies.beadAspects.Material;
import com.beadinventory.beadinventory.Domain.Supplies.beadAspects.Shape;
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
