package com.ev.RouteOptimizationSystem.services;
import com.ev.RouteOptimizationSystem.dtos.ChargingStationDTO;
import com.ev.RouteOptimizationSystem.exceptions.ResourceNotFoundException;
import com.ev.RouteOptimizationSystem.interfaces.ChargingStationService;
import com.ev.RouteOptimizationSystem.models.ChargingStation;
import com.ev.RouteOptimizationSystem.repositories.ChargingStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChargingStationServiceImpl implements ChargingStationService {

    private final ChargingStationRepository chargingStationRepository;

    @Autowired
    public ChargingStationServiceImpl(ChargingStationRepository chargingStationRepository) {
        this.chargingStationRepository = chargingStationRepository;
    }

    @Override
    public ChargingStationResponse createChargingStation(ChargingStationRequest chargingStationRequest) {
        ChargingStation chargingStation = new ChargingStation();
        chargingStation.setName(chargingStationRequest.getName());
        chargingStation.setAddress(chargingStationRequest.getAddress());
        chargingStation.setLatitude(chargingStationRequest.getLatitude());
        chargingStation.setLongitude(chargingStationRequest.getLongitude());

        ChargingStation savedChargingStation = chargingStationRepository.save(chargingStation);
        ChargingStationDTO chargingStationDTO = convertToDTO(savedChargingStation);
        return new ChargingStationResponse(chargingStationDTO);
    }

    @Override
    public ChargingStationResponse updateChargingStation(Long chargingStationId, ChargingStationRequest chargingStationRequest) throws ResourceNotFoundException {
        ChargingStation chargingStation = chargingStationRepository.findById(chargingStationId)
                .orElseThrow(() -> new ResourceNotFoundException("Charging Station", chargingStationId));

        chargingStation.setName(chargingStationRequest.getName());
        chargingStation.setAddress(chargingStationRequest.getAddress());
        chargingStation.setLatitude(chargingStationRequest.getLatitude());
        chargingStation.setLongitude(chargingStationRequest.getLongitude());

        ChargingStation updatedChargingStation = chargingStationRepository.save(chargingStation);
        ChargingStationDTO chargingStationDTO = convertToDTO(updatedChargingStation);
        return new ChargingStationResponse(chargingStationDTO);
    }

    @Override
    public ChargingStationDTO getChargingStationById(Long chargingStationId) throws ResourceNotFoundException {
        ChargingStation chargingStation = chargingStationRepository.findById(chargingStationId)
                .orElseThrow(() -> new ResourceNotFoundException("Charging Station", chargingStationId));
        return convertToDTO(chargingStation);
    }

    @Override
    public List<ChargingStationDTO> getAllChargingStations() {
        return chargingStationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteChargingStation(Long chargingStationId) throws ResourceNotFoundException {
        if (!chargingStationRepository.existsById(chargingStationId)) {
            throw new ResourceNotFoundException("Charging Station", chargingStationId);
        }
        chargingStationRepository.deleteById(chargingStationId);
    }

    private ChargingStationDTO convertToDTO(ChargingStation chargingStation) {
        return ChargingStationDTO.builder()
                .id(chargingStation.getId())
                .name(chargingStation.getName())
                .address(chargingStation.getAddress())
                .latitude(chargingStation.getLatitude())
                .longitude(chargingStation.getLongitude())
                .build();
    }
}
