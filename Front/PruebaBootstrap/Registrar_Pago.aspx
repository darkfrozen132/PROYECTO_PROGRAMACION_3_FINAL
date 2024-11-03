<%@ Page Title="" Language="C#" MasterPageFile="~/MasterVentas.master" AutoEventWireup="true" CodeBehind="Registrar_Pago.aspx.cs" Inherits="PruebaBootstrap.Registrar_Pago" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphVentasContenido" runat="server">

    <!-- Agregar JavaScript para manejar el cambio de contenido basado en la selección -->
    <script type="text/javascript">
        function mostrarResumen() {
            var ddl = document.getElementById('<%= ddlPedidos.ClientID %>');
            var pedidoSeleccionado = ddl.value;

            // Ocultar ambos paneles por defecto
            document.getElementById("resumenPedido1").style.display = "none";
            document.getElementById("resumenPedido2").style.display = "none";

            // Mostrar el resumen según el pedido seleccionado
            if (pedidoSeleccionado === "1") {
                document.getElementById("resumenPedido1").style.display = "block";
            } else if (pedidoSeleccionado === "2") {
                document.getElementById("resumenPedido2").style.display = "block";
            }
        }
    </script>

    <div class="container">
           <h2>Registrar Pago</h2>
        <div class="row">
            <!-- Selección de Pedido -->
            <div class="col-md-6">
                <div class="form-group">
                    <label for="ddlPedidos">Vincular Pedido:</label>
                    <asp:DropDownList ID="ddlPedidos" runat="server" CssClass="form-control" AutoPostBack="False" onchange="mostrarResumen();">
                        <asp:ListItem Text="--Seleccionar pedido--" Value="0" />
                        <asp:ListItem Text="Pedido 1" Value="1" />
                        <asp:ListItem Text="Pedido 2" Value="2" />
                    </asp:DropDownList>
                </div>
            </div>

            <!-- Tipo de Pago -->
            <div class="col-md-6">
                <div class="form-group">
                    <label>Tipo de Pago:</label>
                    <div>
                        <asp:RadioButton ID="rdbEfectivo" runat="server" GroupName="TipoPago" Text="Efectivo" />
                        <asp:RadioButton ID="rdbTransferencia" runat="server" GroupName="TipoPago" Text="Transferencia" />
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-4">
            <!-- Resumen del Pedido para Pedido 1 -->
            <div id="resumenPedido1" class="col-md-6" style="display:none;">
                <h4>Resumen del pedido (Pedido 1):</h4>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Nombre del Producto</th>
                            <th>Cant.</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Four Loko</td>
                            <td>3</td>
                        </tr>
                        <tr>
                            <td>Smirnoff Ice</td>
                            <td>3</td>
                        </tr>
                        <tr>
                            <td>Mike's Hard Lemonade</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <td>White Claw</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <td>Twisted Tea</td>
                            <td>1</td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <!-- Resumen del Pedido para Pedido 2 -->
            <div id="resumenPedido2" class="col-md-6" style="display:none;">
                <h4>Resumen del pedido (Pedido 2):</h4>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Nombre del Producto</th>
                            <th>Cant.</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Coca-Cola</td>
                            <td>5</td>
                        </tr>
                        <tr>
                            <td>Pepsi</td>
                            <td>4</td>
                        </tr>
                        <tr>
                            <td>Sprite</td>
                            <td>2</td>
                        </tr>
                        <tr>
                            <td>Fanta</td>
                            <td>3</td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <!-- Resumen de Pago -->
            <div class="col-md-6">
                <h4>Resumen de Pago:</h4>
                <div class="form-group">
                    <label for="txtSubtotal">Subtotal:</label>
                    <asp:TextBox ID="txtSubtotal" runat="server" CssClass="form-control" />
                </div>
                <div class="form-group">
                    <label for="txtIGV">IGV:</label>
                    <asp:TextBox ID="txtIGV" runat="server" CssClass="form-control" />
                </div>
                <div class="form-group">
                    <label for="txtTotal">Total:</label>
                    <asp:TextBox ID="txtTotal" runat="server" CssClass="form-control" />
                </div>
            </div>
        </div>

        <div class="row mt-4">
            <!-- Botones -->
            <div class="col-md-12 text-end">
                <asp:Button ID="btnCancelar" runat="server" Text="Cancelar" CssClass="btn btn-secondary me-2" />
                <asp:Button ID="btnLimpiar" runat="server" Text="Limpiar" CssClass="btn btn-warning me-2" />
                <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="btn btn-primary" />
            </div>
        </div>
    </div>


</asp:Content>
