
import java.util.ArrayList;

public class PreguntaDesarrollo extends Pregunta{
  private String respEsperada;


//contructor de los parametros
  public PreguntaDesarrollo(String pregunta, String tema, String respEsperada){
    super(pregunta, tema);
    this.respEsperada = respEsperada;
  }
//contructor sin parametros
  public PreguntaDesarrollo(){
    super();
  }

  //getter de respuesta esperada
  public String getRespEsperada(){
    return respEsperada;
  }

  //setter de respuesta esperada
  public void setRespEsperada(String respEsperada){
    this.respEsperada = respEsperada;
  }


//entrega todos los contenidos de la pregunta 
  public String contenidos(){
    return ("Pregunta: " + getPregunta() + "\n" + "Tema: "+ getTema() + "\n" + "Respuesta Esperada: "+ respEsperada + "\n");
  }
}