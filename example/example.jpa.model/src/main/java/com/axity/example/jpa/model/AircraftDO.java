 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "K_AERONAVE")
public class AircraftDO extends AbstractCatalogEntity<AircraftDO>{

    private static final long serialVersionUID = 6338666657128763522L;

    @Id
    @Column(name = "ID_AERONAVE")
    private Integer idAircraft;

    @Column(name = "DS_MATRICULA")
    private String registration;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "ID_AREOLINEA" , referencedColumnName = "ID_AEROLINEA" )
    private CarrierDO carrier;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_AERONAVE" , referencedColumnName = "ID_TIPO_AERONAVE")
    private AircraftTypeDO aircraftType;
    
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "aircraft")
    private List<FlightDO> flights;

    public Integer getIdAircraft() {
        return idAircraft;
    }

    public void setIdAircraft(Integer idAircraft) {
        this.idAircraft = idAircraft;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

   
    @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (this == object) {
            isEquals = true;
        } else if (object != null && object.getClass().equals(this.getClass())) {
            AircraftDO that = (AircraftDO) object;
            isEquals = new EqualsBuilder().append(this.idAircraft, that.idAircraft).isEquals();
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.idAircraft).toHashCode();
    }

    @Override
    public String toString() {
        return "AircraftDO{" + "idAircraft=" + idAircraft + ", registration=" + registration + ", carrier=" + carrier + ", aircraftType=" + aircraftType + ", flights=" + flights + '}';
    }
            
    
           
}
