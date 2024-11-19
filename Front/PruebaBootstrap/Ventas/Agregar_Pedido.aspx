<%@ Page Title="" Language="C#" MasterPageFile="MV_GesPed.master" AutoEventWireup="true" CodeBehind="Agregar_Pedido.aspx.cs" Inherits="PruebaBootstrap.Agregar_Pedido" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphVentas_Ped" runat="server">
<asp:ScriptManager runat="server"></asp:ScriptManager>
                        <!-- datos del cliente -->
                    <div>
                        <h6 class="card-title"> DATOS DEL CLIENTE</h6>
                        <div class="row align-items-center mb-3">
                          <div class="col-12 col-md-auto me-2">
                              <asp:Label ID="lblNombre" runat="server" Text="NOMBRE: " CssClass="col-form-label"></asp:Label>
                          </div>
                          <div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
                              <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control"></asp:TextBox>
                          </div>
                          <div class="col-12 col-md-3 me-2 mt-3 mt-md-0">
                              <!-- <i class='fa-solid fa-magnifying-glass'></i> -->
                              <asp:Button ID="lbBuscarCliente" runat="server" class="btn btn-primary btn-lg" Text="BUSCAR"
                                  OnClick="lbBuscar_Click"/>
                          </div>
                       </div>
                        <div class="row">
                            <div class="col-md-4 pb-md-3 align-items-center">
                                <asp:Label ID="lblIDCliente" runat="server" Text="ID:" CssClass="col-form-label"></asp:Label>
                                <asp:TextBox ID="txtIDCliente" runat="server" CssClass="form-control" ReadOnly="true" ></asp:TextBox>
                            </div>
                            <div class="col-md-4 pb-md-3 align-items-center">
                                <asp:Label ID="lbldoi" runat="server" Text="DOI:" CssClass="col-form-label"></asp:Label>
                                <asp:TextBox ID="txtdoi" runat="server" CssClass="form-control" ></asp:TextBox>
                            </div>
                            <div class="col-md-4 pb-md-3 align-items-center">
                                <asp:Label ID="lblTelefono" runat="server" Text="TELEFONO:" CssClass="col-form-label"></asp:Label>
                                <asp:TextBox ID="txtTelefono" runat="server" CssClass="form-control" ></asp:TextBox>
                            </div>
                        </div>
                    </div>
                    <!-- tabla de lista de productos del pedido -->
                    <div class="mt-3">
                        <h6 class="card-title"> LISTA DE PRODUCTOS </h6>
                        <p>Aca se presentan los productos del pedido de venta al cliente</p>
                        <!-- tabla -->
                        <asp:GridView ID="gvListaLineaPedido" runat="server" AutoGenerateColumns="False" CssClass="table table-striped"
                            ShowFooter="true" OnRowDataBound="gvPedidoVenta_RowDataBound" >
                            <Columns>
                                <asp:TemplateField HeaderText="">
                                    <ItemTemplate>
                                        <asp:LinkButton runat="server" Text="<i class='fa fa-edit text-warning'></i>"
                                            OnClick="lbModificar_Click" CommandArgument='<%#Eval("Nombre") %>'/>
                                        <asp:LinkButton runat="server" Text="<i class='fa fa-trash text-danger'></i>"
                                            OnClick="lbEliminar_Click" CommandArgument='<%#Eval("Nombre") %>'/>
                                    </ItemTemplate>
                                </asp:TemplateField>
                                <asp:BoundField DataField="Codigo" HeaderText="CODIGO"/>
                                <asp:BoundField DataField="Nombre" HeaderText="NOMBRE"/>
                                <asp:BoundField DataField="Descripcion" HeaderText="DESCRIPCION" />
                                


                                <asp:BoundField DataField="PrecioUnitario" HeaderText="PRECIO UNITARIO"/>
                                <asp:BoundField DataField="Cantidad" HeaderText="CANTIDAD"/>



                                <asp:BoundField DataField="Monto" HeaderText="MONTO"/>
                            </Columns>
                        </asp:GridView>
                    </div>
                    <!-- formulario para agregar una linea al pedido -->
                    <div class="row mt-3">
                    <!-- es para datos de añadir producto -->
                    <h6 class="card-title"> AÑADIR PRODUCTO </h6>
                    <p> Aca se ingresan los datos para cada detalle del pedido </p>
                    <div class="row">
                        <!-- criterio de busqueda , update panel para no recargar todo-->
                        <asp:UpdatePanel ID="upRadButBusqueda" runat="server" UpdateMode="Conditional">
                            <ContentTemplate>
                            <div class="row mb-3">
                                <p> CRITERIO DE BUSQUEDA</p>
                                <div class="col">
                                    <asp:RadioButton ID="radButNombre" runat="server" GroupName="TipoBusProd" Text="NOMBRE" AutoPostBack="true"
                                                CssClass="d-inline-block me-2" OnCheckedChanged="btnRadioCriterio" />
                                    <asp:RadioButton ID="radButCodigo" runat="server" GroupName="TipoBusProd" Text="CODIGO" AutoPostBack="true"
                                                CssClass="d-inline-block" OnCheckedChanged="btnRadioCriterio"/>

                                </div>
                                </div>
                                <div class="row align-items-center mb-3">
                                    <div class="col-12 col-md-auto me-2">
                                        <asp:Label ID="Label3" runat="server" Text="NOMBRE: " CssClass="col-form-label"></asp:Label>
                                    </div>
                                    <div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
                                        <asp:TextBox ID="txtNombreAgregar" runat="server" CssClass="form-control"></asp:TextBox>
                                    </div>
                                </div>
                                <div class="row align-items-center mb-3">
                                    <div class="col-12 col-md-auto me-2">
                                        <asp:Label ID="Label11" runat="server" Text="CODIGO: " CssClass="col-form-label"></asp:Label>
                                    </div>
                                    <div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
                                        <asp:TextBox ID="txtCodigoAgregar" runat="server" CssClass="form-control"></asp:TextBox>
                                    </div>
                                </div>
                            </ContentTemplate>
                        </asp:UpdatePanel>
                        <div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
                            <asp:Button ID="btBuscarProducto" runat="server" class="btn btn-primary btn-lg" Text="BUSCAR" OnClick="lbBuscarProducto_Click"/>
                        </div>
                        <!-- mostrar la imagen del producto y otros datos -->
                        <div class="row">
                            <!-- imagen -->
                            <!-- <div class="col">
                                <asp:Label ID="Label2" runat="server" Text="Banner Promocional:" CssClass="col-form-label fw-bold" ></asp:Label>
                                <asp:Image ID="Image1" runat="server" CssClass="img-fluid img-thumbnail" ImageUrl="/Images/logo2.png" Height="235" Width="720" />
                            </div> -->
                            <!-- datos de marca, cantidad y precio -->
                            <div class="col">
                                <div class="row">
                                    <asp:Label ID="Label10" runat="server" Text="IDPRODUCTO:" CssClass="col-form-label"></asp:Label>
                                    <asp:TextBox ID="txtIdProducto" runat="server" CssClass="form-control"  ></asp:TextBox>
                                </div>
                                <div class="row">
                                    <asp:Label ID="Label6" runat="server" Text="MARCA:" CssClass="col-form-label"></asp:Label>
                                    <asp:TextBox ID="txtMarca" runat="server" CssClass="form-control"  ></asp:TextBox>
                                </div>
                                <div class="row">
                                    <asp:Label ID="Label4" runat="server" Text="CANTIDAD:" CssClass="col-form-label"></asp:Label>
                                    <asp:TextBox ID="txtCantidad" runat="server" CssClass="form-control"  ></asp:TextBox>
                                </div>
                                <div class="row">
                                    <asp:Label ID="Label5" runat="server" Text="PRECIO:" CssClass="col-form-label"></asp:Label>
                                    <asp:TextBox ID="txtPrecio" runat="server" CssClass="form-control"  ></asp:TextBox>
                                </div>
                            </div>
                        </div>
                        <!-- mostrar descripcion y demas -->
                        <div class="row">
                            <asp:Label ID="Label7" runat="server" Text="DESCRIPCION DEL PRODUCTO:" CssClass="col-form-label fw-bold" ></asp:Label>
                            <textarea id="txtDescripcionLinea" runat="server" class="form-control" cols="20" rows="2"></textarea>
                        </div>
                        <div class="row">
                            <!-- boton de limpiar cuando se iba a modificar o agergar, quitar los enable -->
                            <asp:Button ID="btnLimpiarAgregar" runat="server" class="btn btn-primary btn-lg bg-warning" Text="LIMPIAR" OnClick="lbLimpiarAgregar"/>
                            <asp:Button ID="btnAgregarProd" runat="server" class="btn btn-primary btn-lg bg-success" Text="GUARDAR" OnClick="lbAgregarProducto"/>
                        </div>
                    </div>
                </div>
                    <!-- botones de guardar, regresar o cancelar -->

                    <div class="row mt-4">
                    <!-- Botones -->
                        <div class="col-md-12 text-end">
                            <asp:Button ID="btnCancelar" runat="server" Text="CANCELAR" CssClass="btn btn-secondary me-2" />
                            <asp:Button ID="btnRegistrar" runat="server" Text="REGISTRAR" CssClass="btn btn-success" OnClick="lbGuardarPedido"/>
                        </div>
                    </div>
