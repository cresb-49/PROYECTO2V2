package com.mycompany.proyecto2v2.DBManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    // Librería de MySQL
    private String driver = "com.mysql.jdbc.Driver";
    // Nombre de la base de datos
    private String database = "PROYECTO2";
    // Host
    private String hostname = "localhost";
    // Puerto
    private String port = "3306";
    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?allowPublicKeyRetrieval=true&useSSL=false&&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    // Nombre de usuario
    private String username = "root";
    // Clave de usuario
    private String password = "201931012";
    // conencion de base de datos
    private static Connection conexion = null;

    /**
     * Constructor principal de la clase conexion Genera la conexion de la base
     * de datos al principio
     */
    public ConnectionDB() throws ClassNotFoundException, SQLException {
        //Carga en memoria la clase del driver JDBC, para luego obtener la conexion con el DriveManager
        Class.forName(driver);
        conexion = DriverManager.getConnection(url, username, password);

    }

    /**
     * Retorna la conexion de la base de datos
     *
     * @return
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Cierra la conexion con la base de datos del programa
     *
     * @throws SQLException
     */
    public void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
        }

    }
}
