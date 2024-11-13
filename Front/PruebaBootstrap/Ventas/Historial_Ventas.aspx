<%@ Page Title="" Language="C#" MasterPageFile="MV_GesPed.master" AutoEventWireup="true" CodeBehind="Historial_Ventas.aspx.cs" Inherits="PruebaBootstrap.Historial_Ventas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphVentas_Ped" runat="server">

    <div class="container">
    <div class="card">
        <div class="card-header bg-primary text-light">
            <h2>Historial de Ventas</h2>
        </div>
        <div class="card-body">
            <!-- Filtros -->
            <div class="row mb-3">
                <div class="col-md-6">
                    <asp:TextBox ID="txtRUC" runat="server" CssClass="form-control" Placeholder="RUC"></asp:TextBox>
                </div>
                <div class="col-md-6">
                    <asp:TextBox ID="txtRazonSocial" runat="server" CssClass="form-control" Placeholder="Razón social"></asp:TextBox>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-6">
                    <asp:DropDownList ID="ddlMetodoPago" runat="server" CssClass="form-control">
                        <asp:ListItem Text="Seleccione el estado de pago" Value=""></asp:ListItem>
                        <asp:ListItem Text="PAGADO" Value="PAGADO"></asp:ListItem>
                        <asp:ListItem Text="PENDIENTE" Value="PENDIENTE"></asp:ListItem>
                        <asp:ListItem Text="CANCELADO" Value="CANCELADO"></asp:ListItem>
                    </asp:DropDownList>
                </div>
            </div>
            <!-- Intervalos de Fechas -->
            <div class="row mb-3">
                <!-- Fecha de Creación -->
                <div class="col-md-3">
                    <label for="txtFechaCreacionDesde">Fecha de Creación (Desde)</label>
                    <asp:TextBox ID="txtFechaCreacionDesde" runat="server" TextMode="Date" CssClass="form-control"></asp:TextBox>
                </div>
                <div class="col-md-3">
                    <label for="txtFechaCreacionHasta">Fecha de Creación (Hasta)</label>
                    <asp:TextBox ID="txtFechaCreacionHasta" runat="server" TextMode="Date" CssClass="form-control"></asp:TextBox>
                </div>

                <!-- Fecha de Pago -->
                <div class="col-md-3">
                    <label for="txtFechaPagoDesde">Fecha de Pago (Desde)</label>
                    <asp:TextBox ID="txtFechaPagoDesde" runat="server" TextMode="Date" CssClass="form-control"></asp:TextBox>
                </div>
                <div class="col-md-3">
                    <label for="txtFechaPagoHasta">Fecha de Pago (Hasta)</label>
                    <asp:TextBox ID="txtFechaPagoHasta" runat="server" TextMode="Date" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-6">
                    <asp:Button ID="btnFiltrar" CssClass="btn btn-primary" runat="server" Text="Filtrar" OnClick="btnFiltrar_Click" />
                </div>
            </div>

            <!-- Tabla de Ventas con paginación -->
            <asp:GridView ID="gvVentas" runat="server" AutoGenerateColumns="False" CssClass="table table-striped" AllowPaging="true" PageSize="5" OnPageIndexChanging="gvVentas_PageIndexChanging" ShowFooter="true" OnRowDataBound="gvVentas_RowDataBound">
                <Columns>
                    <asp:TemplateField HeaderText="Id">
                        <ItemTemplate>
                            <%-- Muestra el Id y el ícono de edición al lado --%>
                            <span><%# Eval("Id") %></span>
                                <%# Eval("MetodoPago").ToString() == "PENDIENTE" ?
                                "<a href='Agregar_Pedido.aspx?id=" + Eval("Id") + "&idUsuario=" + Session["IdUsuario"] + "' title='Editar'>" +
                                "<i class='fas fa-edit text-warning'></i>" +
                                "</a>" : "" %>
                        </ItemTemplate>
                    </asp:TemplateField> 
                    <asp:BoundField DataField="RUC" HeaderText="RUC" />
                    <asp:BoundField DataField="RazonSocial" HeaderText="Razón Social" />
                    <asp:BoundField DataField="FechaCreacion" HeaderText="Fecha de Creación" DataFormatString="{0:dd/MM/yyyy}" />
                    <asp:BoundField DataField="FechaPago" HeaderText="Fecha de Pago" DataFormatString="{0:dd/MM/yyyy}" />
                    <asp:BoundField DataField="MetodoPago" HeaderText="Estado de pago" />
                    <asp:BoundField DataField="Subtotal" HeaderText="Subtotal" />
                    <asp:BoundField DataField="IGV" HeaderText="IGV" />
                    <asp:BoundField DataField="Total" HeaderText="Total" />
                </Columns>
            </asp:GridView>
        </div>
        <div class="card-footer">
            <!-- Botón Imprimir -->
            <asp:Button ID="btnImprimir" CssClass="btn btn-success float-start" runat="server" Text="Imprimir" OnClientClick="window.print(); return false;" />
        </div>
    </div>
</div>


</asp:Content>
