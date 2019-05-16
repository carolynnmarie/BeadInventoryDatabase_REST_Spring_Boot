package com.beadinventory.beadinventory;

import com.beadinventory.beadinventory.Domain.StoreList;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.FindingCategory.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Material.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.Shape.*;
import static com.beadinventory.beadinventory.Domain.Supplies.SupplyEnums.StringWireCategory.*;
import com.beadinventory.beadinventory.Repository.StoreListRepo;
import com.beadinventory.beadinventory.Repository.SuppliesRepos.*;

import java.util.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SupplyCommandLineRunner implements CommandLineRunner {

    private final BeadRepo beadRepo;
    private final StoreListRepo listRepo;
    private final FindingRepo findingRepo;
    private final StringWireRepo stringRepo;

    public SupplyCommandLineRunner(BeadRepo beadRepo, StoreListRepo storeListRepo, FindingRepo findingRepo,
                                   StringWireRepo stringRepo) {
        this.beadRepo = beadRepo;
        this.listRepo = storeListRepo;
        this.findingRepo = findingRepo;
        this.stringRepo = stringRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Bead bead1 = new Bead(AMETHYST,ROUND,"purple",4,"good",10,"Amethyst, round, 10mm",0.05,"bead gallery");
        Bead bead2 = new Bead(JASPER, ROUND, "black", 4, "good", 10, "Jasper, round 10mm", 0.6, "Bead Gallery");
        List<Bead> beadList = new ArrayList<>(Arrays.asList(bead1,bead2));

        Finding eyePin = new Finding(EYE_PIN, BRIGHT_SILVER_PLATED,5.08,5.08,25,"Beadalon","thin 2 inch eyepin, Beadalon");
        Finding headPin = new Finding(HEAD_PIN, BRIGHT_SILVER_PLATED,5.08,5.08,20,"Beadalon","thin 2 inch headpin, Beadalon");
        Finding lobsterClasp = new Finding(LOBSTER_CLASP,BRIGHT_SILVER_PLATED,2,0.1,10,"Beadalon","small lobster clasp");
        List<Finding> findingList = new ArrayList<>(Arrays.asList(eyePin,headPin,lobsterClasp));

        StringWire beadingWire = new StringWire(BEADING_WIRE,BRIGHT_SILVER_PLATED,"silver",".5 mm","good",.5,"Beadalon",
                "7 strand beading wire, Beadalon");
        StringWire brassChain = new StringWire(CHAIN,BRASS,"brass","thin","okay",.5,"bead landing", "thin brass chain");
        StringWire leatherCord = new StringWire(CORD,LEATHER,"black","medium","okay",.5,"bead landing", "black leather cord");
        List<StringWire> stringList = new ArrayList<>(Arrays.asList(beadingWire,brassChain,leatherCord));
        List<String> otherItems = new ArrayList<>();


        Iterable<Bead> iBeadList = beadList;
        iBeadList.forEach(bead -> beadRepo.save(bead));

        Iterable<Finding> iFindingList = findingList;
        iFindingList.forEach(finding -> findingRepo.save(finding));

        Iterable<StringWire> iStringList = stringList;
        iStringList.forEach(stringWire -> stringRepo.save(stringWire));

        StoreList storeList = new StoreList("store list",beadList,findingList,stringList,otherItems);
        Iterable<StoreList> iStoreLists = new ArrayList<>(Arrays.asList(storeList));
        iStoreLists.forEach(list -> listRepo.save(list));
    }
}
