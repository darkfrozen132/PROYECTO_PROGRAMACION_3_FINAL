/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.usuario.BO;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.usuario.dao.ClienteDAO;
import pe.edu.pucp.usuario.daoImpl.ClienteDAOImpl;
import pe.edu.pucp.usuario.model.Cliente;
import pe.edu.pucp.usuario.model.Tipo_Usuario;
import pe.edu.pucp.usuario.model.Tipo_Doi;

/**
 *
 * @author usuario
 */
public class ClienteBO {
    private final ClienteDAO clienteDAO;
    
    public ClienteBO(){
        this.clienteDAO = new ClienteDAOImpl();
    }   
    public ArrayList<Cliente> listarTodos(){
        return clienteDAO.listarTodos();
    }

    public ArrayList<Cliente> listarTodosNombreCodigo(String nombre, String codigo){
        return clienteDAO.listarTodosNombreCodigo(nombre, codigo);
    }

    public Integer insertarCliente(Tipo_Usuario tipo_usuario, String doi, Tipo_Doi tipo_doi,
            String correo, Date fechaRegistro, String nombre, String telefono){
        Cliente cliente = new Cliente(null, tipo_usuario, doi, tipo_doi, correo, 
                fechaRegistro, nombre, null, telefono);
        return this.clienteDAO.insertar(cliente);
    }
}
