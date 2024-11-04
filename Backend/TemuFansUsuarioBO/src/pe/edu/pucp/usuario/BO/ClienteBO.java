/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.usuario.BO;

import java.util.ArrayList;
import pe.edu.pucp.usuario.dao.ClienteDAO;
import pe.edu.pucp.usuario.daoImpl.ClienteDAOImpl;
import pe.edu.pucp.usuario.model.Cliente;

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
    
}
