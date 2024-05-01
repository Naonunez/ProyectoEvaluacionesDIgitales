import java.util.ArrayList;
import java.util.HashMap;


public class Colegio{
  private ArrayList <Evaluacion> arrayEvaluaciones_colegio;
  private HashMap <String, Evaluacion> mapaEvaluaciones_colegio;

  //contructor para incializar parametros
  public Colegio(){
    arrayEvaluaciones_colegio = new ArrayList();
    mapaEvaluaciones_colegio = new HashMap();
  }

  //metodo que busca una evaluacion y si no encuentra nada null
  public Evaluacion buscarEvaluacion(String nombre_Unidad) throws EvaluacionNotFoundException{
    if(mapaEvaluaciones_colegio.containsKey(nombre_Unidad) == true){
      return mapaEvaluaciones_colegio.get(nombre_Unidad);
    }
    else{
      throw new EvaluacionNotFoundException();
    }
    
  }


  
  //metodo que busca todas las evaluaciones de una asignatura
  public ArrayList <Evaluacion> buscarEvaluacionAsignatura(String asignatura){

    ArrayList <Evaluacion> aux = new ArrayList();

    for(int i = 0; i < arrayEvaluaciones_colegio.size(); i++){
      Evaluacion ee = arrayEvaluaciones_colegio.get(i);
      if(ee.getAsignatura().equals(asignatura)){

        aux.add(ee);
      }
    }

    try{
      hayEvaluaciones(arrayEvaluaciones_colegio);
      return aux;
    }catch(SinEvaluacionesException e){
      return null;
    }

  }




  //metodo que agrega una evaluacion, si la añade retorna true
  public boolean agregarEvaluacion(Evaluacion ee){
    try{
      Evaluacion aux = buscarEvaluacion(ee.getUnidad());
      return false;
    }catch (EvaluacionNotFoundException e){
      arrayEvaluaciones_colegio.add(ee);
      mapaEvaluaciones_colegio.put(ee.getUnidad(),ee);
      return true;
    }

  }

 

  //metodo que elimina una evaluacion y si no la encuentra retorna false
  public boolean eliminarEvaluacion(String unidad){

    Evaluacion ee = new Evaluacion();
    try{
       ee = buscarEvaluacion(unidad);
    }catch (EvaluacionNotFoundException e){
      return false;
    }

    for(int i = 0; i < arrayEvaluaciones_colegio.size(); i++){
      Evaluacion eva = arrayEvaluaciones_colegio.get(i);
      if(eva.getUnidad().equals(unidad)){

        arrayEvaluaciones_colegio.remove(i);
        mapaEvaluaciones_colegio.remove(eva.getUnidad());
        return true;
      }
    }

    return false;
  }


 

  //metodo de sobrecarga para eliminar una evaluacion
  public void eliminarEvaluacion(String VIEJO,String nueva){
  
    for(int i = 0; i < arrayEvaluaciones_colegio.size(); i++){
      Evaluacion eva = arrayEvaluaciones_colegio.get(i);
      if(eva.getUnidad().equals(nueva)){
        arrayEvaluaciones_colegio.remove(i);
        mapaEvaluaciones_colegio.remove(VIEJO);
        return;
      }
    }

  }



  //metodo que elimina una pregunta y si no la encuentra retorna false
  public boolean eliminarPregunta(String pregunta){
    for(int i = 0; i < arrayEvaluaciones_colegio.size(); i++){
      Evaluacion eva = arrayEvaluaciones_colegio.get(i);
      Pregunta preg = eva.buscarPregunta(pregunta);
      if(preg != null){
        eva.eliminarPregunta(pregunta);
        return true;
      }
    }
    return false;
  }


 
  //metodo que agrega una pregunta y si no la puede agregar retorna false
  public boolean anadirPregunta(Pregunta pregunta, Evaluacion ee){
    Pregunta pregunta2 = ee.buscarPregunta(pregunta.getPregunta()); 
    if(pregunta2 !=null){
      return false;
    }
    else{
      ee.anadirPregunta(pregunta);
      return true;
    }

  }



  //metodo que verifica si hay evaluaciones retorna true si es que lo encuentra
  public boolean hayEvaluaciones(ArrayList <Evaluacion> ee)throws SinEvaluacionesException{


    if(ee.isEmpty()!=true){
      return true;
    }
    else{
      throw new SinEvaluacionesException();
    }
  }

  
  // Método que inicializa datos, es ocupado solo una vez ya que luego se quedan guardados en el csv "Datos".
 
