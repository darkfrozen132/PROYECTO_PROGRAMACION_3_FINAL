function actualizarMaxLength() {
    var tipoDOI = document.getElementById("<%=rbTipoDOI.ClientID%>");
    var txtDOI = document.getElementById("<%=txtDOI.ClientID%>");
    
    console.log("tipoDOI: ", tipoDOI);
    console.log("txtDOI: ", txtDOI);

    if (tipoDOI && txtDOI) {
        var maxLength;
        switch (tipoDOI.value) {
            case "DNI":
                maxLength = 8;
                break;
            case "RUC":
                maxLength = 12;
                break;
            case "PASAPORTE":
                maxLength = 20;
                break;
            default:
                maxLength = 20; // Valor por defecto
                break;
        }

        // Establece el nuevo maxLength
        txtDOI.maxLength = maxLength;

        // Recorta el contenido del TextBox si excede el maxLength
        if (txtDOI.value.length > maxLength) {
            txtDOI.value = txtDOI.value.slice(0, maxLength);
        }
    }
    console.log("ClientID de rbTipoDOI: ", "<%= rbTipoDOI.ClientID %>");
    console.log("ClientID de txtDOI: ", "<%= txtDOI.ClientID %>");
}

function seIngresoNumero(evt) {
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false; // Solo permite números, si detecta un caracter no numérico no deja escribir en el text box
    }
    return true;
}

//Muestra el modal
function mostrarModal() {
    var modal = document.getElementById("modalConfirmacion");
    modal.style.display = "flex";
}

//Volver al inicio
function volverInicio() {
    console.log("Redirigiendo a: /Home.aspx");
    window.location.href = '/Home.aspx';

}

// Función para refrescar la página
function registrarOtroCliente() {
    window.location.reload();
}

function mostrarError() {
    // Crear el pop-up de error
    const errorPopup = document.createElement('div');
    errorPopup.innerText = "Error: Hay uno o varios campos vacíos";
    errorPopup.className = "popup error-popup";
    document.body.appendChild(errorPopup);

    // Ocultar el mensaje después de 2 segundos
    setTimeout(() => {
        errorPopup.remove();
    }, 3000);
}

function mostrarErrorRepetidos() {
    // Crear el pop-up de error
    const errorPopup2 = document.createElement('div');
    errorPopup2.innerText = "Error: El cliente que intenta registrar posee un DOI que ya existe";
    errorPopup2.className = "popup error-popup";
    document.body.appendChild(errorPopup2);

    // Ocultar el mensaje después de 2 segundos
    setTimeout(() => {
        errorPopup2.remove();
    }, 3000);
}