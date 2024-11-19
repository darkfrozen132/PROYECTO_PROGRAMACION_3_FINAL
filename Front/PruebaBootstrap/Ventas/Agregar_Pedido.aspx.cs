using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemuFansBO.ServicioWS;
using TemuFansDocumentosBO;
using TemuFansInventarioBO;
using TemuFansUsuarioBO;

namespace PruebaBootstrap
{
    public partial class Agregar_Pedido : System.Web.UI.Page
    {
        private ClienteBO boCliente;
        private ProductoBO boProducto;
        private PedidoBO boPedido;
        private DetalleBO bodetalle;
        private BindingList<cliente> listaClientes;
        private BindingList<producto> listaProductos;
        private bool buscar_por_nombre;
        private producto prod;
        private pedido ped;
        private BindingList<detallePedido> listaDetallesPedido;
        private decimal totalMonto;

        protected void Page_Load(object sender, EventArgs e)
        {
            //actualizar la lista de detalles
            if (Session["listaDetalles"] == null)
            {
                this.listaDetallesPedido = new BindingList<detallePedido>();
            }
            else
            {
                this.listaDetallesPedido = (BindingList<detallePedido>)Session["listaDetalles"];
            }
            if (Session["producto"] != null)
            {
                this.prod = (producto)Session["producto"];
            }
            if (Session["pedido"] != null)
            {
                this.ped = (pedido)Session["pedido"];
            }
            if (Session["buscarPorNombre"] != null)
            {
                buscar_por_nombre = (bool)Session["buscarPorNombre"];
            }

            //la primera ves que se carga la pagina
            if (!IsPostBack)
            {
                this.bodetalle = new DetalleBO();
                buscar_por_nombre = true;
                prod = new producto();
                ped = new pedido();
                txtCodigoAgregar.Enabled = false;
                txtNombreAgregar.Enabled = true;
                buscar_por_nombre = true;
                DesabilitarComponentes(); //campos que se rellenan solos
            }
        }

        protected void DesabilitarComponentes()
        {
            //desabilitar los demas campos de Buscar Cliente (aca se rellenan)
            txtIDCliente.Enabled = false;
            txtdoi.Enabled = false;
            txtTelefono.Enabled = false;
            //desabilitar los demas campos de Agregar Pedido (aca se rellenan)
            txtIdProducto.Enabled = false;
            txtCodigoAgregar.Enabled = false;
            txtMarca.Enabled = false;
            txtNombreAgregar.Enabled = false;
            txtPrecio.Enabled = false;
        }

        /* ----------------- */
        protected void lbBuscar_Click(object sender, EventArgs e)
        {
            //es un boton que me muestra un modal
            string script = "window.onload = function() { showModalFormClientePedido() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
            //funcion de buscar por el nombre
            this.buscarClientePorNombre(txtNombre.Text);
        }

        protected void lbBuscarModal_Click(object sender, EventArgs e)
        {
            this.buscarClientePorNombre(txtNombreModal.Text);
        }

        protected void buscarClientePorNombre(string nombre)
        {
            this.boCliente = new ClienteBO();
            this.listaClientes = this.boCliente.buscarCliente(nombre);

            var datosFiltrados = this.listaClientes.Select(c => new
            {
                IdCliente = c.idCliente,
                IdUsuario = c.idUsuario,
                Nombre = c.nombre
            }).ToList();

            gvClientesModalPedido.DataSource = datosFiltrados;
            gvClientesModalPedido.DataBind();
        }

        protected void lbSeleccionarNombre_Click(object sender, EventArgs e)
        {
            //al seleccionar un cliente
            int idCliente = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idCliente"] = idCliente;
            //obtener los demas datos del cliente con ObtenerPorId
            this.boCliente = new ClienteBO();
            cliente cli = this.boCliente.obtenerPorId(idCliente);
            txtNombre.Text = cli.nombre;
            txtIDCliente.Text = Convert.ToString(cli.idCliente);
            txtdoi.Text = cli.doi;
            txtTelefono.Text = cli.telefono;
            //poner en datos del pedido
            this.ped = new pedido();
            this.ped.usuario = cli;
            Session["pedido"] = this.ped;
            //cerrar el modal
            ScriptManager.RegisterStartupScript(this, GetType(), "", "__doPostBack('', '');", true);
        }
        /* ----------------- */

