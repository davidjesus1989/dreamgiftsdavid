

package ConectarSql;

import java.sql.*;

public class Connection {
    private static Connection cn;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dreamgifts","root","");
        } catch (Exception e) {
            System.out.println("no conectado: " + e);
        }
        return cn;
    }
    //public static void main(String[] args)  {
        //Connection pruebaCn=Connection.getConnection();
        //if(pruebaCn!=null){
            //System.out.println("conectado");
        //}
    //}

    public com.mysql.jdbc.Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}