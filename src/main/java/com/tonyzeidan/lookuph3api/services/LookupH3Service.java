package com.tonyzeidan.lookuph3api.services;

import com.tonyzeidan.lookuph3api.dtos.*;
import com.uber.h3core.AreaUnit;
import com.uber.h3core.H3Core;
import com.uber.h3core.util.LatLng;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LookupH3Service {

    private final H3Core h3CoreInstance;

    private static final Map<String, AreaUnit> AREA_UNIT_MAPPING;

    static {
        AREA_UNIT_MAPPING = new HashMap<>();
        AREA_UNIT_MAPPING.put("km2", AreaUnit.km2);
        AREA_UNIT_MAPPING.put("m2", AreaUnit.m2);
        AREA_UNIT_MAPPING.put("rads2", AreaUnit.rads2);
    }

    public LookupH3Service() throws IOException {
        this.h3CoreInstance = H3Core.newInstance();
    }

    public LatLngToCellResponseDTO latLngToCell(Double lat, Double lng, Integer res) {
        String hexRes = this.h3CoreInstance.latLngToCellAddress(lat, lng, res);
        LatLngToCellResponseDTO latLngToCellResponseDTO = new LatLngToCellResponseDTO();
        latLngToCellResponseDTO.setCell(hexRes);
        return latLngToCellResponseDTO;
    }

    public CellToLatLngResponseDTO cellToLatLng(String cell) {
        LatLng latLngPair = this.h3CoreInstance.cellToLatLng(cell);
        CellToLatLngResponseDTO cellToLatLngResponseDTO = new CellToLatLngResponseDTO();
        cellToLatLngResponseDTO.setLat(latLngPair.lat);
        cellToLatLngResponseDTO.setLng(latLngPair.lng);
        return cellToLatLngResponseDTO;
    }

    public CellToBoundaryResponseDTO cellToBoundary(String cell) {
        List<LatLng> boundary = this.h3CoreInstance.cellToBoundary(cell);
        List<Double[]> boundaryConvert = latLngToList(boundary);
        CellToBoundaryResponseDTO cellToBoundaryResponseDTO = new CellToBoundaryResponseDTO();
        cellToBoundaryResponseDTO.setBoundary(boundaryConvert);
        return cellToBoundaryResponseDTO;
    }

    public AreNeighborCellsResponseDTO areNeighborCells(String a, String b) {
        Boolean areNeighbors = this.h3CoreInstance.areNeighborCells(a, b);
        AreNeighborCellsResponseDTO areNeighborCellsResponseDTO = new AreNeighborCellsResponseDTO();
        areNeighborCellsResponseDTO.setResult(areNeighbors);
        return areNeighborCellsResponseDTO;
    }

    public CellAreaResponseDTO cellArea(String cell, String areaUnit) {
        Double cellArea = this.h3CoreInstance.cellArea(cell, AREA_UNIT_MAPPING.get(areaUnit));
        CellAreaResponseDTO cellAreaResponseDTO = new CellAreaResponseDTO();
        cellAreaResponseDTO.setArea(cellArea);
        return cellAreaResponseDTO;
    }

    public NumCellsResponseDTO numCells(Integer res) {
        Long numCells = this.h3CoreInstance.getNumCells(res);
        NumCellsResponseDTO numCellsResponseDTO = new NumCellsResponseDTO();
        numCellsResponseDTO.setNumCells(numCells);
        return numCellsResponseDTO;
    }

    public IsPentagonResponseDTO isPentagon(String cell) {
        Boolean isPentagon = this.h3CoreInstance.isPentagon(cell);
        IsPentagonResponseDTO isPentagonResponseDTO = new IsPentagonResponseDTO();
        isPentagonResponseDTO.setIsPentagon(isPentagon);
        return isPentagonResponseDTO;
    }

    private List<Double[]> latLngToList(List<LatLng> coords) {
        List<Double[]> coordsNew = new ArrayList<>(coords.size());
        for (LatLng latLng : coords) {
            coordsNew.add(new Double[]{latLng.lat, latLng.lng});
        }
        return coordsNew;
    }
}
