/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.mercaderia.bo;

import java.util.ArrayList;
import pe.edu.pucp.inventario.model.Torre_Un_Paquete;
import pe.edu.pucp.mercaderia.dao.Torre_Un_PaqueteDAO;
import pe.edu.pucp.mercaderia.daoImpl.Torre_Un_PaqueteDAOImpl;

/**
 *
 * @author usuario
 */
public class Torre_Un_PaqueteBO {
    private final Torre_Un_PaqueteDAO torre_Un_PaqueteDAO;
    
    public Torre_Un_PaqueteBO(){
        this.torre_Un_PaqueteDAO = new Torre_Un_PaqueteDAOImpl();
    }
    
    public Torre_Un_Paquete consultarStockProductoPorId(Integer idProducto){
        return this.torre_Un_PaqueteDAO.consultarStockProductoPorId(idProducto);
    }
    
    public ArrayList<Torre_Un_Paquete> listarAlertasDeStock(){
        return this.torre_Un_PaqueteDAO.alertasDeStock();
    }
}
