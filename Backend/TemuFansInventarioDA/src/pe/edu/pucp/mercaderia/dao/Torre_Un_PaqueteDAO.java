/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.mercaderia.dao;

import java.util.ArrayList;
import pe.edu.pucp.inventario.model.ConsultaStock;

/**
 *
 * @author usuario
 */
public interface Torre_Un_PaqueteDAO {
    public ConsultaStock consultarStockProductoPorId(Integer idProducto);
    
    public ArrayList<ConsultaStock> alertasDeStock();
}
