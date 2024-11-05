using PruebaBootstrap.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PruebaBootstrap
{
    public partial class Registrar_Pago : System.Web.UI.Page
    {
        private ServicioWSClient servicioWS=new ServicioWSClient();
        protected void Page_Load(object sender, EventArgs e)
        {
           // servicioWS.pedido_modificarPago();
        }
    }
}