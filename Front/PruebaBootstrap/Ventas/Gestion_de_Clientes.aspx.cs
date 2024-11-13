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
            Response.Redirect("/Ventas/Gestion_de_Clientes.aspx");
        }

        protected void btnRegresar_Click(Object sender, EventArgs e)
        {
            Response.Redirect("/Home.aspx");
        }

        protected void btnGuardar_Click(Object sender, EventArgs e)
        {
            ClienteBO usuario = new ClienteBO();
            string doi = txtDOI.Text;

            if (verificarCamposVacios())
            {
                ClientScript.RegisterStartupScript(this.GetType(), "mostrarError", "mostrarError();", true);
            }
            else if (usuario.existeCliente(doi))
            {
                ClientScript.RegisterStartupScript(this.GetType(), "mostrarErrorRepetidos", "mostrarErrorRepetidos();", true);
            }
            else
            {
                DateTime dateTime = DateTime.Now;
                usuario.insertarCliente(rbTipoUsuario.SelectedValue, doi,
                    rbTipoDOI.SelectedValue, txtCorreo.Text, dateTime.ToString("yyyy-MM-dd"),
                    txtNombre.Text, txtTelefono.Text);

                ClientScript.RegisterStartupScript(this.GetType(), "mostrarModal", "mostrarModal();", true);
            }
        }

        private bool verificarCamposVacios()
        {
            return string.IsNullOrWhiteSpace(txtDOI.Text) || string.IsNullOrWhiteSpace(rbTipoDOI.SelectedValue) ||
                string.IsNullOrWhiteSpace(txtCorreo.Text) ||
                string.IsNullOrWhiteSpace(txtNombre.Text) ||
                string.IsNullOrWhiteSpace(txtTelefono.Text) ||
                string.IsNullOrWhiteSpace(rbTipoUsuario.SelectedValue);
        }
    }
}