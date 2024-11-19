using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Web;
using System.Web.Services;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemuFansBO.ServicioWS;
using TemuFansInventarioBO;

namespace PruebaBootstrap.Almacen
{
    public partial class AsignarProductoEnTorre : System.Web.UI.Page
    {
        private AlmacenBO almacenBO = new AlmacenBO();
        private Torre_Un_PaqueteBO torreBO = new Torre_Un_PaqueteBO();

        private static List<Producto> Productos = new List<Producto>
        {
            new Producto { Id = 1, Nombre = "Producto A", Descripcion = "Descripción del Producto A" },
            new Producto { Id = 2, Nombre = "Producto B", Descripcion = "Descripción del Producto B" },
            new Producto { Id = 3, Nombre = "Producto C", Descripcion = "Descripción del Producto C" },
            new Producto { Id = 4, Nombre = "Producto D", Descripcion = "Descripción del Producto D" },
            new Producto { Id = 5, Nombre = "Producto Especial", Descripcion = "Un producto especial con características avanzadas" },
            new Producto { Id = 6, Nombre = "Producto Extra", Descripcion = "Producto adicional para pruebas" },
            new Producto { Id = 7, Nombre = "Jaguer 1UND ", Descripcion = "Producto adicional para pruebas" },
            new Producto { Id = 8, Nombre = "Jaguer 5UND", Descripcion = "Producto adicional para pruebas" },
            new Producto { Id = 9, Nombre = "Monster 10UND", Descripcion = "Producto adicional para pruebas" }
        };

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarAlmacenes();
                CargarTorres(1); // Cargar torres del primer almacén por defecto
            }
        }

        private void CargarAlmacenes()
        {
            // Simulación de datos de almacenes
            BindingList<almacen> almacenes = almacenBO.listarTodos();
            //            List<Almacen> almacenes = ObtenerAlmacenes();
            
            ddlAlmacenes.DataSource = almacenes;
            ddlAlmacenes.DataTextField = "direccion";
            ddlAlmacenes.DataValueField = "idAlmacen";
            ddlAlmacenes.DataBind();
        }

        /*private List<Almacen> ObtenerAlmacenes()
        {
            // Simulación de almacenes
            return new List<Almacen>
            {
                new Almacen { Id = 1, Nombre = "Almacén Central" },
                new Almacen { Id = 2, Nombre = "Almacén Norte" },
                new Almacen { Id = 3, Nombre = "Almacén Sur" }
            };
        }*/

        private void CargarTorres(int almacenId)
        {
            // Obtener las torres según el almacén seleccionado
            BindingList<consultaStock> torres = almacenBO.listarTorresPorAlmacen(almacenId);
//            List<Torre> torres = ObtenerTorresPorAlmacen(almacenId);

            // Generar el HTML dinámico
            System.Text.StringBuilder html = new System.Text.StringBuilder();
            foreach (consultaStock con in torres)
            {
                string clase = con.torre.estado ? "INACTIVO" : "ACTIVO";
                html.Append($@"
                    <div class='grid-item {clase}' 
                         onclick='openModal({con.torre.idTorre_Un_Paquete}, {(con.torre.estado ? 1 : 0)})'>
                        Torre {con.torre.nro_torre}
                    </div>");
            }

            // Asignar el HTML generado al Literal
            litTorres.Text = html.ToString();
        }

        private List<Torre> ObtenerTorresPorAlmacen(int almacenId)
        {
            // Simulación de torres por almacén
            if (almacenId == 1)
            {
                return new List<Torre>
                {
                    new Torre { Id = 1, Nombre = "T1", Estado = false },
                    new Torre { Id = 2, Nombre = "T2", Estado = true },
                    new Torre { Id = 3, Nombre = "T3", Estado = false }
                };
            }
            else if (almacenId == 2)
            {
                return new List<Torre>
                {
                    new Torre { Id = 4, Nombre = "T4", Estado = false },
                    new Torre { Id = 5, Nombre = "T5", Estado = true }
                };
            }
            else
            {
                return new List<Torre>
                {
                    new Torre { Id = 6, Nombre = "T6", Estado = true },
                    new Torre { Id = 7, Nombre = "T7", Estado = false },
                    new Torre { Id = 8, Nombre = "T8", Estado = false }
                };
            }
        }

        protected void ddlAlmacenes_SelectedIndexChanged(object sender, EventArgs e)
        {
            // Obtener el ID del almacén seleccionado
            int almacenId = int.Parse(ddlAlmacenes.SelectedValue);

            // Cargar las torres correspondientes al almacén
            CargarTorres(almacenId);
        }

        protected void AsignarProducto_Click(object sender, EventArgs e)
        {
            var torreId = Request.Form["idTorre_Un_Paquete"];
            var producto = Request.Form["idProducto"];

            // Lógica para guardar en la base de datos
            GuardarProductoEnTorre(int.Parse(torreId), producto);

            // Recargar la página para reflejar los cambios
            Response.Redirect(Request.RawUrl);
        }

        private void GuardarProductoEnTorre(int torreId, string producto)
        {
            // Aquí se implementa la lógica para guardar el producto en la base de datos
        }

        // Método Web para buscar productos por nombre
        [WebMethod]
        public static List<string> GetProductos(string searchTerm)
        {
            // Filtrar productos según el término de búsqueda
            return Productos
                .Where(p => p.Nombre.IndexOf(searchTerm, StringComparison.OrdinalIgnoreCase) >= 0)
                .Select(p => p.Nombre) // Solo devolvemos los nombres
                .ToList();
        }
    }
    public class Producto
    {
        public int Id { get; set; }
        public string Nombre { get; set; }
        public string Descripcion { get; set; }
    }
    public class Torre
    {
        public int Id { get; set; }
        public string Nombre { get; set; }
        public bool Estado { get; set; } // true: Ocupado, false: Disponible
    }

    public class Almacen
    {
        public int Id { get; set; }
        public string Nombre { get; set; }
    }
}