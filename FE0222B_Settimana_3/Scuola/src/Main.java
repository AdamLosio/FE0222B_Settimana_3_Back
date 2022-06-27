import java.util.*;
import java.text.DecimalFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        DecimalFormat Decimale = new DecimalFormat("0.00");
        Logger logger = LoggerFactory.getLogger(Scuola.class);

      //LISTA STUDENTI PRIMA SCUOLA
        
        Studente adam = new Studente(0, "Adam", "Losio", 'M', randomMap());
        Studente alberto = new Studente(1, "Alberto", "Albe", 'M', randomMap());
        Studente carla = new Studente(2, "Carla", "Carla", 'F', randomMap());
        Studente susi = new Studente(3, "Susi", "Sus", 'F', randomMap());
        Studente ivan = new Studente(4, "Ivan", "Iva", 'M', randomMap());

        //AGGIUNGI STUDENTI PRIMA SCUOLA
        
        List<Studente>listaScuola_1=new ArrayList<>();
        listaScuola_1.add(adam);
        listaScuola_1.add(alberto);
        listaScuola_1.add(carla);
        listaScuola_1.add(susi);
        listaScuola_1.add(ivan);

        Scuola prima = new Scuola(listaScuola_1);
        logger.info(promossi(prima.getPromossi()));
        logger.info(prima.getStudenti().toString());
        logger.info("Studente migliore: " + prima.getStudenteMigliore()
        + "media:" + "/n" + Decimale.format(prima.getStudenteMigliore().mediaVoti()));
        logger.info("La media di : " + susi.getNome() + " è :" + Decimale.format(susi.mediaVoti()));
        File file = new File("/Users/adamlosio/Desktop/Epi\\ ALL/BACK\\ END\\ -\\ ES/FE0222B_Settimana_3/Scuola/lista.txt");
        prima.salvaStudenti(file);
        logger.info("voto: " + Decimale.format(adam.mediaVotoMateria("Grafica")));
        logger.info("voto: " + susi.promosso());

        
      //LISTA STUDENTI SECONDA SCUOLA

        Studente franco = new Studente(5, "Franco", "Fran", 'M', randomMap());
        Studente elisa = new Studente(6, "Elisa", "Eli", 'M', randomMap());
        Studente carlotta = new Studente(7, "Carlotta", "Carl", 'F', randomMap());
        Studente cristina = new Studente(8, "Cristina", "Cris", 'F', randomMap());
        Studente lucas = new Studente(9, "Lucas", "Luc", 'M', randomMap());

        //AGGIUNGI STUDENTI SECONDA SCUOLA
        
        List<Studente> listaScuola_2 = new ArrayList<>();
        listaScuola_2.add(franco);
        listaScuola_2.add(elisa);
        listaScuola_2.add(carlotta);
        listaScuola_2.add(cristina);
        listaScuola_2.add(lucas);
        Scuola seconda = new Scuola(listaScuola_2);

        //THREAD
        
        Thread thread_1 = new Thread(prima, "Scuola_1");
        Thread thread_2 = new Thread(seconda, "Scuola_2");
        thread_1.start();
        thread_2.start();
    }

    //AGGIUNGI STUDENTI SECONDA SCUOLA
    
    private static List<Double> randomList() {
        SplittableRandom random = new SplittableRandom();
        Double[] votiRandom = new Double[6];
        for (int i = 0; i < 6; i++) {
        	votiRandom[i] = random.nextDouble(5, 10);
        }
        return Arrays.stream(votiRandom).collect(Collectors.toList());
    }
    
    //LISTA MATERIE SCUOLA - RANDOM

    private static HashMap<String, List<Double>> randomMap() {
        HashMap<String, List<Double>> randomMap = new HashMap<>();
        randomMap.put("Grafica", randomList());
        randomMap.put("Illustrazione", randomList());
        randomMap.put("Impaginazione", randomList());
        randomMap.put("Fotoritocco", randomList());
        randomMap.put("Advertising", randomList());
        randomMap.put("Layout", randomList());
        return randomMap;
    }
    
    //PROMOSSI - NON PROMOSSI

    private static String promossi(List<Studente> Studenti) {
        if (Studenti.size() == 0) {
            return "No pormossi";
        } else if (Studenti.size() == 1) {
            return
            		"Studente promosso: \n" + Studenti;
        } else {
            return
            		"Studenti promossi: \n" + Studenti;
        }}
}