  public void datosIniciales(){

    Evaluacion eva1 = new Evaluacion("Limites", "Matematicas", "12-06-2022");
    agregarEvaluacion(eva1);

    ArrayList <String> alternativas11= new ArrayList();
    alternativas11.add("El límite de la función a medida que la variable se aproxima a ese punto desde valores menores a dicho punto.");
    alternativas11.add("El límite de la función a medida que la variable se aproxima a ese punto desde valores mayores a dicho punto.");
    alternativas11.add("El límite de la función a medida que la variable se aproxima a ese punto desde ambos lados, pero sin incluir el punto.");
    alternativas11.add("El límite de la función a medida que la variable se aproxima a ese punto desde ambos lados, incluyendo el punto.");
    char altCorrecta11 = 'b';

    PreguntaAlternativas pregunta11 = new PreguntaAlternativas("¿Cómo se define el límite lateral derecho de una función en un punto específico?", "Limites Laterales", alternativas11, altCorrecta11);
    eva1.anadirPregunta(pregunta11);


    ArrayList<String> alternativas12 = new ArrayList<>();
    alternativas12.add("La función debe ser continua en ese punto.");
    alternativas12.add("La función debe ser derivable en ese punto.");
    alternativas12.add("La función debe estar definida en ese punto.");
    alternativas12.add("La función debe ser acotada en ese punto.");
    char altCorrecta12 = 'c';

    PreguntaAlternativas pregunta12 = new PreguntaAlternativas("¿Qué condiciones deben cumplirse para que una función tenga límite lateral derecho en un punto?", "Limites Laterales", alternativas12, altCorrecta12);
    eva1.anadirPregunta(pregunta12);

    PreguntaDesarrollo pregunta13 = new PreguntaDesarrollo(" ¿Qué representa el límite de una función en un punto específico?", "Límites en Cálculo", "El límite de una función en un punto representa hacia dónde tiende la función a medida que la variable se acerca a ese punto.");
    eva1.anadirPregunta(pregunta13);

    Nota nota11 = new Nota(3.0, "Alex");
    Nota nota12 = new Nota(4.4, "Javier");
    Nota nota13 = new Nota(5.7, "Roberto");
    eva1.anadirNota(nota11);
    eva1.anadirNota(nota12);
    eva1.anadirNota(nota13);
    
    Evaluacion LENGUAJEVALUATIVO = new Evaluacion("Análisis del Lenguaje", "Lenguaje", "12-06-2022");
    PreguntaDesarrollo preguntaLenguaje1 = new PreguntaDesarrollo("Escribe un poema relacionado con la naturaleza.", "Poesía", "Escribe aquí tu poema sobre la naturaleza.");
    LENGUAJEVALUATIVO.anadirPregunta(preguntaLenguaje1);
    ArrayList<String> alternativasLenguaje2 = new ArrayList<>();
    alternativasLenguaje2.add("Sujeto");
    alternativasLenguaje2.add("Predicado");
    alternativasLenguaje2.add("Complemento directo");
    alternativasLenguaje2.add("Complemento indirecto");
    char altCorrectaLenguaje2 = 'b';

    PreguntaAlternativas preguntaLenguaje2 = new PreguntaAlternativas("Identifica la parte de la oración que contiene el verbo.", "Gramática", alternativasLenguaje2, altCorrectaLenguaje2);
    LENGUAJEVALUATIVO.anadirPregunta(preguntaLenguaje2);
    PreguntaDesarrollo preguntaLenguaje3 = new PreguntaDesarrollo("Escribe una carta formal.", "Redacción", "Escribe aquí tu carta formal.");
    LENGUAJEVALUATIVO.anadirPregunta(preguntaLenguaje3);

    ArrayList<String> alternativasLenguaje4 = new ArrayList<>();
    alternativasLenguaje4.add("Sílaba tónica");
    alternativasLenguaje4.add("Sílaba átona");
    alternativasLenguaje4.add("Sílaba trabada");
    alternativasLenguaje4.add("Diptongo");
    char altCorrectaLenguaje4 = 'a';

    PreguntaAlternativas preguntaLenguaje4 = new PreguntaAlternativas("Identifica la sílaba con acento en la palabra 'rápido'.", "Ortografía", alternativasLenguaje4, altCorrectaLenguaje4);
    LENGUAJEVALUATIVO.anadirPregunta(preguntaLenguaje4);
    PreguntaDesarrollo preguntaLenguaje5 = new PreguntaDesarrollo("Explica qué es una metáfora.", "Figuras Literarias", "Escribe aquí tu definición de metáfora.");
    LENGUAJEVALUATIVO.anadirPregunta(preguntaLenguaje5);

    LENGUAJEVALUATIVO.anadirNota(new Nota(6.7, "Estudiante1"));
    LENGUAJEVALUATIVO.anadirNota(new Nota(7.8, "Estudiante2"));
    LENGUAJEVALUATIVO.anadirNota(new Nota(5.9, "Estudiante3"));
    LENGUAJEVALUATIVO.anadirNota(new Nota(8.2, "Estudiante4"));
    LENGUAJEVALUATIVO.anadirNota(new Nota(6.1, "Estudiante5"));

    agregarEvaluacion(LENGUAJEVALUATIVO);

    Evaluacion HISTORIAEVALUATIVA = new Evaluacion("Evolución de la Sociedad", "Historia", "12-06-2022");

    PreguntaDesarrollo preguntaHistoria1 = new PreguntaDesarrollo("Describe la Revolución Industrial y su impacto en la sociedad.", "Historia Moderna", "La Revolución Industrial fue un período de transformación económica y social que comenzó en Gran Bretaña a finales del siglo XVIII.");
    HISTORIAEVALUATIVA.anadirPregunta(preguntaHistoria1);

    ArrayList<String> alternativasHistoria2 = new ArrayList<>();
    alternativasHistoria2.add("Napoleón Bonaparte");
    alternativasHistoria2.add("George Washington");
    alternativasHistoria2.add("Simón Bolívar");
    alternativasHistoria2.add("Winston Churchill");
    char altCorrectaHistoria2 = 'a';

    PreguntaAlternativas preguntaHistoria2 = new PreguntaAlternativas("¿Quién fue el líder durante las Guerras Napoleónicas?", "Historia Contemporánea", alternativasHistoria2, altCorrectaHistoria2);
    HISTORIAEVALUATIVA.anadirPregunta(preguntaHistoria2);

    PreguntaDesarrollo preguntaHistoria3 = new PreguntaDesarrollo("Explica qué fue la Guerra Fría.", "Historia Contemporánea", "Escribe aquí tu explicación de la Guerra Fría.");
    HISTORIAEVALUATIVA.anadirPregunta(preguntaHistoria3);

    ArrayList<String> alternativasHistoria4 = new ArrayList<>();
    alternativasHistoria4.add("Sí");
    alternativasHistoria4.add("No");
    char altCorrectaHistoria4 = 'a';

    PreguntaAlternativas preguntaHistoria4 = new PreguntaAlternativas("¿La Revolución Rusa de 1917 estableció un gobierno comunista?", "Revolución Rusa", alternativasHistoria4, altCorrectaHistoria4);
    HISTORIAEVALUATIVA.anadirPregunta(preguntaHistoria4);

    PreguntaDesarrollo preguntaHistoria5 = new PreguntaDesarrollo("Habla sobre el imperio romano.", "Historia Antigua", "Escribe aquí sobre el imperio romano.");
    HISTORIAEVALUATIVA.anadirPregunta(preguntaHistoria5);

    HISTORIAEVALUATIVA.anadirNota(new Nota(7.3, "Estudiante1"));
    HISTORIAEVALUATIVA.anadirNota(new Nota(8.5, "Estudiante2"));
    HISTORIAEVALUATIVA.anadirNota(new Nota(6.6, "Estudiante3"));
    HISTORIAEVALUATIVA.anadirNota(new Nota(9.1, "Estudiante4"));
    HISTORIAEVALUATIVA.anadirNota(new Nota(7.9, "Estudiante5"));

    agregarEvaluacion(HISTORIAEVALUATIVA);

    Evaluacion evaCiencias = new Evaluacion("Biología, Química y Física", "Ciencias", "12-06-2022");

    PreguntaDesarrollo preguntaCiencias1 = new PreguntaDesarrollo("Explica el ciclo del agua.", "Biología", "El ciclo del agua, también conocido como ciclo hidrológico, es el proceso de circulación del agua en la atmósfera y en la tierra.");
    evaCiencias.anadirPregunta(preguntaCiencias1);

  
    ArrayList<String> alternativasCiencias2 = new ArrayList<>();
    alternativasCiencias2.add("Sólido");
    alternativasCiencias2.add("Líquido");
    alternativasCiencias2.add("Gas");
    alternativasCiencias2.add("Plasma");
    char altCorrectaCiencias2 = 'b';

    PreguntaAlternativas preguntaCiencias2 = new PreguntaAlternativas("¿Cuál es el estado de la materia con forma y volumen definidos?", "Física", alternativasCiencias2, altCorrectaCiencias2);
    evaCiencias.anadirPregunta(preguntaCiencias2);


    PreguntaDesarrollo preguntaCiencias3 = new PreguntaDesarrollo("Explica la teoría de la relatividad de Einstein.", "Física Moderna", "La teoría de la relatividad propuesta por Albert Einstein revolucionó nuestra comprensión del espacio, el tiempo y la gravedad.");
    evaCiencias.anadirPregunta(preguntaCiencias3);

    ArrayList<String> alternativasCiencias4 = new ArrayList<>();
    alternativasCiencias4.add("ADN");
    alternativasCiencias4.add("ARN");
    alternativasCiencias4.add("ARNt");
    alternativasCiencias4.add("ARNm");
    char altCorrectaCiencias4 = 'a';

    PreguntaAlternativas preguntaCiencias4 = new PreguntaAlternativas("¿Cuál es la molécula que contiene la información genética en las células?", "Genética", alternativasCiencias4, altCorrectaCiencias4);
    evaCiencias.anadirPregunta(preguntaCiencias4);

    PreguntaDesarrollo preguntaCiencias5 = new PreguntaDesarrollo("Explica la ley de la conservación de la energía.", "Física", "La ley de la conservación de la energía establece que la energía no se crea ni se destruye, solo se transforma.");
    evaCiencias.anadirPregunta(preguntaCiencias5);

    evaCiencias.anadirNota(new Nota(8.0, "Estudiante1"));
    evaCiencias.anadirNota(new Nota(7.5, "Estudiante2"));
    evaCiencias.anadirNota(new Nota(9.2, "Estudiante3"));
    evaCiencias.anadirNota(new Nota(8.7, "Estudiante4"));
    evaCiencias.anadirNota(new Nota(7.9, "Estudiante5"));
    agregarEvaluacion(evaCiencias);
    Evaluacion evaIngles = new Evaluacion("Vocabulary", "Inglés", "12-06-2022");

    PreguntaDesarrollo preguntaIngles1 = new PreguntaDesarrollo("Describe tu rutina diaria en inglés.", "Vocabulario y Rutinas", "Write about your daily routine using English.");
    evaIngles.anadirPregunta(preguntaIngles1);

    ArrayList<String> alternativasIngles2 = new ArrayList<>();
    alternativasIngles2.add("London");
    alternativasIngles2.add("Paris");
    alternativasIngles2.add("Madrid");
    alternativasIngles2.add("Rome");
    char altCorrectaIngles2 = 'a';

    PreguntaAlternativas preguntaIngles2 = new PreguntaAlternativas("What is the capital of England?", "Geography", alternativasIngles2, altCorrectaIngles2);
    evaIngles.anadirPregunta(preguntaIngles2);

    PreguntaDesarrollo preguntaIngles3 = new PreguntaDesarrollo("Explique el uso del presente continuo en inglés.", "Gramática", "Explain the use of present continuous tense in English.");
    evaIngles.anadirPregunta(preguntaIngles3);
    ArrayList<String> alternativasIngles4 = new ArrayList<>();
    alternativasIngles4.add("Red");
    alternativasIngles4.add("Blue");
    alternativasIngles4.add("Green");
    alternativasIngles4.add("Yellow");
    char altCorrectaIngles4 = 'c';

    PreguntaAlternativas preguntaIngles4 = new PreguntaAlternativas("What color is the grass?", "Colors", alternativasIngles4, altCorrectaIngles4);
    evaIngles.anadirPregunta(preguntaIngles4);
    PreguntaDesarrollo preguntaIngles5 = new PreguntaDesarrollo("Habla sobre tus vacaciones ideales en inglés.", "Vocabulario y Viajes", "Talk about your ideal vacation using English.");
    evaIngles.anadirPregunta(preguntaIngles5);

    evaIngles.anadirNota(new Nota(7.6, "Estudiante1"));
    evaIngles.anadirNota(new Nota(8.2, "Estudiante2"));
    evaIngles.anadirNota(new Nota(6.9, "Estudiante3"));
    evaIngles.anadirNota(new Nota(9.0, "Estudiante4"));
    evaIngles.anadirNota(new Nota(8.3, "Estudiante5"));

    agregarEvaluacion(evaIngles);
  }

 

  //se retorna clon del arraylist de evaluaciones
  public ArrayList <Evaluacion> getEvaluaciones(){
    ArrayList <Evaluacion> aux = (ArrayList <Evaluacion>) arrayEvaluaciones_colegio.clone();
    return aux;
  }

}