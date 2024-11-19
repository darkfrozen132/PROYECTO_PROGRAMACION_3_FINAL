using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemuFansBO.ServicioWS;
using TemuFansDocumentosBO;

namespace PruebaBootstrap
{
    public partial class Resumen_DiarioMensual : System.Web.UI.Page
    {
        private PedidoBO pedidoBO;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                pedidoBO = new PedidoBO();
            }
        }

        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            DateTime desde, hasta;

            if (DateTime.TryParse(txtDesde.Text, out desde) && DateTime.TryParse(txtHasta.Text, out hasta))
            {
                // Validación adicional para verificar que desde <= hasta
                if (desde <= hasta)
                {
                    var resumenData = ObtenerDatosDeResumen(desde, hasta);


                    if (resumenData != null && resumenData.Rows.Count > 0)
                    {
                        ViewState["ResumenDataFiltrada"] = resumenData;
                        gvResumen.DataSource = resumenData;
                        gvResumen.DataBind();
                    }
                    else
                    {
                        Response.Write("<script>alert('No se encontraron datos para el rango de fechas seleccionado.');</script>");
                    }
                }
                else
                {
                    Response.Write("<script>alert('La fecha inicial debe ser menor o igual a la fecha final.');</script>");
                }
            }
            else
            {
                Response.Write("<script>alert('Por favor ingrese fechas válidas');</script>");
            }
        }

        private DataTable ObtenerDatosDeResumen(DateTime fechaInicio, DateTime fechaFin)
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("Fecha", typeof(DateTime));
            dt.Columns.Add("Cantidad de pedidos", typeof(int));
            dt.Columns.Add("Total vendido", typeof(decimal));

            try
            {
                pedidoBO = new PedidoBO();
                var listaResumen = pedidoBO.listarPedidosPorFechas(fechaInicio.ToString("yyyy-MM-dd"), fechaFin.ToString("yyyy-MM-dd"));

                foreach (var item in listaResumen)
                {
                    dt.Rows.Add(item.fecha, item.cantPedidos, item.total);
                }
            }
            catch (Exception ex)
            {

                Response.Write("<script>alert('Error al obtener datos del servicio: " + ex.Message + "');</script>");
            }

            return dt;
        }

        protected void gvResumen_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvResumen.PageIndex = e.NewPageIndex;
            gvResumen.DataSource = ViewState["ResumenDataFiltrada"] as DataTable ?? new DataTable(); // Recupera los datos filtrados
            gvResumen.DataBind();
        }

        protected void gvResumen_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {

                decimal totalVenta = Convert.ToDecimal(DataBinder.Eval(e.Row.DataItem, "Total vendido"));
                if (totalVenta > 300)
                {
                    e.Row.BackColor = System.Drawing.Color.LightGreen;
                }
            }

            if (e.Row.RowType == DataControlRowType.Footer)
            {

                DataTable datosFiltrados = ViewState["ResumenDataFiltrada"] as DataTable;
                if (datosFiltrados != null)
                {

                    int totalPedidos = datosFiltrados.AsEnumerable().Sum(row => row.Field<int>("Cantidad de pedidos"));
                    decimal totalGeneral = datosFiltrados.AsEnumerable().Sum(row => row.Field<decimal>("Total vendido"));


                    e.Row.Cells[1].Text = totalPedidos.ToString();


                    e.Row.Cells[2].Text = totalGeneral.ToString("C", System.Globalization.CultureInfo.CreateSpecificCulture("es-PE"));
                }
            }
        }

    }
}