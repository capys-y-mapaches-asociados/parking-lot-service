package co.edu.icesi.papupros.lot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ParkingLot.
 */
@Entity
@Table(name = "parking_lot")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ParkingLot implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotNull
    @Size(min = 12)
    @Column(name = "location", nullable = false)
    private String location;

    @NotNull
    @Max(value = 13000)
    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy = "parkingLot")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "parkingLot" }, allowSetters = true)
    private Set<ParkingSpot> parkingSpots = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ParkingLot id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public ParkingLot name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public ParkingLot location(String location) {
        this.setLocation(location);
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return this.capacity;
    }

    public ParkingLot capacity(Integer capacity) {
        this.setCapacity(capacity);
        return this;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Set<ParkingSpot> getParkingSpots() {
        return this.parkingSpots;
    }

    public void setParkingSpots(Set<ParkingSpot> parkingSpots) {
        if (this.parkingSpots != null) {
            this.parkingSpots.forEach(i -> i.setParkingLot(null));
        }
        if (parkingSpots != null) {
            parkingSpots.forEach(i -> i.setParkingLot(this));
        }
        this.parkingSpots = parkingSpots;
    }

    public ParkingLot parkingSpots(Set<ParkingSpot> parkingSpots) {
        this.setParkingSpots(parkingSpots);
        return this;
    }

    public ParkingLot addParkingSpots(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
        parkingSpot.setParkingLot(this);
        return this;
    }

    public ParkingLot removeParkingSpots(ParkingSpot parkingSpot) {
        this.parkingSpots.remove(parkingSpot);
        parkingSpot.setParkingLot(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ParkingLot)) {
            return false;
        }
        return id != null && id.equals(((ParkingLot) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ParkingLot{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", location='" + getLocation() + "'" +
            ", capacity=" + getCapacity() +
            "}";
    }
}
