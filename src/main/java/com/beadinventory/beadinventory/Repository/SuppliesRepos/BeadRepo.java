package com.beadinventory.beadinventory.Repository.SuppliesRepos;

import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;


@Repository
public interface BeadRepo extends CrudRepository<Bead,Long> {

    List<Bead> findByMaterial(Material material);

    List<Bead> findByMaterialAndColor(Material material, String color);

    List<Bead> findByMaterialAndSizeMM(Material material, int size);

    List<Bead> findByQuantityIsLessThan(long quantity);

    Bead findById(long id);

    @Query(value = "SELECT b FROM Bead b ORDER BY material")
    List<Bead> findAllOrderByMaterial();


}
