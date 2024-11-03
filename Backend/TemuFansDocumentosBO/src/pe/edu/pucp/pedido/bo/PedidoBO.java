
package pe.edu.pucp.pedido.bo;

import pe.edu.pucp.documento.pedido.model.*;
import pe.edu.pucp.usuario.model.*;
import pe.edu.pucp.pedido.dao.PedidoDAO;
import pe.edu.pucp.pedido.daoimpl.PedidoDAOImpl;

public class PedidoBO {
    private final PedidoDAO daoPedido;
    private Pedido pedido; //compra o venta
    private Tipo_Pedido tipo;
    
    public PedidoBO(){
        this.daoPedido = new PedidoDAOImpl();
    }
    
    /* proceso de negocio -> insertar Pedido de Compra a Proveedor
        - id = insertarCompra(1,2,100,18,180)
    */
    public Integer insertarCompra(Integer idUsuario, Integer idEmpleado,double subtotal, double impuesto, double total){
        this.tipo = Tipo_Pedido.COMPRA;
        ponerDatos(idUsuario,idEmpleado,subtotal,impuesto,total);
        return this.daoPedido.insertar(this.tipo,pedido);
    }
    
    /* proceso de negocio -> insertar Pedido de Venta a Cliente
        - id = insertarVenta(3,2,200,36,236)
    */
    public Integer insertarVenta(Integer idUsuario, Integer idEmpleado,double subtotal, double impuesto, double total){
        this.tipo = Tipo_Pedido.VENTA;
        ponerDatos(idUsuario,idEmpleado,subtotal,impuesto,total);
        return this.daoPedido.insertar(this.tipo,pedido);
    }
    
    private void ponerDatos(Integer idUsuario, Integer idEmpleado,double subtotal, double impuesto, double total){
        this.pedido = new Pedido(this.tipo);
        if(this.tipo == Tipo_Pedido.COMPRA){
            //usuario es Proveedor
            Proveedor prov = new Proveedor();
            prov.setIdUsuario(idUsuario);
            this.pedido.setUsuario(prov);
        }
        else{
            //usuario es Cliente
            Cliente cliente = new Cliente();
            cliente.setIdUsuario(idUsuario);
            this.pedido.setUsuario(cliente);
        }
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        this.pedido.setEmpleado(empleado);
        this.pedido.setSubtotal(subtotal);
        this.pedido.setImpuestos(impuesto);
        this.pedido.setTotal(total);
    }
    
    public Pedido obtenerPorId(Integer id){
        this.pedido = this.daoPedido.obtenerPorId(id);
        return this.pedido;
    }
    
}
