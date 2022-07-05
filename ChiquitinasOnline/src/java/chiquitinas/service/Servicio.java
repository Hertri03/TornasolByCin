
package chiquitinas.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Servicio {
    Connection conexion = null;

    private void conectar() {

        try {
            //Paso 1 (Registrar)
            Class.forName("com.mysql.jdbc.Driver");

            try {
            //Paso 2 (Conectar)
                this.conexion = DriverManager.getConnection("\"jdbc:mysql://localhost:3306/proyecto2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC\", \"root\", \"adminadmin\"");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
    
    protected Connection getConexion(){
        try {
            if(this.conexion == null || this.conexion.isClosed()) {
                this.conectar();
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return this.conexion;
    }
    
    public void desconectar() {
        
    try {
        if(conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }  catch (SQLException ex) { 
       ex.printStackTrace();
    }
    }
}
