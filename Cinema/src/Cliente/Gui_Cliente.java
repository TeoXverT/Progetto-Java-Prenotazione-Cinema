/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import input_output.Adapter_SQL;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import oggetti.Film;

/**
 *
 * @author Yoga
 */
public class Gui_Cliente extends JFrame{
    
    private final Controller_Cliente cliente;
    private JPanel pannello;
    private JPanel pannello1, pannello2, pannello3, pannello4, pannello5, pannello6, pannello7;
    Adapter_SQL adapter  = new Adapter_SQL();
     //viene usato nel thread  
    
    ArrayList<Film> listaFilmFiltratiGiornalmente; //qui dichiaro l'arrayList che conterrà la futura lista filtrata
    JPanel visualizzazioneGiornaliera;
    
    //variabile temporanea per il settaggio del inizio e fine giorno
    Calendar temporaneo;
    //i nomi si commentano da soli, qui li definisco
    Calendar inizioPrimoGiorno;
    Calendar finePrimoGiorno;
    
    
    Calendar fineSecondoGiorno;
    
    
    Calendar fineTerzoGiorno;
    
    
    Calendar fineQuartoGiorno;
    
   
    Calendar fineQuintoGiorno;
    
    
    Calendar fineSestoGiorno;
    
    
    Calendar fineSettimoGiorno;
    
    public Gui_Cliente() {
        
        cliente = new Controller_Cliente();
        
        pannello = new JPanel();
        
        
        
        creaGui();
        
        
        //VARIABILI PER IL PRIMO GIORNO
        
        inizioPrimoGiorno = Calendar.getInstance();
        temporaneo = Calendar.getInstance();
        temporaneo.add(Calendar.DAY_OF_MONTH,1);
        temporaneo.set(temporaneo.get(Calendar.YEAR), temporaneo.get(Calendar.MONTH), temporaneo.get(Calendar.DAY_OF_MONTH), 00, 00, 00);
        finePrimoGiorno = temporaneo;
        
        //VARIABILI PER IL SECONDO GIORNO
        temporaneo.add(Calendar.DAY_OF_MONTH,1);
        fineSecondoGiorno = temporaneo;
        
        //VARIABILI PER IL TERZO GIORNO
        temporaneo.add(Calendar.DAY_OF_MONTH,1);
        fineTerzoGiorno = temporaneo;
        
        //VARIABILI PER IL QUARTO GIORNO
        temporaneo.add(Calendar.DAY_OF_MONTH,1);
        fineQuartoGiorno = temporaneo;
        
        //VARIABILI PER IL QUINTO GIORNO
        temporaneo.add(Calendar.DAY_OF_MONTH,1);
        fineQuintoGiorno = temporaneo;
        
        //VARIABILI PER SESTO GIORNO
        temporaneo.add(Calendar.DAY_OF_MONTH,1);
        fineSestoGiorno = temporaneo;
        
        //VARIABILI PER SETTIMO GIORNO
        temporaneo.add(Calendar.DAY_OF_MONTH,1);
        fineSettimoGiorno = temporaneo;
        
        
    }
    
    
    
