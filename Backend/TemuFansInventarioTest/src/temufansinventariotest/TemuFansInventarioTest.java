/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package temufansinventariotest;

import java.util.ArrayList;
import pe.edu.pucp.inventario.model.ConsultaStock;
import pe.edu.pucp.mercaderia.bo.ProductoBO;
import pe.edu.pucp.mercaderia.bo.Torre_Un_PaqueteBO;
import pe.edu.pucp.mercaderia.model.Producto;

/**
 *
 * @author Leoncio
 */
public class TemuFansInventarioTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        test_listarAlertas();
    }
    
    public static void test_insertar(){
        ProductoBO prodBO = new ProductoBO();
        Integer resultado = 0;
        resultado = prodBO.insertarProducto(240.00, "Pack 24 Four Loko Green 473 ml"
                , "ACTIVO", 1);
        
        if(resultado != 0){
            System.out.println("Se inserto correctamente el id " + resultado);
        }else{
            System.out.println("Error al insertar");
        }
    }
    
    public static void test_modificar(){
        ProductoBO prodBO = new ProductoBO();
        
        prodBO.modificarProducto(1, null, "INACTIVO", null);
    }
    
    public static void test_eliminar(){
        ProductoBO prodBO = new ProductoBO();
        
        prodBO.eliminarProducto(2);
    }

    private static void test_listarProductosNombre() {
        ProductoBO prodBO = new ProductoBO();
        
        ArrayList<Producto> lista = prodBO.listarProductosNombre();
        //idProducto, nombre, estado, precio
        for(Producto prod : lista){
            System.out.println("Producto: " + prod.getIdProducto());
            System.out.println("nombre: " + prod.getNombre());
            System.out.println("estado: " + prod.getEstado().toString());
            System.out.println("precio: " + prod.getPrecio());
            System.out.println("-----------------------");
        }
    }

    private static void test_obtenerPorId() {
        ProductoBO prodBO = new ProductoBO();
        
        Producto prod = prodBO.obtenerPorId(1);
        
        System.out.println("El producto seleccionado es: ");
        System.out.println("ID: " + prod.getIdProducto());
        System.out.println("Nombre: " + prod.getNombre());
        System.out.println("Estado: " + prod.getEstado().toString());
        System.out.println("Precio: " + prod.getPrecio());
    }

    private static void test_obtenerPorIdConsultaStock() {
        Torre_Un_PaqueteBO torre_Un_PaqueteBO = new Torre_Un_PaqueteBO();
        ConsultaStock consulta = torre_Un_PaqueteBO.consultarStockProductoPorId(1);
        ////Nombre, Stock, Estado_Producto, Precio, FechaRegistro, Direccion, nroTorre, Marca
        System.out.println("Nombre: " + consulta.getProducto().getNombre());
        System.out.println("Stock: " + consulta.getTorre().getCantidad_paquete());
        System.out.println("Estado_Producto: " + consulta.getProducto().getEstado().toString());
        System.out.println("Precio: " + consulta.getProducto().getPrecio());
        System.out.println("FechaRegistro: " + consulta.getProducto().getFechaRegistro().toString());
        System.out.println("Direccion: " + consulta.getAlmacen().getDireccion());
        System.out.println("nroTorre: " + consulta.getTorre().getNro_torre());
        System.out.println("Marca: " + consulta.getMarca().getNombre());
    }

    private static void test_listarAlertas() {
        Torre_Un_PaqueteBO torrebo = new Torre_Un_PaqueteBO();
        ArrayList<ConsultaStock> lista = torrebo.listarAlertasDeStock();
        
        for(ConsultaStock consulta : lista){
            System.out.println("Nombre: " + consulta.getProducto().getNombre());
            System.out.println("Marca: " + consulta.getMarca().getNombre());
            System.out.println("Direccion: " + consulta.getAlmacen().getDireccion());
            System.out.println("nroTorre: " + consulta.getTorre().getNro_torre());
            System.out.println("Stock: " + consulta.getTorre().getCantidad_paquete());
            System.out.println("----------------------------------");
        }
    }
}
