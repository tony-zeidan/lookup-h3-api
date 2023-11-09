package com.tonyzeidan.lookuph3api.services;

import com.tonyzeidan.lookuph3api.dtos.CellToBoundaryResponseDTO;
import com.tonyzeidan.lookuph3api.dtos.CellToLatLngResponseDTO;
import com.tonyzeidan.lookuph3api.dtos.LatLngToCellResponseDTO;
import com.uber.h3core.H3Core;
import com.uber.h3core.util.LatLng;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LookupH3Service {

    private final H3Core h3CoreInstance;

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

    private List<Double[]> latLngToList(List<LatLng> coords) {
        List<Double[]> coordsNew = new ArrayList<>(coords.size());
        for (LatLng latLng : coords) {
            coordsNew.add(new Double[]{latLng.lat, latLng.lng});
        }
        return coordsNew;
    }
}
