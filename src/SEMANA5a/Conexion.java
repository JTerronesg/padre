/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEMANA5a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url="jdbc:mysql://localhost:3306/bdservicios";
    private static final String usuario="root";
    private static final String contrasena="";
    
    //****MÉTODO PARA CONECTAR A LA BS*////
    
    public static Connection conectar(){
        Connection cnx = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx= DriverManager.getConnection(url,usuario,contrasena);
            System.out.println("Conexión Exitosa");
        }
        catch(ClassNotFoundException e )
        {
            System.err.println("Error: No se encontró el driver JDBC");
            e.printStackTrace();
        }
        catch(SQLException e)
        {
          System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return cnx;
    }
    
    //**MÉTODO PARA CERRAR LA CONEXION*//
    
    public static void cerrarConexion(Connection cnx){
        try{
            if(cnx!=null && !cnx.isClosed()){
                cnx.close();
                System.out.println("Conexion cerrada");
            }
        }catch(SQLException e){
            System.err.println("Error al cerrar la conexion" + e.getMessage());
            e.printStackTrace();
        }
    }
}
