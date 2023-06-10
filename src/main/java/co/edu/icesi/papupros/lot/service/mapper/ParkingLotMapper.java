package co.edu.icesi.papupros.lot.service.mapper;

import co.edu.icesi.papupros.lot.domain.ParkingLot;
import co.edu.icesi.papupros.lot.service.dto.ParkingLotDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ParkingLot} and its DTO {@link ParkingLotDTO}.
 */
@Mapper(componentModel = "spring")
public interface ParkingLotMapper extends EntityMapper<ParkingLotDTO, ParkingLot> {}
