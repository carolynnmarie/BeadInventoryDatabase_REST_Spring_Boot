package com.beadinventory.beadinventory.Repository.SuppliesRepos;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindingRepo extends CrudRepository<Finding,Long> {
    List<Finding> findAll();
    List<Finding> findFindingsByCategory(FindingCategory findingCategory);

    List<Finding> findFindingsByMaterial(Material material);

    List<Finding> findFindingsByCategoryAndLengthCM(FindingCategory category, double length);

    List<Finding> findFindingsByCategoryAndMaterial(FindingCategory category, Material material);

}
