
package pe.edu.pucp.TemuFans.test;

import pe.edu.pucp.documento.pedido.model.Estado_Pedido;
import pe.edu.pucp.documento.pedido.model.Pedido;
import pe.edu.pucp.documento.pedido.model.Tipo_Pedido;
import pe.edu.pucp.pedido.bo.PedidoBO;



/**
 *
 * @author Leoncio
 */
public class PedidoTester {
    public static void main (String []args){
        PedidoBO pedido=new PedidoBO();        
        pedido.modificar_pago(10,"PAGADO");
        
    }
}
