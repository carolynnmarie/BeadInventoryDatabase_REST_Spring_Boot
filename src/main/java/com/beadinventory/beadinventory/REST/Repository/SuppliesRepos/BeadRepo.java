package com.beadinventory.beadinventory.REST.Repository.SuppliesRepos;

import com.beadinventory.beadinventory.REST.Domain.Supplies.Bead;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BeadRepo extends CrudRepository<Bead,Long> {

    //CrudRepository already has the standard Create, Read, Update, and Delete methods

    //SELECT * FROM Bead WHERE material = "material";
    List<Bead> findByMaterial(Material material);

    //SELECT * FROM Bead WHERE material = "material" AND size_mm = size;
    List<Bead> findByMaterialAndSizeMM(Material material, int size);

    //SELECT * FROM Bead WHERE quantity < quantity;
    List<Bead> findByQuantityIsLessThan(long quantity);

    //SELECT bead FROM Bead WHERE bead_id = id;
    Bead findById(long id);

    //SELECT * FROM Bead ORDER BY material;
    @Query(value = "SELECT b FROM Bead b ORDER BY material")
    List<Bead> findAllOrderByMaterial();


}
