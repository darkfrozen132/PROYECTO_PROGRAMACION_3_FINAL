
import java.util.ArrayList;
import pe.edu.pucp.usuario.BO.ClienteBO;
import pe.edu.pucp.usuario.model.Cliente;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usuario
 */
public class prueba {
    public static void main(String[] args){
        ClienteBO clientebo = new ClienteBO();
        ArrayList<Cliente> lista = clientebo.listarTodos();
        
        for(Cliente cli : lista){
            System.out.println(cli.getCodigo() + " " + cli.getNombre());
        }
    }
}
