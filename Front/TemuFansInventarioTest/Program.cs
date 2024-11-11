using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TemuFansBO.ServicioWS;
using TemuFansInventarioBO;

namespace TemuFansInventarioTest
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ProductoBO productoBO = new ProductoBO();

            BindingList<producto> lista = productoBO.listarProductosNombre();

            for (int i = 0; i < lista.Count; i++)
            {
                System.Console.WriteLine("Producto: " + lista[i].idProducto);
                System.Console.WriteLine("nombre: " + lista[i].nombre);
                estado est = lista[i].estado;
                string cad = est.ToString();
                System.Console.WriteLine("estado: " + cad);
                System.Console.WriteLine("precio: " + lista[i].precio);
                System.Console.WriteLine("-----------------------");
            }

            System.Console.ReadLine();
        }
    }
}
