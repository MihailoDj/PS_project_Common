/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.PreparedStatement;
import java.util.Objects;

/**
 *
 * @author Mihailo
 */
public class ProductionCompany implements GenericEntity{
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

    @Override
    public String getTableName() {
        return "productioncompany";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "";
    }

    @Override
    public void getInsertValues(PreparedStatement statement) throws Exception {
        
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public void setId(Long id) {
        this.productionCompanyID = id;
    }

    @Override
    public String getColumnNamesForUpdate() {
        return "";
    }

    @Override
    public String getConditionForUpdate() {
        return "";
    }

    @Override
    public String getConditionForDelete() {
        return "";
    }

    @Override
    public String getColumnNamesForSelect() {
        return "*";
    }

    @Override
    public String getTableForSelect() {
        return "productioncompany ORDER BY name ASC";
    }

    @Override
    public String getConditionForSelect() {
        return "";
    }

    @Override
    public String getConditionForSelectSpecific() {
        return "";
    }

    @Override
    public String getAdditionalQueries() {
        return "";
    }
}
