package com.beadinventory.beadinventory.Repository.SuppliesRepos;

import com.beadinventory.beadinventory.Domain.Supplies.Finding;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = {"http://localhost:8080","http://localhost:8100"})
public interface FindingRepo extends CrudRepository<Finding,Long> {

    List<Finding> findAll();

    List<Finding> findFindingsByCategory(FindingCategory findingCategory);

    List<Finding> findFindingsByMaterial(Material material);

    List<Finding> findFindingsByCategoryAndMaterial(FindingCategory category, Material material);

    Finding findById(long id);

}
