import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.stream.Stream;

public class Studente {
    private final int id;
    private final String nome;
    private final String cognome;
    private final char genere;
    private final HashMap<String, List<Double>> voti;


    //COSTRUTTORE
    
    public Studente(
    		int id,
    		String nome,
    		String cognome,
    		char genere,
    		HashMap<String, List<Double>> voti)
    {	
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.genere = genere;
        this.voti = voti;
    }

//GETTER

    public String getNome() {
        return nome;
    }
    public HashMap<String, List<Double>> getVoti() {
        return voti;
    }
    
    
  //OVERRIDE

    @Override
    public String toString() {
        return " \n id= " + id + "\n nome= " + nome + "\n cognome= " + cognome + "\n genere= " + genere + " ;\n";
    }
    
    //METODO MEDIA VOTO MATERIA

    public double mediaVotoMateria(String materia){
       Collection<Double> collection=getVoti().get(materia);
       Double listaVoti=collection.stream().reduce(0.0, Double::sum);
        return listaVoti/collection.size();
    }
    
    //METODO VOTO MIGLIORE MATERIA

    public double votoMiglioreMateria(String materia){
        Collection<Double> collection=getVoti().get(materia);
        return collection.stream().reduce(0.0,(max, voto) -> (voto > max ? max=voto : max) );
    }
    
    //METODO PROMOZIONE

    public double mediaVoti(){
        Stream<String> collection = getVoti().keySet().stream();
       double Voti=collection.mapToDouble(this::mediaVotoMateria).sum();
       return Voti/getVoti().size();
    }
    
    //METODO PROMOZIONE

    public boolean promosso() {
        Stream<String> collection = getVoti().keySet().stream();
        long votoPromozione=collection.filter(el -> mediaVotoMateria(el) < 6).count();
        return votoPromozione < 5;
    }
    

}