<!-- modal para seleccionar el cliente -->
<div class="modal" id="form-modal-pedido">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                <!-- encabezado de modal -->
                <div class="modal-header">
                    <h5 class="modal-title">BUSQUEDA DEL CLIENTE</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <!-- contenido del model (usa UpdatePanel porque
                                        actualiza la pagina parcialmente)
                                        es una tabla GridView -->
                <div class="modal-body">
                    <asp:UpdatePanel runat="server" >
                        <ContentTemplate>
                            <p>
                              Lista de clientes para el pedido de venta
                          </p>
                                <div class="row align-items-center mb-3">
                          <div class="col-12 col-md-auto me-2">
                              <asp:Label ID="Label1" runat="server" Text="NOMBRE: " CssClass="col-form-label"></asp:Label>
                          </div>
                          <div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
                              <asp:TextBox ID="txtNombreModal" runat="server" CssClass="form-control"></asp:TextBox>
                          </div>
                          <div class="col-12 col-md-3 me-2 mt-3 mt-md-0">
                              <!-- <i class='fa-solid fa-magnifying-glass'></i> -->
                              <asp:Button ID="lbBuscarClienteModal" runat="server" class="btn btn-primary btn-lg" Text="BUSCAR"
                                  OnClick="lbBuscarModal_Click"/>
                          </div>
                        </div>
                            <div class="container row">

                                <asp:GridView ID="gvClientesModalPedido" runat="server" 
                                    AutoGenerateColumns="False" CssClass="table table-striped" ShowFooter="true" >
                                    <Columns>

                                        <asp:BoundField DataField="IdCliente" HeaderText="IDCLIENTE"/>
                                        <asp:BoundField DataField="IdUsuario" HeaderText="IDPERSONA"/>
                                        <asp:BoundField DataField="Nombre" HeaderText="NOMBRE"/>

                                        <asp:TemplateField HeaderText="">
                                            <ItemTemplate>
                                                <asp:LinkButton runat="server" Text="<i class='fa-solid fa-circle-check text-success'></i>"
                                                    OnClick="lbSeleccionarNombre_Click" 
                                                    CommandArgument='<%#Eval("IdCliente") %>'/>
                                            </ItemTemplate>
                                        </asp:TemplateField>

                                    </Columns>
                                </asp:GridView>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
               </div>
            </div>
        </div>
