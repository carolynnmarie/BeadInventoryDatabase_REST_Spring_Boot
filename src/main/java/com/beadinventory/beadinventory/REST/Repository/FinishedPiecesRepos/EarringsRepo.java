package com.beadinventory.beadinventory.REST.Repository.FinishedPiecesRepos;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Earrings;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EarringsRepo extends AllFinishedPiecesRepo<Earrings> {

    List<Earrings> findEarringsBySterlingSilverYorNIsTrue();
}
