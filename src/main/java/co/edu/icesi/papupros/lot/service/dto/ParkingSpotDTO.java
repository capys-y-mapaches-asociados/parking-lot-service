package co.edu.icesi.papupros.lot.service.dto;

import co.edu.icesi.papupros.lot.domain.enumeration.SpotStatus;
import co.edu.icesi.papupros.lot.domain.enumeration.SpotType;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link co.edu.icesi.papupros.lot.domain.ParkingSpot} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ParkingSpotDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer number;

    @NotNull
    private SpotStatus status;

    @NotNull
    private SpotType spotType;

    private ParkingLotDTO parkingLot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public SpotStatus getStatus() {
        return status;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public ParkingLotDTO getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLotDTO parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ParkingSpotDTO)) {
            return false;
        }

        ParkingSpotDTO parkingSpotDTO = (ParkingSpotDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, parkingSpotDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ParkingSpotDTO{" +
            "id=" + getId() +
            ", number=" + getNumber() +
            ", status='" + getStatus() + "'" +
            ", spotType='" + getSpotType() + "'" +
            ", parkingLot=" + getParkingLot() +
            "}";
    }
}
