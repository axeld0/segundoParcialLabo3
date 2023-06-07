package Modelo.Colecciones;

import Modelo.Clases.Materia;
import Modelo.Excepciones.CampoYaAgregado;
import Modelo.Interfaz.I_ConvertirAJSOn;
import Modelo.Interfaz.I_ConvertirAJsonArray;
import Modelo.Interfaz.I_MetodosColecciones;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;

public class ListadoMaterias <T> implements I_ConvertirAJsonArray {


    private HashSet<T> listamaterias;


    /**constructores*/

    public ListadoMaterias (HashSet<T> listamaterias)
    {this.listamaterias= listamaterias;}

    public ListadoMaterias()
    {
        listamaterias = new HashSet<>();
    }


    /**
     * GETTER
     */

    public HashSet<T> getListamaterias() {
        return listamaterias;
    }

    /**
     * METODOS PARA AGREGAR, BORRAR Y LISTAR ELEMENTOS.
     */

   public boolean agregar(T element){
        boolean agregado = false;
        if (element instanceof Materia) {
            if (listamaterias.contains(element)) {
                throw new CampoYaAgregado(((Materia) element).getCodigoMateria().toString());
            }
            listamaterias.add(element);
            agregado = true;
        }
       return agregado;
   }



    public int contar() {
            int contador = 0;
        for(T element : listamaterias)
        {
            contador++;
        }
        return contador;
    }

    public String listar() {
        StringBuilder sb = new StringBuilder();
        for(T element: listamaterias)
        {
            if(element instanceof Materia)
            sb.append(element.toString());
        }
        return sb.toString();
    }




    public boolean eliminar(T element) throws NoSuchFieldException {
        boolean eliminado = false;
        if(listamaterias.contains(element))
        {
            listamaterias.remove(element);
        }
        else
        {
            throw new NoSuchFieldException("no ta, sory");
        }
        return eliminado;
    }


    /**
   CONVERTIR LA COLECCION EN UN JSON ARRAY.
     DEVUELVE UN JSON ARRAY.
     */
    @Override
    public JSONArray convertirAJsonArray()
    {
        JSONArray jsonArray = new JSONArray();

            for(T element : listamaterias)
            {
                if(element instanceof Materia)
                jsonArray.put(((Materia) element).convertirAJson());
            }
        return jsonArray;

    }
}
