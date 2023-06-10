package co.edu.icesi.papupros.lot.service.impl;

import co.edu.icesi.papupros.lot.domain.ParkingSpot;
import co.edu.icesi.papupros.lot.repository.ParkingSpotRepository;
import co.edu.icesi.papupros.lot.service.ParkingSpotService;
import co.edu.icesi.papupros.lot.service.dto.ParkingSpotDTO;
import co.edu.icesi.papupros.lot.service.mapper.ParkingSpotMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link ParkingSpot}.
 */
@Service
@Transactional
public class ParkingSpotServiceImpl implements ParkingSpotService {

    private final Logger log = LoggerFactory.getLogger(ParkingSpotServiceImpl.class);

    private final ParkingSpotRepository parkingSpotRepository;

    private final ParkingSpotMapper parkingSpotMapper;

    public ParkingSpotServiceImpl(ParkingSpotRepository parkingSpotRepository, ParkingSpotMapper parkingSpotMapper) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingSpotMapper = parkingSpotMapper;
    }

    @Override
    public ParkingSpotDTO save(ParkingSpotDTO parkingSpotDTO) {
        log.debug("Request to save ParkingSpot : {}", parkingSpotDTO);
        ParkingSpot parkingSpot = parkingSpotMapper.toEntity(parkingSpotDTO);
        parkingSpot = parkingSpotRepository.save(parkingSpot);
        return parkingSpotMapper.toDto(parkingSpot);
    }

    @Override
    public ParkingSpotDTO update(ParkingSpotDTO parkingSpotDTO) {
        log.debug("Request to update ParkingSpot : {}", parkingSpotDTO);
        ParkingSpot parkingSpot = parkingSpotMapper.toEntity(parkingSpotDTO);
        parkingSpot = parkingSpotRepository.save(parkingSpot);
        return parkingSpotMapper.toDto(parkingSpot);
    }

    @Override
    public Optional<ParkingSpotDTO> partialUpdate(ParkingSpotDTO parkingSpotDTO) {
        log.debug("Request to partially update ParkingSpot : {}", parkingSpotDTO);

        return parkingSpotRepository
            .findById(parkingSpotDTO.getId())
            .map(existingParkingSpot -> {
                parkingSpotMapper.partialUpdate(existingParkingSpot, parkingSpotDTO);

                return existingParkingSpot;
            })
            .map(parkingSpotRepository::save)
            .map(parkingSpotMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ParkingSpotDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ParkingSpots");
        return parkingSpotRepository.findAll(pageable).map(parkingSpotMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ParkingSpotDTO> findOne(Long id) {
        log.debug("Request to get ParkingSpot : {}", id);
        return parkingSpotRepository.findById(id).map(parkingSpotMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ParkingSpot : {}", id);
        parkingSpotRepository.deleteById(id);
    }
}
