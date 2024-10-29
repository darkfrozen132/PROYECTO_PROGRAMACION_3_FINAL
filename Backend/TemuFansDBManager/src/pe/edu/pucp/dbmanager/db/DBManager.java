package pe.edu.pucp.dbmanager.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import pe.edu.pucp.dbmanager.util.Cifrado;

public class DBManager {

    private static final String ARCHIVO_CONFIGURACION = "jdbc.properties";

    private Connection conexion;
    private String driver;
    private String tipo_de_driver;
    private String base_de_datos;
    private String nombre_de_host;
    private String puerto;
    private String usuario;
    private String contraseña;
    private static DBManager dbManager;
    
    private DBManager(){
        //se hace el constructor privado para que no pueda ser invocado
    }

    public static DBManager getInstance() {
        if (DBManager.dbManager == null) {
            createInstance();
        }
        return DBManager.dbManager;
    }

    private static void createInstance() {
        if (DBManager.dbManager == null) {
            DBManager.dbManager = new DBManager();
        }
    }

    public Connection getConnection() {
        try {
            leer_archivo_de_propiedades();
            Class.forName(this.driver);
            this.conexion = DriverManager.getConnection(getURL(), this.usuario, Cifrado.descifrarMD5(this.contraseña));
        } catch (ClassNotFoundException ex) {
            System.err.println("Error al generar la conexión - " + ex);
        } catch (SQLException ex) {
            System.err.println("Error al generar la conexión - " + ex);
        }
        return conexion;
    }

    private String getURL() {
        String url = tipo_de_driver.concat("://");
        url = url.concat(this.nombre_de_host);
        url = url.concat(":");
        url = url.concat(this.puerto);
        url = url.concat("/");
        url = url.concat(this.base_de_datos);        
        return url;
    }

    private void leer_archivo_de_propiedades() {
        Properties properties = new Properties();
        try {
            //el siguiente código ha sido probado en Windows
            //el archivo de configuración se encuentra en la carpeta resources/jdbc.properties
            //del proyecto que lo invoca
            String nmArchivoConf = "resources" + "/" + ARCHIVO_CONFIGURACION;

            properties.load(new FileInputStream(new File(nmArchivoConf)));
            this.driver = properties.getProperty("driver");
            this.tipo_de_driver = properties.getProperty("tipo_de_driver");
            this.base_de_datos = properties.getProperty("base_de_datos");
            this.nombre_de_host = properties.getProperty("nombre_de_host");
            this.puerto = properties.getProperty("puerto");
            this.usuario = properties.getProperty("usuario");
            this.contraseña = properties.getProperty("contrasenha");
        } catch (FileNotFoundException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        }
    }

}