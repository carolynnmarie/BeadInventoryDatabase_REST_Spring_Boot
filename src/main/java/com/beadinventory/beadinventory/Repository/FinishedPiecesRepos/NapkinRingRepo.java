package com.beadinventory.beadinventory.Repository.FinishedPiecesRepos;

import com.beadinventory.beadinventory.Domain.FinishedPieces.NapkinRing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NapkinRingRepo extends AllFinishedPiecesRepo<NapkinRing> {
}
