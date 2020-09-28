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
        String nombre = "";
        if (archivo.indexOf("/") == -1) {
            nombre = archivo;
        } else {
            int ubicacion = 0;
            int temp = 0;
            while (temp != -1) {
                ubicacion=temp;
                temp=archivo.indexOf("/",0);
                temp++;
            }
            nombre = archivo.substring(ubicacion, archivo.length()-ubicacion);
        }
        return nombre;
    }
}
