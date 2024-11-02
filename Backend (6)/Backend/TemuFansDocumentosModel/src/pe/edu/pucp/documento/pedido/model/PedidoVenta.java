
package pe.edu.pucp.documento.pedido.model;

import pe.edu.pucp.usuario.model.Cliente;

public class PedidoVenta extends Pedido{
    private Cliente cliente;
    
    public PedidoVenta(){
        super();
        this.cliente = null;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
