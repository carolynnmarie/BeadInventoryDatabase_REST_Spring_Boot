package com.beadinventory.beadinventory.Service.FinishedPiecesServices;

import com.beadinventory.beadinventory.Repository.FinishedPiecesRepos.NecklaceRepo;
import com.beadinventory.beadinventory.Service.SuppliesServices.BeadService;
import com.beadinventory.beadinventory.Service.SuppliesServices.FindingService;
import com.beadinventory.beadinventory.Service.SuppliesServices.StringingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NecklaceService {

    private NecklaceRepo necklaceRepo;
    private BeadService beadService;
    private FindingService findingService;
    private StringingMaterialService stringMaterialService;

    @Autowired
    public NecklaceService(NecklaceRepo necklaceRepo, BeadService beadService, FindingService findingService,
                           StringingMaterialService stringMaterialService){
        this.necklaceRepo = necklaceRepo;
        this.beadService = beadService;
        this.findingService = findingService;
        this.stringMaterialService = stringMaterialService;
    }



}
