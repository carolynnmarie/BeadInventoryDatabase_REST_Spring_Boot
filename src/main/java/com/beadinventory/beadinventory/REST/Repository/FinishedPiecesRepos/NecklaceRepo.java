package com.beadinventory.beadinventory.REST.Repository.FinishedPiecesRepos;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Necklace;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NecklaceRepo extends AllFinishedPiecesRepo<Necklace> {

    List<Necklace> findNecklacesByHasNaturalStonesTrue();
    List<Necklace> findNecklacesByHasSwarovskiTrue();


}
