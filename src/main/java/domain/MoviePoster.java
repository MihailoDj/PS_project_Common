/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author Mihailo
 */
public class MoviePoster implements Serializable{
    private int moviePosterID;
    private transient BufferedImage posterImage;

    public MoviePoster() {
    }

    public MoviePoster(int moviePosterID, BufferedImage posterImage) {
        this.moviePosterID = moviePosterID;
        this.posterImage = posterImage;
    }

    public int getMoviePosterID() {
        return moviePosterID;
    }

    public void setMoviePosterID(int moviePosterID) {
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
}
