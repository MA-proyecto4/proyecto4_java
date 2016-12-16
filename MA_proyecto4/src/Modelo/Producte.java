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
    private String prod_foto;
    private double prod_precio;
    

    public Producte() {
    }

    public Producte(int prod_id, String prod_nom, String prod_foto, double prod_precio) {
        this.prod_id = prod_id;
        this.prod_nom = prod_nom;
        this.prod_foto = prod_foto;
        this.prod_precio = prod_precio;
    }

    //Metodos accesorios
    //Getters

        public int getProd_id() {
            return prod_id;
        }

        public String getProd_nom() {
            return prod_nom;
        }

        public String getProd_foto() {
            return prod_foto;
        }

        public double getProd_precio() {
            return prod_precio;
        }
    //Setters

        public void setProd_id(int prod_id) {
            this.prod_id = prod_id;
        }

        public void setProd_nom(String prod_nom) {
            this.prod_nom = prod_nom;
        }

        public void setProd_foto(String prod_foto) {
            this.prod_foto = prod_foto;
        }

        public void setProd_precio(double prod_precio) {
            this.prod_precio = prod_precio;
        }

    
    
    
    
    
    
}

