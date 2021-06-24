package com.beadinventory.beadinventory.REST.Repository.FinishedPiecesRepos;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Bracelet;
import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.BraceletType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BraceletRepo extends AllFinishedPiecesRepo<Bracelet> {

    List<Bracelet> findBraceletsByBraceletType(BraceletType braceletType);



}
