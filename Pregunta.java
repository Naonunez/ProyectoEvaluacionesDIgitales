
import java.util.ArrayList;

public class Pregunta{
  private String pregunta;
  private String tema;

//contructor de parametro
  public Pregunta(String pregunta, String tema){
    this.pregunta = pregunta;
    this.tema = tema;
  }

  //contructor sin parametro
  public Pregunta(){
    this.pregunta = "PEDRO";
  }
//getter pregunta

  public String getPregunta(){
    return pregunta;
  }
//getter tema

  public String getTema(){
    return tema;
  }


//setter pregunta  
  public void setPregunta(String pregunta){
    this.pregunta = pregunta;
  }

  //setter tema
  public void setTema(String tema){
    this.tema = tema;
  }

  //entrega todos los contenidos de una pregunta
  public String contenidos(){
    return (pregunta + "\n" + "Tema: "+ tema);
  }
}