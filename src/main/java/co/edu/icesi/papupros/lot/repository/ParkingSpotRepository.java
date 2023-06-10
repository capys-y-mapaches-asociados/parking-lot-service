package co.edu.icesi.papupros.lot.repository;

import co.edu.icesi.papupros.lot.domain.ParkingSpot;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ParkingSpot entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {}
