function mostrarEditDoc() {
    var estado = document.getElementById("areaEditarDoc").style.display;
    if (estado === "none") {
        document.getElementById("areaEditarDoc").style.display = "block";
    } else {
        document.getElementById("areaEditarDoc").style.display = "none";
    }
}