
package pe.edu.pucp.TemuFans.test;

import java.util.ArrayList;
import pe.edu.pucp.documento.pedido.model.Estado_Pedido;
import pe.edu.pucp.documento.pedido.model.Pedido;
import pe.edu.pucp.documento.pedido.model.ResumenHistorialVentas;
import pe.edu.pucp.documento.pedido.model.ResumenPorFecha;
import pe.edu.pucp.documento.pedido.model.Tipo_Pedido;
import pe.edu.pucp.pedido.bo.PedidoBO;



/**
 *
 * @author Leoncio
 */
public class PedidoTester {
    public static void main (String []args){
        /*
        PedidoBO pedido=new PedidoBO();   
//        pedido.modificar_pago(10,"PAGADO");
        ArrayList<ResumenPorFecha> lista = pedido.obtenerResumenPorFecha("2024-10-05", "2024-10-30");
        
        for(ResumenPorFecha res : lista){
            System.out.println(res.getCantPedidos());
            System.out.println(res.getFecha());
            System.out.println(res.getTotal());
            System.out.println("----------------");
        }*/
        
        PedidoBO pedidoBO = new PedidoBO();
        
        // Parámetros de prueba para el historial de ventas
        String fechaInicio = "2024-01-01";
        String fechaFin = "2024-12-12";
        String fechaPagoInicio = "2024-01-01";
        String fechaPagoFin = "2024-12-12";
        String ruc = null;
        String razonSocial = null;
        String metodoPago = "PAGADO";

        ArrayList<ResumenHistorialVentas> listaHistorial = pedidoBO.obtenerHistorialVentasFiltrado(
                fechaInicio, fechaFin, fechaPagoInicio, fechaPagoFin, ruc, razonSocial, metodoPago);

        System.out.println("Resultado del Historial de Ventas:");
        for (ResumenHistorialVentas historial : listaHistorial) {
            System.out.println("ID: " + historial.getId() +
                    ", RUC: " + historial.getRuc() +
                    ", Razón Social: " + historial.getRazonSocial() +
                    ", Fecha Creación: " + historial.getFechaCreacion() +
                    ", Fecha Pago: " + historial.getFechaPago() +
                    ", Método Pago: " + historial.getMetodoPago() +
                    ", Subtotal: " + historial.getSubtotal() +
                    ", IGV: " + historial.getIgv() +
                    ", Total: " + historial.getTotal());
        }
    }
}
