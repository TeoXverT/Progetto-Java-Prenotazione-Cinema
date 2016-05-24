/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oggetti;

import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Cris
 */
public class ButtonCart extends JButton{
    
    private Proiezione proiezione;
    
    public ButtonCart(Proiezione proiezione) throws IOException {
        
        this.proiezione = proiezione;
        this.setIcon(scalaImmagine(new ImageIcon(ImageIO.read(new URL("https://d30y9cdsu7xlg0.cloudfront.net/png/28468-200.png"))), 30, 30));
        
        
    }
    
    private ImageIcon scalaImmagine(ImageIcon immagine, int lunghezza, int altezza) {
        return new ImageIcon(immagine.getImage().getScaledInstance(lunghezza, altezza, java.awt.Image.SCALE_SMOOTH));
    }
    
    
    
    
}
