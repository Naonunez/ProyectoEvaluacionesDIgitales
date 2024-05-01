import java.util.ArrayList;


public class Evaluacion{
  private String unidad;
  private String fecha;
  private String asignatura; 
  private ArrayList <Nota> notas;
  private ArrayList <Pregunta> preguntas;
  

  //contructor de evaluacion que recibe todos los parametros
  public Evaluacion(String unidad,String asignatura, String fecha, ArrayList <Nota> notas2, ArrayList <Pregunta> preg2){
    this.fecha = fecha;
    this.unidad = unidad;
    this.asignatura = asignatura;

    preguntas = new ArrayList();
    for(int i=0; i < preg2.size(); i++){
      Pregunta anadirPregunta = preg2.get(i);
      preguntas.add(i, anadirPregunta);
    }

    notas = new ArrayList();
    for(int i=0; i < notas2.size(); i++){
      Nota anadirNota = notas2.get(i);
      notas.add(i, anadirNota);
    }
  }

  
  //contructor  solo atributos sin colecciones
  public Evaluacion(String unidad,String asignatura, String fecha){
    this.fecha = fecha;
    this.unidad = unidad;
    this.asignatura = asignatura;

    preguntas = new ArrayList();

    notas = new ArrayList();
  }

 
  //contructor de evaluaciones sin parametros
  public Evaluacion(){
    preguntas = new ArrayList();
    notas = new ArrayList();
  }

  //añade añadir pregunta
  public void anadirPregunta (Pregunta pregunta){
    preguntas.add(pregunta);
  }
  
  
//metodo para eliminar pregunta de evaluacion
  public boolean eliminarPregunta (String pregunta){
 
    if(preguntas.contains(pregunta)==false){
      return false;
    }
    else{
      preguntas.remove(preguntas.indexOf(pregunta));
    }
    return true;
  }
  
//metodo que busca una pregunta en la evaluacion
  public Pregunta buscarPregunta(String pregunta){
   
    for(int i = 0; i < preguntas.size(); i++){
      Pregunta pp = preguntas.get(i);

      if(pp.getPregunta().equals(pregunta)){
        return pp;
      }
    }
    return null;
  }

  

  //metodo que añade una nota a la evaluacion 
  public boolean anadirNota(Nota nn){
    if(notas.contains(nn)){
      return false;
    }
    else{
      notas.add(nn);
      return true;
    }

  }
  
//metodo que elimina una nota de la evaluacion
  public boolean eliminarNota(String alumno){
  
    for(int i=0 ; i < notas.size(); i++){
      Nota notaActual = notas.get(i);
      if(notaActual.getAlumno().equals(alumno)){
        notas.remove(notaActual);
        return true;
      }
    }
    return false;
  }

  

  //metodo que calcula el promedio de las notas de la evaluacion
  public double promedioEvaluacion(){

    int cantidadNotas = notas.size();
    double suma = 0;
    if(cantidadNotas == 0){
      return 0;
    }
    for(int i = 0; i < cantidadNotas; i++){
      Nota nn = (Nota)notas.get(i);
      suma = suma + nn.getNota();
    }

    return Math.round(suma/cantidadNotas*10.0)/10.0;
  }
 

  //metodo que busca una nota en la evaluacion
  public Nota buscarNota(String alumno){
    
    for(int i = 0; i < notas.size(); i++){
      Nota nota = notas.get(i);
      if(nota.getAlumno().equals(alumno)){
        return nota;
      }
    }
    return null;
  }

 //getter de unidad
  public String getUnidad(){
    return unidad;
  }

  
  //getter de fecha
  public String getFecha(){
    return fecha;
  }



  //getter de asignatura
  public String getAsignatura(){
    return asignatura;
  }

  
  //getter de preguntas evaluacion
  public ArrayList<Pregunta> getPreguntas(){
    ArrayList <Pregunta> aux = (ArrayList <Pregunta>) preguntas.clone();
    return aux;
  }

 
  //getter de un clon
  public ArrayList<Nota> getNotas(){
    ArrayList <Nota> aux = (ArrayList <Nota>) notas.clone();
    return aux;
  }

  
  //setter de fecha
  public void setFecha(String fecha){
    this.fecha = fecha;
  }

  
  //setter de unidad
  public void setUnidad(String unidad){
    this.unidad = unidad;
  }

  
  //setter de asignatura
  public void setAsignatura(String asignatura){
    this.asignatura = asignatura;
  }
}