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
        alert("La fecha introducida no es valida");
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

function validarModificarPaciente() {
    var nombre, sexo, DPI, telefono, peso, sangre, fecha;

    nombre = document.getElementById("nombrePaciente").value;
    sexo = document.getElementById("sexoPaciente").value;
    DPI = document.getElementById("DPIPaciente").value;
    telefono = document.getElementById("telefonoPaciente").value;
    peso = document.getElementById("pesoPaciente").value;
    sangre = document.getElementById("tipoSangre").value;
    fecha = document.getElementById("fechaNacimiento").value;

    if (nombre === "" || DPI === "" || telefono === "" || peso === "") {
        alert("Todos los campos son obligatorios");
        return false;
    } else if (nombre.length > 60) {
        alert("El nombre es muy largo");
        return false;
    } else if (!exprecionesRegulares.nombre.test(nombre)) {
        alert("No es nombre valido\nDebe estar escrito de la forma Juan Perez");
        return false;
    } else  if (!(exprecionesRegulares.fecha.test(fecha))) {
        alert("La fecha introducida no es valida");
        return false;
    } else  if (!(exprecionesRegulares.telefono.test((telefono)))) {
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
    } else if (!(exprecionesRegulares.fecha.test(inicioTrabajo))) {
        alert("La fecha introducida de inicio de trabajo no es valida");
        return false;
    }
    for(var i =0;i<especialidades.options.length;i++){
        especialidades.options[i].selected = true;
    }
    return true;
}

