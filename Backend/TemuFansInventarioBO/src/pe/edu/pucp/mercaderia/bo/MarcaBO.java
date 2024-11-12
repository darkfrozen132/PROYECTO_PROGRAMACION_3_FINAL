/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.mercaderia.bo;

import java.util.ArrayList;
import pe.edu.pucp.mercaderia.dao.MarcaDAO;
import pe.edu.pucp.mercaderia.daoImpl.MarcaDAOImpl;
import pe.edu.pucp.mercaderia.model.Marca;

/**
 *
 * @author usuario
 */
public class MarcaBO {
    private final MarcaDAO daoMarca;

    public MarcaBO(){
        this.daoMarca = new MarcaDAOImpl();
    }

    public ArrayList<Marca> listarPorNombre(String nombre){
        return this.daoMarca.listarPorNombre(nombre);
    }
    
    public ArrayList<Marca> listarMarcas(){
        return this.daoMarca.listarMarcas();
    }
}
