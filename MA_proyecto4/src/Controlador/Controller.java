/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Producte;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    //Funcion que nos devuelve un DefaultTableModel y se ejecuta al inicio de la vista, de forma que nos pinta los datos en la tabla.
        public DefaultTableModel mostrarTabla() {
          DefaultTableModel muestra = null;
          //Consulta que engloba la tabla producto,categoria y estoc para mostrar los datos
          String sql = "SELECT * FROM `tbl_producte` LEFT JOIN `tbl_estoc` ON `tbl_producte`.`prod_id`=`tbl_estoc`.`prod_id` LEFT JOIN `tbl_categoria` ON `tbl_producte`.`categoria_id`=`tbl_categoria`.`categoria_id`;";
          Statement st = null;
          String vectorProducto[] = new String[6];
          String vectorProducto1[] = new String[6];
          //vectorProducto1[0] = "prod_id";
          vectorProducto1[0] = "prod_nom";
          vectorProducto1[1] = "prod_precio";
         // vectorProducto1[3] = "categoria_id";
          vectorProducto1[2] = "estoc_q_min";
           vectorProducto1[3] = "estoc_q_max";
          vectorProducto1[4] = "estoc_actual";
          vectorProducto1[5] = "categoria_nom";
           muestra=new DefaultTableModel(null, vectorProducto1);
//String[] vectorProducto; De otra manera definir el vector

        try {

            st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

               // vectorProducto[0] = String.valueOf(rs.getInt("prod_id"));
                vectorProducto[0] = rs.getString("prod_nom");
                vectorProducto[1] = String.valueOf(rs.getInt("prod_precio"));
                //vectorProducto[3] = String.valueOf(rs.getInt("categoria_id"));
                vectorProducto[2] = String.valueOf(rs.getInt("estoc_q_min"));
                vectorProducto[3] = String.valueOf(rs.getInt("estoc_q_max"));
                vectorProducto[4] = String.valueOf(rs.getInt("estoc_actual"));
                vectorProducto[5] = rs.getString("categoria_nom");
                muestra.addRow(vectorProducto);
            }
        } catch (Exception e) {
        }

        return muestra;
    }

        //Funcion que no devuelve nada y sirve para añadir un producto nuevo a nuestra BD

        public void AnadirProducto (Producte p){
         String sql = "INSERT INTO tbl_producte (prod_nom, prod_precio) VALUES (?,?)";
                PreparedStatement pst = null;
                try {
                    // Creamos el pst, para pasar los parametros a la consulta
                    pst = cn.prepareStatement(sql);
                    //montar tabla para insertar en la bd
                    System.out.println("He llegado aqui");
                    pst.setString(1, p.getProd_nom());
                    pst.setDouble(2, p.getProd_precio());
                    //pst.setDouble(3, p.getPro_stok());
                    // ejecutamos la consulta del pst
                    //pst.executeUpdate();

                    //variable para comprobar que hace la conexion, ya que 'pst.executeUpdate();' devuelve 1 o 0. Falso o verdadero
                    int n = pst.executeUpdate();
                    System.out.println("He llegado aqui2");
                    if (n != 0) {

                        JOptionPane.showMessageDialog(null, "Se han insertado los datos correctamente");

                    } else {
                        JOptionPane.showMessageDialog(null, "No se han insertado los datos");

                    }

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Conexion erronea");
                } finally {
                    try {
                        cn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Conexion no cerrada");
                    }

                }
        }
}