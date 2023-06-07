package Modelo.Interfaz;

import Modelo.Excepciones.CampoYaAgregado;


public interface I_MetodosColecciones {


    /**
   METODOS PARA UTILIZAR EN LAS COLECCIONES.
     */
    public boolean agregar();
    public int contar();
    public String listar();
    public boolean eliminar() throws NoSuchFieldException;

}
