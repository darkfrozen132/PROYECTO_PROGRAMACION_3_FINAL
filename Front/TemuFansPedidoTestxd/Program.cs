using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using TemuFansBO.ServicioWS;
using TemuFansDocumentosBO;
using TemuFansUsuarioBO;

namespace TemuFansPedidoTestxd
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //testListarClientes();

          //  PedidoBO pedidoBO=new PedidoBO();
         //pedidoBO.modificar_pago(17, "CANCELADO");
            ClienteBO clientebo=new ClienteBO();
            //int a = clientebo.insertarCliente("CLIENTE", "6515621", "DNI", "aASD@pucp.edu.pe", "2024-11-06", "MICHAEL JACKSON2", "987612342");
           System.Console.WriteLine( );
        }

        public static void testListarClientes()
        {
            ClienteBO clienteBO = new ClienteBO();
            BindingList<cliente> clientes = clienteBO.listarTodos();

            for (int i = 0; i < clientes.Count; i++)
            {
                System.Console.WriteLine(string.Concat("CLI-", clientes[i].idCliente)); //+ clientes[i].nombre + clientes[i].fecha_registro.ToString);
                System.Console.WriteLine(clientes[i].nombre);
                System.Console.WriteLine(clientes[i].fecha_registro);
            }

            System.Console.WriteLine(Boolean.Parse(Boolean.TrueString));
            System.Console.ReadLine();
        }
        

    }
}
