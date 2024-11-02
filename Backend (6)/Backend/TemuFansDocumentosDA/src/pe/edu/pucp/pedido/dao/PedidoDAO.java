
package pe.edu.pucp.pedido.dao;

import java.util.ArrayList;
import pe.edu.pucp.documento.pedido.model.Pedido;

public interface PedidoDAO {
    public Integer insertar(Pedido pedido);
    public Pedido obtenerPorId(Integer idPedido);
}
