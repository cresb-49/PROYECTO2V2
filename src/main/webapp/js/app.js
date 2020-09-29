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
    texto: /^([A-Za-z_-]+)$/
};

function validarRegistroPaciente() {
    var nombre, sexo, DPI, telefono, peso, sangre, correo, password, password2, fecha;

    nombre = document.getElementById("nombrePaciente").value;
    sexo = document.getElementById("sexoPaciente").value;
    DPI = document.getElementById("DPIPaciente").value;
    telefono = document.getElementById("telefonoPaciente").value;
    peso = document.getElementById("pesoPaciente").value;
    sangre = document.getElementById("tipoSangre").value;
    correo = document.getElementById("correoPaciente").value;
    password = document.getElementById("passPaciente").value;
    password2 = document.getElementById("passPacienteVer").value;
    fecha = document.getElementById("fechaNacimiento").value;

    if (nombre === "" || DPI === "" || telefono === "" || peso === "" || correo === "" || password === "" || password2 === "") {
        alert("Todos los campos son obligatorios");
        return false;
    } else if (nombre.length > 60) {
        alert("El nombre es muy largo");
        return false;
    } else if (!exprecionesRegulares.nombre.test(nombre)) {
        alert("No es nombre valido\nDebe estar escrito de la forma Juan Perez");
        return false;
    } else if (correo.length > 45) {
        alert("El correo es muy largo");
        return false;
    } else if (!(exprecionesRegulares.fecha.test(fecha))) {
        alert("La fecha introducida no es valida")
        return false;
    } else if (!(exprecionesRegulares.correo.test(correo))) {
        alert("El correo no es valido");
        return false;
    } else if (!(exprecionesRegulares.telefono.test((telefono)))) {
        alert("No es numero de telefono valido");
        return false;
    } else if (!(exprecionesRegulares.nDpi.test(DPI))) {
        alert("No es numero de DPI valido\nRecuerda debe tener 13 digitos");
        return false;
    } else if (!(exprecionesRegulares.tiposSangre.test(sangre))) {
        alert("Debe se seleccionar un tipo de sangre");
        return false;
    } else if (!(exprecionesRegulares.sexo.test(sexo))) {
        alert("Debe de seleccionar un sexo");
        return false;
    } else if (!(exprecionesRegulares.IntOrDouble.test(peso))) {
        alert("El peso introducido no es valido");
        return false;
    } else if (password.length > 45 || password2.length > 45) {
        alert("La password no debe superar los 45 caracteres");
        return false;
    } else if (!(password === password2)) {
        alert("Las password no concuerdan");
        return false;
    }
    return true;
}
function validarModificaionMedico(){
    var nombre,numeroColegiado, DPI, telefono,inicioHorario,finHorario,especialidades,inicioTrabajo;
    
    nombre = document.getElementById("nameDoctor").value;
    numeroColegiado = document.getElementById("coleDoctor").value;
    telefono=document.getElementById("telDoctor").value;
    DPI = document.getElementById("DPIDoctor").value;
    inicioHorario=document.getElementById("inicioDoctor").value;
    finHorario=document.getElementById("finDoctor").value;
    especialidades = document.getElementById("espeDoctor");
    inicioTrabajo=document.getElementById("incioTrabajo").value;
    
    if(especialidades.options.length===0){
        alert("No ah ingresado ninguna especialidad");
        return false;
    }else if (nombre === "" || DPI === "" || telefono === ""||numeroColegiado===""||inicioHorario===""||finHorario===""||inicioTrabajo==="") {
        alert("Todos los campos son obligatorios");
        return false;
    }
    for(var i =0;i<especialidades.options.length;i++){
        var especilidad = especialidades.options[i].value;
        if(!exprecionesRegulares.texto.test(especilidad)){
            alert("La especialidad introucida no es valida");
            return false;
        }
    }
    if (nombre.length > 60) {
        alert("El nombre es muy largo");
        return false;
    } else if (!exprecionesRegulares.nombre.test(nombre)) {
        alert("No es nombre valido\nDebe estar escrito de la forma Juan Perez");
        return false;
    } else if (!(exprecionesRegulares.telefono.test((telefono)))) {
        alert("No es numero de telefono valido\nRecuerda debe tener 8 digitos");
        return false;
    } else if (!(exprecionesRegulares.nDpi.test(DPI))) {
        alert("No es numero de DPI valido\nRecuerda debe tener 13 digitos");
        return false;
    } else if(!(exprecionesRegulares.numeroEntero.test(numeroColegiado))){
        alert("El numero de colegiado no es valido solo deben ser numeros");
        return false;
    }
    for(var i =0;i<especialidades.options.length;i++){
        especialidades.options[i].selected = true;
    }
}

function mostrarEditDoc() {
    var estado = document.getElementById("areaEditarDoc").style.display;
    if (estado === "none") {
        document.getElementById("areaEditarDoc").style.display = "block";
    } else {
        document.getElementById("areaEditarDoc").style.display = "none";
    }
}

function eliminarEspecialidad() {
    var combo = document.getElementById("espeDoctor");
    combo.remove(document.getElementById("espeDoctor").selectedIndex);
}

function agregarEspecialidad() {
    var texto = document.getElementById("ingresoEspecialidad");
    if (texto.value.length === 0) {
        alert("Debe de escribir la especilidad");
    } else if (!(exprecionesRegulares.texto.test(texto.value))){
        alert("El texto introducido no es valido")
    }else{
        var combo = document.getElementById("espeDoctor");
        var option=document.createElement("option");
        combo.options.add(option,0);
        combo.options[0].value=texto.value;
        combo.options[0].innerText=texto.value;
        texto.value="";
    }
}