
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion { // inicio clase Conexion
    
   Connection conectar= null;
    
        public  Connection ConexionBD(){//inicio clase ConexionBD
        
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conectar = DriverManager.getConnection("jdbc:mysql://localhost/dreamgifts", "root", "");

                JOptionPane.showMessageDialog(null, "Conexion Exitosa");
            } catch (Exception e) {
                System.out.println("No se logro conectar a la BD " + e);

                JOptionPane.showMessageDialog(null, "Conexion Error" + e.getMessage());
            }
            return conectar;

    }

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }// fin clase Conexion
