
import pe.edu.pucp.documento.pedido.model.Pedido;
import pe.edu.pucp.documento.pedido.model.Tipo_Pedido;
import pe.edu.pucp.usuario.model.*;
import pe.edu.pucp.pedido.bo.PedidoBO;

/**
 *
 * @author rodri
 */
public class TestPedido {
    
    public static void main(String[] args){
        PedidoBO pedidoBO = new PedidoBO();
        
        //insertar en pedido un dato
        Integer idUsuario = 2;
        Integer idEmpleado = 1;
        double subtotal = 300;
        double impuesto = 0.18*subtotal;
        double total = subtotal + impuesto;
        //insertar en la tabla pedido
        Integer nuevoId = pedidoBO.insertarCompra(idUsuario, idEmpleado, subtotal, impuesto, total);
        System.out.println("El nuevo pedido tiene id = " + nuevoId.toString());
        
        
        //obtener por id un pedido
        Pedido pedido = pedidoBO.obtenerPorId(16);
        System.out.println("El id del pedido es : " + pedido.getId_pedido());
        switch (pedido.getTipo_pedido()) {
            case Tipo_Pedido.COMPRA -> { 
                Proveedor prov = (Proveedor) pedido.getUsuario();
                System.out.println("El id del proveedor es : " + prov.getIdProveedor());
            }
            case Tipo_Pedido.VENTA -> { 
                Cliente cli = (Cliente)pedido.getUsuario();
                System.out.println("El id del cliente es: " + cli.getIdCliente());
            }
            default -> System.out.println("Hubo error al obtener el pedido");
        }
        System.out.println("El nombre del usuario es : " + pedido.getUsuario().getNombre());
    }
}
