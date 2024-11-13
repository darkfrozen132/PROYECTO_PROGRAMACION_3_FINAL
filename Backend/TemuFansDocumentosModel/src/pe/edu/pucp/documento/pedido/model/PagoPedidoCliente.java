package pe.edu.pucp.documento.pedido.model;

import pe.edu.pucp.usuario.model.Usuario;

/**
 *
 * @author Leoncio
 */
public class PagoPedidoCliente {

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    private Pedido pedido;
    private Usuario usuario;
    public PagoPedidoCliente(){
        this.pedido= new Pedido();
        this.usuario= new Usuario();
    }
    public PagoPedidoCliente(Pedido pedido,Usuario usuario){
        this.pedido=pedido;
        this.usuario=usuario;
    }
}
