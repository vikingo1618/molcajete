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
@Table(name = "C_ESTACION")
public class StationDO {
    private static final long serialVersionUID = -2300320077270334506L;
    
    @Id
    @Column(name = "ID_ESTACION")
    private Integer idStation;
    
    
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "ID_PAIS" , referencedColumnName = "ID_PAIS" )
    private CountryDO country;
    
    
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "departure")
    private List<RouteDO> departureRouter;
    
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "arrive")
    private List<RouteDO> arriveRouter;

    public Integer getIdStation() {
        return idStation;
    }

    public void setIdStation(Integer idStation) {
        this.idStation = idStation;
    }

    public CountryDO getCountry() {
        return country;
    }

    public void setCountry(CountryDO country) {
        this.country = country;
    }

    public List<RouteDO> getDepartureRouter() {
        return departureRouter;
    }

    public void setDepartureRouter(List<RouteDO> departureRouter) {
        this.departureRouter = departureRouter;
    }

    public List<RouteDO> getArriveRouter() {
        return arriveRouter;
    }

    public void setArriveRouter(List<RouteDO> arriveRouter) {
        this.arriveRouter = arriveRouter;
    }
    
    
    @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (this == object) {
            isEquals = true;
        } else if (object != null && object.getClass().equals(this.getClass())) {
            StationDO that = (StationDO) object;
            isEquals = new EqualsBuilder().append(this.idStation, that.idStation).isEquals();
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.idStation).toHashCode();
    }

    @Override
    public String toString() {
        return "StationDO{" + "idStation=" + idStation + ", country=" + country + ", departureRouter=" + departureRouter + ", arriveRouter=" + arriveRouter + '}';
    }
    
    
}
