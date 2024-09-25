package com.crafter.springboottechiteasy.Dtos.television;

import com.crafter.springboottechiteasy.models.CiModule;
import com.crafter.springboottechiteasy.models.Remote;
import com.crafter.springboottechiteasy.models.WallBracket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TelevisionOutputDto {
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
    private Remote remote;
    private List<CiModule> modules;
    private List<WallBracket> wallBrackets;
}
