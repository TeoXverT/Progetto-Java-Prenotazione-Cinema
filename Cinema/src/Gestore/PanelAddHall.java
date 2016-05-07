/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestore;

import static com.sun.webkit.graphics.WCImage.getImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import oggetti.Config;
import oggetti.Seat;

/**
 *
 * @author Yatin
 */
public class PanelAddHall extends JPanel {

    private int x;
    private int y;
    private ArrayList<Seat> seats = null;

    public PanelAddHall(Controller_Gestore controller, final JLabel outputGrafico) {
        this.setLayout(new GridLayout(0, 2));
        JLabel row_num = new JLabel("Number of rows:");
        JLabel column_num = new JLabel("Number of col:");
        final JTextField row = new JTextField(10);
        final JTextField column = new JTextField(10);
        JButton submit = new JButton("Submit");
        this.add(row_num);
        this.add(row);
        this.add(column_num);
        this.add(column);
        this.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                outputGrafico.setText("Visualizzazione Layout in Corso..");
                x = Integer.parseInt(row.getText());
                y = Integer.parseInt(column.getText());
                creaLayoutPosti();
            }
        });
    }

    public void creaLayoutPosti() {
        this.removeAll();
        this.setLayout(new BorderLayout(20, 30));
        JPanel nord = new JPanel();
        JPanel sud = new JPanel(new BorderLayout(10,20));
        JPanel west = new JPanel();
        JPanel seats_layout = new JPanel(new GridLayout(x,y,1,6));
        ImageIcon seat_icon = new ImageIcon("immagini/poltrone/seat_disponibile.png");
        ImageIcon screen_icon = new ImageIcon("immagini/poltrone/screen.png");
        JLabel screen = new JLabel(screen_icon);

        nord.add(screen);
        
        seats = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                seats.add(new Seat(i, j, seat_icon));
            }
        }
        
        for (Seat s : seats) {
            seats_layout.add(s);
        }
        
        JButton crea_sala = new JButton("Crea Sala");
        sud.add(seats_layout, BorderLayout.CENTER);
        sud.add(crea_sala, BorderLayout.SOUTH);
        String[] type_list = {"Disattivato", "Vip", "Disabili"};
        JComboBox seat_type = new JComboBox(type_list);
        west.add(seat_type);
        
        this.add(nord, BorderLayout.NORTH);
        this.add(sud, BorderLayout.SOUTH);
        this.add(west, BorderLayout.CENTER);
    }
}
