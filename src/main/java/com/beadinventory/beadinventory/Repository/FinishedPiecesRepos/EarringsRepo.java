package com.beadinventory.beadinventory.Repository.FinishedPiecesRepos;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EarringsRepo extends AllFinishedPiecesRepo<Earrings> {

    List<Earrings> findEarringsBySterlingSilverYorNIsTrue();
}
