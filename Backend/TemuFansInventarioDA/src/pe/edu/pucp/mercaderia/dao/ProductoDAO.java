/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.mercaderia.dao;

import java.util.ArrayList;
import pe.edu.pucp.mercaderia.model.Producto;

/**
 *
 * @author usuario
 */
public interface ProductoDAO {
    Integer insertarProducto(Producto producto);
    
    void modificarProducto(Producto producto);
    
    void eliminarProducto(Producto producto);
    
    public ArrayList<Producto> listarFiltrado(String nombre,Integer idMarca);
    
    public Producto obtenerPorId(Integer idProducto);
}
