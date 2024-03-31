import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Curso {
    private String nombre;
    private ArrayList<Asignatura> asignaturas;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.asignaturas = new ArrayList<>();
    }

    public void agregarAsignatura(Asignatura asignatura) {
        this.asignaturas.add(asignatura);
    }
    public String getNombre() {
        return nombre;
    }
}
