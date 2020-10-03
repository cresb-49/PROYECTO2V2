package com.mycompany.proyecto2v2.Paths;

public class obtenerNombreArchivo {
    /**
     * CLASE UTILIZADA EN WINDOWS PARA OBTENER EL NOMBRE DE UN ARCHIVO DE UN PATH
     */
    public obtenerNombreArchivo() {
    }
    /**
     * SE INTRODUCE UNA DIRECCION Y EL RESULTADO ES EL NOMBRE EN SI DEL ARCHIVO
     * @param archivo
     * @return 
     */
    public String obtenerNombre(String archivo) {
        //System.out.println("Nombre de Archivo: "+archivo);
        String nombre = "";
        int busqueda = archivo.indexOf("/");
        if (busqueda == -1) {
            nombre = archivo;
        } else {
            int ubicacion = busqueda+1;
            while (busqueda != -1) {
                ubicacion = busqueda+1;
                busqueda=archivo.indexOf("/",busqueda+1);
            }
            nombre = archivo.substring(ubicacion,archivo.length());
        }
        return nombre;
    }
}
