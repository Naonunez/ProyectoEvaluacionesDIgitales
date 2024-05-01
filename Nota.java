

public class Nota{
  private double nota;
  private String alumno;




  //Constructor con todos los parámetros
  public Nota (double nota, String alumno){
    this.nota = nota;
    this.alumno = alumno;
  }



  //Constructor sin parámetros
  public Nota (){
  }


//setter de nota
  public void setNota(double nota){
    this.nota = nota;
  }

 //setter de alumno

  public void setAlumno(String alumno){
    this.alumno = alumno;
  }

//getter nota
  public double getNota(){
    return nota;
  }


  //Este método que obtiene la nota como un string
  public String getNotaString(){
    String notaString = String.valueOf(nota);
    return notaString;
  }

  //getter alumno

  public String getAlumno(){
    return alumno;
  }
}