/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.detallepedido.dao;

import java.util.ArrayList;
import pe.edu.pucp.documento.pedido.model.DetallePedido;

/**
 *
 * @author usuario
 */
public interface DetPedDAO {
    public ArrayList<DetallePedido> listarLineasDePedido(Integer id);
    
    public Integer insertar(DetallePedido det);
    
    public void insertarPorLote(ArrayList<DetallePedido> detalles);
}