        protected void gvPedidoVenta_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            // Verificar si se trata del pie de la tabla
            if (e.Row.RowType == DataControlRowType.Footer)
            {
                decimal totalGeneral = 0;

                // Recorrer todas las filas de datos del GridView
                foreach (GridViewRow row in gvListaLineaPedido.Rows)
                {
                    if (row.RowType == DataControlRowType.DataRow)
                    {
                        // Intentar obtener el valor de la columna "Monto"
                        decimal monto;
                        if (decimal.TryParse(row.Cells[6].Text, out monto))
                        {
                            totalGeneral += monto;
                        }
                    }
                }

                // Mostrar el total general en el pie de la tabla
                e.Row.Cells[4].Text = "Total General:";
                e.Row.Cells[5].Text = totalGeneral.ToString("S/.");
                this.totalMonto = totalGeneral; // Actualizar el valor en la variable de clase si es necesario
            }
        }

        /*
            manejo de agregar producto
         */
        protected void btnRadioCriterio(object sender, EventArgs e)
        {
            if (radButNombre.Checked)
            {
                //desabilitar codigo
                txtCodigoAgregar.Enabled = false;
                txtNombreAgregar.Enabled = true;
                buscar_por_nombre = true;
            }
            else if (radButCodigo.Checked)
            {
                //desabilitar nombre
                txtCodigoAgregar.Enabled = true;
                txtNombreAgregar.Enabled = false;
                buscar_por_nombre = false;
            }
            Session["buscarPorNombre"] = buscar_por_nombre;
            upRadButBusqueda.Update();
        }
        protected void lbBuscarProducto_Click(object sender, EventArgs e)
        {
            //es un boton que me muestra un modal
            string script = "window.onload = function() { showModalFormAgregarProducto() };";
            ClientScript.RegisterStartupScript(GetType(), "", script, true);
            //Recojer de los textbox
            string texto = "";
            if (buscar_por_nombre)
            {
                texto = txtNombreAgregar.Text;
            }
            else
            {
                texto = txtCodigoAgregar.Text;
            }
            this.productoBuscarPorCriterio(texto);
        }

        protected void lbBuscarProductoModal_Click(object sender, EventArgs e)
        {
            string texto = "";
            if (buscar_por_nombre)
            {
                texto = txtNombreProdModal.Text;
            }
            else
            {
                texto = txtCodProdModal.Text;
            }
            this.productoBuscarPorCriterio(texto);
        }

        protected void productoBuscarPorCriterio(string texto)
        {
            this.boProducto = new ProductoBO();
            //busqueda segun cual esta criterio esta habilitado
            if (buscar_por_nombre)
            {
                this.listaProductos = this.boProducto.buscarPorCriterio(texto, null);
            }
            else
            {
                this.listaProductos = this.boProducto.buscarPorCriterio(null, texto);
            }

            var datosFiltrados = this.listaProductos.Select(c => new
            {
                IdProducto = c.idProducto,
                Codigo = c.codigo,
                Marca = c.marca.nombre,
                Nombre = c.nombre,
                P_Unitario = c.precio
            }).ToList();

            gvModelBuscarProd.DataSource = datosFiltrados;
            gvModelBuscarProd.DataBind();
        }

        protected void lbSeleccionarProducto_Click(object sender, EventArgs e)
        {
            //en un arreglo lo que obtengo al dar clic
            string[] data = ((LinkButton)sender).CommandArgument.ToString().Split(',');
            //rellenar los campos
            txtIdProducto.Text = data[0];
            txtCodigoAgregar.Text = data[1];
            txtMarca.Text = data[2];
            txtNombreAgregar.Text = data[3];
            txtPrecio.Text = data[4];
            //poner datos en producto (ira en detallepedido que insertare en el GridView)
            this.prod = new producto();
            this.prod.idProducto = Int32.Parse(data[0]);
            this.prod.codigo = data[1];
            marca mar = new marca();
            mar.nombre = data[2];
            this.prod.marca = mar;
            this.prod.nombre = data[3];
            this.prod.precio = Double.Parse(data[4]);
            Session["producto"] = this.prod;
        }
        /* ------------- */

