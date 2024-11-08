//using PruebaBootstrap.ServicioWS;
using System;
using System.Collections.Generic;
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

        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void BtnAceptar_Click(Object sender, EventArgs e)
        {
            int pedidoID;
            if (int.TryParse(txtPedidoID.Text, out pedidoID))
            {
                PedidoBO pedidobo = new PedidoBO();
                pedidobo.modificar_pago(pedidoID, rbEstado.Text);
                Response.Redirect("HomeVentas.aspx");
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
    }
}