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
public class Genre implements GenericEntity{
   private Long genreID;
   private String name;

    public Genre() {
    }

    public Genre(Long genreID, String name) {
        this.genreID = genreID;
        this.name = name;
    }

    public Long getGenreID() {
        return genreID;
    }

    public void setGenreID(Long genreID) {
        this.genreID = genreID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.genreID);
        hash = 41 * hash + Objects.hashCode(this.name);
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
        final Genre other = (Genre) obj;
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
        return "genre";
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
        this.genreID = id;
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
        return "genre ORDER BY name ASC";
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
