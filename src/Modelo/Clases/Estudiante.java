package Modelo.Clases;

import Modelo.Colecciones.ListadoMaterias;
import Modelo.Interfaz.I_ConvertirAJSOn;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Estudiante implements I_ConvertirAJSOn {

    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private int legajo;
    private String mail;
    private ListadoMaterias listadoMaterias;


    /**
     * contructores

     */
    public Estudiante(String nombre, String apellido, String fechaNacimiento, int legajo, String mail, ListadoMaterias listadoMaterias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.legajo = legajo;
        this.mail = mail;
        this.listadoMaterias = listadoMaterias;
    }

    public Estudiante() {
        nombre = "";
        apellido = "";
        fechaNacimiento = "";
        legajo = 0;
        mail = "";
        listadoMaterias = new ListadoMaterias<>();
    }

    /**
     * GETTERS Y SETTERS
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ListadoMaterias getListadoMaterias() {
        return listadoMaterias;
    }

    public void setListadoMaterias(ListadoMaterias listadoMaterias) {
        this.listadoMaterias = listadoMaterias;
    }


    /** TOSTRING*/
    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", legajo=" + legajo +
                ", mail='" + mail + '\'' +
                ", listadoMaterias=" + listadoMaterias +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return legajo == that.legajo && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(mail, that.mail) && Objects.equals(listadoMaterias, that.listadoMaterias);
    }

    @Override
    public int hashCode() {
        return 12;
    }

    /**
     * NOTA A .JSON
     */

    @Override
    public JSONObject convertirAJson()
    {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Nombre", nombre);
            jsonObject.put("Apellido", apellido);
            jsonObject.put("Nacimiento", fechaNacimiento);
            jsonObject.put("legajo", legajo);
            jsonObject.put("Mail", mail);


            jsonObject.put("Materias", listadoMaterias.convertirAJsonArray());
        }
        catch (JSONException e)
        {
            e.getCause();
        }
        return jsonObject;
    }
}
