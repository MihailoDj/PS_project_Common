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
public class User implements GenericEntity{
    private Long userID;
    private String username;
    private String password;
    private String status = "offline";

    public User() {
        
    }

    public User(Long userID, String username, String password, String status) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "username, password, status";
    }

    @Override
    public void getInsertValues(PreparedStatement statement) throws Exception {
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, status);
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public void setId(Long id) {
        this.userID = id;
    }

    @Override
    public String getColumnNamesForUpdate() {
        return "username=?, password=?, status=?";
    }

    @Override
    public String getConditionForUpdate() {
        return "userID=" +userID;
    }

    @Override
    public String getConditionForDelete() {
        return "userID=" +userID;
    }

    @Override
    public String getColumnNamesForSelect() {
        return "*";
    }

    @Override
    public String getTableForSelect() {
        return "user";
    }

    @Override
    public String getConditionForSelect() {
        return "";
    }

    @Override
    public String getConditionForSelectSpecific() {
        return "username=\"" + username + "\"";
    }
}
