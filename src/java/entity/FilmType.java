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
public class FilmType {
    private int idType;
    private String typeName;

    public FilmType() {
    }

    public FilmType(int idType, String typeName) {
        this.idType = idType;
        this.typeName = typeName;
    }

    public int getIdType() {
        return idType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
