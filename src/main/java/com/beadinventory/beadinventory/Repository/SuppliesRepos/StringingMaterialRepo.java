package com.beadinventory.beadinventory.Repository.SuppliesRepos;

import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StringingMaterialRepo extends CrudRepository<StringingMaterial,Long> {

    List<StringingMaterial> findStringingMaterialsBySMCategory(StringingMaterialCategory category);

    List<StringingMaterial> findStringingMaterialsByMaterial(Material material);
}
