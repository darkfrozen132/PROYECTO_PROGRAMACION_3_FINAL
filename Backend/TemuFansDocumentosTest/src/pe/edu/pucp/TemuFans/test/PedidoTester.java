
package pe.edu.pucp.TemuFans.test;

import java.util.ArrayList;
import pe.edu.pucp.documento.pedido.model.Estado_Pedido;
import pe.edu.pucp.documento.pedido.model.Pedido;
import pe.edu.pucp.documento.pedido.model.ResumenPorFecha;
import pe.edu.pucp.documento.pedido.model.Tipo_Pedido;
import pe.edu.pucp.pedido.bo.PedidoBO;



/**
 *
 * @author Leoncio
 */
public class PedidoTester {
    public static void main (String []args){
        PedidoBO pedido=new PedidoBO();   
//        pedido.modificar_pago(10,"PAGADO");
        ArrayList<ResumenPorFecha> lista = pedido.obtenerResumenPorFecha("2024-10-05", "2024-10-30");
        
        for(ResumenPorFecha res : lista){
            System.out.println(res.getCantPedidos());
            System.out.println(res.getFecha());
            System.out.println(res.getTotal());
            System.out.println("----------------");
        }
    }
}
