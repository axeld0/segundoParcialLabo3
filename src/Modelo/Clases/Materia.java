package Modelo.Clases;

import Modelo.Colecciones.ColeccionNotas;
import Modelo.Interfaz.I_ConvertirAJSOn;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Materia implements I_ConvertirAJSOn {


    private CodigoMateria codigoMateria;
    private String nombreDescriptivo;
    private String docente;
    private String ayudante;
    private  ColeccionNotas notas;

    public Materia(CodigoMateria codigoMateria, String nombreDescriptivo, String docente, String ayudante, ColeccionNotas notas)
    {
        this.codigoMateria = codigoMateria;
        this.nombreDescriptivo = nombreDescriptivo;
        this.docente = docente;
        this.ayudante = ayudante;
        this.notas = notas;
    }
    public Materia()
    {
        codigoMateria = CodigoMateria.DEFAULT;
        nombreDescriptivo = "";
        docente = "";
        ayudante = "";
        notas = new ColeccionNotas<>();
    }

    public String getNombreDescriptivo() {
        return nombreDescriptivo;
    }

    public String getDocente() {
        return docente;
    }

    public String getAyudante() {
        return ayudante;
    }

    public ColeccionNotas getNotas() {
        return notas;
    }

    public CodigoMateria getCodigoMateria() {
        return codigoMateria;
    }

    /**setter*
     *
     */

    public void setNotas(ColeccionNotas notas) {
        this.notas = notas;
    }


    /**
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "Materia{" +
                "codigoMateria='" + codigoMateria + '\'' +
                ", nombreDescriptivo='" + nombreDescriptivo + '\'' +
                ", docente='" + docente + '\'' +
                ", ayudante='" + ayudante + '\'' +
                ", notas=" + notas +
                '}';
    }


    /**
     * convertir a json. Crea un objeto json la materia y la retorna.
     */

    @Override
    public JSONObject convertirAJson()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Descripcion",nombreDescriptivo);
            jsonObject.put("Docente", docente);
            jsonObject.put("Ayudante", ayudante);
            JSONArray jsonArray = new JSONArray();
            jsonObject.put("Notas",notas.convertirAJsonArray());
        }
        catch (JSONException e)
        {
            e.getCause();
        }
        return jsonObject;
    }
}