function validarRegistroMedico(){
    var codigo,nombre,numeroColegiado,correo,DPI, telefono,inicioHorario,finHorario,especialidades,inicioTrabajo,password,password2;
    nombre = document.getElementById("nameDoctor").value;
    numeroColegiado = document.getElementById("coleDoctor").value;
    codigo = document.getElementById("codeDoctor").value;
    telefono=document.getElementById("telDoctor").value;
    correo = document.getElementById("emailDoctor").value;
    DPI = document.getElementById("DPIDoctor").value;
    inicioHorario=document.getElementById("inicioDoctor").value;
    finHorario=document.getElementById("finDoctor").value;
    especialidades = document.getElementById("espeDoctor");
    inicioTrabajo=document.getElementById("incioTrabajo").value;
    password = document.getElementById("passwordDoctor").value;
    password2 = document.getElementById("passwordDoctor2").value;
    
    if (nombre === "" || DPI === "" || telefono === ""||numeroColegiado===""||inicioHorario===""||finHorario===""||inicioTrabajo===""||correo===""||codigo===""||password===""||password2===""||especialidades.options.length===0){
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
    if(!exprecionesRegulares.codigoDoctor.test(codigo)){
        alert("El codigo del medico no es valido debe ser de la forma MED-XXX");
        return false;
    }else if (nombre.length > 60) {
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
    }else if (password.length > 45 || password2.length > 45) {
        alert("La password no debe superar los 45 caracteres");
        return false;
    } else if (!(password === password2)) {
        alert("Las password no concuerdan");
        return false;
    }else if (correo.length > 45) {
        alert("El correo es muy largo");
        return false;
    } else if (!(exprecionesRegulares.correo.test(correo))) {
        alert("El correo no es valido");
        return false;
    }
    
    for(var i =0;i<especialidades.options.length;i++){
        especialidades.options[i].selected = true;
    }
    return true;
}

function validarRegistroLaboratorista(){
    var codigo,nombre,numeroRegistroSalud,correoLab,DPI,telefono,tipoDeExamen,inicioTrabajo,password,password2,diasTrabajo;
    
    
    codigo = document.getElementById("codeLaboratorista").value;
    numeroRegistroSalud=document.getElementById("numeroRegistroSalud").value;
    telefono = document.getElementById("telefonoLaboratorista").value;
    correoLab = document.getElementById("emailLaboratorista").value;
    nombre = document.getElementById("nameLaboratorista").value;
    DPI = document.getElementById("DPILaboratorista").value;
    inicioTrabajo = document.getElementById("incioTrabajoLaboratorista").value;
    tipoDeExamen=document.getElementById("tipoDeExamenLaboratorista").value;
    diasTrabajo = document.getElementById("diasSemanaLab");
    password=document.getElementById("passwordLaboratorista").value;
    password2=document.getElementById("passwordLaboratorista2").value;
    
    if(codigo===""||numeroRegistroSalud===""||telefono===""||correoLab===""||nombre===""||DPI===""||inicioTrabajo===""||tipoDeExamen===""||diasTrabajo.options.length===0||password===""||password2===""){
        alert("Todos los campos son obligatorios");
        return false;
    }else if(!exprecionesRegulares.codigoLaboratorista.test(codigo)){
        alert("El codigo del laboratorista no es valido debe ser de la forma LAB-XXXX");
        return false;
    }else if(!exprecionesRegulares.registroSalud.test(numeroRegistroSalud)){
        alert("El registro de salud no es valido debe ser de la forma SALUD-XXXX");
        return false;
    }else if(!exprecionesRegulares.telefono.test(telefono)){
        alert("El numero de telefono no es valido\nRecuerda que deben ser 8 digitos");
        return false;
    }else if (correoLab.length > 45) {
        alert("El correo es muy largo");
        return false;
    } else  if(!exprecionesRegulares.correo.test(correoLab)){
        alert("La direccion de correo electronico no es valida");
        return false;
    }else  if (nombre.length > 60) {
        alert("El nombre es muy largo");
        return false;
    } else if(!exprecionesRegulares.nombre.test(nombre)){
        alert("El nombre no es valido debe ser de la forma Juan Perez");
        return false;
    }else if(!exprecionesRegulares.nDpi.test(DPI)){
        alert("EL numero de DPI no es valido\nRecuerda que deben de ser 13 digitos");
        return false;
    } else if(!exprecionesRegulares.fecha.test(inicioTrabajo)){
        alert("La fecha ingresada en el campo de inicio de trabajo no es valida");
        return false;
    }else if(!exprecionesRegulares.texto.test(tipoDeExamen)){
        alert("El nombre del examen no es valido");
        return false;
    }else if(diasTrabajo.options.length===0){
        alert("No asigno dias de trabajo");
        return false;
    }else{
        for(var i=0;i<diasTrabajo.options.length;i++){
            var dia = diasTrabajo.options[i].value;
            if(!exprecionesRegulares.diasSemana.test(dia)){
                alert("El texto no corresponde a un dia de la semana");
                return false;
            }
        }
    }
    if (password.length > 45 || password2.length > 45) {
        alert("La password no debe superar los 45 caracteres");
        return false;
    } else if (!(password === password2)) {
        alert("Las password no concuerdan");
        return false;
    }
    for(var i =0;i<diasTrabajo.options.length;i++){
        diasTrabajo.options[i].selected = true;
    }
    return true;
}

function validarModificacionLaboratorista(){
    var nombre,numeroRegistroSalud,DPI,telefono,tipoDeExamen,inicioTrabajo,diasTrabajo;
    
    numeroRegistroSalud=document.getElementById("numeroRegistroSalud").value;
    telefono = document.getElementById("telefonoLaboratorista").value;
    nombre = document.getElementById("nameLaboratorista").value;
    DPI = document.getElementById("DPILaboratorista").value;
    inicioTrabajo = document.getElementById("incioTrabajoLaboratorista").value;
    tipoDeExamen=document.getElementById("tipoDeExamenLaboratorista").value;
    diasTrabajo = document.getElementById("diasSemanaLab");
    
    if(numeroRegistroSalud===""||telefono===""||nombre===""||DPI===""||inicioTrabajo===""||tipoDeExamen===""||diasTrabajo.options.length===0){
        alert("Todos los campos son obligatorios");
        return false;
    }else  if(!exprecionesRegulares.registroSalud.test(numeroRegistroSalud)){
        alert("El registro de salud no es valido debe ser de la forma SALUD-XXXX");
        return false;
    }else if(!exprecionesRegulares.telefono.test(telefono)){
        alert("El numero de telefono no es valido\nRecuerda que deben ser 8 digitos");
        return false;
    }else if (nombre.length > 60) {
        alert("El nombre es muy largo");
        return false;
    } else if(!exprecionesRegulares.nombre.test(nombre)){
        alert("El nombre no es valido debe ser de la forma Juan Perez");
        return false;
    }else if(!exprecionesRegulares.nDpi.test(DPI)){
        alert("EL numero de DPI no es valido\nRecuerda que deben de ser 13 digitos");
        return false;
    } else if(!exprecionesRegulares.fecha.test(inicioTrabajo)){
        alert("La fecha ingresada en el campo de inicio de trabajo no es valida");
        return false;
    }else if(!exprecionesRegulares.texto.test(tipoDeExamen)){
        alert("El nombre del examen no es valido");
        return false;
    }else if(diasTrabajo.options.length===0){
        alert("No asigno dias de trabajo");
        return false;
    }else{
        for(var i=0;i<diasTrabajo.options.length;i++){
            var dia = diasTrabajo.options[i].value;
            if(!exprecionesRegulares.diasSemana.test(dia)){
                alert("El texto no corresponde a un dia de la semana");
                return false;
            }
        }
    }

    for(var i =0;i<diasTrabajo.options.length;i++){
        diasTrabajo.options[i].selected = true;
    }
    return true;
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
        alert("El texto introducido no es valido");
    }else{
        var combo = document.getElementById("espeDoctor");
        var option=document.createElement("option");
        combo.options.add(option,0);
        combo.options[0].value=texto.value;
        combo.options[0].innerText=texto.value;
        texto.value="";
    }
}

