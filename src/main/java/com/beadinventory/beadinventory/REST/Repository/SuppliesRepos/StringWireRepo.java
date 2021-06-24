package com.beadinventory.beadinventory.REST.Repository.SuppliesRepos;

import com.beadinventory.beadinventory.REST.Domain.Supplies.StringWire;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.Material;
import com.beadinventory.beadinventory.REST.Domain.Supplies.SupplyEnums.StringWireCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = {"http://localhost:8080","http://localhost:8100"})
public interface StringWireRepo extends CrudRepository<StringWire,Long> {

    List<StringWire> findAllByStringWireCategory(StringWireCategory category);

    List<StringWire> findAllByMaterial(Material material);
}
