package Modelo.Clases;

import Modelo.Interfaz.I_ConvertirAJSOn;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;
import java.util.jar.JarException;

public class Notas implements I_ConvertirAJSOn {

    private int notaNumerica;
    private int instancia;
    private String fecha;

    /**
     * constructores
     *
     * @param notaNumerica
     * @param instancia
     * @param fecha
     */

    public Notas(int notaNumerica, int instancia, String fecha) {
        this.notaNumerica = notaNumerica;
        this.instancia = instancia;
        this.fecha = fecha;
    }

    public Notas() {
        notaNumerica = 0;
        instancia = 0;
        fecha = "";
    }

    /**
     * getters and setters
     *
     * @return
     */
    public int getNotaNumerica() {
        return notaNumerica;
    }

    public void setNotaNumerica(int notaNumerica) {
        this.notaNumerica = notaNumerica;
    }

    public int getInstancia() {
        return instancia;
    }

    public void setInstancia(int instancia) {
        this.instancia = instancia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    /**
     * EQUALS AND HASHCODE
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notas notas = (Notas) o;
        return notaNumerica == notas.notaNumerica && instancia == notas.instancia && Objects.equals(fecha, notas.fecha);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public boolean compareTo(Object o)
    {
        boolean igual = false;
        if(o !=null)
        {
            if(o instanceof Notas)
            {
                Notas aux = (Notas) o;
                if(aux.getNotaNumerica()== getNotaNumerica() && aux.getInstancia()== getInstancia() && aux.getFecha().compareTo(getFecha())== 0)
                {
                    igual = true;
                }
            }

        }
        return igual;
    }


    /**
     * NOTA A .JSON
     */

    @Override
    public JSONObject convertirAJson()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Nota numerica", notaNumerica);
            jsonObject.put("Instancia", instancia);
            jsonObject.put("Fecha", fecha);
        }
        catch (JSONException e)
        {
            e.getCause();
        }
        return jsonObject;
    }
}
