/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author rflet
 */
public class Trailer {
    
    private int idFilm;
    private String linkTrailer;

    public Trailer() {
    }

    public Trailer(int idFilm, String linkTrailer) {
        this.idFilm = idFilm;
        this.linkTrailer = linkTrailer;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getLinkTrailer() {
        return linkTrailer;
    }

    public void setLinkTrailer(String linkTrailer) {
        this.linkTrailer = linkTrailer;
    }
    
    
}
