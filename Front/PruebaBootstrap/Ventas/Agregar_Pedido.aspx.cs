using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PruebaBootstrap
{
    public partial class Agregar_Pedido : System.Web.UI.Page
    {
        private DataTable dt;
        protected void Page_Load(object sender, EventArgs e)
        {

            if (!IsPostBack)
            {
                // Cargar los datos al iniciar la página
                this.dt = new DataTable();
                DataTable dt = new DataTable();
                this.dt.Columns.Add("Codigo", typeof(string));
                this.dt.Columns.Add("Nombre", typeof(string));
                this.dt.Columns.Add("Descripcion", typeof(string));
                this.dt.Columns.Add("Precio Unitario", typeof(decimal));
                this.dt.Columns.Add("Cantidad", typeof(int));
                this.dt.Columns.Add("Monto", typeof(decimal));

                this.dt.Rows.Add("FLK-091", "Pilsen 900 ml", "Cerveza Pilsen de 900 ml con " +
                    "4% de alcholo", 48.00, 3, 144.00);
                this.dt.Rows.Add("CVH-085", "Cristal 450 ml", "Cerveza Cristal de 450 ml con " +
                    "2% de alcholo", 50.00, 3, 150.00);
                gvListaProductos.DataSource = this.dt;
                gvListaProductos.DataBind();
            }
            DesabilitarComponentes();

            
        }

        protected void DesabilitarComponentes()
        {
            txtIDCliente.Enabled = false;
            txtdoi.Enabled = false;
            txtTelefono.Enabled = false;
        }

        protected void lbBuscar_Click(object sender, EventArgs e)
        {
            //es un boton que me muestra un modal
            string script = "window.onload = function() { showModalFormClientePedido() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
        }

        protected void lbAgregarProducto_Click(object sender, EventArgs e)
        {
            //es un boton que me muestra un modal
            string script = "window.onload = function() { showModalFormAgregarProducto() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
        }
        protected void lbModificar_Click(object sender, EventArgs e)
        {
            //es un boton que me muestra un modal
            string script = "window.onload = function() { showModalFormAgregarProducto() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            //es un boton que me muestra un modal
            string script = "window.onload = function() { showModalFormAgregarProducto() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
        }

        protected void gvPedidoVenta_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.Footer)
            {
                // Calcular y mostrar el total general
                decimal totalGeneral = this.dt.AsEnumerable().Sum(row => row.Field<decimal>("Monto"));
                e.Row.Cells[4].Text = "Total General:";
                e.Row.Cells[5].Text = totalGeneral.ToString("S/.");
            }
        }
    }
}