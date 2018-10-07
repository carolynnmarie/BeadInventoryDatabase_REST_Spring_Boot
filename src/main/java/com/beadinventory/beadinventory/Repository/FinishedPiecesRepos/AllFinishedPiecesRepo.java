package com.beadinventory.beadinventory.Repository.FinishedPiecesRepos;

import com.beadinventory.beadinventory.Domain.FinishedPieces.AllFinishedPieces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AllFinishedPiecesRepo<T extends AllFinishedPieces> extends CrudRepository<T,Long> {
}
