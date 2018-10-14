package com.beadinventory.beadinventory.Repository.SuppliesRepos;

import com.beadinventory.beadinventory.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StringWireRepo extends CrudRepository<StringWire,Long> {

    List<StringWire> findAllByStringWireCategory(StringWireCategory category);

    List<StringWire> findAllByMaterial(Material material);
}
