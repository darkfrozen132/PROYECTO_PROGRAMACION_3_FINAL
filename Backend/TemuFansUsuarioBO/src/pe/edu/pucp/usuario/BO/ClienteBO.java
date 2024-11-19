/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.usuario.BO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.usuario.dao.ClienteDAO;
import pe.edu.pucp.usuario.daoImpl.ClienteDAOImpl;
import pe.edu.pucp.usuario.model.Cliente;
import pe.edu.pucp.usuario.model.Tipo_Doi;
import pe.edu.pucp.usuario.model.Tipo_Usuario;

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
    
    public ArrayList<Cliente> buscarCliente(String nombre){
        return clienteDAO.listarPorNombre(nombre);
    }

    public Integer insertarCliente(String tipo_usuario, String doi, String tipo_doi,
            String correo, String fechaRegistro, String nombre, String telefono) throws ParseException{
        
        
        Tipo_Usuario tipUs = Tipo_Usuario.valueOf(tipo_usuario);
        Tipo_Doi tipDoi = Tipo_Doi.valueOf(tipo_doi);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = sdf.parse(fechaRegistro);
        
        Cliente cliente = new Cliente(null, tipUs, doi, tipDoi, correo, 
                fecha, nombre, null, telefono);
        
//        Cliente cliente = new Cliente(tipo_usuario, doi, tipo_doi, correo, 
//                fechaRegistro, nombre, telefono);
        
        return this.clienteDAO.insertar(cliente);
    }
    
    public boolean existeCliente(String doi){
        return this.clienteDAO.existeCliente(doi);
    }
    
    public Cliente obtenerPorId(Integer idCliente){
        return this.clienteDAO.obtenerPorId(idCliente);
    }
}
