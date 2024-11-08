﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemuFansInventarioBO;

namespace PruebaBootstrap
{
    public partial class modificarProducto : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void BtnGuardar_Click(object sender, EventArgs e)
        {
            ProductoBO productoBO = new ProductoBO();
            
            productoBO.modificarProducto(int.Parse(txtIdProducto.Text), txtNombreProducto.Text, rbEstado.Text, double.Parse(txtPrecio.Text));
            Response.Redirect("modificarProducto.aspx");
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
    }
}