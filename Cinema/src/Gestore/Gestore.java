package Gestore;


import oggetti.Proiezione;
import oggetti.Film;
import input_output.Input;
import oggetti.Sala;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yatin
 */
public class Gestore {
    ArrayList<Film> Film;
    ArrayList<Sala> Sale;
    ArrayList<Proiezione> Proiezioni;
    
    public Gestore(){
         Film = new ArrayList<>();
         Sale = new ArrayList<>();
         Proiezioni = new ArrayList<>();
    }
    
    public void AggiornaDati(String nome_file) throws IOException {
        Input IO = new Input();
        switch(nome_file) {
            case "film.txt":
                Film = IO.scaricaFilm(nome_file);
                break;
            case "sale.txt":
                Sale = IO.scaricaSala(nome_file);
                break;
            case "proiezione.txt":
                 Proiezioni = IO.scaricaProiezione(nome_file);
                break;   
        }  
    }
    
    public void AggiungiFilm(String nome,String trama, int durata ) {
        int IDFilm = Film.size() + 1;
        //Film f = new Film(nome, IDFilm, trama, durata);
       // Film.add(f);
        // metodo per aggiornare lista database!!! da fare!!
    }
}