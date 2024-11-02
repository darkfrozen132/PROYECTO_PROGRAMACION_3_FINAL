
package pe.edu.pucp.documento.pedido.model;

import pe.edu.pucp.usuario.model.Proveedor;

public class PedidoCompra extends Pedido{
    private Proveedor proveedor;
    
    public PedidoCompra(){
        super();
        this.proveedor = null;
    }

    /**
     * @return the proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
}
