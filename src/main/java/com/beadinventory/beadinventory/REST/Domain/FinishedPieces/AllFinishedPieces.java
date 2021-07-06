package com.beadinventory.beadinventory.REST.Domain.FinishedPieces;

import com.beadinventory.beadinventory.REST.Domain.Serializers.*;
import com.beadinventory.beadinventory.REST.Domain.Supplies.*;
import com.fasterxml.jackson.databind.annotation.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.persistence.*;
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

    @Column(name = "ARCHIVED")
    protected boolean isArchived;

    @Column(name = "PICTURE")
    protected byte[] picture;

    public AllFinishedPieces() {
    }

    public AllFinishedPieces(String jpgName){
        try{
            BufferedImage bImage = ImageIO.read(new File(jpgName));
            ByteArrayOutputStream byteOStream = new ByteArrayOutputStream();
            ImageIO.write(bImage,"jpg", byteOStream);
            this.picture = byteOStream.toByteArray();
        } catch(Exception e){
            System.out.println("file not read");
        }
    }

    public AllFinishedPieces(HashMap<Bead, Integer> beads, HashMap<Finding, Integer> findings, double price, String description,
    boolean isArchived, String jpgName) {
        this.beads = beads;
        this.findings = findings;
        this.price = price;
        this.description = description;
        this.isArchived = isArchived;
        try{
            BufferedImage bImage = ImageIO.read(new File(jpgName));
            ByteArrayOutputStream byteOStream = new ByteArrayOutputStream();
            ImageIO.write(bImage,"jpg", byteOStream);
            this.picture = byteOStream.toByteArray();
        } catch(Exception e){
            System.out.println("file not read");
        }
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

    public void setIsArchived(boolean archived){
        this.isArchived = archived;
    }

    public boolean getIsArchived(){
        return isArchived;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public abstract void setAutoPrice();
}
