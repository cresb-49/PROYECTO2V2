var nombre,dpi,telefono,sexo,sangre;

nombre=document.obtenerValorParametro('Rnombre');
dpi=document.obtenerValorParametro('RDPI');
telefono=document.obtenerValorParametro('Rtelefono');
sexo=document.obtenerValorParametro('&Rsexo');
sangre=document.obtenerValorParametro('&Rsangre');

if(nombre===null||dpi===null||telefono===null||sexo===null||sangre===null){
    alert("nombre:-"+nombre+"-");
}
else{
    alert("El correo electronico ya esta registrado"+"nombre:-"+nombre+"-");
}




function obtenerValorParametro(sParametroNombre) {
var sPaginaURL = window.location.search.substring(1);
 var sURLVariables = sPaginaURL.split('&');
  for (var i = 0; i < sURLVariables.length; i++) {
    var sParametro = sURLVariables[i].split('=');
    if (sParametro[0] == sParametroNombre) {
      return sParametro[1];
    }
  }
 return null;
}