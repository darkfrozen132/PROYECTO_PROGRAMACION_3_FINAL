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
            test_almacen();
            //test_torre();
            /*
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
            */
        }

        private static void test_almacen()
        {
            AlmacenBO almacen = new AlmacenBO();
            BindingList<almacen> list = almacen.listarTodos();

            foreach (almacen item in list)
            {
                System.Console.WriteLine(item.idAlmacen);
                System.Console.WriteLine(item.direccion);
            }

            System.Console.ReadLine();
        }

        private static void test_alerta()
        {
            Torre_Un_PaqueteBO torrebo = new Torre_Un_PaqueteBO();
            BindingList<consultaStock> lista = torrebo.listarAlertasDeStock();

            foreach (consultaStock consulta in lista)
            {
                System.Console.WriteLine("Nombre: " + consulta.producto.nombre);
                System.Console.WriteLine("Marca: " + consulta.marca.nombre);
                System.Console.WriteLine("Direccion: " + consulta.almacen.direccion);
                System.Console.WriteLine("nroTorre: " + consulta.torre.nro_torre);
                System.Console.WriteLine("Stock: " + consulta.torre.cantidad_paquete);
                System.Console.WriteLine("----------------------------------");
            }

            System.Console.ReadLine();
        }

        private static void test_torre()
        {
            Torre_Un_PaqueteBO torre_Un_PaqueteBO = new Torre_Un_PaqueteBO();
            consultaStock consulta = torre_Un_PaqueteBO.consultarStockProductoPorId(1);
            ////Nombre, Stock, Estado_Producto, Precio, FechaRegistro, Direccion, nroTorre, Marca
            System.Console.WriteLine("Nombre: " + consulta.producto.nombre);
            System.Console.WriteLine("Stock: " + consulta.torre.cantidad_paquete);
            System.Console.WriteLine("Estado_Producto: " + consulta.producto.estado.ToString());
            System.Console.WriteLine("Precio: " + consulta.producto.precio);
            System.Console.WriteLine("FechaRegistro: " + consulta.producto.fechaRegistro.ToString());
            System.Console.WriteLine("Direccion: " + consulta.almacen.direccion);
            System.Console.WriteLine("nroTorre: " + consulta.torre.nro_torre);
            System.Console.WriteLine("Marca: " + consulta.marca.nombre);

            System.Console.ReadLine();
        }
    }
}
