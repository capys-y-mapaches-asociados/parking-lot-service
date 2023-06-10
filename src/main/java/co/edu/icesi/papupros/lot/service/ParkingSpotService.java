package co.edu.icesi.papupros.lot.service;

import co.edu.icesi.papupros.lot.service.dto.ParkingSpotDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link co.edu.icesi.papupros.lot.domain.ParkingSpot}.
 */
public interface ParkingSpotService {
    /**
     * Save a parkingSpot.
     *
     * @param parkingSpotDTO the entity to save.
     * @return the persisted entity.
     */
    ParkingSpotDTO save(ParkingSpotDTO parkingSpotDTO);

    /**
     * Updates a parkingSpot.
     *
     * @param parkingSpotDTO the entity to update.
     * @return the persisted entity.
     */
    ParkingSpotDTO update(ParkingSpotDTO parkingSpotDTO);

    /**
     * Partially updates a parkingSpot.
     *
     * @param parkingSpotDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ParkingSpotDTO> partialUpdate(ParkingSpotDTO parkingSpotDTO);

    /**
     * Get all the parkingSpots.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ParkingSpotDTO> findAll(Pageable pageable);

    /**
     * Get the "id" parkingSpot.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ParkingSpotDTO> findOne(Long id);

    /**
     * Delete the "id" parkingSpot.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
