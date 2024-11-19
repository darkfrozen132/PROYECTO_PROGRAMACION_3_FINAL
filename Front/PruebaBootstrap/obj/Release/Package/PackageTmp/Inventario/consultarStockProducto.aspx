<%@ Page Title="" Language="C#" MasterPageFile="~/Inventario/MasterInventario.master" AutoEventWireup="true" CodeBehind="consultarStockProducto.aspx.cs" Inherits="PruebaBootstrap.Inventario.consultarStockProducto" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphInventarioContenido" runat="server">
<div class="container">
    <h2>Consultar Stock</h2>
    
    <!-- ddl para elegir el producto -->
    <div class="row">
        <!-- Nombre de Producto -->
        <div class="col-md-6">
            <div class="form-group">
                <label for="txtNombreProducto">NOMBRE DEL PRODUCTO:</label>
                
                <asp:DropDownList ID="ddlProducto" runat="server" AutoPostBack="true" CssClass="form-select" 
                    OnSelectedIndexChanged="ddlProducto_SelectedIndexChanged"></asp:DropDownList>
                
                 <!--
                <asp:TextBox ID="txtNombreProducto" runat="server" CssClass="form-control" placeholder="Modifique el nombre del Producto" />
                    -->
            </div>
        </div>
    </div>
    <hr />
    <!-- Aca se muestran los datos del producto -->
    <!--Nombre, Stock, Estado_Producto, Precio, FechaRegistro, Direccion, nroTorre, Marca-->
    <table class="table table-bordered">
        <tr>
            <th>NOMBRE DEL PRODUCTO</th>
            <td><asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" placeholder="Nombre del producto" ReadOnly="true" /></td>
        </tr>
        <tr>
            <th>STOCK DEL PRODUCTO</th>
            <td><asp:TextBox ID="txtStock" runat="server" CssClass="form-control" placeholder="Stock del producto" ReadOnly="true" /></td>
        </tr>
        <tr>
            <th>ESTADO DEL PRODUCTO</th>
            <td>
                <asp:RadioButtonList ID="rbEstado" runat="server" RepeatDirection="Horizontal" CellPadding="5" CssClass="form-control" Enabled="false">
                    <asp:ListItem Value="ACTIVO" Text="ACTIVO" />
                    <asp:ListItem Value="INACTIVO" Text="INACTIVO" />
                </asp:RadioButtonList>
            </td>
        </tr>
        <tr>
            <th>PRECIO DEL PRODUCTO</th>
            <td><asp:TextBox ID="txtPrecio" runat="server" CssClass="form-control" placeholder="Precio del Producto" ReadOnly="true" /></td>
        </tr>
        <tr>
            <th>FECHA DE REGISTRO</th>
            <td><asp:TextBox ID="txtFechaRegistro" runat="server" CssClass="form-control" placeholder="Fecha de registro del Producto" ReadOnly="true" /></td>
        </tr>
        <tr>
            <th>DIRECCION DEL ALMACEN</th>
            <td><asp:TextBox ID="txtDireccion" runat="server" CssClass="form-control" placeholder="Direccion del Almacen" ReadOnly="true" /></td>
        </tr>
        <tr>
            <th>NUMERO DE TORRE</th>
            <td><asp:TextBox ID="txtNroTorre" runat="server" CssClass="form-control" placeholder="Numero de torre en el Almacen" ReadOnly="true" /></td>
        </tr>
        <tr>
            <th>MARCA</th>
            <td><asp:TextBox ID="txtMarca" runat="server" CssClass="form-control" placeholder="Marca del Producto" ReadOnly="true" /></td>
        </tr>
    </table>
    <div class="card-footer">
        <!-- Botón Imprimir -->
        <!--
        <asp:Button ID="Button" CssClass="btn btn-success float-start" runat="server" Text="Imprimir" OnClientClick="window.print(); return false;" />
        -->
        <asp:Button ID="Button1" CssClass="btn btn-success float-start" runat="server" Text="Generar PDF" OnClick="Button1_Click" />

    </div>
</div>
</asp:Content>