        /*
         * Guardar o Limpiar el Producto a ingresar al pedido
         */
        protected void lbAgregarProducto(object sender, EventArgs e)
        {
            // poner datos en clase detallePedido
            detallePedido detalle = new detallePedido();
            detalle.producto = this.prod;
            detalle.cantidad = Int32.Parse(txtCantidad.Text);
            detalle.descripcion = txtDescripcionLinea.InnerText;
            detalle.monto = this.prod.precio * Int32.Parse(txtCantidad.Text);
            //agregar a la lista que hay en el GridView
            this.listaDetallesPedido.Add(detalle);
            Session["listaDetalles"] = this.listaDetallesPedido;

            //datos que pondre en la tabla
            var datosFiltrados = this.listaDetallesPedido.Select(c => new
            {
                Codigo = c.producto.codigo,
                Nombre = c.producto.nombre,
                Descripcion = c.descripcion,
                PrecioUnitario = c.producto.precio,
                Cantidad = c.cantidad,
                Monto = c.monto
            }).ToList();

            //actualizar la tabla
            gvListaLineaPedido.DataSource = datosFiltrados;
            gvListaLineaPedido.DataBind();

            //vaciar los campos de abajo
            LimpiarDatosAgregarProducto();
        }

        protected void LimpiarDatosAgregarProducto()
        {
            txtNombreAgregar.Text = "";
            txtCodigoAgregar.Text = "";
            txtIdProducto.Text = "";
            txtMarca.Text = "";
            txtCantidad.Text = "";
            txtPrecio.Text = "";
            txtDescripcionLinea.InnerText = "";
        }

        protected void lbLimpiarAgregar(object sender, EventArgs e)
        {
            HabilitarCodigoYNombre();
            LimpiarDatosAgregarProducto();
        }

        protected void HabilitarCodigoYNombre()
        {
            //solo el nombre porque es asi por default
            txtNombreAgregar.Enabled = true;
        }

        /*
         * Acciones para la linea del pedido
         */

        protected void lbModificar_Click(object sender, EventArgs e)
        {

        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            //quitar de la lista que esta en el GriedView
            string nombre = ((LinkButton)sender).CommandArgument;
            //buscar en la listaDetallePedido
            foreach (detallePedido detalle in this.listaDetallesPedido)
            {
                if (detalle.producto.nombre == nombre)
                {
                    this.listaDetallesPedido.Remove(detalle);
                    break;
                }
            }
            //datos que pondre en la tabla
            var datosFiltrados = this.listaDetallesPedido.Select(c => new
            {
                Codigo = c.producto.codigo,
                Nombre = c.producto.nombre,
                Descripcion = c.descripcion,
                PrecioUnitario = c.producto.precio,
                Cantidad = c.cantidad,
                Monto = c.monto
            }).ToList();

            //actualizar la tabla
            gvListaLineaPedido.DataSource = datosFiltrados;
            gvListaLineaPedido.DataBind();
        }

        /* 
         * Guardar el pedido y sus detalles en la base de datos 
        */
        protected void lbGuardarPedido(object sender, EventArgs e)
        {
            this.boPedido = new PedidoBO();
            this.bodetalle = new DetalleBO();
            //insertar el pedido
            int idPedidoGenerado = this.boPedido.insertarPedidoVenta(this.ped.usuario.idUsuario, 1,
                (double)this.totalMonto, (double)this.totalMonto * 0.18, (double)this.totalMonto * 1.18);
            //ya tengo el id del pedido generado, ahora insertar por lote las lineas de pedido
            if (idPedidoGenerado > 0)
            {
                this.ped.id_pedido = idPedidoGenerado;
                //ponerle datos del cliente
                foreach (detallePedido det in this.listaDetallesPedido)
                {
                    det.pedido = this.ped;
                }
                this.bodetalle.insertarPorLote(this.listaDetallesPedido);
            }
        }
    }
}