    public void creaGui() {
        
       
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Pannello Cliente");
        this.setBounds(100, 100, 880, 700);
//        this.setResizable(false);

        ImageIcon icona = new ImageIcon("immagini/logo_trasparente.png");
        setIconImage(icona.getImage());

        
        JTabbedPane tab = new JTabbedPane();
        
        
        this.add(tab);
        /*_______________________________________
        |                                        |
        |ISTANZIAZIONE PANNELLI GIORNI SETTIMANA |
        |________________________________________|
        */
        pannello1 = new JPanel();
        pannello1.setName("pannello1");
        pannello2  = new JPanel();
        pannello2.setName("pannello2");
        pannello3 = new JPanel();
        pannello3.setName("pannello3");
        pannello4  = new JPanel();
        pannello4.setName("pannello4");
        pannello5 = new JPanel();
        pannello5.setName("pannello5");
        pannello6  = new JPanel();
        pannello6.setName("pannello6");
        pannello7 = new JPanel();
        pannello7.setName("pannello7");
        
        /*____________________________________
        |                                    |
        |AGGIUNTA AL TABBEDPANE DEI PANNELLI |
        |____________________________________|
        */

        Calendar dataAttuale = Calendar.getInstance();
          
        tab.add(pannello1, giornoDellaSettimana(dataAttuale.get(Calendar.DAY_OF_WEEK)) + " "+ dataAttuale.get(Calendar.DAY_OF_MONTH) +" " + elaboraMese(dataAttuale.get(Calendar.MONTH)) );
        dataAttuale.add(Calendar.DAY_OF_MONTH , 1);
        
        tab.add(pannello2, giornoDellaSettimana(dataAttuale.get(Calendar.DAY_OF_WEEK)) + " "+ dataAttuale.get(Calendar.DAY_OF_MONTH) +" " + elaboraMese(dataAttuale.get(Calendar.MONTH)) );
        dataAttuale.add(Calendar.DAY_OF_MONTH , 1);

        tab.add(pannello3,giornoDellaSettimana(dataAttuale.get(Calendar.DAY_OF_WEEK)) + " "+ dataAttuale.get(Calendar.DAY_OF_MONTH) +" " + elaboraMese(dataAttuale.get(Calendar.MONTH)) );
        dataAttuale.add(Calendar.DAY_OF_MONTH , 1);
       
        tab.add(pannello4,giornoDellaSettimana(dataAttuale.get(Calendar.DAY_OF_WEEK)) + " "+ dataAttuale.get(Calendar.DAY_OF_MONTH) +" " + elaboraMese(dataAttuale.get(Calendar.MONTH)) );
           dataAttuale.add(Calendar.DAY_OF_MONTH , 1);
       
        tab.add(pannello5,giornoDellaSettimana(dataAttuale.get(Calendar.DAY_OF_WEEK)) + " "+ dataAttuale.get(Calendar.DAY_OF_MONTH) +" " + elaboraMese(dataAttuale.get(Calendar.MONTH)) );
        dataAttuale.add(Calendar.DAY_OF_MONTH , 1);
        
        tab.add(pannello6,giornoDellaSettimana(dataAttuale.get(Calendar.DAY_OF_WEEK)) + " "+ dataAttuale.get(Calendar.DAY_OF_MONTH) +" " + elaboraMese(dataAttuale.get(Calendar.MONTH)) );
        dataAttuale.add(Calendar.DAY_OF_MONTH , 1);
       
        tab.add(pannello7,giornoDellaSettimana(dataAttuale.get(Calendar.DAY_OF_WEEK)) + " "+ dataAttuale.get(Calendar.DAY_OF_MONTH) +" " + elaboraMese(dataAttuale.get(Calendar.MONTH)) );
        
        
        /*_________________________________________________________
        |                                                         |
        |QUI CREO IL CHANGELISTENER PER GESTIRE IL CAMBIO DEI TAB |
        |NEL JTABBEDPANE E FAR PARTIRE I RELATIVI THREAD          |
        |_________________________________________________________|     */
                
        tab.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
         
                Component c = tab.getSelectedComponent();
                System.out.println(c.getName());
                if(c.getName().equals("pannello1")) {
                    ThreadFilmPrimoTab().start();
                }
                if(c.getName().equals("pannello2")) {
                    ThreadFilmSecondoTab().start();
                }
                if(c.getName().equals("pannello3")) {
                    ThreadFilmTerzoTab().start();
                }
                if(c.getName().equals("pannello4")) {
                    ThreadFilmQuartoTab().start();
                }
                if(c.getName().equals("pannello5")) {
                    ThreadFilmQuintoTab().start();
                }
                if(c.getName().equals("pannello6")) {
                    ThreadFilmSestoTab().start();
                }
                if(c.getName().equals("pannello7")) {
                    ThreadFilmSettimoTab().start();
                }
            }
        });
        
        
        
        
        
        
    }
    
    
    //METODO PER CAMBIARE IL METODO DI IDENTIFICAZIONE DEI GIORNI DA NUMERO(INT) A NOME(STRING)
    
    private String giornoDellaSettimana(int numero) {
        
        if(numero == 1) {
            
            return "Domenica";
        }
        
        if(numero == 2) {
            
            return "lunedì";
        }
        if(numero == 3) {
            
            return "martedì";
        }
        if(numero == 4) {
            
            return "mercoledì";
        }
        if(numero == 5) {
            
            return "giovedì";
        }
        if(numero == 6) {
            
            return "venerdì";
        }
        if(numero == 7) {
            
            return "sabato";
        }
        
        else{
            return "giorno non valido";
        }
        
    }
    
    
    
    //METODO PER CAMBIARE IL METODO DI IDENTIFICAZIONE DEI MESI DA NUMERO(INT) A NOME(STRING)
    private String elaboraMese(int mese) {
        
        if(mese==0){
            return "Gennaio";
        }
        if(mese==1){
            return "Febbraio";
        }
        if(mese==2){
            return "Marzo";
        }
        if(mese==3){
            return "Aprile";
        }
        if(mese==4){
            return "Maggio";
        }
        if(mese==5){
            return "Giugno";
        }
        if(mese==6){
            return "Luglio";
        }
        if(mese==7){
            return "Agosto";
        }
        if(mese==8){
            return "Settembre";
        }
        if(mese==9){
            return "Ottobre";
        }
        if(mese==10){
            return "Novembre";
        }
        if(mese==11){
            return "Dicembre";
        }
        else{
            return "numero inserito sbagliato";
        }
        
        
        
        
    }
    
    
    /*_______________________________________           
    |                                       |
    |QUI CREO I THREAD PER OGNI SCHEDA      |
    |_______________________________________|
    */
    
    
    private Thread ThreadFilmPrimoTab() {
        
        Thread t  = new Thread(new Runnable () {
            
            public void run() {
                
                try{
                    
                    
                    
                    visualizzazioneGiornaliera = new JPanel(new  GridLayout(10, 3));
                    
                    listaFilmFiltratiGiornalmente = adapter.visualizzaFilmFiltratiRispettoOraEData(inizioPrimoGiorno, finePrimoGiorno);
                    
                    //CICLO CHE PRINTA E AGGIUNGE LA COPERTINA AL JPANEL
                    for(int i = 0; i < listaFilmFiltratiGiornalmente.size(); i++) {
                        System.out.println("In Download immagine URL: " + listaFilmFiltratiGiornalmente.get(i).getLink_copertina());
                        ImageIcon immagine = new ImageIcon(ImageIO.read(new URL(listaFilmFiltratiGiornalmente.get(i).getLink_copertina())));
                          
                        visualizzazioneGiornaliera.add(new JLabel (scalaImmagine(immagine, 100, 100)));
                      
                        //METODO PER IMPOSTAZIONE IL JPANEL (GLI PASSO IL NUMERO 1 PERCHè VOGLIO CREARE QUELLO DELLA PRIMA TAB)
                        aggiornaGuiGiornaliera(1, visualizzazioneGiornaliera);
                        System.out.println("finito caricamento immagini");
                    }
                    
                    
                } catch(IOException ex) {
                    System.out.println("errore nello scaricamento immagini");
                } catch (SQLException ex) {
                    Logger.getLogger(Gui_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
        
        );
        
        return t;
        
    }
    
    
    private Thread ThreadFilmSecondoTab() {
        
        Thread t  = new Thread(new Runnable () {
            
            public void run() {
                
                try{
                    
                  
                    visualizzazioneGiornaliera = new JPanel(new  GridLayout(10, 3)); 
                    listaFilmFiltratiGiornalmente = adapter.visualizzaFilmFiltratiRispettoOraEData(finePrimoGiorno, fineSecondoGiorno );
                    
                    //CICLO CHE PRINTA E AGGIUNGE LA COPERTINA AL JPANEL
                    for(int i = 0; i < listaFilmFiltratiGiornalmente.size(); i++) {
                         System.out.println("In Download immagine URL: " + listaFilmFiltratiGiornalmente.get(i).getLink_copertina());
                        ImageIcon immagine = new ImageIcon(ImageIO.read(new URL(listaFilmFiltratiGiornalmente.get(i).getLink_copertina())));
                        visualizzazioneGiornaliera.add(new JLabel (scalaImmagine(immagine, 100, 100)));
                        
                        //METODO PER IMPOSTAZIONE IL JPANEL (GLI PASSO IL NUMERO 1 PERCHè VOGLIO CREARE QUELLO DELLA PRIMA TAB)
                        aggiornaGuiGiornaliera(2, visualizzazioneGiornaliera);
                        System.out.println("finito caricamento immagini");
                    }
                    
                    
                } catch(IOException ex) {
                    System.out.println("errore nello scaricamento immagini");
                } catch (SQLException ex) {
                    Logger.getLogger(Gui_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
        
        );
        
        return t;
        
    }
    
    
    private Thread ThreadFilmTerzoTab() {
        
        Thread t  = new Thread(new Runnable () {
            
            public void run() {
                
                try{
                    
                  
                    visualizzazioneGiornaliera = new JPanel(new  GridLayout(10, 3)); 
                    listaFilmFiltratiGiornalmente = adapter.visualizzaFilmFiltratiRispettoOraEData(fineSecondoGiorno, fineTerzoGiorno );
                    
                    //CICLO CHE PRINTA E AGGIUNGE LA COPERTINA AL JPANEL
                    for(int i = 0; i < listaFilmFiltratiGiornalmente.size(); i++) {
                         System.out.println("In Download immagine URL: " + listaFilmFiltratiGiornalmente.get(i).getLink_copertina());
                        ImageIcon immagine = new ImageIcon(ImageIO.read(new URL(listaFilmFiltratiGiornalmente.get(i).getLink_copertina())));
                        visualizzazioneGiornaliera.add(new JLabel (scalaImmagine(immagine, 100, 100)));
                        
                        //METODO PER IMPOSTAZIONE IL JPANEL (GLI PASSO IL NUMERO 1 PERCHè VOGLIO CREARE QUELLO DELLA PRIMA TAB)
                        aggiornaGuiGiornaliera(3, visualizzazioneGiornaliera);
                        System.out.println("finito caricamento immagini");
                    }
                    
                    
                } catch(IOException ex) {
                    System.out.println("errore nello scaricamento immagini");
                } catch (SQLException ex) {
                    Logger.getLogger(Gui_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
        
        );
        
        return t;
        
    }
    
    private Thread ThreadFilmQuartoTab() {
        
        Thread t  = new Thread(new Runnable () {
            
            public void run() {
                
                try{
                    
                  
                    visualizzazioneGiornaliera = new JPanel(new  GridLayout(10, 3)); 
                    
                    listaFilmFiltratiGiornalmente = adapter.visualizzaFilmFiltratiRispettoOraEData(fineTerzoGiorno, fineQuartoGiorno );
                    
                    //CICLO CHE PRINTA E AGGIUNGE LA COPERTINA AL JPANEL
                    for(int i = 0; i < listaFilmFiltratiGiornalmente.size(); i++) {
                         System.out.println("In Download immagine URL: " + listaFilmFiltratiGiornalmente.get(i).getLink_copertina());
                        ImageIcon immagine = new ImageIcon(ImageIO.read(new URL(listaFilmFiltratiGiornalmente.get(i).getLink_copertina())));
                        visualizzazioneGiornaliera.add(new JLabel (scalaImmagine(immagine, 100, 100)));
                        
                        //METODO PER IMPOSTAZIONE IL JPANEL (GLI PASSO IL NUMERO 1 PERCHè VOGLIO CREARE QUELLO DELLA PRIMA TAB)
                        aggiornaGuiGiornaliera(4, visualizzazioneGiornaliera);
                        System.out.println("finito caricamento immagini");
                    }
                    
                    
                } catch(IOException ex) {
                    System.out.println("errore nello scaricamento immagini");
                } catch (SQLException ex) {
                    Logger.getLogger(Gui_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
        
        );
        
        return t;
        
    }
    
    private Thread ThreadFilmQuintoTab() {
        
        Thread t  = new Thread(new Runnable () {
            
            public void run() {
                
                try{
                    
                  
                    visualizzazioneGiornaliera = new JPanel(new  GridLayout(10, 3));
                    
                    listaFilmFiltratiGiornalmente = adapter.visualizzaFilmFiltratiRispettoOraEData(fineQuartoGiorno, fineQuintoGiorno );
                    
                    //CICLO CHE PRINTA E AGGIUNGE LA COPERTINA AL JPANEL
                    for(int i = 0; i < listaFilmFiltratiGiornalmente.size(); i++) {
                         System.out.println("In Download immagine URL: " + listaFilmFiltratiGiornalmente.get(i).getLink_copertina());
                        ImageIcon immagine = new ImageIcon(ImageIO.read(new URL(listaFilmFiltratiGiornalmente.get(i).getLink_copertina())));
                        visualizzazioneGiornaliera.add(new JLabel (scalaImmagine(immagine, 100, 100)));
                        
                        //METODO PER IMPOSTAZIONE IL JPANEL (GLI PASSO IL NUMERO 1 PERCHè VOGLIO CREARE QUELLO DELLA PRIMA TAB)
                        aggiornaGuiGiornaliera(5, visualizzazioneGiornaliera);
                        System.out.println("finito caricamento immagini");
                    }
                    
                    
                } catch(IOException ex) {
                    System.out.println("errore nello scaricamento immagini");
                } catch (SQLException ex) {
                    Logger.getLogger(Gui_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
        
        );
        
        return t;
        
    }
    
    private Thread ThreadFilmSestoTab() {
        
        Thread t  = new Thread(new Runnable () {
            
            public void run() {
                
                try{
                    
                  
                    visualizzazioneGiornaliera = new JPanel(new  GridLayout(10, 3)); 
                  
                    listaFilmFiltratiGiornalmente = adapter.visualizzaFilmFiltratiRispettoOraEData(fineQuintoGiorno, fineSestoGiorno );
                    
                    //CICLO CHE PRINTA E AGGIUNGE LA COPERTINA AL JPANEL
                    for(int i = 0; i < listaFilmFiltratiGiornalmente.size(); i++) {
                         System.out.println("In Download immagine URL: " + listaFilmFiltratiGiornalmente.get(i).getLink_copertina());
                        ImageIcon immagine = new ImageIcon(ImageIO.read(new URL(listaFilmFiltratiGiornalmente.get(i).getLink_copertina())));
                        visualizzazioneGiornaliera.add(new JLabel (scalaImmagine(immagine, 100, 100)));
                        
                        //METODO PER IMPOSTAZIONE IL JPANEL (GLI PASSO IL NUMERO 1 PERCHè VOGLIO CREARE QUELLO DELLA PRIMA TAB)
                        aggiornaGuiGiornaliera(6, visualizzazioneGiornaliera);
                        System.out.println("finito caricamento immagini");
                    }
                    
                    
                } catch(IOException ex) {
                    System.out.println("errore nello scaricamento immagini");
                } catch (SQLException ex) {
                    Logger.getLogger(Gui_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
        
        );
        
        return t;
        
    }
    
    private Thread ThreadFilmSettimoTab() {
        
        Thread t  = new Thread(new Runnable () {
            
            public void run() {
                
                try{
                    
                  
                    visualizzazioneGiornaliera = new JPanel(new  GridLayout(10, 3)); 
                    listaFilmFiltratiGiornalmente = adapter.visualizzaFilmFiltratiRispettoOraEData(fineSestoGiorno, fineSettimoGiorno );
                    
                    //CICLO CHE PRINTA E AGGIUNGE LA COPERTINA AL JPANEL
                    for(int i = 0; i < listaFilmFiltratiGiornalmente.size(); i++) {
                         System.out.println("In Download immagine URL: " + listaFilmFiltratiGiornalmente.get(i).getLink_copertina());
                        ImageIcon immagine = new ImageIcon(ImageIO.read(new URL(listaFilmFiltratiGiornalmente.get(i).getLink_copertina())));
                        visualizzazioneGiornaliera.add(new JLabel (scalaImmagine(immagine, 100, 100)));
                        
                        //METODO PER IMPOSTAZIONE IL JPANEL (GLI PASSO IL NUMERO 1 PERCHè VOGLIO CREARE QUELLO DELLA PRIMA TAB)
                        aggiornaGuiGiornaliera(7, visualizzazioneGiornaliera);
                        System.out.println("finito caricamento immagini");
                    }
                    
                    
                } catch(IOException ex) {
                    System.out.println("errore nello scaricamento immagini");
                } catch (SQLException ex) {
                    Logger.getLogger(Gui_Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
        
        );
        
        return t;
        
    }
    
    
    
    
    
    
    
    
    
    ImageIcon scalaImmagine(ImageIcon immagine, int lunghezza, int altezza) {
        return new ImageIcon(immagine.getImage().getScaledInstance(lunghezza, altezza, java.awt.Image.SCALE_SMOOTH));
    }
    
    public void aggiornaGuiGiornaliera(int i, JPanel pannelloGiornaliero){
        
        /*  PRIMA TAB = 1
            SECONDA TAB = 2
            TERZA TAB = 3
            QUARTA TAB = 4
            QUINTA TAB = 5
            SESTA TAB = 6
            SETTIMA TAB = 7
        */
        if(i == 1) {
            
            pannello1.add(pannelloGiornaliero);
            pannello1.revalidate();
            pannello1.repaint();
        }
        
        if(i == 2) {
            pannello2.add(pannelloGiornaliero);
            pannello2.revalidate();
            pannello2.repaint();
        }
        
        if(i == 3) {
            
            pannello3.add(pannelloGiornaliero);
            pannello3.revalidate();
            pannello3.repaint();
        }
        
        if(i == 4) {
            
            pannello4.add(pannelloGiornaliero);
            pannello4.revalidate();
            pannello4.repaint();
        }
        
        if(i == 5) {
            
            pannello5.add(pannelloGiornaliero);
            pannello5.revalidate();
            pannello5.repaint();
            
        }
        
        if(i == 6) {
            
            pannello6.add(pannelloGiornaliero);
            pannello6.revalidate();
            pannello6.repaint();
        }
        
        if(i == 7) {
            
            pannello7.add(pannelloGiornaliero);
            pannello7.revalidate();
            pannello7.repaint();
        }
        
        
        
        
    }
    
    
}
