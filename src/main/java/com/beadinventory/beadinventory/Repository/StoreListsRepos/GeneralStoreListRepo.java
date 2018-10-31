package com.beadinventory.beadinventory.Repository.StoreListsRepos;

import com.beadinventory.beadinventory.Domain.StoreLists.GeneralStoreList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralStoreListRepo extends CrudRepository<GeneralStoreList,Long> {
}
