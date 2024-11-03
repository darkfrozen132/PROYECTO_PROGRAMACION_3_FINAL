/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.usuario.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.dbmanager.config.DAOImpl;
import pe.edu.pucp.usuario.dao.ClienteDAO;
import pe.edu.pucp.usuario.model.Cliente;

/**
 *
 * @author usuario
 */
public class ClienteDAOImpl extends DAOImpl implements ClienteDAO {
    private Integer tipoListado;
    private Cliente cliente;
    
    public ClienteDAOImpl(){
        this.tipoListado = 1;
        this.cliente = null;
    }

    @Override
    protected String getProcedure_Insertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String getProcedure_Modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String getProcedure_Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String getProcedure_Listar() {
        switch (this.tipoListado){
            case 1 -> {
                return "ListarClientesMantenimiento";
            }
        }
        
        //nunca se llega aqui, pero por defecto lista todo
        System.out.println("Error al asignar el tipoListado");
        return "ListarClientesMantenimiento";
    }

    @Override
    protected String getProcedure_ObtenerPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamEntrada_Insertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamEntrada_Modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamEntrada_Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamEntrada_Listar() {
        switch(this.tipoListado){
            case 1:
                //no tienen parametros de entrada;
                break;
        }
    }

    @Override
    protected void getParamEntrada_ObtenerPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamSalida_Insertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamSalida_Modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamSalida_Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void setParamSalida_Insertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void setParamSalida_Modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void setParamSalida_Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected Object agregarObjetoALaLista(ResultSet lector) {
        try {
            switch(this.tipoListado){
                case 1 -> {
                    Cliente cli = new Cliente();
                    cli.setNombre(lector.getString("nombre"));
                    cli.setFecha_registro(lector.getDate("fechaRegistro"));
                    String[] cod = lector.getString("codigo").split("-");
                    //logica de asignacion del codgio si por alguna razon el cod tiene "-" incluido
                    //como por ejemplo CLI-GOGO-12
                    int i;
                    String cod_unido = "";
                    for(i=0; i<cod.length - 1; i++){
                        cod_unido += cod[i];
                        if(i<cod.length - 2)cod_unido += "-";
                    }
                    cli.setCodigo(cod_unido);
                    cli.setIdCliente(Integer.valueOf(cod[i]));
                    return cli;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //no deberias de llegar aca, sino hay un error con el tipoListado
        return this.cliente;
    }

    @Override
    protected void instanciarObjetoDelResultSet(ResultSet lector) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> listarTodos() {
        this.tipoListado = 1;
        ArrayList<Cliente> lista = new ArrayList<>();
        for(Object obj : super.listar())
            lista.add((Cliente)obj);
        return lista;
    }
    
}
