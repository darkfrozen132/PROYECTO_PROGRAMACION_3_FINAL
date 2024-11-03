
package pe.edu.pucp.pedido.dao;

import pe.edu.pucp.documento.pedido.model.Pedido;
import pe.edu.pucp.documento.pedido.model.Tipo_Pedido;

public interface PedidoDAO {
    public Integer insertar(Tipo_Pedido tipo,Pedido pedido);
    public Pedido obtenerPorId(Integer idPedido);
}