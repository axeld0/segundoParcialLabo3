import Modelo.Clases.CodigoMateria;
import Modelo.Clases.Estudiante;
import Modelo.Clases.Materia;
import Modelo.Clases.Notas;
import Modelo.Colecciones.ColeccionNotas;
import Modelo.Colecciones.ListadoMaterias;
import Modelo.JSON.JSONControladora;

public class Main {
    public static void main(String[] args) {

        //creo las notas
        Notas n1 = new Notas(10, 1, "7/6");
        Notas n2 = new Notas(8,1,"8/6");
        //creo la coleccion de notas y agrego las notas
        ColeccionNotas<Notas> notasMate = new ColeccionNotas<>();
        notasMate.agregar(n1);
        notasMate.agregar(n2);

        //creo una materia y agrego las notas
        Materia m1 = new Materia(CodigoMateria.LEN,"Matematica aplicada a conjuntos", "Susy", "Pri", notasMate);
        //creo el listado de materias y agrego la materia
        ListadoMaterias<Materia> listadoMaterias = new ListadoMaterias<>();
        listadoMaterias.agregar(m1);
        //creo el alumno, agrego sus datos y sus materias

        Estudiante e1 = new Estudiante("Axel", "Dominguez", "16/03/1992", 55506, "axel.do@live.com.ar", listadoMaterias );
        //creo el archivo .json
        JSONControladora.CrearJson(e1);



    }
}