package com.crafter.springboottechiteasy.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Televisions")
public class Television {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String type;
    String brand;
    String name;
    Double price;
    Double availableSize;
    Integer refreshRate;
    String screenType;
    String screenQuality;
    Boolean smartTv;
    Boolean wifi;
    Boolean voiceControl;
    Boolean hdr;
    Boolean bluetooth;
    Boolean ambilight;
    Integer originalStock;
    Integer sold;

    public Television() {
    }

    public Television(String type, String brand, String name) {
        this.type = type;
        this.brand = brand;
        this.name = name;
    }

    public Television(Long id, String type, String brand, String name, Double price, Double availableSize, Integer refreshRate, String screenType, String screenQuality, Boolean smartTv, Boolean wifi, Boolean voiceControl, Boolean hdr, Boolean bluetooth, Boolean ambilight, Integer originalStock, Integer sold) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambilight = ambilight;
        this.originalStock = originalStock;
        this.sold = sold;
    }

}
