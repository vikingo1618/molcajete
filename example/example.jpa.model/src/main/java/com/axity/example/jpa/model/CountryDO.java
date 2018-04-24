package com.axity.example.jpa.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "C_PAIS")
public class CountryDO {
    private static final long serialVersionUID = -2300320077270334506L;
    
    @Id
    @Column(name = "ID_PAIS")
    private Integer idCountry;
    
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "country")
    private List<StationDO> stations;

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public List<StationDO> getStations() {
        return stations;
    }

    public void setStations(List<StationDO> stations) {
        this.stations = stations;
    }
    
     @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (this == object) {
            isEquals = true;
        } else if (object != null && object.getClass().equals(this.getClass())) {
            CountryDO that = (CountryDO) object;
            isEquals = new EqualsBuilder().append(this.idCountry, that.idCountry).isEquals();
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.idCountry).toHashCode();
    }

    @Override
    public String toString() {
        return "CountryDO{" + "idCountry=" + idCountry + ", stations=" + stations + '}';
    }
    
    
}
