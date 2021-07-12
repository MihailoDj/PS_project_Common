/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author Mihailo
 */
public class Movie implements GenericEntity{
    private Long movieID;
    private String name;
    private LocalDate releaseDate;
    private String description;
    private double score;
    private Director director;
    private List<Role> roles;
    private List<MovieGenre> movieGenres;
    private List<Production> productions;
    private MoviePoster moviePoster;
    private int duration;
    
    public Movie() {
        this.roles = new ArrayList<Role>();
        this.movieGenres = new ArrayList<MovieGenre>();
        this.productions = new ArrayList<Production>();
        this.moviePoster = new MoviePoster();
    }

    public Movie(Long movieID, String name, LocalDate releaseDate, String description, double score, Director director, int duration) {
        this.movieID = movieID;
        this.name = name;
        this.releaseDate = releaseDate;
        this.description = description;
        this.score = score;
        this.director = director;
        this.duration = duration;
        this.roles = new ArrayList<Role>();
        this.movieGenres = new ArrayList<MovieGenre>();
        this.productions = new ArrayList<Production>();
        this.moviePoster = new MoviePoster();
    }
    
    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<MovieGenre> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(List<MovieGenre> movieGenres) {
        this.movieGenres = movieGenres;
    }

    public List<Production> getProductions() {
        return productions;
    }

    public void setProductions(List<Production> productions) {
        this.productions = productions;
    }
    
    public MoviePoster getMoviePoster() {
        return moviePoster;
    }
    
    public void setMoviePoster(MoviePoster moviePoster) {
        this.moviePoster = moviePoster;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.movieID);
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.releaseDate);
        hash = 71 * hash + Objects.hashCode(this.description);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.score) ^ (Double.doubleToLongBits(this.score) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.director);
        hash = 71 * hash + Objects.hashCode(this.roles);
        hash = 71 * hash + Objects.hashCode(this.movieGenres);
        hash = 71 * hash + Objects.hashCode(this.productions);
        hash = 71 * hash + Objects.hashCode(this.moviePoster);
        hash = 71 * hash + this.duration;
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
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
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
        return "movie";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "movieID, name, releasedate, score, description, directorid, movieposterID, duration";
    }

    @Override
    public void getInsertValues(PreparedStatement statement) throws Exception{
        statement.setLong(1, movieID);
        statement.setString(2, name);
        statement.setObject(3, releaseDate, java.sql.Types.DATE);
        statement.setDouble(4, score);
        statement.setString(5, description);
        statement.setLong(6, director.getDirectorID());
        statement.setLong(7, moviePoster.getMoviePosterID());
        statement.setInt(8, duration);
    }

    @Override
    public void setId(Long id) {
        this.movieID = id;
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnNamesForUpdate() {
        return "movieID=?, name=?, releasedate=?, score=?, description=?, directorID=?,"
                    + " movieposterID=?, duration=?";
    }

    @Override
    public String getConditionForUpdate() {
        return "movieID = " + movieID;
    }

    @Override
    public String getConditionForDelete() {
        return "movieID = " + movieID;
    }

    @Override
    public String getColumnNamesForSelect() {
        return "*";
    }

    @Override
    public String getTableForSelect() {
        return "movie m JOIN director d ON (m.directorID = d.directorID) JOIN movieposter mp ON (m.movieposterID = mp.movieposterID)";
    }

    @Override
    public String getConditionForSelect() {
        return "";
    }

    @Override
    public String getConditionForSelectSpecific() {
        return "name like \"%" + name + "%\" OR firstname like \"%" + director.getFirstName() + "%\" OR "
                    + "lastname like \"%" + director.getLastName() + "%\"";
    }

    @Override
    public String getAdditionalQueries() {
        return "";
    }
}
