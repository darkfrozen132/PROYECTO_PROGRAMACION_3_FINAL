<%@ Page Title="" Language="C#" MasterPageFile="MasterInventario.master" AutoEventWireup="true" CodeBehind="modificarProducto.aspx.cs" Inherits="PruebaBootstrap.modificarProducto" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphInventarioContenido" runat="server">
        <h2>Modificar Producto</h2>
    
    <script type="text/javascript">
        function validarSeleccionProducto() {
            var ddlProducto = document.getElementById('<%= ddlProducto.ClientID %>');
            if (ddlProducto.value === "0") {
                alert("Por favor, seleccione un producto válido.");
                return false; // Evita que el formulario se envíe
            }
            return true; // Permite el envío del formulario si se selecciona un producto válido
        }
    </script>

    <div class="row">
        <!-- Nombre de Producto -->
        <div class="col-md-6">
            <div class="form-group">
                <label for="txtNombreProducto">Nombre del Producto:</label>
                
                <asp:DropDownList ID="ddlProducto" runat="server" AutoPostBack="true" CssClass="form-select" 
                    OnSelectedIndexChanged="ddlProducto_SelectedIndexChanged"></asp:DropDownList>
                
                 <!--
                <asp:TextBox ID="txtNombreProducto" runat="server" CssClass="form-control" placeholder="Modifique el nombre del Producto" />
                    -->
            </div>
        </div>
    </div>
    <hr />
    <div class="row mt-4">
        <!-- Selección de Estado con RadioButtons alineados -->
        <div class="col-md-6">
            <label>Modifique el Estado del Producto:</label>
            <asp:RadioButtonList ID="rbEstado" runat="server" RepeatDirection="Horizontal" CellPadding="5" CssClass="form-control RadioButtonList">
                <asp:ListItem Value="ACTIVO" Text="ACTIVO" />
                <asp:ListItem Value="INACTIVO" Text="INACTIVO" />
               </asp:RadioButtonList>
        </div>
    </div>

    <div class="row">
        <!-- Precio -->
        <div class="col-md-6">
            <div class="form-group">
                <label for="txtPrecio">Precio del Producto:</label>
                <asp:TextBox ID="txtPrecio" runat="server" CssClass="form-control" placeholder="Modifique el Precio del Producto" />
            </div>
        </div>
    </div>

    <div class="row">
        <!-- Nombre -->
        <div class="col-md-6">
            <div class="form-group">
                <label for="txtNombreProductoModificar">Nombre del Producto:</label>
                <asp:TextBox ID="txtNombreProductoModificar" runat="server" CssClass="form-control" placeholder="Modifique el nombre del Producto" />
            </div>
        </div>
    </div>

    <div class="row mt-4">
        <!-- Botones de Acción -->
        <div class="col-md-12 text-end">
            <asp:Button ID="btnCancelar" runat="server" Text="Cancelar" CssClass="btn btn-secondary me-2" OnClick="BtnCancelar_Click" />
            <asp:Button ID="btnLimpiar" runat="server" Text="Limpiar" CssClass="btn btn-warning me-2" OnClick="BtnLimpiar_Click"/>
            <asp:Button ID="btnGuardar" runat="server" Text="Modificar" CssClass="btn btn-primary"  OnClick="BtnGuardar_Click" OnClientClick="return validarSeleccionProducto();" />
        </div>
    </div>
</div>
</asp:Content>
