/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.inventario.model;

import pe.edu.pucp.mercaderia.model.Marca;
import pe.edu.pucp.mercaderia.model.Producto;

/**
 *
 * @author usuario
 */
//Nombre, Stock, Estado_Producto, Precio, FechaRegistro, Direccion, nroTorre, Marca
public class ConsultaStock {
    private Producto producto;
    private Almacen almacen;
    private Torre_Un_Paquete torre;
    private Marca marca;

    public ConsultaStock(Producto producto, Almacen almacen, Torre_Un_Paquete torre, Marca marca) {
        this.producto = producto;
        this.almacen = almacen;
        this.torre = torre;
        this.marca = marca;
    }
    
    public ConsultaStock() {
        this.producto = new Producto();
        this.almacen = new Almacen();
        this.torre = new Torre_Un_Paquete();
        this.marca = new Marca();
    }
    
    public ConsultaStock(Integer idProducto) {
        this.producto = new Producto(idProducto);
        this.almacen = new Almacen();
        this.torre = new Torre_Un_Paquete();
        this.marca = new Marca();
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the almacen
     */
    public Almacen getAlmacen() {
        return almacen;
    }

    /**
     * @param almacen the almacen to set
     */
    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    /**
     * @return the torre
     */
    public Torre_Un_Paquete getTorre() {
        return torre;
    }

    /**
     * @param torre the torre to set
     */
    public void setTorre(Torre_Un_Paquete torre) {
        this.torre = torre;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    
}
