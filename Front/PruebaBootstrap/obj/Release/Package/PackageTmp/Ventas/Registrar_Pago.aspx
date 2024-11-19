<%@ Page Title="" Language="C#" MasterPageFile="MasterVentas.master" AutoEventWireup="true" CodeBehind="Registrar_Pago.aspx.cs" Inherits="PruebaBootstrap.Registrar_Pago" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphVentasContenido" runat="server">

    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Registrar Pago</h2>
            </div>

            <div class="card-body">
                <!-- Filtros de fecha -->
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
                        <asp:Button ID="btnFiltrar" runat="server" CssClass="btn btn-primary mt-4" Text="Filtrar" OnClick="btnFiltrar_Click" />
                    </div>
                </div>

                <!-- GridView para mostrar el resumen de pagos -->
                <asp:GridView ID="gvResumen" runat="server" AutoGenerateColumns="False" CssClass="table table-striped" AllowPaging="true" PageSize="5" OnPageIndexChanging="gvResumen_PageIndexChanging" OnSelectedIndexChanged="gvResumen_SelectedIndexChanged" DataKeyNames="ID" >
                    <Columns>
                        <asp:ButtonField ButtonType="Button" CommandName="Select" Text="Seleccionar" />

                        <asp:BoundField DataField="Nombre" HeaderText="Nombre" />
                        <asp:BoundField DataField="Fecha" HeaderText="Fecha" DataFormatString="{0:dd/MM/yyyy}" />
                        <asp:BoundField DataField="Total" HeaderText="Total" DataFormatString="{0:C}" />
                    </Columns>
                </asp:GridView>

        <asp:Panel ID="pnlDetalles" runat="server" Visible="false">
             <div class="row mt-3">
            <div class="col-md-2">
                <label for="txtPedidoID">ID del Pedido</label>
                <asp:TextBox ID="txtPedidoID" runat="server" CssClass="form-control" ReadOnly="true" />
            </div>

            <div class="col-md-4">
                <label>Estado del Pedido</label>
                <asp:RadioButtonList ID="rbEstado" runat="server" CssClass="form-control">
                    <asp:ListItem Text="PAGADO" Value="PAGADO"></asp:ListItem>
                    <asp:ListItem Text="CANCELADO" Value="CANCELADO"></asp:ListItem>
                </asp:RadioButtonList>
            </div>
        </div>
        
        <div class="row mt-3">
            <div class="col-md-2">
                <asp:Button ID="BtnAceptar" runat="server" Text="Aceptar" CssClass="btn btn-success" OnClick="BtnAceptar_Click" />
            </div>
            <div class="col-md-2">
                <asp:Button ID="BtnBorrar" runat="server" Text="Borrar" CssClass="btn btn-warning" OnClick="BtnBorrar_Click" />
            </div>
            <div class="col-md-2">
                <asp:Button ID="BtnCancelar" runat="server" Text="Cancelar" CssClass="btn btn-danger" OnClick="BtnCancelar_Click" />
            </div>
        </div>
    </asp:Panel>
            </div>
        </div>
    </div>

</asp:Content>
