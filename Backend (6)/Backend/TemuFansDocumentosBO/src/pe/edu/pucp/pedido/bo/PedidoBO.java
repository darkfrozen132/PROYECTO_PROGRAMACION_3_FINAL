
package pe.edu.pucp.pedido.bo;

import pe.edu.pucp.documento.pedido.model.*;
import pe.edu.pucp.pedido.dao.PedidoDAO;
import pe.edu.pucp.pedido.daoimpl.PedidoDAOImpl;
import pe.edu.pucp.usuario.model.*;

public class PedidoBO {
    private final PedidoDAO daoPedido;
    private Pedido pedido; //compra o venta
    
    public PedidoBO(){
        this.daoPedido = new PedidoDAOImpl();
    }
    
    /* proceso de negocio -> insertar Pedido de Compra a Proveedor
        - id = insertarCompra(1,2,100,18,180)
    */
    public Integer insertarCompra(Integer idUsuario, Integer idEmpleado,double subtotal, double impuesto, double total){
        ponerDatos(Tipo_Pedido.COMPRA,idUsuario,idEmpleado,subtotal,impuesto,total);
        return this.daoPedido.insertar(pedido);
    }
    
    /* proceso de negocio -> insertar Pedido de Venta a Cliente
        - id = insertarVenta(3,2,200,36,236)
    */
    public Integer insertarVenta(Integer idUsuario, Integer idEmpleado,double subtotal, double impuesto, double total){
        ponerDatos(Tipo_Pedido.VENTA,idUsuario,idEmpleado,subtotal,impuesto,total);
        return this.daoPedido.insertar(pedido);
    }
    
    private void ponerDatos(Tipo_Pedido tipo,Integer idUsuario,Integer idEmpleado, double subtotal, double impuesto, double total){
        if(tipo == Tipo_Pedido.COMPRA){
            PedidoCompra pedCompra= new PedidoCompra();
            Proveedor proveedor = new Proveedor();
            proveedor.setIdUsuario(idUsuario);
            pedCompra.setProveedor(proveedor);
            this.pedido = pedCompra;
        }else{
            PedidoVenta pedVenta = new PedidoVenta();
            Cliente cliente = new Cliente();
            cliente.setIdUsuario(idUsuario);
            pedVenta.setCliente(cliente);
            this.pedido = pedVenta;
        }
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        this.pedido.setEmpleado(empleado);
        this.pedido.setTipo_pedido(tipo);
        this.pedido.setSubtotal(subtotal);
        this.pedido.setImpuestos(impuesto);
        this.pedido.setTotal(total);
    }
    
}
