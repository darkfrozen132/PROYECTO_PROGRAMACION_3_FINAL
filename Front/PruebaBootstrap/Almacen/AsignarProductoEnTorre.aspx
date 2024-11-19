<%@ Page Title="Asignar Producto a Torre" Language="C#" MasterPageFile="~/Almacen/MasterAlmacen.master" AutoEventWireup="true" CodeBehind="AsignarProductoEnTorre.aspx.cs" Inherits="PruebaBootstrap.Almacen.AsignarProductoEnTorre" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphInventarioContenido" runat="server">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>

    <style>
        .grid-container {
            display: grid;
            grid-template-columns: repeat(5, 1fr); /* Ajustar columnas */
            gap: 10px;
            padding: 10px;
        }
        .grid-item {
            padding: 20px;
            text-align: center;
            background-color: #ccc;
            border: 1px solid #aaa;
            cursor: pointer;
        }
        .available {
            background-color: #4CAF50; /* Verde */
        }
        .occupied {
            background-color: #F44336; /* Rojo */
        }
        .legend-container {
            display: flex;
            align-items: center;
            gap: 20px;
            padding: 10px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        .legend-item {
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .legend-color {
            width: 20px;
            height: 20px;
            border-radius: 3px;
        }
        .legend-green {
            background-color: #4CAF50; /* Verde */
        }
        .legend-red {
            background-color: #F44336; /* Rojo */
        }
    </style>

    <script>
        $(document).ready(function () {
            // Activar autocompletado en el input de producto
            $("#producto").autocomplete({
                source: function (request, response) {
                    $.ajax({
                        url: "AsignarProductoEnTorre.aspx/GetProductos",
                        type: "POST",
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        data: JSON.stringify({ searchTerm: request.term }),
                        success: function (data) {
                            response(data.d); // La respuesta del servidor
                        },
                        error: function () {
                            alert("Error al buscar productos.");
                        }
                    });
                },
                minLength: 0 // Buscar después de escribir al menos 0 caracteres
            });
        });

        function openModal(torreId, estado) {
            document.getElementById("torreId").value = torreId;
            document.getElementById("estadoActual").innerText = estado == 1 ? "Ocupado" : "Disponible";
            document.getElementById("assignModal").style.display = "block";
        }

        function closeModal() {
            document.getElementById("assignModal").style.display = "none";
        }
    </script>

    <h1>Gestión de Torres</h1>
    <label for="ddlAlmacenes">Seleccionar Almacén:</label>
    <asp:DropDownList ID="ddlAlmacenes" runat="server" AutoPostBack="true" OnSelectedIndexChanged="ddlAlmacenes_SelectedIndexChanged">
    </asp:DropDownList>

    <!-- Leyenda de colores -->
    <div class="legend-container">
        <div class="legend-item">
            <div class="legend-color legend-green"></div>
            <span>Libre</span>
        </div>
        <div class="legend-item">
            <div class="legend-color legend-red"></div>
            <span>Ocupado</span>
        </div>
    </div>

    <!-- Contenedor de torres -->
    <div class="grid-container">
        <asp:Literal ID="litTorres" runat="server"></asp:Literal>
    </div>

    <!-- Modal para asignar producto -->
    <div id="assignModal" style="display:none; padding:20px; border:1px solid #000; background-color:#fff;">
        <h2>Asignar Producto</h2>
        <p>ID Torre: <input type="text" id="torreId" readonly /></p>
        <p>Estado Actual: <span id="estadoActual"></span></p>
        <label for="producto">Producto:</label>
        <input type="text" id="producto" name="producto" />
        <button type="button" onclick="closeModal()">Cancelar</button>
        <asp:Button ID="btnAsignar" runat="server" Text="Asignar" OnClick="AsignarProducto_Click" />
    </div>
</asp:Content>

