/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.TemuFans.servicios;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.documento.pedido.model.Estado_Pedido;
import pe.edu.pucp.documento.pedido.model.Tipo_Pedido;
import pe.edu.pucp.usuario.BO.ClienteBO;
import pe.edu.pucp.usuario.model.Cliente;
import pe.edu.pucp.pedido.bo.PedidoBO;

/**
 *
 * @author usuario
 */
@WebService(serviceName = "ServicioWS")
public class ServicioWS {
   
    private final ClienteBO clientebo;
    private final PedidoBO pedidobo;
    /**
     * This is a sample web service operation
     */
    public ServicioWS(){
        clientebo= new ClienteBO();
        pedidobo= new PedidoBO();
    }
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "cliente_listarClientes")
    public ArrayList<Cliente> cliente_listarClientes(){
        
        return this.clientebo.listarTodos();
    }
    
    @WebMethod(operationName = "cliente_listarClientesNombreCodigo")
    public ArrayList<Cliente> cliente_listarClientesNombreCodigo(@WebParam(name = "nombre")String nombre, @WebParam(name = "codigo") String codigo){
        
        return this.clientebo.listarTodosNombreCodigo(nombre, codigo);
    }
    @WebMethod(operationName = "pedido_modificarPago")
    public void pedido_modificar_pago(@WebParam(name = "idPedido")Integer idPedido, @WebParam(name = "estado_pedido") String estado_pedido){
        
        
        this.pedidobo.modificar_pago(idPedido,estado_pedido);
    }
}
