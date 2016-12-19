
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
    private int categoria;
    private int prod_estoc_actual;
    private int prod_estoc_minim;
    private int prod_estoc_max;
    
    //Constructores

    public Producte() {
    }
    //COnstructor con todo, menos con categoria
    public Producte(String prod_nom,  double prod_precio,  int prod_estoc_actual, int prod_estoc_minim, int prod_estoc_max) {
        this.prod_nom = prod_nom;
        //this.prod_foto = prod_foto;
        this.prod_precio = prod_precio;
        //this.categoria = categoria;
        this.prod_estoc_actual = prod_estoc_actual;
        this.prod_estoc_minim = prod_estoc_minim;
        this.prod_estoc_max = prod_estoc_max;
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

            public int getCategoria() {
                return categoria;
            }

            public int getProd_estoc_actual() {
                return prod_estoc_actual;
            }

            public int getProd_estoc_minim() {
                return prod_estoc_minim;
            }

            public int getProd_estoc_max() {
                return prod_estoc_max;
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

            public void setCategoria(int categoria) {
                this.categoria = categoria;
            }

            public void setProd_estoc_actual(int prod_estoc_actual) {
                this.prod_estoc_actual = prod_estoc_actual;
            }

            public void setProd_estoc_minim(int prod_estoc_minim) {
                this.prod_estoc_minim = prod_estoc_minim;
            }

            public void setProd_estoc_max(int prod_estoc_max) {
                this.prod_estoc_max = prod_estoc_max;
            }

            

    
}

