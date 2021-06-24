package com.beadinventory.beadinventory.REST.Repository.FinishedPiecesRepos;

import com.beadinventory.beadinventory.REST.Domain.FinishedPieces.Bookmark;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepo extends AllFinishedPiecesRepo<Bookmark> {

    //SELECT b FROM bookmark b WHERE b.beads
    List<Bookmark> findAllBy();
}
