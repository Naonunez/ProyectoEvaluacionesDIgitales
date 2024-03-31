import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
public class Alumno {
    private String nombre;
    private Curso curso;
    private HashMap<String, Double> notas;

    public Alumno(String nombre, Curso curso) {
        this.nombre = nombre;
        this.curso = curso;
        this.notas = new HashMap<>();
    }

    public void ingresarNota(String asignatura, Double nota) {
        this.notas.put(asignatura, nota);
    }

    public boolean pasoDeCurso(double notaMinima) {
        return obtenerPromedio() >= notaMinima;
    }

    public double obtenerPromedio() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        double sumaTotal = 0.0;
        for (Double nota : notas.values()) {
            sumaTotal += nota;
        }
        double promedio = sumaTotal / notas.size();
        return Math.round(promedio * 10) / 10.0;
    }


    public String getNombre() {
        return nombre;
    }
    public Curso getCurso() {
        return curso;
    }
}
