using System;
using System.Collections.Generic;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PruebaBootstrap.Almacen
{
    public partial class reporteAlmacen : System.Web.UI.Page
    {
        // Clase Almacen que contiene los datos de los almacenes
        public class Almacen
        {
            public int Id { get; set; }
            public string Nombre { get; set; }
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Cargar los nombres de los almacenes en los CheckBox
                CargarNombresAlmacenes();
            }

        }

        // Método que carga los nombres de los almacenes en los labels de los CheckBox
        private void CargarNombresAlmacenes()
        {
            List<Almacen> almacenes = ObtenerAlmacenes();

            // Asignar los nombres de los almacenes al CheckBoxList
            almacenesCheckBoxList.DataSource = almacenes;
            almacenesCheckBoxList.DataTextField = "Nombre";
            almacenesCheckBoxList.DataValueField = "Id";
            almacenesCheckBoxList.DataBind();
        }

        // Método que devuelve la lista de almacenes
        private List<Almacen> ObtenerAlmacenes()
        {
            // Aquí deberías obtener la lista de almacenes de una base de datos o fuente de datos
            return new List<Almacen>
            {
                new Almacen { Id = 1, Nombre = "Almacén Principal" },
                new Almacen { Id = 2, Nombre = "Almacén Secundario" }
            };
        }

        // Evento al hacer clic en el botón de "Seleccionar Todos"
        protected void btnSelectAll_Click(object sender, EventArgs e)
        {
            bool selectAll = true;

            // Verificar si todos ya están seleccionados
            foreach (ListItem item in almacenesCheckBoxList.Items)
            {
                if (!item.Selected)
                {
                    selectAll = false;
                    break;
                }
            }

            // Si todos están seleccionados, desmarcamos todos, si no, seleccionamos todos
            foreach (ListItem item in almacenesCheckBoxList.Items)
            {
                item.Selected = !selectAll;
            }

            // Cambiar el texto del botón según el estado
            btnSelectAll.Text = selectAll ? "Seleccionar Todos" : "Deseleccionar Todos";
        }
        protected void almacenesCheckBoxList_SelectedIndexChanged(object sender, EventArgs e)
        {
            /*
            bool allSelected = true;

            // Verificar si todos los almacenes están seleccionados
            foreach (ListItem item in almacenesCheckBoxList.Items)
            {
                if (!item.Selected)
                {
                    allSelected = false;
                    break;
                }
            }

            // Si todos están seleccionados, marcar "Seleccionar todos"
            chkSelectAll.Checked = allSelected;
            */
        }

        // Método para el botón de imprimir
        protected void Button1_Click(object sender, EventArgs e)
        {
            // Aquí puedes manejar la lógica para generar el reporte con los almacenes seleccionados
            List<int> almacenesSeleccionados = new List<int>();

            foreach (ListItem item in almacenesCheckBoxList.Items)
            {
                if (item.Selected)
                {
                    almacenesSeleccionados.Add(int.Parse(item.Value));
                }
            }
            // Lógica para generar el reporte con almacenes seleccionados
            GenerarReporte(almacenesSeleccionados);
        }

        // Método para generar el reporte
        private void GenerarReporte(List<int> almacenesSeleccionados)
        {
            if (almacenesSeleccionados.Count == 2)
            {
                Response.Write("Generando reporte para Almacén 1 y Almacén 2...");
            }
            else if (almacenesSeleccionados.Count == 1)
            {
                Response.Write($"Generando reporte para Almacén {almacenesSeleccionados[0]}...");
            }
            else
            {
                Response.Write("No hay almacenes seleccionados.");
            }
        }
    }
}
