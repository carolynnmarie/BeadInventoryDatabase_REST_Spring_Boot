package com.beadinventory.beadinventory.REST.Repository;

import com.beadinventory.beadinventory.REST.Domain.StoreList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = {"http://localhost:8080","http://localhost:8100"})
public interface StoreListRepo extends CrudRepository<StoreList,Long> {

    StoreList findStoreListsByProjectTitle(String title);
}
