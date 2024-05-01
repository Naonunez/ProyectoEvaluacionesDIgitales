
import java.util.*;
import java.io.*;

public class CSV {

  private BufferedReader file;
  private String currentLine;

  // contructor de la clase csv
  public CSV(String name) throws FileNotFoundException {

    this.file = new BufferedReader(new FileReader("./" + name + ".csv"));
  }

  // contructrie de la clase csv que es usada para instanciar una variable con un
  // nombre y una ruta especifica
  public CSV(String ruta, String archivo) throws FileNotFoundException {
    this.file = new BufferedReader(new FileReader(ruta + archivo));
  }

  // otro constructor csv
  public CSV() {
  }

  // metodo que entrega la primera linea del csv
  public String firstLine() throws IOException {
    return nextLine();
  }

  // metodo que entrega la siguiente linea del csv
  public String nextLine() {
    try {
      this.currentLine = this.file.readLine();
      return (this.currentLine);
    } catch (IOException e) {
      System.out.println("No se pudo acceder a la linea");
      return null;
    }

  }

  // metodo que entrega el dato del campo en una linea del CSV
  public String get_csvField(String line, int field) {
    Scanner s = new Scanner(line);
    int index = 0;
    s.useDelimiter(";|\\n");
    String output;

    while (s.hasNext()) {
      output = (s.next());
      if ((output.charAt(0)) == ('\"')) {
        while (true) {
          if ((output.charAt((output.length()) - 1)) == ('\"')) {
            break;
          }
          output = (output + "," + (s.next()));
        }
      }

      if (index == field) {
        s.close();
        return (output);
      }
      index = (index + 1);
    }

    s.close();
    return (null);
  }

  // metodo que entrega el dato del campo en una linea del CSV
  public String get_csvField(int field, String line) {
    Scanner s = new Scanner(line);
    int index = (0);
    s.useDelimiter(",|\\n");
    String output;

    while (s.hasNext()) {
      output = (s.next());
      if ((output.charAt(0)) == ('\"')) {
        while (true) {
          output = (output + "," + (s.next()));
          if ((output.charAt((output.length()) - 1)) == ('\"')) {
            break;
          }
        }
      }

      if (index == field) {
        return (output);
      }
      index = (index + 1);
    }

    return (null);
  }

  // metodo que cierra el archivo csv
  public void close() {
    try {
      file.close();
    } catch (IOException e) {
      System.out.println("Error al cerrar el archivo");
    }

  }
}