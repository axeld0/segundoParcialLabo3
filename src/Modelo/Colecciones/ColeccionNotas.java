package Modelo.Colecciones;

import Modelo.Clases.Notas;
import Modelo.Excepciones.CampoYaAgregado;
import Modelo.Interfaz.I_ConvertirAJsonArray;
import Modelo.Interfaz.I_MetodosColecciones;
import org.json.JSONArray;

import javax.swing.*;
import java.util.HashSet;
import java.util.Objects;

public class ColeccionNotas <T> implements I_ConvertirAJsonArray {

    private HashSet<T> conjuntoNotas;


    /**
     * constructores
     */

    public ColeccionNotas(HashSet<T> conjuntoNotas)
    {
        this.conjuntoNotas = conjuntoNotas;
    }

    public ColeccionNotas()
    {
        conjuntoNotas = new HashSet<>();
    }


    /**
     * getters y setters
     * @return
     */
    public HashSet<T> getConjuntoNotas() {
        return conjuntoNotas;
    }




    /**
     * metodos de agregar, listar y borrar
     */

    public boolean agregar(T element)
    {
        boolean agregado = false;
            if(conjuntoNotas.contains(element))
            {
                throw new CampoYaAgregado(element.toString());
            }
            else {
                conjuntoNotas.add(element);
                agregado = true;
            }
        return agregado;
    }


    public int contar() {
        int contador= 0;
        for(T element : conjuntoNotas)
        {
            contador++;
        }
        return  contador;
    }


    public String listar() {
        StringBuilder sb = new StringBuilder();

        for(T element: conjuntoNotas)
        {
            sb.append(element.toString());
        }
        return sb.toString();
    }


    public boolean eliminar(T element) throws NoSuchFieldException {
        boolean eliminado = false;
        if (!conjuntoNotas.contains(element))
        {
            throw new NoSuchFieldException();}
        else {
            conjuntoNotas.remove(element);
            eliminado = true;
        }
        return eliminado;
    }


    /**
     * to string
     */
    @Override
    public String toString() {
        return "ColeccionNotas{" +
                "conjuntoNotas=" + conjuntoNotas +
                '}';
    }


    /**equals*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColeccionNotas<?> that = (ColeccionNotas<?>) o;
        return Objects.equals(conjuntoNotas, that.conjuntoNotas);
    }



    /** convertir a json array
     *
     */

    @Override
    public JSONArray convertirAJsonArray()
    {
        JSONArray jsonArray = new JSONArray();

        for(T element : conjuntoNotas)
        {
            if(element instanceof Notas)
            jsonArray.put(((Notas) element).convertirAJson());
        }
        return jsonArray;

    }
}

