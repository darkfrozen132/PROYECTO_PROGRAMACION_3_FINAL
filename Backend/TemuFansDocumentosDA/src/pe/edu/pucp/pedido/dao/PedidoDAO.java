
package pe.edu.pucp.pedido.dao;

import java.util.ArrayList;
import pe.edu.pucp.documento.pedido.model.PagoPedidoCliente;
import pe.edu.pucp.documento.pedido.model.Pedido;
import pe.edu.pucp.documento.pedido.model.ResumenHistorialVentas;
import pe.edu.pucp.documento.pedido.model.ResumenPorFecha;
import pe.edu.pucp.documento.pedido.model.Tipo_Pedido;

public interface PedidoDAO {
    public Integer insertar(Tipo_Pedido tipo,Pedido pedido);
    
    public Pedido obtenerPorId(Integer idPedido);
    
    public void modificar_pago(Integer idPedido,String estado);
    
    public ArrayList<ResumenPorFecha>listarResumen(String fechaInicio, String fechaFin);
    
    // Nuevo método para listar el historial de ventas filtrado - Jairo
    public ArrayList<ResumenHistorialVentas> listarResumenHistorialVentas(
        String fechaInicio, String fechaFin, String ruc, String razonSocial, 
        String metodoPago, String fechaPagoInicio, String fechaPagoFin);
    
    public ArrayList<PagoPedidoCliente> listarPago(String fechaInicio, String fechaFin);
}
