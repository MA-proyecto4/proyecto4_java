
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Categoria;
import Modelo.Conexion;
import Modelo.Producte;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
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
    //Funcion que nos devuelve un DefaultTableModel y se ejecuta al inicio de la vista, de forma que nos pinta los datos en la tabla.
        public DefaultTableModel mostrarTabla() {
          DefaultTableModel muestra = null;
          //Consulta que engloba la tabla producto,categoria y estoc para mostrar los datos
          String sql = "SELECT * FROM `tbl_producte` LEFT JOIN `tbl_categoria` ON `tbl_producte`.`categoria_id`=`tbl_categoria`.`categoria_id`;";
          Statement st = null;
          String vectorProducto[] = new String[6];
          String vectorProducto1[] = new String[6];
          //vectorProducto1[0] = "prod_id";
          vectorProducto1[0] = "prod_nom";
          vectorProducto1[1] = "prod_precio";
         // vectorProducto1[3] = "categoria_id";
          vectorProducto1[2] = "prod_estoc_minim";
           vectorProducto1[3] = "prod_estoc_max";
          vectorProducto1[4] = "prod_estoc_actual";
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
                vectorProducto[2] = String.valueOf(rs.getInt("prod_estoc_minim"));
                vectorProducto[3] = String.valueOf(rs.getInt("prod_estoc_max"));
                vectorProducto[4] = String.valueOf(rs.getInt("prod_estoc_actual"));
                vectorProducto[5] = rs.getString("categoria_nom");
                muestra.addRow(vectorProducto);
            }
        } catch (Exception e) {
        }

        return muestra;
    }

        //Funcion que no devuelve nada y sirve para añadir un producto nuevo a nuestra BD

        public void AnadirProducto (Producte p){
             //1. conectarme
               // Conexion conectar = new Conexion();
                //Connection cn = conectar.conec();
                 String sql = "INSERT INTO `tbl_producte` (`prod_nom`,  `prod_precio`, `categoria_id`, `prod_estoc_actual`, `prod_estoc_minim`, `prod_estoc_max`) VALUES (?, ?, '1', ?, ?, ?);;";
                PreparedStatement pst = null;
                try {
                    
                    // Creamos el pst, para pasar los parametros a la consulta
                    pst = cn.prepareStatement(sql);
                    //montar tabla para insertar en la bd
                    System.out.println("He llegado aqui");
                        pst.setString(1, p.getProd_nom());
                        pst.setDouble(2, p.getProd_precio());
                        pst.setInt(3, p.getCategoria());
                        pst.setInt(4, p.getProd_estoc_actual());
                        pst.setInt(5, p.getProd_estoc_minim());
                        pst.setInt(6, p.getProd_estoc_max());
                        
                    
                      System.out.println("Y ahora Aquí 2");
                                    
                        pst.executeUpdate();

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
        //Selecciona los datos de categoria y rellena el combo box
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

                     value.addElement(new Categoria(rs.getInt("categoria_id"),rs.getString("categoria_nom")));

                    }
                    cn.close();
                } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, "Conexion erronea");

                }
        }
      

        
}
