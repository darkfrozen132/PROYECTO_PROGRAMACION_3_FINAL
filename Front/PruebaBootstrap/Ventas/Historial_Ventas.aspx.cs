using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemuFansBO.ServicioWS;
using TemuFansDocumentosBO;

namespace PruebaBootstrap
{
    public partial class Historial_Ventas : System.Web.UI.Page
    {
        private PedidoBO pedidoBO = new PedidoBO();

        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            // Obtener los valores de los campos de texto y fechas
            /*   string ruc = txtRUC.Text.Trim();
               string razonSocial = txtRazonSocial.Text.Trim();
               string metodoPago = ddlMetodoPago.SelectedValue;*/

            string ruc = string.IsNullOrWhiteSpace(txtRUC.Text) ? null : txtRUC.Text.Trim();
            string razonSocial = string.IsNullOrWhiteSpace(txtRazonSocial.Text) ? null : txtRazonSocial.Text.Trim();
            string metodoPago = string.IsNullOrWhiteSpace(ddlMetodoPago.SelectedValue) ? null : ddlMetodoPago.SelectedValue;

            DateTime fechaCreacionDesde, fechaCreacionHasta, fechaPagoDesde, fechaPagoHasta;
            bool fechaCreacionDesdeValida = DateTime.TryParse(txtFechaCreacionDesde.Text, out fechaCreacionDesde);
            bool fechaCreacionHastaValida = DateTime.TryParse(txtFechaCreacionHasta.Text, out fechaCreacionHasta);
            bool fechaPagoDesdeValida = DateTime.TryParse(txtFechaPagoDesde.Text, out fechaPagoDesde);
            bool fechaPagoHastaValida = DateTime.TryParse(txtFechaPagoHasta.Text, out fechaPagoHasta);

            // Llamar al método para obtener los datos del historial de ventas
            var historialVentasData = ObtenerDatosDeHistorialVentas(
                fechaCreacionDesdeValida ? fechaCreacionDesde.ToString("yyyy-MM-dd") : null,
                fechaCreacionHastaValida ? fechaCreacionHasta.ToString("yyyy-MM-dd") : null,
                fechaPagoDesdeValida ? fechaPagoDesde.ToString("yyyy-MM-dd") : null,
                fechaPagoHastaValida ? fechaPagoHasta.ToString("yyyy-MM-dd") : null,
                ruc,
                razonSocial,
                metodoPago
            );

            // Cargar los datos en el GridView
            if (historialVentasData != null && historialVentasData.Rows.Count > 0)
            {
                ViewState["VentasDataFiltrada"] = historialVentasData;
                gvVentas.DataSource = historialVentasData;
                gvVentas.DataBind();
            }
            else
            {
                gvVentas.DataSource = null;
                gvVentas.DataBind();
                Response.Write("<script>alert('No se encontraron datos para los filtros seleccionados.');</script>");
            }
        }

        private DataTable ObtenerDatosDeHistorialVentas(
            string fechaCreacionDesde, string fechaCreacionHasta,
            string fechaPagoDesde, string fechaPagoHasta,
            string ruc, string razonSocial, string metodoPago)
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

            try
            {

                BindingList<resumenHistorialVentas> listaHistorial = pedidoBO.listarHistorialVentas(
                    fechaCreacionDesde, fechaCreacionHasta,
                    fechaPagoDesde, fechaPagoHasta, ruc, razonSocial, metodoPago);

                foreach (resumenHistorialVentas item in listaHistorial)
                {
                    dt.Rows.Add(item.id, item.ruc, item.razonSocial, item.fechaCreacion,
                                item.fechaPago, item.metodoPago, item.subtotal, item.igv, item.total);
                }
            }
            catch (Exception ex)
            {
                Response.Write("<script>alert('Error al obtener datos del servicio: " + ex.Message + "');</script>");
            }

            return dt;
        }

        protected void gvVentas_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvVentas.PageIndex = e.NewPageIndex;
            gvVentas.DataSource = ViewState["VentasDataFiltrada"] as DataTable ?? new DataTable();
            gvVentas.DataBind();
        }

        protected void gvVentas_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.Footer)
            {
                DataTable datosFiltrados = ViewState["VentasDataFiltrada"] as DataTable;
                if (datosFiltrados != null)
                {
                    decimal totalGeneral = datosFiltrados.AsEnumerable().Sum(row => row.Field<decimal>("Total"));
                    e.Row.Cells[6].Text = "Total General:";
                    e.Row.Cells[7].Text = totalGeneral.ToString("C");
                }
            }
        }
    }
}