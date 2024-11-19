/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.usuario.BO;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.usuario.dao.ProveedorDAO;
import pe.edu.pucp.usuario.daoImpl.ProveedorDAOImpl;
import pe.edu.pucp.usuario.model.Proveedor;
import pe.edu.pucp.usuario.model.Tipo_Doi;
import pe.edu.pucp.usuario.model.Tipo_Usuario;

/**
 *
 * @author usuario
 */
public class ProveedorBO {
    private final ProveedorDAO provedorDAO;
    
    public ProveedorBO(){
        this.provedorDAO = new ProveedorDAOImpl();
    }
    
    public Integer insertar(String doi, String correo, String nombre){
        Proveedor prov = new Proveedor();
        prov.setCorreo(correo);
        prov.setNombre(nombre);
        prov.setDoi(doi);
        prov.setFecha_registro(new Date());
        
        return this.provedorDAO.insertar(prov);
    }
    
    public ArrayList<Proveedor> listarPorNombreRuc(String doi, String nombre){
        Proveedor prov = new Proveedor();
        prov.setDoi(doi);
        prov.setNombre(nombre);
        
        return this.provedorDAO.listarPorRucNombre(prov);
    }
}
