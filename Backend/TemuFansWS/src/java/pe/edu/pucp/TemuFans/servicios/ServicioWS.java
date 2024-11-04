/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.TemuFans.servicios;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.usuario.BO.ClienteBO;
import pe.edu.pucp.usuario.model.Cliente;

/**
 *
 * @author usuario
 */
@WebService(serviceName = "ClienteWS")
public class ServicioWS {
    private ClienteBO clientebo;
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "cliente_listarClientes")
    public ArrayList<Cliente> cliente_listarClientes(){
        clientebo = new ClienteBO();
        return this.clientebo.listarTodos();
    }
}
