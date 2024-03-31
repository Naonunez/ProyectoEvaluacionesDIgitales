import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<Alumno>> alumnosPorCurso = new HashMap<>();

        while (true) {
            System.out.println("Menú:");
            System.out.println("1) Inserción de alumno y notas");
            
            System.out.println("3) Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    insertarAlumnoYNotas(alumnosPorCurso, br);
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void insertarAlumnoYNotas(HashMap<String, ArrayList<Alumno>> alumnosPorCurso, BufferedReader br) throws IOException {
        System.out.print("Ingrese nombre del alumno: ");
        String nombreAlumno = br.readLine();
        System.out.print("Ingrese nombre del curso: ");
        String nombreCurso = br.readLine();
        Curso curso = new Curso(nombreCurso);

        Alumno alumno = new Alumno(nombreAlumno, curso);

        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese nombre de la asignatura o 'fin' para terminar: ");
            String nombreAsignatura = br.readLine();
            if ("fin".equalsIgnoreCase(nombreAsignatura)) {
                continuar = false;
            } else {
                System.out.print("Ingrese nota de " + nombreAsignatura + ": ");
                double nota = Double.parseDouble(br.readLine());
                alumno.ingresarNota(nombreAsignatura, nota);
                curso.agregarAsignatura(new Asignatura(nombreAsignatura));
            }
        }

        double notaMinima = 4.0;
        System.out.println("Nota final: " + alumno.obtenerPromedio());
        if (alumno.pasoDeCurso(notaMinima)) {
            System.out.println("El alumno " + nombreAlumno + " ha pasado de curso.");
        } else {
            System.out.println("El alumno " + nombreAlumno + " no ha pasado de curso.");
        }

        alumnosPorCurso.computeIfAbsent(nombreCurso, k -> new ArrayList<>()).add(alumno);
    }

    
}
