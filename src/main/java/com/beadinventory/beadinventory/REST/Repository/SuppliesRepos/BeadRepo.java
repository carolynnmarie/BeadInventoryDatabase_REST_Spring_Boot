package com.beadinventory.beadinventory.REST.Repository.SuppliesRepos;

import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BeadRepo extends CrudRepository<Bead,Long> {

    List<Bead> findByMaterial(Material material);

    List<Bead> findByMaterialAndSizeMM(Material material, int size);

    List<Bead> findByQuantityIsLessThan(long quantity);

    Bead findById(long id);

    @Query(value = "SELECT b FROM Bead b ORDER BY material")
    List<Bead> findAllOrderByMaterial();


}
