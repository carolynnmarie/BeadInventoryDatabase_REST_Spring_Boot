package com.beadinventory.beadinventory.Domain.FinishedPieces;

import com.beadinventory.beadinventory.Domain.Serializers.*;
import com.beadinventory.beadinventory.Domain.Supplies.*;
import com.fasterxml.jackson.databind.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AllFinishedPieces implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ALL_ID")
    protected long allId;


    @JsonSerialize(keyUsing = BeadSerializer.class)
    @JsonDeserialize(keyUsing = BeadDeserializer.class)
    @ElementCollection
    @CollectionTable(name = "BEAD_MAP", joinColumns = @JoinColumn(name = "ALL_ID"))
    @MapKeyJoinColumn(name = "BEAD_ID", referencedColumnName = "BEAD_ID")
    @Column(name = "BEADS_ALL")
    protected Map<Bead, Integer> beads = new HashMap<>();


    @JsonSerialize(keyUsing = FindingSerializer.class)
    @JsonDeserialize(keyUsing = FindingDeserializer.class)
    @ElementCollection
    @CollectionTable(name = "FINDING_MAP",joinColumns = @JoinColumn(name = "ALL_ID"))
    @MapKeyJoinColumn(name = "FINDING_ID")
    @Column(name = "FINDINGS_ALL")
    protected Map<Finding, Integer> findings = new HashMap<>();

    @Column(name = "PRICE")
    protected double price;

    @Column(name = "DESCRIPTION")
    protected String description;

    public AllFinishedPieces() {
    }

    public AllFinishedPieces(HashMap<Bead, Integer> beads, HashMap<Finding, Integer> findings, double price, String description) {
        this.beads = beads;
        this.findings = findings;
        this.price = price;
        this.description = description;
    }

    public Map<Bead, Integer> getBeads() {
        return beads;
    }

    public void setBeads(Map<Bead, Integer> beads) {
        this.beads = beads;
    }

    public Map<Finding, Integer> getFindings() {
        return findings;
    }

    public void setFindings(Map<Finding, Integer> findings) {
        this.findings = findings;
    }

    public void setAllId(long allId) {
        this.allId = allId;
    }

    public long getAllId(){
        return allId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Map<String, Integer> getBeadJsonString(){
//        ObjectMapper mapper = new ObjectMapper();
//        String beadString = "";
//        Map<String, Integer> stringMap = new LinkedHashMap<>();
//        for (Map.Entry<Bead, Integer> entry:beads.entrySet()) {
//            try {
//                beadString = mapper.writeValueAsString(entry.getKey());
//            } catch(JsonProcessingException e){
//                beadString = "bead json processing error";
//            }
//            stringMap.put(beadString,entry.getValue());
//        }
//        return stringMap;
//    }
//
//    public Map<String,Integer> getFindingJsonString(){
//        ObjectMapper mapper = new ObjectMapper();
//        String findingString = "";
//        Map<String, Integer> stringMap = new LinkedHashMap<>();
//        for (Map.Entry<Finding, Integer> entry : findings.entrySet()) {
//            try {
//                findingString = mapper.writeValueAsString(entry.getKey());
//            } catch(JsonProcessingException e){
//                findingString = "finding json processing error";
//            }
//            stringMap.put(findingString,entry.getValue());
//        }
//        return stringMap;
//    }

    public abstract void setAutoPrice();
}
