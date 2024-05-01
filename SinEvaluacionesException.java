import java.util.*;
import java.io.*;

public class SinEvaluacionesException extends Exception{
  //contructor de la excepcion
  public SinEvaluacionesException(){
    super("No hay ninguna evaluación en el sistema");
  }

}