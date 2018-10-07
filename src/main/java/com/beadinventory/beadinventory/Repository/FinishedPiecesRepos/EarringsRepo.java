package com.beadinventory.beadinventory.Repository.FinishedPiecesRepos;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Earrings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarringsRepo extends AllFinishedPiecesRepo<Earrings> {
}
