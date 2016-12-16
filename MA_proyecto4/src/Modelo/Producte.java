/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author usuari
 */
public class Producte {
    
    private int prod_id;
    private String prod_nom;

    public Producte() {
    }

    public Producte(int prod_id, String prod_nom) {
        this.prod_id = prod_id;
        this.prod_nom = prod_nom;
    }

    public int getProd_id() {
        return prod_id;
    }

    public String getProd_nom() {
        return prod_nom;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public void setProd_nom(String prod_nom) {
        this.prod_nom = prod_nom;
    }
    

    
    
    
    
    
}

