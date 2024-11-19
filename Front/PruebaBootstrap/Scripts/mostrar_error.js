function mostrarError(mensaje) {
    // Busca el contenedor de error en el DOM
    let mensajeError = document.getElementById("mensajeError");

    // Si no existe, lo crea
    if (!mensajeError) {
        mensajeError = document.createElement("div"); // Crea el contenedor
        mensajeError.id = "mensajeError"; // Asigna el ID
        mensajeError.className = "popup error-popup"; // Aplica las clases CSS
        document.body.appendChild(mensajeError); // Agrega el contenedor al cuerpo del documento
    }

    // Agrega el mensaje de error y lo muestra
    mensajeError.textContent = mensaje;
    mensajeError.style.display = "block";

    // Oculta el mensaje después de 2 segundos
    setTimeout(() => {
        mensajeError.style.display = "none";
    }, 4000);
}