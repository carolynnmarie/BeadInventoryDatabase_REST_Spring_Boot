package com.beadinventory.beadinventory.Repository;

import com.beadinventory.beadinventory.Domain.StoreList;
import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreListRepo extends CrudRepository<StoreList,Long> {

    List<StoreList> findStoreListsByProjectTitle(String title);
}
