import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException{
    Colegio colegio = new Colegio();
    Menu ELMENU = new Menu(colegio);
    ELMENU.importar();    
    
    ELMENU.opciones();
    ELMENU.exportar();
  }
}