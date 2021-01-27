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
public class Production implements GenericEntity{
    private ProductionCompany productionCompany;
    private Movie movie;
    
    public Production() {
        
    }

    public Production(ProductionCompany productionCompany, Movie movie) {
        this.productionCompany = productionCompany;
        this.movie = movie;
    }

    public ProductionCompany getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(ProductionCompany productionCompany) {
        this.productionCompany = productionCompany;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.productionCompany);
        hash = 29 * hash + Objects.hashCode(this.movie);
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
        final Production other = (Production) obj;
        if (!Objects.equals(this.productionCompany, other.productionCompany)) {
            return false;
        }
        if (!Objects.equals(this.movie, other.movie)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Production{" + "productionCompany=" + productionCompany + ", movie=" + movie + '}';
    }

    @Override
    public String getTableName() {
        return "production";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "productioncompanyID, movieID";
    }

    @Override
    public void getInsertValues(PreparedStatement statement) throws Exception{
        statement.setLong(1, productionCompany.getProductionCompanyID());
        statement.setLong(2, movie.getMovieID());
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 2;
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
        return "movieID = " + movie.getMovieID();
    }

    
}
