
package pe.edu.pucp.pedido.dao;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.documento.pedido.model.Estado_Pedido;
import pe.edu.pucp.documento.pedido.model.Pedido;
import pe.edu.pucp.documento.pedido.model.ResumenPorFecha;
import pe.edu.pucp.documento.pedido.model.Tipo_Pedido;

public interface PedidoDAO {
    public Integer insertar(Tipo_Pedido tipo,Pedido pedido);
    public Pedido obtenerPorId(Integer idPedido);
    public void modificar_pago(Integer idPedido,String estado);
    public ArrayList<ResumenPorFecha>listarResumen(Date fechaInicio, Date fechaFin);

}
