/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Vang Nguyen
 */
public class Comment {
    public String fullComment;
    public String nameFilm;
    public String fullNameUser;
    public String username;
    public String poster;
    public int idFilm;

    public Comment() {
    }

    public Comment(String fullComment, String nameFilm, String fullNameUser, String username, String poster, int idFilm) {
        this.fullComment = fullComment;
        this.nameFilm = nameFilm;
        this.fullNameUser = fullNameUser;
        this.username = username;
        this.poster = poster;
        this.idFilm = idFilm;
    }

    public String getFullComment() {
        return fullComment;
    }

    public void setFullComment(String fullComment) {
        this.fullComment = fullComment;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getFullNameUser() {
        return fullNameUser;
    }

    public void setFullNameUser(String fullNameUser) {
        this.fullNameUser = fullNameUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    
    
    
}
