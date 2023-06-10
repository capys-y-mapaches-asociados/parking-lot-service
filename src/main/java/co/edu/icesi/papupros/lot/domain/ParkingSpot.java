package co.edu.icesi.papupros.lot.domain;

import co.edu.icesi.papupros.lot.domain.enumeration.SpotStatus;
import co.edu.icesi.papupros.lot.domain.enumeration.SpotType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ParkingSpot.
 */
@Entity
@Table(name = "parking_spot")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ParkingSpot implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "number", nullable = false, unique = true)
    private Integer number;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SpotStatus status;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "spot_type", nullable = false)
    private SpotType spotType;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "parkingSpots" }, allowSetters = true)
    private ParkingLot parkingLot;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ParkingSpot id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return this.number;
    }

    public ParkingSpot number(Integer number) {
        this.setNumber(number);
        return this;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public SpotStatus getStatus() {
        return this.status;
    }

    public ParkingSpot status(SpotStatus status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(SpotStatus status) {
        this.status = status;
    }

    public SpotType getSpotType() {
        return this.spotType;
    }

    public ParkingSpot spotType(SpotType spotType) {
        this.setSpotType(spotType);
        return this;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public ParkingLot getParkingLot() {
        return this.parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSpot parkingLot(ParkingLot parkingLot) {
        this.setParkingLot(parkingLot);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ParkingSpot)) {
            return false;
        }
        return id != null && id.equals(((ParkingSpot) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ParkingSpot{" +
            "id=" + getId() +
            ", number=" + getNumber() +
            ", status='" + getStatus() + "'" +
            ", spotType='" + getSpotType() + "'" +
            "}";
    }
}
