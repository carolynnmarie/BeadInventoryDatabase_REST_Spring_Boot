package com.beadinventory.beadinventory.Repository.SuppliesRepos;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;

import java.util.List;


@Repository
public interface BeadRepo extends CrudRepository<Bead,Long> {

    List<Bead> findByMaterial(Material material);

    List<Bead> findByMaterialAndColor(Material material, String color);

    List<Bead> findByMaterialAndSize(Material material, int size);

    List<Bead> findByShape(Shape shape);

    List<Bead> findByQuantityIsLessThan(long quantity);

    Bead findById(long id);


}
