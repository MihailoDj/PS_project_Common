/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;

/**
 *
 * @author Mihailo
 */
public class MoviePoster implements GenericEntity{
    private Long moviePosterID;
    private transient BufferedImage posterImage;

    public MoviePoster() {
    }

    public MoviePoster(Long moviePosterID, BufferedImage posterImage) {
        this.moviePosterID = moviePosterID;
        this.posterImage = posterImage;
    }

    public Long getMoviePosterID() {
        return moviePosterID;
    }

    public void setMoviePosterID(Long moviePosterID) {
        this.moviePosterID = moviePosterID;
    }

    public BufferedImage getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(BufferedImage posterImage) {
        this.posterImage = posterImage;
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ImageIO.write(this.posterImage, "png", out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.posterImage = ImageIO.read(in);
    }

    @Override
    public String getTableName() {
        return "movieposter";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "movieposterID, posterimage";
    }

    @Override
    public void getInsertValues(PreparedStatement statement) throws Exception{
        statement.setLong(1, moviePosterID);
            
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(posterImage, "jpg", baos);
        InputStream imageStream = new ByteArrayInputStream(baos.toByteArray());

        statement.setBlob(2, imageStream);
    }

    @Override
    public void setId(Long id) {
        this.moviePosterID = id;
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
        return "movieposterID = " + moviePosterID;
    }

    @Override
    public String getColumnNamesForSelect() {
        return "";
    }

    @Override
    public String getTableForSelect() {
        return "";
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
