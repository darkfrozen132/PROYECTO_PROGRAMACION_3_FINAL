using System;
using System.Web.UI;
using TemuFansBO.ServicioWS;
using TemuFansUsuarioBO;
using UtilidadesWeb;

namespace PruebaBootstrap
{
    public partial class Gestion_de_Proveedores : System.Web.UI.Page
    {
        private ProveedorBO proveedorBO = new ProveedorBO();
        protected void Page_Load(object sender, EventArgs e)
        {
            // Aquí no hay lógica en este momento.
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            string doi = txtRUC.Text;

            if (verificarCamposVacios())
            {
                ScriptsGenericos.MostrarMensajeError(this, "Los campos estan vacios.");
                //ClientScript.RegisterStartupScript(this.GetType(), "mostrarError", "mostrarError();", true);
            }
            /*
            else if (usuario.existeCliente(doi))
            {
                ClientScript.RegisterStartupScript(this.GetType(), "mostrarErrorRepetidos", "mostrarErrorRepetidos();", true);
            }*/
            else
            {
                proveedorBO.insertar(doi,txtCorreo.Text,txtRazonSocial.Text);
                
                //ClientScript.RegisterStartupScript(this.GetType(), "mostrarModal", "mostrarModal();", true);
            }
        }

        private bool verificarCamposVacios()
        {
            return string.IsNullOrWhiteSpace(txtCorreo.Text) || string.IsNullOrWhiteSpace(txtRUC.Text)
                || string.IsNullOrWhiteSpace(txtRazonSocial.Text);
        }

        protected void btnLimpiar_Click(object sender, EventArgs e)
        {
            // Limpiar los campos del formulario
            txtRUC.Text = string.Empty;
            txtRazonSocial.Text = string.Empty;
            txtCorreo.Text = string.Empty;
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            // Redirigir al Home de Compras
            Response.Redirect("HomeCompras.aspx");
        }
    }
}
