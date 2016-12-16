/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Miguel
 */
public class Controller {

    //Controllador
    public Controller() {
    }
    
    //Funcion de login, devuelve 1 si el login es TRUE y 0 si es FALSE
    
    Conexion conectar = new Conexion();
    Connection cn = conectar.conec();
    public int controlAcceso (String nombre, String password){
        //Hacemos la consulta SQL
        String sql = "SELECT * FROM `tbl_usuario` WHERE usu_nick = ? AND usu_pass = ?";
        
        PreparedStatement pst;
        
        try {
            
            pst=cn.prepareStatement(sql);
            //montamos la consulta
            pst.setString(1, nombre);
            pst.setString(2,password);
            ResultSet rs= pst.executeQuery();
            
            if(rs.next()){
                return 1;
            }
            else{
                return 0;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        //return 0;
    }
    
    public void llenarCombo(JComboBox box){
        DefaultComboBoxModel value;
        String sql = "Select * From tbl_categoria";
        Statement st = null;
        ResultSet rs=null;

        try {
            st = cn.createStatement();
             //JOptionPane.showMessageDialog(null, "Conexion viento en popa2");
            rs = st.executeQuery(sql);
             // JOptionPane.showMessageDialog(null, "Conexion viento en popa2");
            value=new DefaultComboBoxModel();
            box.setModel(value);
            while (rs.next()) {
            
             value.addElement(new Categoria(rs.getInt("idcategoria"),rs.getString("name")));
            
            }
            cn.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Conexion erronea");
          
        }

          

    
    }
        
    
    //Funcion que nos devuelve un DefaultTableModel y se ejecuta al inicio de la vista, de forma que nos pinta los datos en la tabla.
        public DefaultTableModel mostrarTabla() {
          DefaultTableModel muestra = null;
          String sql = "SELECT * FROM `tbl_producte` LEFT JOIN `tbl_estoc` ON `tbl_producte`.`prod_id`=`tbl_estoc`.`prod_id`";
          Statement st = null;
          String vectorProducto[] = new String[7];
          String vectorProducto1[] = new String[7];
          vectorProducto1[0] = "prod_id";
          vectorProducto1[1] = "prod_nom";
          vectorProducto1[2] = "prod_precio";
          vectorProducto1[3] = "categoria_id";
          vectorProducto1[4] = "estoc_q_max";
          vectorProducto1[5] = "estoc_q_min";
          vectorProducto1[6] = "estoc_actual";
           muestra=new DefaultTableModel(null, vectorProducto1);
//String[] vectorProducto; De otra manera definir el vector

        try {

            st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                vectorProducto[0] = String.valueOf(rs.getInt("prod_id"));
                vectorProducto[1] = rs.getString("prod_nom");
                vectorProducto[2] = String.valueOf(rs.getInt("prod_precio"));
                vectorProducto[3] = String.valueOf(rs.getInt("categoria_id"));
                vectorProducto[4] = String.valueOf(rs.getInt("estoc_q_min"));
                vectorProducto[5] = String.valueOf(rs.getInt("estoc_q_max"));
                vectorProducto[6] = String.valueOf(rs.getInt("estoc_actual"));
                muestra.addRow(vectorProducto);
            }
        } catch (Exception e) {
        }

        return muestra;
    }
}
