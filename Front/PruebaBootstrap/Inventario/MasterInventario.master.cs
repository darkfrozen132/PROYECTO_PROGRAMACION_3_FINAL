using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PruebaBootstrap
{
    public partial class MasterInventario : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string currentPage = System.IO.Path.GetFileName(Request.Path);
            //idGestionClientes.Attributes["class"] += " active";
            //idGestionClientes.Attributes["aria-current"] = "true";
            
            if (currentPage == "añadirProducto.aspx")
            {
                idAñadirProducto.Attributes["class"] += " active";
                idAñadirProducto.Attributes["aria-current"] = "true";
            }
            else if(currentPage == "modificarProducto.aspx")
            {
                idModificarProducto.Attributes["class"] += " active";
                idModificarProducto.Attributes["aria-current"] = "true";
            }
            else if (currentPage == "eliminarProducto.aspx")
            {
                idEliminarProducto.Attributes["class"] += " active";
                idEliminarProducto.Attributes["aria-current"] = "true";
            }
            else if (currentPage == "consultarStockProducto.aspx")
            {
                idConsultarStockProducto.Attributes["class"] += " active";
                idConsultarStockProducto.Attributes["aria-current"] = "true";
            }
            else if (currentPage == "AlertasDeStock.aspx")
            {
                idAlertasDeStock.Attributes["class"] += " active";
                idAlertasDeStock.Attributes["aria-current"] = "true";
            }
        }
    }
}