package com.axity.example.jpa.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "K_VUELO")
class FlightDO {

    private static final long serialVersionUID = -2300320077270334506L;

    @Id
    @Column(name = "ID_VUELO")
    private Integer idFlight;

    @Column(name = "QT_VUELO")
    private Integer flight;

    @Column(name = "QT_TIME_DELAY_ARR")
    private Integer delayArrive;

    @Column(name = "QT_TIME_DELAY_DEP")
    private Integer delayDeparture;

    @Column(name = "DT_SCH_DEPARTURE_UTC")
    private Date scheduledDepartureUtc;

    @Column(name = "DT_SCH_ARRIVE_UTC")
    private Date scheduledArriveUtc;

    @Column(name = "DT_ACT_DEPARTURE_UTC")
    private Date actualDepartureUtc;

    @Column(name = "DT_ACT_ARRIVE_UTC")
    private Date actualArriveUtc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_RUTA", referencedColumnName = "ID_RUTA")
    private RouteDO route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_AERONAVE", referencedColumnName = "ID_AERONAVE")
    private AircraftDO aircraft;

    public Integer getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Integer idFlight) {
        this.idFlight = idFlight;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Integer getDelayArrive() {
        return delayArrive;
    }

    public void setDelayArrive(Integer delayArrive) {
        this.delayArrive = delayArrive;
    }

    public Integer getDelayDeparture() {
        return delayDeparture;
    }

    public void setDelayDeparture(Integer delayDeparture) {
        this.delayDeparture = delayDeparture;
    }

    public Date getScheduledDepartureUtc() {
        return scheduledDepartureUtc;
    }

    public void setScheduledDepartureUtc(Date scheduledDepartureUtc) {
        this.scheduledDepartureUtc = scheduledDepartureUtc;
    }

    public Date getScheduledArriveUtc() {
        return scheduledArriveUtc;
    }

    public void setScheduledArriveUtc(Date scheduledArriveUtc) {
        this.scheduledArriveUtc = scheduledArriveUtc;
    }

    public Date getActualDepartureUtc() {
        return actualDepartureUtc;
    }

    public void setActualDepartureUtc(Date actualDepartureUtc) {
        this.actualDepartureUtc = actualDepartureUtc;
    }

    public Date getActualArriveUtc() {
        return actualArriveUtc;
    }

    public void setActualArriveUtc(Date actualArriveUtc) {
        this.actualArriveUtc = actualArriveUtc;
    }

    public RouteDO getRoute() {
        return route;
    }

    public void setRoute(RouteDO route) {
        this.route = route;
    }

    public AircraftDO getAircraft() {
        return aircraft;
    }

    public void setAircraft(AircraftDO aircraft) {
        this.aircraft = aircraft;
    }
    
        @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (this == object) {
            isEquals = true;
        } else if (object != null && object.getClass().equals(this.getClass())) {
            FlightDO that = (FlightDO) object;
            isEquals = new EqualsBuilder().append(this.idFlight, that.idFlight).isEquals();
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.idFlight).toHashCode();
    }

    @Override
    public String toString() {
        return "FlightDO{" + "idFlight=" + idFlight + ", flight=" + flight + ", delayArrive=" + delayArrive + ", delayDeparture=" + delayDeparture + ", scheduledDepartureUtc=" + scheduledDepartureUtc + ", scheduledArriveUtc=" + scheduledArriveUtc + ", actualDepartureUtc=" + actualDepartureUtc + ", actualArriveUtc=" + actualArriveUtc + ", route=" + route + ", aircraft=" + aircraft + '}';
    }


}
