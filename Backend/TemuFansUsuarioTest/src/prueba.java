
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
        /*ClienteBO clientebo = new ClienteBO();
        ArrayList<Cliente> lista = clientebo.listarTodos();
        System.out.println("holamundo");
        System.out.println("");
        for(Cliente cli : lista){
            System.out.println(cli.getCodigo() + " " + cli.getNombre());
        }
        
        
        ClienteBO clientebo = new ClienteBO();
        ArrayList<Cliente> lista = clientebo.listarTodosNombreCodigo(null, null);
        System.out.println("holamundo");
        System.out.println("");
        for(Cliente cli : lista){
            System.out.println(cli.getCodigo() + " " + cli.getNombre());
        }
        */
        ClienteBO clientebo = new ClienteBO();
        ArrayList<Cliente> lista = clientebo.buscarCliente("MICH");
        
        for(Cliente cli : lista){
            System.out.println("IdCliente: " + cli.getIdCliente());
            System.out.println("IdUsuario:  " + cli.getIdUsuario());
            System.out.println("Nombre " + cli.getNombre());
            System.out.println("---------------------------");
        }
        
    }
}