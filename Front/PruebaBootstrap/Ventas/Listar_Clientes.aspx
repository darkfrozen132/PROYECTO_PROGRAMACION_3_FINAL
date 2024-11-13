<%@ Page Title="" Language="C#" MasterPageFile="MV_GesCli.master" AutoEventWireup="true" CodeBehind="Listar_Clientes.aspx.cs" Inherits="PruebaBootstrap.Listar_Clientes" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphVentas_Gestion_Clientes" runat="server">
<div class="container">
    <div class="card">
        <div class="card-header">
            <h2>Listar Clientes</h2>
        </div>

        <div class="card-body">
            <div class="row mb-3">
                <div class="col-md-2">
                    <label for="txtDesde">Nombre (Razon social)</label>
                    <asp:TextBox ID="txtNombre" runat="server" TextMode="Search" CssClass="form-control"></asp:TextBox>
                </div>

                <div class="col-md-2">
                    <label for="txtHasta">Codigo ("CLI-")</label>
                    <asp:TextBox ID="txtCodigo" runat="server" TextMode="Search" CssClass="form-control"></asp:TextBox>
                </div>


                <div class="col-md-2">
                    <asp:Button ID="btnFiltrar" runat="server" CssClass="btn btn-primary mt-4" Text="Filtrar" OnClick="btnFiltrar_Click"/>
                </div>
            </div>

            <asp:GridView ID="gvResumen" runat="server" AutoGenerateColumns="False" CssClass="table table-striped" AllowPaging="true" PageSize="5" OnPageIndexChanging="gvResumen_PageIndexChanging" ShowFooter="true" OnRowDataBound="gvResumen_RowDataBound">
                <Columns>
                    <asp:BoundField DataField="Codigo" HeaderText="Codigo" />
                    <asp:BoundField DataField="Nombre" HeaderText="Nombre" />
                    <asp:BoundField DataField="Fecha Registro" HeaderText="Fecha Registro" DataFormatString="{0:dd/MM/yyyy}"/>
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