<!-- modal para seleccionar el producto -->
<div class="modal" id="form-modal-agregar_producto">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Busqueda del Producto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <!-- buscar el producto -->
                <asp:UpdatePanel runat="server" >
                    <ContentTemplate>
                        <p>Buscar el producto para el pedido </p>

                        <div class="row align-items-center mb-3">
                            <div class="col-12 col-md-auto me-2">
                                <asp:Label ID="Label8" runat="server" Text="NOMBRE: " CssClass="col-form-label"></asp:Label>
                            </div>
                            <div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
                                <asp:TextBox ID="txtNombreProdModal" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                            <div class="col-12 col-md-auto me-2">
                                <asp:Label ID="Label9" runat="server" Text="CODIGO: " CssClass="col-form-label"></asp:Label>
                            </div>
                            <div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
                                <asp:TextBox ID="txtCodProdModal" runat="server" CssClass="form-control"></asp:TextBox>
                            </div>
                            <div class="col-12 col-md-3 me-2 mt-3 mt-md-0">

                                <asp:Button ID="btnBuscarProductoModal" runat="server" class="btn btn-primary btn-lg" Text="BUSCAR"
                                    OnClick="lbBuscarProductoModal_Click"/>
                            </div>
                        </div>

                        <div class="container row" id="dtPreSeleccion">
                            <asp:GridView ID="gvModelBuscarProd" runat="server" 
                                AutoGenerateColumns="False" CssClass="table table-striped" ShowFooter="true" >
                                <Columns>

                                    <asp:BoundField DataField="IdProducto" HeaderText="IDPRODUCTO"/>
                                    <asp:BoundField DataField="Codigo" HeaderText="CODIGO"/>
                                    <asp:BoundField DataField="Marca" HeaderText="MARCA"/>
                                    <asp:BoundField DataField="Nombre" HeaderText="NOMBRE"/>
                                    <asp:BoundField DataField="P_Unitario" HeaderText="P.UNITARIO"/>

                                    <asp:TemplateField HeaderText="">
                                        <ItemTemplate>
                                            <asp:LinkButton runat="server" Text="<i class='fa-solid fa-circle-check text-success'></i>"
                                                CommandArgument='<%#Eval("IdProducto") + "," + Eval("Codigo")
                                                    + "," + Eval("Marca") + "," + Eval("Nombre") + "," + Eval("P_Unitario")%>' OnClick="lbSeleccionarProducto_Click"/>
                                        </ItemTemplate>
                                    </asp:TemplateField>

                                </Columns>
                            </asp:GridView>
                        </div>

                    </ContentTemplate>
                </asp:UpdatePanel>
            </div>
        </div>
    </div>
</div>
</asp:Content>
