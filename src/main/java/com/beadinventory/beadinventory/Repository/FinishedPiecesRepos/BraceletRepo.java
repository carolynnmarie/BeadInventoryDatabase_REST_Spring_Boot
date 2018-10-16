package com.beadinventory.beadinventory.Repository.FinishedPiecesRepos;

import com.beadinventory.beadinventory.Domain.FinishedPieces.Bracelet;
import com.beadinventory.beadinventory.Domain.FinishedPieces.BraceletType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BraceletRepo extends AllFinishedPiecesRepo<Bracelet> {

    List<Bracelet> findBraceletsByBraceletType(BraceletType braceletType);
}
