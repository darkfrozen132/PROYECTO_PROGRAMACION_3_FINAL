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
                idAñadirProducto.Attributes["class"] += " activate";
                idAñadirProducto.Attributes["aria-current"] = "true";
            }
            else if(currentPage == "modificarProducto.aspx")
            {
                idAñadirProducto.Attributes["class"] += " activate";
                idAñadirProducto.Attributes["aria-current"] = "true";
            }
            else if (currentPage == "eliminarProducto.aspx")
            {
                idAñadirProducto.Attributes["class"] += " activate";
                idAñadirProducto.Attributes["aria-current"] = "true";
            }
        }
    }
}