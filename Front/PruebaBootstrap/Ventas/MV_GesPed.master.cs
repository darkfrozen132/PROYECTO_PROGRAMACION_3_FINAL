using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PruebaBootstrap
{
    public partial class MasterVentas_GestionPedido : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            // Obtener el nombre de la página actual
            string currentPage = System.IO.Path.GetFileName(Request.Path);

            // Establecer clase y atributo según la página actual
            if (currentPage == "Agregar_Pedido.aspx")
            {
                idAgregarPedido_Nuevo.Attributes["class"] = "nav-link active";
                idAgregarPedido_Nuevo.Attributes["aria-current"] = "true";
            }
            else if (currentPage == "Historial_Ventas.aspx")
            {
                idAgregarPedido_Lista.Attributes["class"] = "nav-link active";
                idAgregarPedido_Lista.Attributes["aria-current"] = "true";
            }
        }

        protected void btnNombreAgregarProducto_Click(object sender, EventArgs e)
        {

        }

        protected void btnIdAgregarProducto_Click(object sender, EventArgs e)
        {

        }

        protected void btnGuardar_AgregarProducto(object sender, EventArgs e)
        {
            Response.Redirect("Agregar_Pedido.aspx");
        }
    }
}