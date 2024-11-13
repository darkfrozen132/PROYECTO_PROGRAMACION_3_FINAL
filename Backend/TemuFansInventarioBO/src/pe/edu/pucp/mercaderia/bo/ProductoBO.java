/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.mercaderia.bo;

import java.util.ArrayList;
import pe.edu.pucp.mercaderia.dao.ProductoDAO;
import pe.edu.pucp.mercaderia.daoImpl.ProductoDAOImpl;
import pe.edu.pucp.mercaderia.model.Producto;

/**
 *
 * @author usuario
 */
public class ProductoBO {
    private final ProductoDAO productoDAO;
    
    public ProductoBO(){
        this.productoDAO = new ProductoDAOImpl();
    }
    
    public Integer insertarProducto(Double precio, String nombre, String estado, Integer idMarca){
        Producto prod = new Producto(precio, nombre, estado, idMarca);
        return this.productoDAO.insertarProducto(prod);
    }
    
    public void modificarProducto(Integer idProducto, String nombre, String estado, Double precio){
        Producto prod = new Producto(idProducto, precio, nombre, estado);
        this.productoDAO.modificarProducto(prod);
    }
    
    public void eliminarProducto(Integer idProducto){
        Producto prod = new Producto(idProducto);
        this.productoDAO.eliminarProducto(prod);
    }
    
    public ArrayList<Producto> listarFiltrado(String nombre,Integer idMarca){
        return this.productoDAO.listarFiltrado(nombre, idMarca);
    }

    public Producto obtenerPorId(Integer idProducto){
        return this.productoDAO.obtenerPorId(idProducto);
    }
    
    public ArrayList<Producto> listarProductosNombre(){
        return this.productoDAO.listarProductosNombre();
    }
}
