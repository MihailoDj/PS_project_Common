/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Mihailo
 */
public class ProductionCompany implements Serializable{
    private Long productionCompanyID;
    private String name;
    
    public ProductionCompany() {
        
    }

    public ProductionCompany(Long productionCompanyID, String name) {
        this.productionCompanyID = productionCompanyID;
        this.name = name;
    }

    public Long getProductionCompanyID() {
        return productionCompanyID;
    }

    public void setProductionCompanyID(Long productionCompanyID) {
        this.productionCompanyID = productionCompanyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.productionCompanyID);
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductionCompany other = (ProductionCompany) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
