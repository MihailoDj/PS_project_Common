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
public class Actor implements GenericEntity{
    private Long actorID;
    private String firstName;
    private String lastName;
    private String biography;
    
    public Actor() {
        
    }

    public Long getActorID() {
        return actorID;
    }

    public void setActorID(Long actorID) {
        this.actorID = actorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.actorID);
        hash = 83 * hash + Objects.hashCode(this.firstName);
        hash = 83 * hash + Objects.hashCode(this.lastName);
        hash = 83 * hash + Objects.hashCode(this.biography);
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
        final Actor other = (Actor) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.actorID, other.actorID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public String getTableName() {
        return "actor";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "firstname, lastname, biography";
    }

    @Override
    public void getInsertValues(PreparedStatement statement) throws Exception {
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, biography);
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public void setId(Long id) {
        this.actorID = id;
    }

    @Override
    public String getColumnNamesForUpdate() {
        return "firstname=?, lastname=?, biography=?";
    }

    @Override
    public String getConditionForUpdate() {
        return "actorID=" + actorID;
    }

    @Override
    public String getConditionForDelete() {
        return "actorID=" + actorID;
    }

    @Override
    public String getColumnNamesForSelect() {
        return "*";
    }

    @Override
    public String getTableForSelect() {
        return "actor ORDER BY firstname ASC, lastname";
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
