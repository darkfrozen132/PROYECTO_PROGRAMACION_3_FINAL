using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemuFansBO.ServicioWS;
using TemuFansInventarioBO;

namespace PruebaBootstrap
{
    public partial class eliminarProducto : System.Web.UI.Page
    {
        private ProductoBO productoBO = new ProductoBO();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                ddlProducto.DataSource = productoBO.listarProductosNombre();
                ddlProducto.DataTextField = "nombre";
                ddlProducto.DataValueField = "idProducto";
                ddlProducto.DataBind();
            }
        }
        protected void BtnGuardar_Click(object sender, EventArgs e)
        {
            
            productoBO.eliminarProducto(int.Parse(ddlProducto.SelectedValue));
            Response.Redirect("eliminarProducto.aspx");
        }
        protected void BtnCancelar_Click(object sender, EventArgs e)
        {
            // Acción para cancelar (redirigir o limpiar los campos)
            //Response.Redirect("OtraPagina.aspx"); // Por ejemplo, redirigir a otra página
            Response.Redirect("HomeInventario.aspx");
        }
        protected void BtnLimpiar_Click(object sender, EventArgs e)
        {
            // Limpiar los campos
            Response.Redirect("eliminarProducto.aspx");
        }

        //sin este metodo no funciona el drop down list
        protected void ddlProducto_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }
    }
}