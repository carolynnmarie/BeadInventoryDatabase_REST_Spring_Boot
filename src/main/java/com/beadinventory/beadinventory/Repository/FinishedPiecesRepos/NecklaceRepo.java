package com.beadinventory.beadinventory.Repository.FinishedPiecesRepos;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Necklace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NecklaceRepo extends AllFinishedPiecesRepo<Necklace> {
}
