 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "C_TIPO_AERONAVE")
public class AircraftTypeDO {

    private static final long serialVersionUID = 6338966655828763232L;

    @Id
    @Column(name = "ID_TIPO_AERONAVE")
    private Integer idAircraftType;

  

    public Integer getIdAircraft() {
        return idAircraftType;
    }

    public void setIdAircraft(Integer idAircraft) {
        this.idAircraftType = idAircraft;
    }

   
    
    @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (this == object) {
            isEquals = true;
        } else if (object != null && object.getClass().equals(this.getClass())) {
            AircraftTypeDO that = (AircraftTypeDO) object;
            isEquals = new EqualsBuilder().append(this.idAircraftType, that.idAircraftType).isEquals();
        }
        return isEquals;
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.idAircraftType).toHashCode();
    }


    
    
}
