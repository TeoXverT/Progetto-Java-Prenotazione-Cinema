package Gestore;


import input_output_sql.Controller_Dati_Gestore;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import oggetti.*;

/**
 *
 * @author Yatin
 */
public class Gestore {
    
    private final Controller_Dati_Gestore controller= new Controller_Dati_Gestore();

    
    public Gestore() {

    
    
    }
        
//        public boolean creaProiezione( String data_ora,int id_film, int id_sala, String  tipo_proiezione, int prezzo_normale, int prezzo_3d){ 
//            Proiezione proiezione = new Proiezione(0, parseData_ora(data_ora),id_film, id_sala, tipo_proiezione, prezzo_normale, prezzo_3d);
//            return controller.creaProiezione(proiezione);
//        }
//
//        public boolean modifica_config(double prezzo_vip, double sconto){
//            try {
//            Config config1 = new Config(prezzo_vip, sconto);
//            controller.modifica_config(config1);
//            }
//            catch(IOException e){
//                    System.out.println("Errore!!!");
//                    return false;
//                    }
//            return true;            
//        }
//        
  
//    private Calendar parseData_ora(String stringaCalendario) {
//        int anno, mese, giorno, ora, min, sec;
//
//        StringTokenizer st = new StringTokenizer(stringaCalendario);
//        StringTokenizer rt = new StringTokenizer(st.nextToken(), "-");
//
//        anno = Integer.parseInt(rt.nextToken());
//        mese = Integer.parseInt(rt.nextToken());
//        giorno = Integer.parseInt(rt.nextToken());
//
//        rt = new StringTokenizer(st.nextToken(), ":");
//
//        ora = Integer.parseInt(rt.nextToken());
//        min = Integer.parseInt(rt.nextToken());
//        sec = Integer.parseInt(rt.nextToken());
//        
//        Calendar fine = new GregorianCalendar(anno, mese, giorno, ora, min, sec);
//
//        return fine;
//    }
//        
//    public boolean aggiungiFilm(String titolo_film, String genere, int durata, String descrizione, String link_trailer) throws IOException{
//        Film newFilm = new Film(0, titolo_film, genere, durata, descrizione, link_trailer);
//        if (newFilm.getDurata() < 300) {
//            boolean adding = controller.controllerFilm(newFilm);
//            return adding;
//        } else {
//            return false;
//        }
//    }
    
    public ArrayList<Proiezione> visualizzaPrenotazione(int tipo) throws SQLException{
        //TIPO = 0 //Odierne
        //TIPO = 1 //Future
        ArrayList<Proiezione> Proiezione =controller.visualizzaPrenotazione(tipo);
        return Proiezione;
    }  
    
        public ArrayList<Film> visualizzaFilm(int quantita_max_da_visualizzare) throws SQLException{
        //quantita_max_da_visualizzare = 0 //NO LIMIT
        ArrayList<Film> Films =controller.visualizzaFilm(quantita_max_da_visualizzare);
        return Films;
    }  
    
}
