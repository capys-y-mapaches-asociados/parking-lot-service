package co.edu.icesi.papupros.lot.service.mapper;

import co.edu.icesi.papupros.lot.domain.ParkingLot;
import co.edu.icesi.papupros.lot.domain.ParkingSpot;
import co.edu.icesi.papupros.lot.service.dto.ParkingLotDTO;
import co.edu.icesi.papupros.lot.service.dto.ParkingSpotDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ParkingSpot} and its DTO {@link ParkingSpotDTO}.
 */
@Mapper(componentModel = "spring")
public interface ParkingSpotMapper extends EntityMapper<ParkingSpotDTO, ParkingSpot> {
    @Mapping(target = "parkingLot", source = "parkingLot", qualifiedByName = "parkingLotId")
    ParkingSpotDTO toDto(ParkingSpot s);

    @Named("parkingLotId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ParkingLotDTO toDtoParkingLotId(ParkingLot parkingLot);
}
