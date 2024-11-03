using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PruebaBootstrap
{
    public partial class Listar_Clientes : System.Web.UI.Page
    {
        private DataTable resumenData;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Cargar los datos al iniciar la página
                resumenData = ObtenerDatosDeResumen();
                ViewState["ResumenData"] = resumenData; // Guardar datos en ViewState
                gvResumen.DataSource = resumenData;
                gvResumen.DataBind();
            }
            else
            {
                resumenData = ViewState["ResumenData"] as DataTable; // Recuperar datos desde ViewState
            }
        }

        private DataTable ObtenerDatosDeResumen()
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("Codigo", typeof(string));
            dt.Columns.Add("Nombre", typeof(string));
            dt.Columns.Add("Fecha Registro", typeof(DateTime));
            dt.Rows.Add("CLI-01", "Bodega San Pedro", DateTime.Parse("02/10/2024"));
            dt.Rows.Add("CLI-02", "Bodega Central", DateTime.Parse("04/10/2024"));
            dt.Rows.Add("CLI-03", "Bodega Los Olivos", DateTime.Parse("05/10/2024"));
            dt.Rows.Add("CLI-04", "Bodega Los Pinos", DateTime.Parse("07/10/2024"));
            dt.Rows.Add("CLI-05", "Bodega San Juan", DateTime.Parse("08/10/2024"));
            dt.Rows.Add("CLI-06", "Bodega Pepito", DateTime.Parse("09/10/2024"));
            dt.Rows.Add("CLI-07", "TITOS", DateTime.Parse("10/10/2024"));
            dt.Rows.Add("CLI-08", "Comercial Valila", DateTime.Parse("11/10/2024"));
            dt.Rows.Add("CLI-09", "AGAPITO", DateTime.Parse("12/10/2024"));
            dt.Rows.Add("CLI-10", "Donde todos vuelven", DateTime.Parse("13/10/2024"));
            dt.Rows.Add("CLI-11", "Donde todos llegan", DateTime.Parse("14/10/2024"));
            dt.Rows.Add("CLI-12", "El pollon", DateTime.Parse("15/10/2024"));
            dt.Rows.Add("CLI-13", "El pollo pechugon", DateTime.Parse("16/10/2024"));
            return dt;
        }

        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            // Obtener los filtros
            string nombre = txtNombre.Text, codigo = txtCodigo.Text;
            System.Console.WriteLine(codigo);
            System.Console.WriteLine(nombre);

            if (codigo == "" || codigo.StartsWith("CLI-"))
            {
                // Filtrar los datos en función de las fechas seleccionadas
                var datosFiltrados = resumenData.AsEnumerable()
                    .Where(row => row.Field<string>("Nombre") == nombre || row.Field<string>("Nombre").Contains(nombre)
                    || row.Field<string>("Codigo") == codigo || row.Field<string>("Codigo").Contains(codigo))
                    .CopyToDataTable();

                // Guardar los datos filtrados en el ViewState para su uso en el RowDataBound y paginación
                ViewState["ResumenDataFiltrada"] = datosFiltrados;

                // Actualizar el GridView con los datos filtrados
                gvResumen.DataSource = datosFiltrados;
                gvResumen.DataBind();  // Ahora el RowDataBound se ejecutará correctamente con los datos filtrados
            }
            else
            {
                // Mostrar un mensaje si el codigo no es válido
                Response.Write("<script>alert('Por favor ingrese un codigo válido');</script>");
            }
        }


        protected void gvResumen_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvResumen.PageIndex = e.NewPageIndex;
            gvResumen.DataSource = ViewState["ResumenDataFiltrada"] as DataTable ?? ViewState["ResumenData"] as DataTable; // Recuperar los datos filtrados o completos
            gvResumen.DataBind();
        }

        protected void gvResumen_RowDataBound(object sender, GridViewRowEventArgs e)
        {


        }
    }
}