﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
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
            Response.Redirect("/Gestion_de_Clientes.aspx");
        }

        protected void btnRegresar_Click(Object sender, EventArgs e)
        {
            Response.Redirect("/Home.aspx");
        }

        protected void btnGuardar_Click(Object sender, EventArgs e)
        {
            UsuarioBO usuario = new UsuarioBO();

            usuario.insertarCliente(rbTipoUsuario.SelectedValue, txtDOI.Text, 
                rbTipoDOI.SelectedValue, txtCorreo.Text, dtpFechaRegistro.Text,
                txtNombre.Text, txtTelefono.Text);

            Response.Redirect("/Home.aspx");
        }
    }
}