using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemuFansInventarioBO;

namespace PruebaBootstrap
{
    public partial class añadirProducto : System.Web.UI.Page
    {
        private ProductoBO productoBO = new ProductoBO();
        private MarcaBO marcaBO = new MarcaBO();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                ddlMarca.DataSource = marcaBO.listarMarcas();
                ddlMarca.DataTextField = "nombre";
                ddlMarca.DataValueField = "idMarca";
                ddlMarca.DataBind();
            }
        }
        protected void BtnGuardar_Click(object sender, EventArgs e)
        {
            
            int id = productoBO.insertarProducto(double.Parse(txtPrecio.Text), txtNombreProducto.Text, rbEstado.Text, int.Parse(ddlMarca.SelectedValue));
            Response.Redirect("añadirProducto.aspx");
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
            Response.Redirect("añadirProducto.aspx");
        }

        protected void ddlMarca_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}