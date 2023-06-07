package Modelo.JSON;

import Modelo.Clases.Estudiante;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONControladora {


    /**
     * guarda en un archivo json los datos. Como json utiles venía configurado para que devolviera un json array,
     * queda todo guardado en un json array.
     */
    public static void CrearJson(Estudiante estudiante)
    {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(estudiante.convertirAJson());
        JsonUtiles.grabar(jsonArray, "Array JSON de estudiantes");

    }
}
