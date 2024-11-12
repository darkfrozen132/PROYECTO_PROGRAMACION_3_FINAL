<%@ Page Title="" Language="C#" MasterPageFile="MasterVentas.master" AutoEventWireup="true" CodeBehind="Resumen_DiarioMensual.aspx.cs" Inherits="PruebaBootstrap.Resumen_DiarioMensual" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphVentasContenido" runat="server">

    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Resumen Diario/Mensual
                </h2>
            </div>

            <div class="card-body">
                <div class="row mb-3">
                    <div class="col-md-2">
                        <label for="txtDesde">Desde</label>
                        <asp:TextBox ID="txtDesde" runat="server" TextMode="Date" CssClass="form-control"></asp:TextBox>
                    </div>

                    <div class="col-md-2">
                        <label for="txtHasta">Hasta</label>
                        <asp:TextBox ID="txtHasta" runat="server" TextMode="Date" CssClass="form-control"></asp:TextBox>
                    </div>


                    <div class="col-md-2">
                        <asp:Button ID="btnFiltrar" runat="server" CssClass="btn btn-primary mt-4" Text="Filtrar" OnClick="btnFiltrar_Click"/>
                    </div>
                </div>

                <asp:GridView ID="gvResumen" runat="server" AutoGenerateColumns="False" CssClass="table table-striped" AllowPaging="true" PageSize="5" OnPageIndexChanging="gvResumen_PageIndexChanging" ShowFooter="true" OnRowDataBound="gvResumen_RowDataBound">
                    <Columns>
                        <asp:BoundField DataField="Fecha" HeaderText="Fecha" DataFormatString="{0:dd/MM/yyyy}"/>
                        <asp:BoundField DataField="Cantidad de pedidos" HeaderText="Cantidad de pedidos" />
                        <asp:BoundField DataField="Total vendido" HeaderText="Total vendido" />
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
