package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Clase para conectar con la base de datos Mysql
public class ConexionBD {

    public static final String BD = "bdcaja";
    public static final String PUERTO = "3306";
    public static final String HOST = "localhost";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "admin";
    public static final String CLASSNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://" + HOST + ":" + PUERTO + "/" + BD;

    public Connection con = null;

    public Connection conexion() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return con;
    }

    public void cerrarConexion() throws SQLException {
        try {
            if (con != null) {
                if (con.isClosed() == false) {
                    con.close();
                }
            }

        } catch (SQLException e) {
            throw e;
        }
    }

    //Prueba que verifica la conexión a la bd(bdcaja) en Mysql
    /*public static void main(String[] args) throws ClassNotFoundException, SQLException 
     {
     ConexionBD c= new ConexionBD();
     if (c.conexion() != null) 
     {
     System.out.println("Exito al conectarse a Mysql");
     }else
     {
     System.out.println("Error al conectarse a Mysql");
     }
     }
     */
}
