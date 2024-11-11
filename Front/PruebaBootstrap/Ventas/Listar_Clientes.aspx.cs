using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemuFansBO.ServicioWS;
using TemuFansUsuarioBO;

namespace PruebaBootstrap
{
    public partial class Listar_Clientes : System.Web.UI.Page
    {
        private DataTable resumenData;
        protected void Page_Load(object sender, EventArgs e)
        {
            resumenData = ObtenerDatosDeResumen();
            if (!IsPostBack)
            {
                // Cargar los datos al iniciar la página
                
                ViewState["ResumenData"] = resumenData; // Guardar datos en ViewState
                gvResumen.DataSource = resumenData;
                gvResumen.DataBind();
            }
            else
            {
                resumenData = ViewState["ResumenData"] as DataTable; // Recuperar datos desde ViewState
            }
        }

        private DataTable ObtenerDatosDeResumen()
        {
            ClienteBO clienteBO = new ClienteBO();
            //            BindingList<cliente> lista = clienteBO.listarTodosNombreCodigo(txtCodigo.Text,txtCodigo.Text);
            BindingList<cliente> lista = clienteBO.listarTodos();
            
            DataTable dt = new DataTable();
            dt.Columns.Add("Codigo", typeof(string));
            dt.Columns.Add("Nombre", typeof(string));
            dt.Columns.Add("Fecha Registro", typeof(DateTime));

            for (int i = 0; i<lista.Count; i++)
            {
                dt.Rows.Add(string.Concat(lista[i].codigo + "-",lista[i].idCliente), lista[i].nombre,lista[i].fecha_registro);
            }
            return dt;
        }

        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            // Obtener los filtros
            string nombre = txtNombre.Text, codigo = txtCodigo.Text;
            System.Console.WriteLine(codigo);
            System.Console.WriteLine(nombre);

            if (codigo == "" || codigo.StartsWith("CLI-"))
            {
                // Filtrar los datos en función de las fechas seleccionadas
                ClienteBO clienteBO = new ClienteBO();
                BindingList<cliente> lista = clienteBO.listarTodosNombreCodigo(nombre,codigo);

                DataTable dt = new DataTable();
                dt.Columns.Add("Codigo", typeof(string));
                dt.Columns.Add("Nombre", typeof(string));
                dt.Columns.Add("Fecha Registro", typeof(DateTime));

                for (int i = 0; i < lista.Count; i++)
                {
                    dt.Rows.Add(string.Concat(lista[i].codigo + "-", lista[i].idCliente), lista[i].nombre, lista[i].fecha_registro);
                }

                // Guardar los datos filtrados en el ViewState para su uso en el RowDataBound y paginación
                ViewState["ResumenDataFiltrada"] = dt;

                // Actualizar el GridView con los datos filtrados
                gvResumen.DataSource = dt;
                gvResumen.DataBind();  // Ahora el RowDataBound se ejecutará correctamente con los datos filtrados
            }
            else
            {
                // Mostrar un mensaje si el codigo no es válido
                Response.Write("<script>alert('Por favor ingrese un codigo válido');</script>");
            }
        }


        protected void gvResumen_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvResumen.PageIndex = e.NewPageIndex;
            gvResumen.DataSource = ViewState["ResumenDataFiltrada"] as DataTable ?? ViewState["ResumenData"] as DataTable; // Recuperar los datos filtrados o completos
            gvResumen.DataBind();
        }

        protected void gvResumen_RowDataBound(object sender, GridViewRowEventArgs e)
        {


        }
    }
}