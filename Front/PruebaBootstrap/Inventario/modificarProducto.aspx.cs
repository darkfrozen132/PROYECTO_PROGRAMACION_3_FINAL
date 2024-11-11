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
    public partial class modificarProducto : System.Web.UI.Page
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

                ddlProducto.Items.Insert(0, new ListItem("Seleccione un producto", "0"));
            }
        }
        protected void BtnGuardar_Click(object sender, EventArgs e)
        {
            if(ddlProducto.SelectedValue != "0")
            {
                productoBO.modificarProducto(int.Parse(ddlProducto.SelectedValue),
                //txtNombreProducto.Text,
                txtNombreProductoModificar.Text,
                rbEstado.Text,
                double.Parse(txtPrecio.Text));

                Response.Redirect("modificarProducto.aspx");
            }
            
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
            Response.Redirect("modificarProducto.aspx");
        }

        protected void ddlProducto_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (ddlProducto.SelectedIndex != 0)
            {
                // Get the selected product ID
                int idProducto = int.Parse(ddlProducto.SelectedValue);

                // Fetch the product details based on the selected product ID
                producto prod = productoBO.obtenerProductoPorId(idProducto);

                if (prod != null)
                {
                    // Populate the fields with the product details
                    txtNombreProductoModificar.Text = prod.nombre.ToString();
                    txtPrecio.Text = prod.precio.ToString();
                    rbEstado.SelectedValue = prod.estado.ToString(); // Assuming 'estado' is either 'ACTIVO' or 'INACTIVO'
                }
            }
            else
            {
                txtNombreProductoModificar.Text = string.Empty;
                txtPrecio.Text = string.Empty;
                rbEstado.ClearSelection();
            }
            
        }
    }
}