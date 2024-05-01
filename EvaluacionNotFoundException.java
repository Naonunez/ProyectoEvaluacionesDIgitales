import java.util.*;
import java.io.*;

public class EvaluacionNotFoundException extends Exception{

  //contructur de la excepcion
  public EvaluacionNotFoundException(){
    super("La evaluacion no está registrada");
  }
}