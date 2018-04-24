package com.axity.example.jpa.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "K_RUTA")
public class RouteDO {
    private static final long serialVersionUID = -2300320077270334506L;
    
    @Id
    @Column(name = "ID_RUTA")
    private Integer idRoute;
    
    @Column(name = "DS_CODE")
    private String code;
    
   @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "ID_ESTACION_DEP" , referencedColumnName = "ID_ESTACION" )
    private StationDO departure;
    
   @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "ID_ESTACION_ARR" , referencedColumnName = "ID_ESTACION" )
    private StationDO arrive;
   
   @OneToMany(fetch = FetchType.LAZY , mappedBy = "route")
    private List<FlightDO> flights;

    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public StationDO getDeparture() {
        return departure;
    }

    public void setDeparture(StationDO departure) {
        this.departure = departure;
    }

    public StationDO getArrive() {
        return arrive;
    }

    public void setArrive(StationDO arrive) {
        this.arrive = arrive;
    }

    public List<FlightDO> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDO> flights) {
        this.flights = flights;
    }
 
   @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (this == object) {
            isEquals = true;
        } else if (object != null && object.getClass().equals(this.getClass())) {
            RouteDO that = (RouteDO) object;
            isEquals = new EqualsBuilder().append(this.idRoute, that.idRoute).isEquals();
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.idRoute).toHashCode();
    }

    @Override
    public String toString() {
        return "RouteDO{" + "idRoute=" + idRoute + ", code=" + code + ", departure=" + departure + ", arrive=" + arrive + ", flights=" + flights + '}';
    }

    
}
