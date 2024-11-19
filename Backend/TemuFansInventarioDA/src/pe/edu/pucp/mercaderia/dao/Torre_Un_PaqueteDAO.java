/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.mercaderia.dao;

import java.util.ArrayList;
import pe.edu.pucp.inventario.model.Torre_Un_Paquete;

/**
 *
 * @author usuario
 */
public interface Torre_Un_PaqueteDAO {
    public Torre_Un_Paquete consultarStockProductoPorId(Integer idProducto);
    
    public ArrayList<Torre_Un_Paquete> alertasDeStock();
}
