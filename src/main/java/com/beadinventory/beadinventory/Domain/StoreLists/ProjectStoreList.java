package com.beadinventory.beadinventory.Domain.StoreLists;


import com.beadinventory.beadinventory.Domain.Serializers.*;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "PROJECT_STORE_LIST")
public class ProjectStoreList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @JsonSerialize(keyUsing = BeadSerializer.class)
    @JsonDeserialize(keyUsing = BeadDeserializer.class)
    @ElementCollection
    @CollectionTable(name = "BEADS_NEEDED", joinColumns = @JoinColumn(name = "ALL_ID"))
    @MapKeyJoinColumn(name = "BEAD_ID", referencedColumnName = "BEAD_ID")
    @Column(name = "BEADS")
    private Map<Bead, Integer> beadsNeeded;

    @JsonSerialize(keyUsing = FindingSerializer.class)
    @JsonDeserialize(keyUsing = FindingDeserializer.class)
    @ElementCollection
    @CollectionTable(name = "FINDINGS_NEEDED",joinColumns = @JoinColumn(name = "ALL_ID"))
    @MapKeyJoinColumn(name = "FINDING_ID")
    @Column(name = "FINDINGS")
    private Map<Finding, Integer> findingsNeeded;

    @JsonDeserialize(keyUsing = StringWireDeserializer.class)
    @JsonSerialize(keyUsing = StringWireSerializer.class)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "STRING_WIRE_ID")
    private List<StringWire> stringingMaterialsNeeded;

    @ElementCollection
    @Column(name = "OTHER_SUPPLIES")
    private List<String> otherItemsNeeded;

    public ProjectStoreList(HashMap<Bead,Integer> beadsNeeded, HashMap<Finding,Integer> findingsNeeded,
                            ArrayList<StringWire> stringingMaterialsNeeded, ArrayList<String> otherItemsNeeded){
        this.beadsNeeded = beadsNeeded;
        this.findingsNeeded = findingsNeeded;
        this.stringingMaterialsNeeded = stringingMaterialsNeeded;
        this.otherItemsNeeded = otherItemsNeeded;
    }

    public ProjectStoreList(HashMap<Bead,Integer> beadsNeeded, HashMap<Finding,Integer> findingsNeeded,
                            ArrayList<StringWire> stringingMaterialsNeeded){
        this.beadsNeeded = beadsNeeded;
        this.findingsNeeded = findingsNeeded;
        this.stringingMaterialsNeeded = stringingMaterialsNeeded;
        this.otherItemsNeeded = new ArrayList<>();
    }
    public ProjectStoreList(LinkedHashMap<Bead,Integer> beadsNeeded, HashMap<Finding,Integer> findingsNeeded){
        this.beadsNeeded = beadsNeeded;
        this.findingsNeeded = findingsNeeded;
        this.stringingMaterialsNeeded = new ArrayList<>();
        this.otherItemsNeeded = new ArrayList<>();
    }

    public ProjectStoreList(HashMap<Bead,Integer> beadsNeeded){
        this.beadsNeeded = beadsNeeded;
        this.findingsNeeded = new HashMap<>();
        this.stringingMaterialsNeeded = new ArrayList<>();
        this.otherItemsNeeded = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Bead, Integer> getBeadsNeeded() {
        return beadsNeeded;
    }

    public void setBeadsNeeded(Map<Bead, Integer> beadsNeeded) {
        this.beadsNeeded = beadsNeeded;
    }

    public Map<Finding, Integer> getFindingsNeeded() {
        return findingsNeeded;
    }

    public void setFindingsNeeded(Map<Finding, Integer> findingsNeeded) {
        this.findingsNeeded = findingsNeeded;
    }

    public List<StringWire> getStringingMaterialsNeeded() {
        return stringingMaterialsNeeded;
    }

    public void setStringingMaterialsNeeded(List<StringWire> stringingMaterialsNeeded) {
        this.stringingMaterialsNeeded = stringingMaterialsNeeded;
    }

    public List<String> getOtherItemsNeeded() {
        return otherItemsNeeded;
    }

    public void setOtherItemsNeeded(List<String> otherItemsNeeded) {
        this.otherItemsNeeded = otherItemsNeeded;
    }
}
