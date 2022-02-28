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
public class Review {
    
    public int idFilm;
    public int idUser;
    public int isLike;

    public Review() {
    }

    public Review(int idFilm, int idUser, int isLike) {
        this.idFilm = idFilm;
        this.idUser = idUser;
        this.isLike = isLike;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIsLike() {
        return isLike;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }
    
    
    
}
