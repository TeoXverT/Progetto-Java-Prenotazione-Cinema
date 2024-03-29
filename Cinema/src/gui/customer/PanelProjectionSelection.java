package gui.customer;

import gui.obj.ButtonCart;
import core.CustomerController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import core.obj.Film;
import gui.obj.YoutubePanel;
import core.obj.Projection;

/**
 * Pannello che visualizza le informazioni relative al film passatogli  oltre che permette al scielta della proiezione tra una lista di proiezioni
 *
*/


public class PanelProjectionSelection extends JPanel {

    private CustomerController controller;
    private Film film;
    private ArrayList<Projection> proiezione;
    private Calendar focusedDateTime;

    public PanelProjectionSelection(Film film, Calendar focusedDateTime) {
        this.controller = CustomerController.getInstance();
        this.film = film;
        this.focusedDateTime = focusedDateTime;
        this.setLayout(new GridLayout(2, 2, 10, 10));
        
        draw();
    }

    private void draw() {
        
        //Creazione bottone home e assegnazione action listener
        JButton cover = new JButton();
        cover.setIcon(imageScaling(new ImageIcon("images/home.png"), 30, 30));
        cover.setBorderPainted(true);
        cover.setContentAreaFilled(false);
        cover.addActionListener(goBackEvent());
        
        //pannello copertina e relativa JLabel con immagine
        JPanel pannelloCopertina = new JPanel();
        pannelloCopertina.setBackground(java.awt.Color.WHITE);
        this.add(pannelloCopertina);
        JLabel label1 = new JLabel(imageScaling(downloadImageFromUrl(film.getLinkCover()), 250, 350));
        pannelloCopertina.add(label1);

        
        JPanel pannelloTrama = new JPanel(new BorderLayout(10, 10));
        pannelloTrama.setBackground(java.awt.Color.WHITE);
        this.setBackground(java.awt.Color.WHITE);
        this.add(pannelloTrama);

        JPanel pannelloTramaGridLayout = new JPanel(new GridLayout(2, 3));
        pannelloTramaGridLayout.setBackground(java.awt.Color.WHITE);
        pannelloTrama.add(pannelloTramaGridLayout, BorderLayout.NORTH);

        pannelloTramaGridLayout.add(new JLabel());

        pannelloTramaGridLayout.add(new JLabel());

        
        JPanel pannelloHome = new JPanel();
        pannelloTramaGridLayout.add(pannelloHome);
        pannelloHome.add(cover);
        pannelloHome.setSize(new Dimension(50, 50));

        pannelloHome.setBackground(java.awt.Color.WHITE);

        pannelloTramaGridLayout.add(new JLabel());
        
        //titolo film
        JEditorPane labeln = new JEditorPane();
        labeln.setContentType("text/html");
        labeln.setText("<b>" + film.toString() + "</b>");
        labeln.setEditable(false);
        labeln.setBorder(null);
        labeln.setBackground(java.awt.Color.WHITE);
        pannelloTramaGridLayout.add(labeln);
       
        
        pannelloTramaGridLayout.add(new JLabel());
        
        //creazione trama film
        JTextArea Trama = new JTextArea(film.getDescription());
        Trama.setLineWrap(true);
        Trama.setEditable(false);
        Trama.setBorder(null);
        Trama.setBackground(java.awt.Color.WHITE);
        Trama.setWrapStyleWord(true);
        pannelloTrama.add(Trama, BorderLayout.CENTER);
        
        
        //filtra le proiezioni del determinato film in base all'orario
        try {
            proiezione = controller.projectionFilteredByFilmAndTime(film.getIdFilm(), focusedDateTime);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Errore nella lettura delle informazioni del film, prova più tardi.",
                    "Errore",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");

        JPanel pannelloContenitoreBackOrari = new JPanel();
        pannelloContenitoreBackOrari.setBackground(java.awt.Color.WHITE);
        this.add(pannelloContenitoreBackOrari);
        this.add(new YoutubePanel(film.getLinkYoutube(), 200, 200));
        
        JPanel pannelloOrari = new JPanel(new GridLayout(proiezione.size(), 2, 10, 10));
        pannelloOrari.setBackground(java.awt.Color.WHITE);

        ButtonCart bottoneCarrello = null;
        
        JPanel pannelloCart;
        JScrollPane scrollpane = new JScrollPane(pannelloOrari, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pannelloContenitoreBackOrari.add(scrollpane, BorderLayout.CENTER);
        scrollpane.setBorder(null);
        
        //aggiunta proiezioni con relativa ora e sala
        for (final Projection s : proiezione) {

            pannelloOrari.add(new JLabel(sdfDate.format(s.getData_ora().getTime()) + "    tipo: " + s.getType_String() + "    sala: " + s.getRoom().getIdHall()), BorderLayout.SOUTH);
            try {
                bottoneCarrello = new ButtonCart(s);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "Errore nella lettura della proiezione, riprova più tardi.",
                        "Errore",
                        JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
            bottoneCarrello.setBorderPainted(false);
            bottoneCarrello.setContentAreaFilled(false);
            bottoneCarrello.setPreferredSize(new Dimension(50, 50));
            bottoneCarrello.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    s.setFilm(film);
                    openPageThree(s);
                }
            });
            
            //creazione e aggiunta bottone carrello
            pannelloCart = new JPanel();
            pannelloCart.setBackground(java.awt.Color.WHITE);
            pannelloCart.add(bottoneCarrello);
            pannelloCart.setSize(new Dimension(50, 50));
            pannelloOrari.add(pannelloCart);

        }

    }

    private ImageIcon imageScaling(ImageIcon immagine, int lunghezza, int altezza) {
        return new ImageIcon(immagine.getImage().getScaledInstance(lunghezza, altezza, java.awt.Image.SCALE_SMOOTH));
    }

    private void goBack() {
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new PanelDayAndFilmSelection(), BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    private ActionListener goBackEvent() {
        ActionListener evento = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBack();
            }
        };
        return evento;
    }

    private void openPageThree(Projection screening) {
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new PanelSeatSelection(screening), BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }


    private ImageIcon downloadImageFromUrl(String link_url) {
        
        Image image = null;
        try {
            URL url = new URL(link_url);
            image = ImageIO.read(url);
        } catch (IOException e) {
            
            JOptionPane.showMessageDialog(null,
                    "Errore nello scaricamento copertina film, riprovare più tardi.",
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
                        
        }
        ImageIcon ii = new ImageIcon(image);
        return ii;
    }




}
