package com.beadinventory.beadinventory.Service.StoreListsServices;

import com.beadinventory.beadinventory.Repository.StoreListsRepos.ProjectStoreListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectStoreListService {

    private ProjectStoreListRepo projectListRepo;

    @Autowired
    public ProjectStoreListService(ProjectStoreListRepo projectListRepo){
        this.projectListRepo = projectListRepo;
    }
}
