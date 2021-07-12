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
public class UserMovieCollection implements GenericEntity{
    private Movie movie;
    private User user;

    public UserMovieCollection() {
    }

    public UserMovieCollection(Movie movie, User user) {
        this.movie = movie;
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.movie);
        hash = 61 * hash + Objects.hashCode(this.user);
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
        final UserMovieCollection other = (UserMovieCollection) obj;
        if (!Objects.equals(this.movie, other.movie)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "collection";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "movieID, userID";
    }

    @Override
    public void getInsertValues(PreparedStatement statement) throws Exception {
        statement.setLong(1, movie.getMovieID());
        statement.setLong(2, user.getUserID());
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public void setId(Long id) {

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
        return "movieID=" + movie.getMovieID() + " AND "
                    + "userID=" + user.getUserID();
    }

    @Override
    public String getColumnNamesForSelect() {
        return "*";
    }

    @Override
    public String getTableForSelect() {
        return "collection c JOIN movie m ON (c.movieID=m.movieID) "
                    + "JOIN user u ON (u.userID=c.userID) JOIN director d ON (d.directorID=m.directorID) "
                    + "JOIN movieposter mp ON (mp.movieposterID=m.movieposterID)";
    }

    @Override
    public String getConditionForSelect() {
        return "";
    }

    @Override
    public String getConditionForSelectSpecific() {
        return "c.userID=" + user.getUserID();
    }

    @Override
    public String getAdditionalQueries() {
        return "";
    }
    
    
}
