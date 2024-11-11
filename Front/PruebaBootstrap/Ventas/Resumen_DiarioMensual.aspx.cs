using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PruebaBootstrap
{
    public partial class Resumen_DiarioMensual : System.Web.UI.Page
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
            dt.Columns.Add("Fecha", typeof(DateTime));
            dt.Columns.Add("Cantidad de pedidos", typeof(int));
            dt.Columns.Add("Total vendido", typeof(decimal));
            dt.Rows.Add(DateTime.Parse("02/10/2024"), 122, 13567.70m);
            dt.Rows.Add(DateTime.Parse("04/10/2024"), 112, 11567.70m);
            dt.Rows.Add(DateTime.Parse("05/10/2024"), 100, 11000.00m);
            dt.Rows.Add(DateTime.Parse("07/10/2024"), 75, 8700.50m);
            dt.Rows.Add(DateTime.Parse("08/10/2024"), 140, 14500.45m);
            dt.Rows.Add(DateTime.Parse("09/10/2024"), 95, 9800.60m);
            dt.Rows.Add(DateTime.Parse("10/10/2024"), 100, 10000.00m);
            dt.Rows.Add(DateTime.Parse("11/10/2024"), 210, 21500.35m);
            dt.Rows.Add(DateTime.Parse("12/10/2024"), 50, 5400.75m);
            dt.Rows.Add(DateTime.Parse("13/10/2024"), 180, 18500.80m);
            dt.Rows.Add(DateTime.Parse("14/10/2024"), 190, 19500.90m);
            dt.Rows.Add(DateTime.Parse("15/10/2024"), 125, 13000.65m);
            dt.Rows.Add(DateTime.Parse("16/10/2024"), 230, 24000.95m);
            return dt;
        }

        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            // Obtener las fechas seleccionadas por el usuario
            DateTime desde, hasta;

            if (DateTime.TryParse(txtDesde.Text, out desde) && DateTime.TryParse(txtHasta.Text, out hasta))
            {
                // Filtrar los datos en función de las fechas seleccionadas
                var datosFiltrados = resumenData.AsEnumerable()
                    .Where(row => row.Field<DateTime>("Fecha") >= desde && row.Field<DateTime>("Fecha") <= hasta)
                    .CopyToDataTable();

                // Guardar los datos filtrados en el ViewState para su uso en el RowDataBound y paginación
                ViewState["ResumenDataFiltrada"] = datosFiltrados;

                // Actualizar el GridView con los datos filtrados
                gvResumen.DataSource = datosFiltrados;
                gvResumen.DataBind();  // Ahora el RowDataBound se ejecutará correctamente con los datos filtrados
            }
            else
            {
                // Mostrar un mensaje si las fechas no son válidas
                Response.Write("<script>alert('Por favor ingrese fechas válidas');</script>");
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
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                // Cambiar el color si el monto es alto
                decimal totalVenta = Convert.ToDecimal(DataBinder.Eval(e.Row.DataItem, "Total vendido"));
                if (totalVenta > 300) // Resalta montos mayores a 300
                {
                    e.Row.BackColor = System.Drawing.Color.LightGreen;
                }
            }

            if (e.Row.RowType == DataControlRowType.Footer)
            {
                // Recupera los datos filtrados si existen, si no, usa los datos originales
                DataTable datosFiltrados = ViewState["ResumenDataFiltrada"] as DataTable ?? ViewState["ResumenData"] as DataTable;
                if (datosFiltrados != null)
                {
                    // Calcular el total de pedidos y el total general de las ventas basados en los datos filtrados
                    int totalPedidos = datosFiltrados.AsEnumerable().Sum(row => row.Field<int>("Cantidad de pedidos"));
                    decimal totalGeneral = datosFiltrados.AsEnumerable().Sum(row => row.Field<decimal>("Total vendido"));

                    // Mostrar el total de pedidos en la columna "Cantidad de Pedidos"
                    e.Row.Cells[1].Text = totalPedidos.ToString();

                    // Mostrar el total general en la columna "Total"
                    e.Row.Cells[2].Text = totalGeneral.ToString("C", System.Globalization.CultureInfo.CreateSpecificCulture("es-PE"));
                }
            }
        }

    }
}