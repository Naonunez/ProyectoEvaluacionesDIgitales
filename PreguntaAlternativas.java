
import java.util.ArrayList;

public class PreguntaAlternativas extends Pregunta{
  private char altCorrecta;
  private ArrayList <String> alternativas;


  //contructor con todos los parametros
  public PreguntaAlternativas(String pregunta, String tema, ArrayList <String> alternativas2, char altCorrecta){
    super(pregunta, tema);
    this.altCorrecta = altCorrecta;

    alternativas = new ArrayList();
    for(int i = 0; i < alternativas2.size(); i++){
      String alter = alternativas2.get(i);
      alternativas.add(i, alter);
    }
  }


  //contructor que solo registra pregunta,tema y arraylist vacio
  public PreguntaAlternativas(String pregunta, String tema){
    super(pregunta, tema);
    alternativas = new ArrayList();
  }


  //contrucutor sin parametros
  public PreguntaAlternativas(){
    super();
    alternativas = new ArrayList();
  }

  //getter alternativa correcta
  public char getAltCorrecta(){
    return altCorrecta;
  }

  //copia de arraylist de alaternativas
  public ArrayList<String> getAlternativas(){
    ArrayList<String> aux = (ArrayList<String>) alternativas.clone();
    return aux;
  }


  //setter alternativa correcta
  public void setAltCorrecta(char altCorrecta){
    this.altCorrecta = altCorrecta;
  }


  //agrega alternativas a un indice especifico del arraylist
  public void setAlternativa(String alter, int index){
    alternativas.set(index, alter);
  }

  //agrega sus alternativas
  public void setAlternativa(String alter){
    alternativas.add(alter);
  }
//entrega todos los contenidos de la pregunta de alternativas
  public String contenidos(){
    String cont = ("Pregunta :" + getPregunta() + "\n" + "Tema: " + getTema());
    ArrayList<Character> letrasArray = new ArrayList<>();
    for (char letra = 'a'; letra <= 'z'; letra++) {
      letrasArray.add(letra);
    }
    for(int i = 0; i < alternativas.size(); i++){
      cont = cont + "\n" + letrasArray.get(i) + ") " + alternativas.get(i);
    }

    cont = (cont + "\n" + "Alternativa correcta: " + altCorrecta + "\n");
    return cont;
  }
}