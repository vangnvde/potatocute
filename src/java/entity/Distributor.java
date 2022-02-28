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
public class Distributor {
    private int idDistributor;
    private String nameDistributor;

    public Distributor() {
    }

    public Distributor(int idDistributor, String nameDistributor) {
        this.idDistributor = idDistributor;
        this.nameDistributor = nameDistributor;
    }

    public int getIdDistributor() {
        return idDistributor;
    }

    public String getNameDistributor() {
        return nameDistributor;
    }

    public void setIdDistributor(int idDistributor) {
        this.idDistributor = idDistributor;
    }

    public void setNameDistributor(String nameDistributor) {
        this.nameDistributor = nameDistributor;
    }
    
    
}
