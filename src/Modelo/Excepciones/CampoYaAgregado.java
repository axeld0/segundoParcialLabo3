package Modelo.Excepciones;

public class CampoYaAgregado extends IllegalArgumentException{


    /**
    SERÁ UNA EXCEPCIÓN QUE DIRÁ CUANDO REPETIMOS UN CAMPO A LA HORA DE CREAR UN OBJETO.
     */
    public CampoYaAgregado(String info)
    {
        super(info);
    }

}
