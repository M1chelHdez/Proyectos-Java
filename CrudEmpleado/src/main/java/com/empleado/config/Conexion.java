package com.empleado.config;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private static final Logger LOGGER = Logger.getLogger(Conexion.class.getName());

    public static final String username = "sistemas";
    public static final String password = "sistemas";
    public static final String database = "bdempleado";
    public static final String url = "jdbc:mysql://localhost:3306/" + database;

    public static Connection getConnection() {
        Connection cn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, username, password);
            LOGGER.info("Conexión establecida");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cn;
    }
}
