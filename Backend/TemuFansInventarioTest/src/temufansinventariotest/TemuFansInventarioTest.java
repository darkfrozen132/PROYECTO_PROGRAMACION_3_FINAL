/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package temufansinventariotest;

import pe.edu.pucp.mercaderia.bo.ProductoBO;

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
        ProductoBO prodBO = new ProductoBO();
        
        prodBO.eliminarProducto(2);
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
}
