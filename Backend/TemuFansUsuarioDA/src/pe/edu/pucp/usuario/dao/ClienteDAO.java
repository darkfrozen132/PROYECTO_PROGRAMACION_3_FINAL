/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.usuario.model.Cliente;

/**
 *
 * @author usuario
 */
public interface ClienteDAO {
    public ArrayList<Cliente> listarTodos();
    
    public ArrayList<Cliente> listarTodosNombreCodigo(String nombre, String codigo);
    
    public int insertar(Cliente cliente);

    public ArrayList<Cliente> listarPorNombre(String nombre);
    
    public boolean existeCliente(String doi);
    
    public Cliente obtenerPorId(Integer idCliente);
}
