const exprecionesRegulares = {
    nombre: /^[A-Z][a-z]+([\s][A-Z][a-z]+){1,5}$/,
    correo: /^[a-zA-Z0-9_-]+@[a-zA-z]+\.[a-z]+$/,
    telefono: /^[0-9]{8}$/,
    nDpi: /^[0-9]{13}$/,
    numeroEntero: /^[\d]+$/,
    IntOrDouble: /^(([\d]+\.[\d]+)|([\d]+))$/,
    tiposSangre: /^(([A]|[B]|[O]|([A][B]))|([A]|[B]|[O]|([A][B]))(\+|\-))$/,
    sexo: /^(([H][o][m][b][r][e])|([M][u][j][e][r]))$/,
    fecha: /^[0-9]{4}\-[0-9]{2}\-[0-9]{2}$/,
    texto: /^([A-Za-z_-]+)$/,
    codigoDoctor: /^[M][E][D][-][0-9]+$/,
    codigoLaboratorista: /^[L][A][B][-][0-9]+$/,
    codigoAdmin: /^[A][D][M][I][N][0-9]+$/,
    registroSalud: /^[S][A][L][U][D][-][0-9]+$/,
    diasSemana: /^((Lunes)|(Martes)|(Miercoles)|(Jueves)|(Viernes)|(Sabado)|(Domingo))$/,
    estadoOrden: /^((TRUE)|(FALSE))$/,
    formatoInforme: /^((PDF)|(IMG))$/
};
function validarModificacionExamen(){

    var nombreEx,orden,descripcion,costo,informe;

    nombreEx = document.getElementById("nombreExamen").value;
    orden = document.getElementById("ordenExamen").value;
    descripcion = document.getElementById("descripcionExamen").value;
    costo = document.getElementById("costoExamen").value;
    informe = document.getElementById("informeExamen").value;

    if(nombreEx===""||orden===""||descripcion===""||costo===""||informe===""){
        alert("Todos los campos son obligatorios");
        return false;
    }else if (!exprecionesRegulares.nombre.test(nombreEx)){
        alert("El nombre del examen no es valido");
        return false;
    }else if(!exprecionesRegulares.estadoOrden.test(orden)){
        alert("Selececcione un estado de orden");
        return false;
    }else if(descripcion.length===0){
        alert("Debe de agregar una descripcion para el examen");
        return false;
    }else if(!exprecionesRegulares.IntOrDouble.test(costo)){
        alert("El costo asignado no es valido");
        return false;
    }else if(!exprecionesRegulares.formatoInforme.test(informe)){
        alert("Debe de agregar un formato de informe");
        return false;
    }
    return true;
}

function validarAdmin(){
    var nombreAdmin,numeroDPI,codigoAd,passAd1,passAd2;
    nombreAdmin = document.getElementById("nombreAdmin").value;
    numeroDPI = document.getElementById("DPIAdmin").value;
    codigoAd = document.getElementById("codigoAdmin").value;
    passAd1 = document.getElementById("passAdmin").value;
    passAd2 = document.getElementById("passAdmin2").value;

    if (nombreAdmin ===""||numeroDPI===""||codigoAd===""||passAd1===""||passAd2===""){
        alert("Todos los campos son obligatorios");
        return false;
    }else if(!exprecionesRegulares.nombre.test(nombreAdmin)){
        alert("El nombre del admin no es valido debe ser de la forma Juan Perez");
        return false;
    }else if(!exprecionesRegulares.nDpi.test(numeroDPI)){
        alert("El numero de DPI no es valido debe tener 13 digitos");
        return false;
    }else if(!exprecionesRegulares.codigoAdmin.test(codigoAd)){
        alert("El codigo del Admintrador no es valido");
        return false;
    }else if((passAd1.length>45||passAd2.length>45)){
        alert("La password es muy larga");
        return false;
    }else if(!(passAd1===passAd2)){
        alert("Las password no coinciden");
        return false;
    }
    return true;
}