/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.detallepedido.bo;

import java.util.ArrayList;
import pe.edu.pucp.detallepedido.dao.DetPedDAO;
import pe.edu.pucp.detallepedido.daoImpl.DetPedDAOImpl;
import pe.edu.pucp.documento.pedido.model.DetallePedido;

/**
 *
 * @author usuario
 */
public class DetallePedidoBO {
    private DetPedDAO detallePedidoDAO;

    public DetallePedidoBO(){
        this.detallePedidoDAO = new DetPedDAOImpl();
    }

    //arraylist de lineas de un pedido
    public ArrayList<DetallePedido> listarLineasDePedido(Integer id){
        return this.detallePedidoDAO.listarLineasDePedido(id);
    }

    public Integer insertarLineaPedido(DetallePedido det){
        return this.detallePedidoDAO.insertar(det);
    }

    //insertar una linea de pedido por lote
    public void insertarPorLoteLineaPed(ArrayList<DetallePedido> detalles){
        this.detallePedidoDAO.insertarPorLote(detalles);
    }
}
