using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TemuFansBO.ServicioWS;
using TemuFansUsuarioBO;

namespace TemuFansUsuarioTest
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ClienteBO clienteBO = new ClienteBO();

            BindingList<cliente> lista = clienteBO.buscarCliente("MICH");

            foreach (cliente cli in lista)
            {
                System.Console.WriteLine("IdCliente: " + cli.idCliente);
                System.Console.WriteLine("IdUsuario:  " + cli.idUsuario);
                System.Console.WriteLine("Nombre " + cli.nombre);
                System.Console.WriteLine("---------------------------");
                
            }

            System.Console.ReadLine();
        }
    }
}
