package com.tonyzeidan.lookuph3api.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class LatLngToCellRequestDTO implements Serializable {

    private Double lat;
    private Double lng;
    private Integer res;
}
