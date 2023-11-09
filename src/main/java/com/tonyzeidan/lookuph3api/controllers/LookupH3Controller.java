package com.tonyzeidan.lookuph3api.controllers;

import com.tonyzeidan.lookuph3api.dtos.*;
import com.tonyzeidan.lookuph3api.services.LookupH3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("lookuph3")
public class LookupH3Controller {

    private final LookupH3Service lookupH3Service;

    @Autowired
    public LookupH3Controller(LookupH3Service lookupH3Service) {
        this.lookupH3Service = lookupH3Service;
    }

    @GetMapping("latLngToCell")
    public ResponseEntity<LatLngToCellResponseDTO> latLngToCellMapping(@RequestParam Double lat, @RequestParam Double lng, @RequestParam Integer res) {
        LatLngToCellResponseDTO latLngToCellResponseDTO = this.lookupH3Service.latLngToCell(lat, lng, res);
        return ResponseEntity.ok(latLngToCellResponseDTO);
    }

    @PostMapping("latLngToCell")
    public ResponseEntity<LatLngToCellResponseDTO> latLngToCellMapping(@RequestBody LatLngToCellRequestDTO latLngToCellRequestDTO) {
        LatLngToCellResponseDTO latLngToCellResponseDTO = this.lookupH3Service.latLngToCell(latLngToCellRequestDTO.getLat(), latLngToCellRequestDTO.getLng(), latLngToCellRequestDTO.getRes());
        return ResponseEntity.ok(latLngToCellResponseDTO);
    }

    @GetMapping("cellToLatLng")
    public ResponseEntity<CellToLatLngResponseDTO> latLngToCellMapping(@RequestParam String cell) {
        CellToLatLngResponseDTO cellToLatLngResponseDTO = this.lookupH3Service.cellToLatLng(cell);
        return ResponseEntity.ok(cellToLatLngResponseDTO);
    }

    @PostMapping("cellToLatLng")
    public ResponseEntity<CellToLatLngResponseDTO> latLngToCellMapping(@RequestBody CellToLatLngRequestDTO cellToLatLngRequestDTO) {
        CellToLatLngResponseDTO cellToLatLngResponseDTO = this.lookupH3Service.cellToLatLng(cellToLatLngRequestDTO.getCell());
        return ResponseEntity.ok(cellToLatLngResponseDTO);
    }

    @GetMapping("cellToBoundary")
    public ResponseEntity<CellToBoundaryResponseDTO> cellToBoundaryMapping(@RequestParam String cell) {
        CellToBoundaryResponseDTO cellToBoundaryResponseDTO = this.lookupH3Service.cellToBoundary(cell);
        return ResponseEntity.ok(cellToBoundaryResponseDTO);
    }

    @PostMapping("cellToBoundary")
    public ResponseEntity<CellToBoundaryResponseDTO> cellToBoundaryMapping(@RequestBody CellToBoundaryRequestDTO cellToBoundaryRequestDTO) {
        CellToBoundaryResponseDTO cellToBoundaryResponseDTO = this.lookupH3Service.cellToBoundary(cellToBoundaryRequestDTO.getCell());
        return ResponseEntity.ok(cellToBoundaryResponseDTO);
    }

    @GetMapping("areNeighborCells")
    public ResponseEntity<AreNeighborCellsResponseDTO> areNeighborCellsMapping(@RequestParam String a, @RequestParam String b) {
        AreNeighborCellsResponseDTO areNeighborCellsResponseDTO = this.lookupH3Service.areNeighborCells(a, b);
        return ResponseEntity.ok(areNeighborCellsResponseDTO);
    }

    @PostMapping("areNeighborCells")
    public ResponseEntity<AreNeighborCellsResponseDTO> areNeighborCellsMapping(@RequestBody AreNeighborCellsRequestDTO areNeighborCellsRequestDTO) {
        AreNeighborCellsResponseDTO areNeighborCellsResponseDTO = this.lookupH3Service.areNeighborCells(areNeighborCellsRequestDTO.getA(), areNeighborCellsRequestDTO.getB());
        return ResponseEntity.ok(areNeighborCellsResponseDTO);
    }

    @GetMapping("cellArea")
    public ResponseEntity<CellAreaResponseDTO> cellAreaMapping(@RequestParam String cell, @RequestParam String areaUnit) {
        CellAreaResponseDTO cellAreaResponseDTO = this.lookupH3Service.cellArea(cell, areaUnit);
        return ResponseEntity.ok(cellAreaResponseDTO);
    }

    @PostMapping("cellArea")
    public ResponseEntity<CellAreaResponseDTO> cellAreaMapping(@RequestBody CellAreaRequestDTO cellAreaRequestDTO) {
        CellAreaResponseDTO cellAreaResponseDTO = this.lookupH3Service.cellArea(cellAreaRequestDTO.getCell(), cellAreaRequestDTO.getAreaUnit());
        return ResponseEntity.ok(cellAreaResponseDTO);
    }

    @GetMapping("numCells")
    public ResponseEntity<NumCellsResponseDTO> numCellsMapping(@RequestParam Integer res) {
        NumCellsResponseDTO numCellsResponseDTO = this.lookupH3Service.numCells(res);
        return ResponseEntity.ok(numCellsResponseDTO);
    }

    @PostMapping("numCells")
    public ResponseEntity<NumCellsResponseDTO> numCellsMapping(@RequestBody NumCellsRequestDTO numCellsRequestDTO) {
        NumCellsResponseDTO numCellsResponseDTO = this.lookupH3Service.numCells(numCellsRequestDTO.getRes());
        return ResponseEntity.ok(numCellsResponseDTO);
    }

    @GetMapping("isPentagon")
    public ResponseEntity<IsPentagonResponseDTO> isPentagonMapping(@RequestParam String cell) {
        IsPentagonResponseDTO isPentagonResponseDTO = this.lookupH3Service.isPentagon(cell);
        return ResponseEntity.ok(isPentagonResponseDTO);
    }

    @PostMapping("isPentagon")
    public ResponseEntity<IsPentagonResponseDTO> isPentagonMapping(@RequestBody IsPentagonRequestDTO isPentagonRequestDTO) {
        IsPentagonResponseDTO isPentagonResponseDTO = this.lookupH3Service.isPentagon(isPentagonRequestDTO.getCell());
        return ResponseEntity.ok(isPentagonResponseDTO);
    }
}
