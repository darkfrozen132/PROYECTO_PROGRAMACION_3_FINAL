/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.usuario.dao;

import java.util.ArrayList;
import pe.edu.pucp.usuario.model.Proveedor;

/**
 *
 * @author usuario
 */
public interface ProveedorDAO {
    public Integer insertar(Proveedor proveedor);
    
    public ArrayList<Proveedor> listarPorRucNombre(Proveedor proveedor);
}
