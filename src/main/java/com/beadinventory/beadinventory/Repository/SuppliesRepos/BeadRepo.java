package com.beadinventory.beadinventory.Repository.SuppliesRepos;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.MaterialCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BeadRepo extends CrudRepository<Bead,Long> {

//    Iterable<Bead> findBeadsByMaterial_Category(MaterialCategory beadCategory);

    Iterable<Bead> findBeadsByMaterial(Material material);

    Iterable<Bead> findBeadsByMaterialAndColor(Material material, String color);

    Iterable<Bead> findBeadsByMaterialAndSize(Material material, int size);

    Iterable<Bead> findBeadsByShape(Shape shape);

    Iterable<Bead> findByQuantityIsLessThan(long quantity);

}
