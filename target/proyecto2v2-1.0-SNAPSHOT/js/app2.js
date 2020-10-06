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
    }else if (!exprecionesRegulares.texto.test(nombreEx)){
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

function validarModificacionAdmin(){
    var nombreAdmin,numeroDPI,codigoAd,passAd1,passAd2;
    nombreAdmin = document.getElementById("nombreAdmin").value;
    numeroDPI = document.getElementById("DPIAdmin").value;

    if (nombreAdmin ===""||numeroDPI===""){
        alert("Todos los campos son obligatorios");
        return false;
    }else if(!exprecionesRegulares.nombre.test(nombreAdmin)){
        alert("El nombre del admin no es valido debe ser de la forma Juan Perez");
        return false;
    }else if(!exprecionesRegulares.nDpi.test(numeroDPI)){
        alert("El numero de DPI no es valido debe tener 13 digitos");
        return false;
    }
    return true;
}

function validarCita(){
    var codigoDoc,especialidad,fecha,hora;
    codigoDoc = document.getElementById("codigoDoctor").value;
    especialidad = document.getElementById("especilidadCita").value;
    fecha = document.getElementById("fechaCita").value;
    hora = document.getElementById("horaCita").value;
    
    if(!exprecionesRegulares.codigoDoctor.test(codigoDoc)){
        alert("El codigo del doctor no es valido");
        return false;
    }else if(!exprecionesRegulares.texto.test(especialidad)){
        alert("El nombre de la especialidad no es valido");
        return false;
    }else if(fecha.length===0){
        alert("La fecha no es valida");
        return false;
    }else if(hora.length===0){
        alerte("La hora no es valida");
        return false;
    }else if(!exprecionesRegulares.fecha.test(fecha)){
        alert("La fecha no es valida");
        return false;
    }
    return true;
}

function validarCitaLab(){
    var codigoExamen,codigoLab,fecha;
    codigoExamen = document.getElementById("codigoExamen").value;
    codigoLab = document.getElementById("codigoLab").value;
    fecha = document.getElementById("fechaCita").value;
    if(!exprecionesRegulares.codigoLaboratorista.test(codigoLab)){
        alert("El codigo del doctor no es valido");
        return false;
    }else if(!exprecionesRegulares.numeroEntero.test(codigoExamen)){
        alert("El codigo del examen debe ser numerico");
        return false;
    }else if(fecha.length===0){
        alert("La fecha no es valida");
        return false;
    }if(!exprecionesRegulares.fecha.test(fecha)){
        alert("La fecha no es valida");
        return false;
    }
    return true;
}

function validarInforme(){
    var cCita,cPaciente,EspeCita,fecha,hora;

    cCita = document.getElementById("codeCita").value;
    cPaciente = document.getElementById("codePaciente").value;
    EspeCita = document.getElementById("especialidad").value;
    fecha = document.getElementById("fechaCita").value;
    hora = document.getElementById("horaCita").value;

    if(!exprecionesRegulares.numeroEntero.test(cCita)){
        alert("El codigo de cita no es correcto");
        return false;
    }else if(!exprecionesRegulares.numeroEntero.test(cPaciente)){
        alert("El codigo del paciente no es valido");
        return false;
    }else if(!exprecionesRegulares.texto.test(EspeCita)){
        alert("La especialidad de la cita no es correcta")
        return false;
    }else if(!exprecionesRegulares.fecha.test(fecha)){
        alert("La fecha introducida no es valida");
        return false;
    }else if(hora.length===0){
        alert("Debe de introducir una hora correcta");
        return false;
    }
    return true;
}