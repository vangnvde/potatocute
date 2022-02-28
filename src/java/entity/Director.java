/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author tinqu
 */
public class Director {
    private int idDirector;
    private String nameDirector;

    public Director() {
    }

    public Director(int idDirector, String nameDirector) {
        this.idDirector = idDirector;
        this.nameDirector = nameDirector;
    }

    public int getIdDirector() {
        return idDirector;
    }

    public String getNameDirector() {
        return nameDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    public void setNameDirector(String nameDirector) {
        this.nameDirector = nameDirector;
    }
}
