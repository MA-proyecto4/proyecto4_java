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
public class Estoc {
    private int estoc_id;
    private int estoc_actual;
    private int estoc_q_min;
    private int estoc_q_max;

    public Estoc() {
    }

    public Estoc(int estoc_id, int estoc_actual, int estoc_q_min, int estoc_q_max) {
        this.estoc_id = estoc_id;
        this.estoc_actual = estoc_actual;
        this.estoc_q_min = estoc_q_min;
        this.estoc_q_max = estoc_q_max;
    }

    public int getEstoc_id() {
        return estoc_id;
    }

    public int getEstoc_actual() {
        return estoc_actual;
    }

    public int getEstoc_q_min() {
        return estoc_q_min;
    }

    public int getEstoc_q_max() {
        return estoc_q_max;
    }

    public void setEstoc_id(int estoc_id) {
        this.estoc_id = estoc_id;
    }

    public void setEstoc_actual(int estoc_actual) {
        this.estoc_actual = estoc_actual;
    }

    public void setEstoc_q_min(int estoc_q_min) {
        this.estoc_q_min = estoc_q_min;
    }

    public void setEstoc_q_max(int estoc_q_max) {
        this.estoc_q_max = estoc_q_max;
    }
    
    
}
