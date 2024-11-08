/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.mercaderia.dao;

import java.util.ArrayList;
import pe.edu.pucp.mercaderia.model.Marca;

/**
 *
 * @author usuario
 */
public interface MarcaDAO {
    public ArrayList<Marca> listarPorNombre(String nombre);
}
