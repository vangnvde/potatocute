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
public class Film {
    private int id;
    private String nameFilm;
    private String descriptionFilm;
    private String poster;
    private String time;
    private int year;
    private String type;
    private String director;
    private String distributor;
    private int likeReview;
    private int unlikeReview;
    private float totalReview;

    public Film() {
    }

    public Film(int id, String nameFilm, String descriptionFilm, String poster, String time, int year, String type, String director, String distributor, int likeReview, int unlikeReview, float totalReview) {
        this.id = id;
        this.nameFilm = nameFilm;
        this.descriptionFilm = descriptionFilm;
        this.poster = poster;
        this.time = time;
        this.year = year;
        this.type = type;
        this.director = director;
        this.distributor = distributor;
        this.likeReview = likeReview;
        this.unlikeReview = unlikeReview;
        this.totalReview = totalReview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getDescriptionFilm() {
        return descriptionFilm;
    }

    public void setDescriptionFilm(String descriptionFilm) {
        this.descriptionFilm = descriptionFilm;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public int getLikeReview() {
        return likeReview;
    }

    public void setLikeReview(int likeReview) {
        this.likeReview = likeReview;
    }

    public int getUnlikeReview() {
        return unlikeReview;
    }

    public void setUnlikeReview(int unlikeReview) {
        this.unlikeReview = unlikeReview;
    }

    public float getTotalReview() {
        return totalReview;
    }

    public void setTotalReview(float totalReview) {
        this.totalReview = totalReview;
    }

    @Override
    public String toString() {
        return "Film{" + "id=" + id + ", nameFilm=" + nameFilm + ", descriptionFilm=" + descriptionFilm + ", poster=" + poster + ", time=" + time + ", year=" + year + ", type=" + type + ", director=" + director + ", distributor=" + distributor + ", likeReview=" + likeReview + ", unlikeReview=" + unlikeReview + ", totalReview=" + totalReview + '}';
    }

   
    
    
    
    
    
    
}
