using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PruebaBootstrap
{
    public partial class Historial_Ventas : System.Web.UI.Page
    {
        private DataTable ventasData;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Cargar los datos al iniciar la página
                ventasData = ObtenerDatosDeVentas();
                ViewState["VentasData"] = ventasData; // Guardar datos en ViewState
                gvVentas.DataSource = ventasData;
                gvVentas.DataBind();
            }
            else
            {
                ventasData = ViewState["VentasData"] as DataTable; // Recuperar datos desde ViewState
            }
        }

        // Simular la obtención de datos de ventas
        private DataTable ObtenerDatosDeVentas()
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("Id", typeof(int));
            dt.Columns.Add("RUC", typeof(string));
            dt.Columns.Add("RazonSocial", typeof(string));
            dt.Columns.Add("FechaCreacion", typeof(DateTime));
            dt.Columns.Add("FechaPago", typeof(DateTime));
            dt.Columns.Add("MetodoPago", typeof(string));
            dt.Columns.Add("Subtotal", typeof(decimal));
            dt.Columns.Add("IGV", typeof(decimal));
            dt.Columns.Add("Total", typeof(decimal));

            // Agregar varios datos de ejemplo
            dt.Rows.Add(100, "20353155", "Bodega Dieguito", DateTime.Parse("01/10/2024"), DateTime.Parse("02/10/2024"), "Efectivo", 155.80m, 0, 155.80m);
            dt.Rows.Add(101, "20314094", "Bodega Juanito", DateTime.Parse("05/10/2024"), DateTime.Parse("06/10/2024"), "Transferencia", 200.50m, 0, 200.50m);
            dt.Rows.Add(102, "20313291", "Bodega Pepito", DateTime.Parse("03/10/2024"), DateTime.Parse("04/10/2024"), "Efectivo", 120.00m, 0, 120.00m);
            dt.Rows.Add(103, "20272044", "Bodega Luchito", DateTime.Parse("02/10/2024"), DateTime.Parse("03/10/2024"), "Transferencia", 175.00m, 0, 175.00m);
            dt.Rows.Add(104, "20242048", "Bodega Divanito", DateTime.Parse("06/10/2024"), DateTime.Parse("07/10/2024"), "Transferencia", 210.00m, 0, 210.00m);
            dt.Rows.Add(105, "20352000", "Bodega Las Palmeras", DateTime.Parse("08/10/2024"), DateTime.Parse("09/10/2024"), "Efectivo", 300.00m, 0, 300.00m);
            dt.Rows.Add(106, "20363011", "Bodega El Girasol", DateTime.Parse("09/10/2024"), DateTime.Parse("10/10/2024"), "Transferencia", 95.50m, 0, 95.50m);
            dt.Rows.Add(107, "20374012", "Bodega Los Robles", DateTime.Parse("10/10/2024"), DateTime.Parse("11/10/2024"), "Efectivo", 410.00m, 0, 410.00m);
            dt.Rows.Add(108, "20385013", "Bodega El Cedro", DateTime.Parse("11/10/2024"), DateTime.Parse("12/10/2024"), "Transferencia", 220.00m, 0, 220.00m);
            dt.Rows.Add(109, "20396014", "Bodega El Nogal", DateTime.Parse("12/10/2024"), DateTime.Parse("13/10/2024"), "Efectivo", 180.00m, 0, 180.00m);

            // Agregar más ejemplos
            dt.Rows.Add(110, "20407015", "Bodega San Pedro", DateTime.Parse("13/10/2024"), DateTime.Parse("14/10/2024"), "Transferencia", 250.00m, 0, 250.00m);
            dt.Rows.Add(111, "20418016", "Bodega Central", DateTime.Parse("14/10/2024"), DateTime.Parse("15/10/2024"), "Efectivo", 500.00m, 0, 500.00m);
            dt.Rows.Add(112, "20429017", "Bodega Los Pinos", DateTime.Parse("15/10/2024"), DateTime.Parse("16/10/2024"), "Transferencia", 350.00m, 0, 350.00m);
            dt.Rows.Add(113, "20440018", "Bodega Los Olivos", DateTime.Parse("16/10/2024"), DateTime.Parse("17/10/2024"), "Efectivo", 275.00m, 0, 275.00m);
            dt.Rows.Add(114, "20451019", "Bodega San Juan", DateTime.Parse("17/10/2024"), DateTime.Parse("18/10/2024"), "Transferencia", 600.00m, 0, 600.00m);

            return dt;
        }

        // Filtrar los datos
        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            // Filtrar lógica
        }

        // Paginación
        protected void gvVentas_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvVentas.PageIndex = e.NewPageIndex;
            gvVentas.DataSource = ViewState["VentasData"] as DataTable; // Recuperar datos desde ViewState
            gvVentas.DataBind();
        }

        // Total general y colores por montos altos
        protected void gvVentas_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                // Cambiar el color si el monto es alto
                decimal totalVenta = Convert.ToDecimal(DataBinder.Eval(e.Row.DataItem, "Total"));
                if (totalVenta > 300) // Ejemplo, resaltar montos mayores a 300
                {
                    e.Row.BackColor = System.Drawing.Color.LightGreen;
                }
            }

            if (e.Row.RowType == DataControlRowType.Footer)
            {
                // Calcular y mostrar el total general
                decimal totalGeneral = ventasData.AsEnumerable().Sum(row => row.Field<decimal>("Total"));
                e.Row.Cells[6].Text = "Total General:";
                e.Row.Cells[7].Text = totalGeneral.ToString("C");
            }
        }
    }
}