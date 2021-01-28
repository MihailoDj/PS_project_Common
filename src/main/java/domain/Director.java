/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Mihailo
 */
public class Director implements GenericEntity{
    private Long directorID;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    
    public Director() {
        
    }

    public Director(Long directorID, String firstName, String lastName, LocalDate dateOfBirth) {
        this.directorID = directorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getDirectorID() {
        return directorID;
    }

    public void setDirectorID(Long directorID) {
        this.directorID = directorID;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.directorID);
        hash = 17 * hash + Objects.hashCode(this.firstName);
        hash = 17 * hash + Objects.hashCode(this.lastName);
        hash = 17 * hash + Objects.hashCode(this.dateOfBirth);
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
        final Director other = (Director) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
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
        return "director";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "firstname, lastname, dateofbirth";
    }

    @Override
    public void getInsertValues(PreparedStatement statement) throws Exception {
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setObject(3, dateOfBirth, java.sql.Types.DATE);
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public void setId(Long id) {
        this.directorID = id;
    }

    @Override
    public String getColumnNamesForUpdate() {
        return "firstname=?, lastname=?, dateofbirth=?";
    }

    @Override
    public String getConditionForUpdate() {
        return "directorID=" + directorID;
    }

    @Override
    public String getConditionForDelete() {
        return "directorID="+ directorID;
    }

    @Override
    public String getColumnNamesForSelect() {
        return "*";
    }

    @Override
    public String getTableForSelect() {
        return "director ORDER BY firstname ASC, lastname";
    }

    @Override
    public String getConditionForSelect() {
        return "";
    }

    @Override
    public String getConditionForSelectSpecific() {
        return "";
    }
}
