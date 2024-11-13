/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.mercaderia.dao;

import java.util.ArrayList;
import pe.edu.pucp.inventario.model.Almacen;
import pe.edu.pucp.inventario.model.ConsultaStock;

/**
 *
 * @author usuario
 */
public interface AlmacenDAO {
    public ArrayList<Almacen> listarTodos();
    
    public ArrayList<ConsultaStock> reportePorId(Integer idAlmacen);
}
