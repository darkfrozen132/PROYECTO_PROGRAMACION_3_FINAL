
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
        double subtotal = 200;
        double impuesto = 36;
        double total = 236;
        //insertar en la tabla pedido
        Integer nuevoId = pedidoBO.insertarCompra(idUsuario, idEmpleado, subtotal, impuesto, total);
        System.out.println("El nuevo pedido tiene id = " + nuevoId.toString());
    }
}
