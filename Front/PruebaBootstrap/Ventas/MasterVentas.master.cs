using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PruebaBootstrap
{
    public partial class NestedMasterPage1 : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            // Obtener el nombre de la página actual
            string currentPage = System.IO.Path.GetFileName(Request.Path);

            // Establecer clase y atributo según la página actual
            if (currentPage == "Gestion_de_Clientes.aspx" || currentPage == "Listar_Clientes.aspx")
            {
                idGestionClientes.Attributes["class"] += " active";
                idGestionClientes.Attributes["aria-current"] = "true";
            }
            else if (currentPage == "Agregar_Pedido.aspx")
            {
                idAgregarPedido.Attributes["class"] += " active";
                idAgregarPedido.Attributes["aria-current"] = "true";
            }
            else if (currentPage == "Registrar_Pago.aspx")
            {
                idRegistrarPago.Attributes["class"] += " active";
                idRegistrarPago.Attributes["aria-current"] = "true";
            }
            else if (currentPage == "Historial_Ventas.aspx")
            {
                idHistorialVentas.Attributes["class"] += " active";
                idHistorialVentas.Attributes["aria-current"] = "true";
            }
            else if (currentPage == "Resumen_DiarioMensual.aspx")
            {
                idResumenDiarioMensual.Attributes["class"] += " active";
                idResumenDiarioMensual.Attributes["aria-current"] = "true";
            }
        }
    }
}