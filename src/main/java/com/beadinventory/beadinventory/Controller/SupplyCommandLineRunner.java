package com.beadinventory.beadinventory.Controller;

import com.beadinventory.beadinventory.Controller.SuppliesControllers.BeadController;
import com.beadinventory.beadinventory.Domain.Supplies.Bead;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.BeadRepo;

import java.util.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SupplyCommandLineRunner implements CommandLineRunner {

    private final BeadRepo beadRepo;
    private BeadController beadController;


    public SupplyCommandLineRunner(BeadRepo beadRepo, BeadController beadController) {
        this.beadRepo = beadRepo;
        this.beadController = beadController;
    }

    @Override
    public void run(String... args) throws Exception {
        Bead bead1 = new Bead(AMETHYST,ROUND,"purple",4,"good",10,"purple with some white",0.05,"bead gallery");
        Bead bead2 = new Bead(JASPER, ROUND, "black", 4, "good", 10, "", 0.6, "Bead Gallery");
        List<Bead> list = new ArrayList<>(Arrays.asList(bead1,bead2));
        Iterable<Bead> iList = list;
        iList.forEach(bead -> beadRepo.save(bead));
//        beadRepo.save(bead1);
//        beadRepo.save(bead2);
        System.out.println(beadController.findAllBeads().get(0));
        System.out.println(beadController.findAllBeads().get(1));
    }
}
/*
MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
 */