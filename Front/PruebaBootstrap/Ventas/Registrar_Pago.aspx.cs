//using PruebaBootstrap.ServicioWS;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemuFansBO.ServicioWS;
using TemuFansDocumentosBO;
using TemuFansUsuarioBO;

namespace PruebaBootstrap
{
    public partial class Registrar_Pago : System.Web.UI.Page
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
                    var resumenData = ObtenerPago(desde, hasta);

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
        private DataTable ObtenerPago(DateTime fechaInicio, DateTime fechaFin)
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("ID", typeof(int));
            dt.Columns.Add("Nombre", typeof(string));
            dt.Columns.Add("Fecha", typeof(DateTime));
            dt.Columns.Add("Total", typeof(decimal));

            try
            {
                pedidoBO = new PedidoBO();
                var listaResumen = pedidoBO.listarPedidosPagos(fechaInicio.ToString("yyyy-MM-dd"), fechaFin.ToString("yyyy-MM-dd"));

                foreach (var item in listaResumen)
                {
                    dt.Rows.Add(item.pedido.id_pedido, item.usuario.nombre, item.pedido.fecha_creacion, item.pedido.total);
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


        protected void BtnAceptar_Click(Object sender, EventArgs e)
        {
            int pedidoID;
            if (int.TryParse(txtPedidoID.Text, out pedidoID))
            {
                string estadoSeleccionado = rbEstado.SelectedValue; // "PAGADO" o "CANCELADO"

                // Llama al método de negocio para actualizar el estado del pedido
                pedidoBO = new PedidoBO();
                try
                {
                    pedidoBO.modificar_pago(pedidoID, estadoSeleccionado);

                    // Mensaje de éxito
                    ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('El estado del pedido se actualizó exitosamente.'); window.location='HomeVentas.aspx';", true);
                }
                catch (Exception ex)
                {
                    // Mensaje de fallo en caso de error
                    Response.Write("<script>alert('Error al actualizar el estado del pedido: " + ex.Message + "');</script>");
                }
            }
            else
            {
                Response.Write("<script>alert('No se ha seleccionado un pedido válido.');</script>");
            }
        }


        protected void BtnBorrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Registrar_Pago.aspx");
        }
        protected void BtnCancelar_Click(object sender, EventArgs e)
        {
            Response.Redirect("HomeVentas.aspx");
        }
        protected void gvResumen_SelectedIndexChanged(object sender, EventArgs e)
        {
            // Obtiene el ID de la fila seleccionada sin mostrarlo en el GridView
            int idSeleccionado = Convert.ToInt32(gvResumen.SelectedDataKey["ID"]);

            // Aquí puedes usar el ID seleccionado para realizar otras acciones
            txtPedidoID.Text = idSeleccionado.ToString();
            pnlDetalles.Visible = true;

        }



    }

}