function agregarDiaTrabajo() {
    var texto = document.getElementById("diaTrabajoLaboratorista").value;
    if (texto.length === 0) {
        alert("Debe de seleccionar un dia para igresarlo");
    } else if (!(exprecionesRegulares.texto.test(texto))){
        alert("El texto introducido no es valido");
    }else{
        var combo = document.getElementById("diasSemanaLab");
        var option=document.createElement("option");
        combo.options.add(option,0);
        combo.options[0].value=texto;
        combo.options[0].innerText=texto;
        document.getElementById("diaTrabajoLaboratorista").remove(document.getElementById("diaTrabajoLaboratorista").selectedIndex);
    }
}
function eliminarDiaTrabajo() {
    var texto = document.getElementById("diasSemanaLab").value;
    if (texto.length === 0) {
        alert("Debe de seleccionar un dia para poder eliminarlo");
    } else if (!(exprecionesRegulares.texto.test(texto))){
        alert("El texto introducido no es valido");
    }else{
        var combo = document.getElementById("diaTrabajoLaboratorista");
        var option=document.createElement("option");
        combo.options.add(option,0);
        combo.options[0].value=texto;
        combo.options[0].innerText=texto;
        document.getElementById("diasSemanaLab").remove(document.getElementById("diasSemanaLab").selectedIndex);
    }
}

function validarRegistroconsulta(){
    var nombre,costo;
    nombre = document.getElementById("nombreConsulta").value;
    costo = document.getElementById("costoConsulta").value;

    if(nombre===""||costo===""){
        alert("Todos los campos son obligatorios");
        return false;
    }else if(!exprecionesRegulares.texto.test(nombre)){
        alert("El nombre del tipo de consulta no es valido");
        return false;
    }else if(!exprecionesRegulares.IntOrDouble.test(costo)){
        alert("El costo introducido no es valido solo deben ser numeros");
        return false;
    }
    return true;
}
function validarRegistroExamen(){
    var codigo,nombre,orden,descripcion,costo,informe;

    codigo = document.getElementById("codigoExamen").value;
    nombre = document.getElementById("nombreExamen").value;
    orden = document.getElementById("ordenExamen").value;
    descripcion = document.getElementById("descripcionExamen").value;
    costo = document.getElementById("costoExamen").value;
    informe = document.getElementById("informeExamen").value;

    if(codigo===""||nombre===""||orden===""||descripcion===""||costo===""||informe===""){
        alert("Todos los campos son obligatorios");
        return false;
    }else if(!exprecionesRegulares.texto.test(nombre)){
        alert("El nombre asignado al examen no es valido");
        return false;
    }else if(!exprecionesRegulares.numeroEntero.test(codigo)){
        alert("El codigo debe ser en formato numerico");
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
