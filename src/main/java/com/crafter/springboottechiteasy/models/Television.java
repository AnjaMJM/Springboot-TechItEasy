package com.crafter.springboottechiteasy.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "televisions")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String brand;
    private String name;
    private Double price;
    private Double availableSize;
    private Integer refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambilight;
    private Integer originalStock;
    private Integer sold;
    @OneToOne
    @JoinColumn(name = "remote_id", referencedColumnName = "id")
    private Remote remote;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ci_module_id", referencedColumnName = "id")
    private CiModule module;
    @ManyToMany
    @JoinTable(
            name = "television_wallbrackets",
            joinColumns = @JoinColumn(name = "television_id"),
            inverseJoinColumns = @JoinColumn(name = "wall_bracket_id")
    )
    private List<WallBracket> wallBrackets = new ArrayList<>();
}
