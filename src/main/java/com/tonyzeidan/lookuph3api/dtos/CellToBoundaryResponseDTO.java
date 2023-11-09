package com.tonyzeidan.lookuph3api.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CellToBoundaryResponseDTO implements Serializable {
    private List<Double[]> boundary;
}
