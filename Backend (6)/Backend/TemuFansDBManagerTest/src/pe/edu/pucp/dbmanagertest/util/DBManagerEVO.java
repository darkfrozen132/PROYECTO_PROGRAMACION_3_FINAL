/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.dbmanagertest.util;

import pe.edu.pucp.dbmanager.dbEVO.DBManager;
import java.sql.Connection;

/**
 *
 * @author usuario
 */
public class DBManagerEVO {
    public static void main(String[] args) {
        //instanciación del dbManager
        DBManager dbManager = null;
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);

        //creación de la conexión a la base de datos
        Connection conexion = dbManager.getConnection();        
    }
}
