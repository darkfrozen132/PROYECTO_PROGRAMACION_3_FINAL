
import java.util.ArrayList;
import pe.edu.pucp.usuario.BO.ClienteBO;
import pe.edu.pucp.usuario.BO.ProveedorBO;
import pe.edu.pucp.usuario.model.Cliente;
import pe.edu.pucp.usuario.model.Proveedor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author usuario
 */
public class prueba {

    public static void main(String[] args) {
        ProveedorBO provBO = new ProveedorBO();
        
        for(Proveedor prov : provBO.listarPorNombreRuc("", null)){
            System.out.println("RUC: " + prov.getDoi());
            System.out.println("Nombre: " + prov.getNombre());
            System.out.println("FechaRegistro: " + prov.getFecha_registro().toString());
            System.out.println("---------------------------");
        }
        
        
//        if(provBO.insertar("1912910", "BoTest@gmail.com", "Proveedor ASIA") <= 0){
//            System.out.println("Error al registrar proveedor");
//        }
//        System.out.println("Registrado con exito el proveedor");
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
        
        ClienteBO clientebo = new ClienteBO();
        ArrayList<Cliente> lista = clientebo.buscarCliente("MICH");
        
        for(Cliente cli : lista){
            System.out.println("IdCliente: " + cli.getIdCliente());
            System.out.println("IdUsuario:  " + cli.getIdUsuario());
            System.out.println("Nombre " + cli.getNombre());
            System.out.println("---------------------------");
        }*/
        /*
        ClienteBO clientebo = new ClienteBO();
        if (clientebo.existeCliente("111")) {
            System.out.println("Lo encontre");
        } else {
            System.out.println("No existe");
        }
        
        if (clientebo.existeCliente("70941145")) {
            System.out.println("Lo encontre");
        } else {
            System.out.println("No existe");
        }*/
        
        
    }
}
