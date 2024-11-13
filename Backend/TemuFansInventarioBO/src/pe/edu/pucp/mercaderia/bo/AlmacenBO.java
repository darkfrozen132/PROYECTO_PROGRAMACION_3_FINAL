/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.mercaderia.bo;

import java.util.ArrayList;
import pe.edu.pucp.inventario.model.Almacen;
import pe.edu.pucp.inventario.model.ConsultaStock;
import pe.edu.pucp.mercaderia.dao.AlmacenDAO;
import pe.edu.pucp.mercaderia.daoImpl.AlmacenDAOImpl;

/**
 *
 * @author usuario
 */
public class AlmacenBO {
    private final AlmacenDAO almacenDAO;
    
    public AlmacenBO(){
        this.almacenDAO = new AlmacenDAOImpl();
    }
    
    public ArrayList<Almacen> listarTodos(){
        return this.almacenDAO.listarTodos();
    }
    
    public ArrayList<ConsultaStock> reportePorId(Integer idAlmacen){
        return this.almacenDAO.reportePorId(idAlmacen);
    }
}
