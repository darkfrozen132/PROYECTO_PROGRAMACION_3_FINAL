<%@ Page Title="" Language="C#" MasterPageFile="~/Inventario/MasterInventario.master" AutoEventWireup="true" CodeBehind="AlertasDeStock.aspx.cs" Inherits="PruebaBootstrap.Inventario.AlertasDeStock" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphInventarioContenido" runat="server">
<div class="container">
    <div class="card">
        <div class="card-header">
            <h2>PRODUCTOS EN ALERTA DE STOCK</h2>
        </div>

        <div class="card-body">

            <asp:GridView ID="gvAlertas" runat="server" AutoGenerateColumns="False" CssClass="table table-striped" AllowPaging="true" PageSize="8" OnPageIndexChanging="gvAlertas_PageIndexChanging" ShowFooter="true" OnRowDataBound="gvAlertas_RowDataBound">
                <Columns>
                    <asp:BoundField DataField="Producto" HeaderText="PRODUTCO" />
                    <asp:BoundField DataField="Marca" HeaderText="MARCA" />
                    <asp:BoundField DataField="Direccion" HeaderText="DIRECCION DEL ALMACEN" />
                    <asp:BoundField DataField="NroTorre" HeaderText="NRO. TORRE" />
                    <asp:BoundField DataField="Stock" HeaderText="STOCK"/>
                </Columns>
            </asp:GridView>
           
        </div>
        <div class="card-footer">
            <!-- Botón Imprimir -->
            <asp:Button ID="Button1" CssClass="btn btn-success float-start" runat="server" Text="Imprimir" OnClientClick="window.print(); return false;" />
        </div>
    </div>
</div>
</asp:Content>
