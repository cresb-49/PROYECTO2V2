function mostrarCrearDoc() {
    var estado = document.getElementById("crearDoc").style.display;
    if (estado === "none") {
        document.getElementById("crearDoc").style.display = "block";
    } else {
        document.getElementById("crearDoc").style.display = "none";
    }
}