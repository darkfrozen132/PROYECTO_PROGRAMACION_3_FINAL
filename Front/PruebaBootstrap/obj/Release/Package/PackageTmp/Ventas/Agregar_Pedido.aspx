<%@ Page Title="" Language="C#" MasterPageFile="MV_GesPed.master" AutoEventWireup="true" CodeBehind="Agregar_Pedido.aspx.cs" Inherits="PruebaBootstrap.Agregar_Pedido" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphVentas_Ped" runat="server">
                        <!-- datos del cliente -->
                    <div>
                        <h6 class="card-title"> Datos del cliente</h6>
                        <div class="row align-items-center mb-3">
                          <div class="col-12 col-md-auto me-2">
                              <asp:Label ID="lblNombre" runat="server" Text="Nombre: " CssClass="col-form-label"></asp:Label>
                          </div>
                          <div class="col-12 col-md-6 me-2 mt-3 mt-md-0">
                              <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control"></asp:TextBox>
                          </div>
                          <div class="col-12 col-md-3 me-2 mt-3 mt-md-0">
                              <!-- <i class='fa-solid fa-magnifying-glass'></i> -->
                              <asp:Button ID="lbBuscarCliente" runat="server" class="btn btn-primary btn-lg" Text="Buscar"
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
                                <asp:Label ID="lblTelefono" runat="server" Text="Telefono:" CssClass="col-form-label"></asp:Label>
                                <asp:TextBox ID="txtTelefono" runat="server" CssClass="form-control" ></asp:TextBox>
                            </div>
                        </div>
                    </div>
                    <!-- tabla de lista de productos del pedido -->
                    <div class="mt-3">
                        <h6 class="card-title"> Lista de Productos </h6>
                        <p>Aca se presentan los productos del pedido de venta al cliente</p>
                        <!-- tabla -->
                        <asp:GridView ID="gvListaProductos" runat="server" AutoGenerateColumns="False" CssClass="table table-striped"
                            ShowFooter="true" OnRowDataBound="gvPedidoVenta_RowDataBound" >
                            <Columns>
                                <asp:TemplateField HeaderText="">
                                    <ItemTemplate>
                                        <asp:LinkButton runat="server" Text="<i class='fa fa-edit text-warning'></i>"
                                            OnClick="lbModificar_Click" />
                                        <asp:LinkButton runat="server" Text="<i class='fa fa-trash text-danger'></i>"
                                            OnClick="lbEliminar_Click" />
                                    </ItemTemplate>
                                </asp:TemplateField>
                                <asp:BoundField DataField="Codigo" HeaderText="Codigo"/>
                                <asp:BoundField DataField="Nombre" HeaderText="Nombre"/>
                                <asp:BoundField DataField="Descripcion" HeaderText="Descripcion"/>
                                <asp:BoundField DataField="Precio Unitario" HeaderText="Precio Unitario"/>
                                <asp:BoundField DataField="Cantidad" HeaderText="Cantidad"/>
                                <asp:BoundField DataField="Monto" HeaderText="Monto"/>
                            </Columns>
                        </asp:GridView>
                        <!-- boton de agregar producto -->
                        <asp:Button ID="lbAgregarProducto" runat="server" class="btn btn-primary btn-lg" Text="Añadir Producto" 
                            OnClick="lbAgregarProducto_Click"/>
                    </div>
                    <!-- botones de guardar, regresar o cancelar -->
                    <div class="row mt-4">
                    <!-- Botones -->
                        <div class="col-md-12 text-end">
                            <asp:Button ID="btnCancelar" runat="server" Text="Cancelar" CssClass="btn btn-secondary me-2" />
                            <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="btn btn-success" />
                        </div>
                    </div>
</asp:Content>
