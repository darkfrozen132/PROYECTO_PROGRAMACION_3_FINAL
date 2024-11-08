<%@ Page Title="" Language="C#" MasterPageFile="~/MasterVentas.master" AutoEventWireup="true" CodeBehind="Registrar_Pago.aspx.cs" Inherits="PruebaBootstrap.Registrar_Pago" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphVentasContenido" runat="server">

    <div class="container">
        <h2>Registrar Estado de Pedido</h2>
        <div class="row">
            <!-- ID de Pedido -->
            <div class="col-md-6">
                <div class="form-group">
                    <label for="txtPedidoID">ID del Pedido:</label>
                    <asp:TextBox ID="txtPedidoID" runat="server" CssClass="form-control" placeholder="Ingrese el ID del pedido" />
                </div>
            </div>
        </div>

        <div class="row mt-4">
            <!-- Selección de Estado con RadioButtons alineados -->
            <div class="col-md-6">
                <label>Estado del Pedido:</label>
                <asp:RadioButtonList ID="rbEstado" runat="server" RepeatDirection="Horizontal" CellPadding="5" CssClass="form-control RadioButtonList">
                    <asp:ListItem Value="PAGADO" Text="PAGADO" />
                    <asp:ListItem Value="CANCELADO" Text="CANCELADO" />
                   </asp:RadioButtonList>
            </div>
        </div>

        <div class="row mt-4">
            <!-- Botones de Acción -->
            <div class="col-md-12 text-end">
                <asp:Button ID="btnCancelar" runat="server" Text="Cancelar" CssClass="btn btn-secondary me-2" OnClick="BtnCancelar_Click" />
                <asp:Button ID="btnBorrar" runat="server" Text="Borrar" CssClass="btn btn-warning me-2" OnClick="BtnBorrar_Click"/>
                <asp:Button ID="btnAceptar" runat="server" Text="Aceptar" CssClass="btn btn-primary"  OnClick="BtnAceptar_Click" />
            </div>
        </div>
    </div>

</asp:Content>
