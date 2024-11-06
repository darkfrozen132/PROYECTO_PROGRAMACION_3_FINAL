using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemuFansBO.ServicioWS;
using TemuFansUsuarioBO;

namespace PruebaBootstrap
{
    public partial class Gestion_de_Clientes : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnLimpiar_Click(object sender, EventArgs e)
        {
            Response.Redirect("AñadirCliente.aspx");
        }

        protected void btnRegresar_Click(Object sender, EventArgs e)
        {
            Response.Redirect("HomeVentas.aspx");
        }

        protected void btnGuardar_Click(Object sender, EventArgs e)
        {
            ClienteBO usuario = new ClienteBO();

            usuario.insertarCliente(rbTipoUsuario.SelectedValue, txtDOI.Text,
                rbTipoDOI.SelectedValue, txtCorreo.Text, dtpFechaRegistro.Text,
                txtNombre.Text, txtTelefono.Text);

            Response.Redirect("HomeVentas.aspx");
        }
    }
}