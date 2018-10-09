package com.beadinventory.beadinventory.Repository.FinishedPiecesRepos;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Necklace;
import com.beadinventory.beadinventory.Domain.Supplies.StringingMaterial;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringingMaterialCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NecklaceRepo extends AllFinishedPiecesRepo<Necklace> {

    List<Necklace> findAllByStringingMaterial(StringingMaterial stringingMaterial);

    List<Necklace> findAllByStringingMaterialCategory(StringingMaterialCategory category);

    List<Necklace> findNecklacesByHasNaturalStonesTrue();

    List<Necklace> findNecklacesByHasSwarovskiTrue();
}
