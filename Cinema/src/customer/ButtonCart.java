/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import obj.Projection;

/**
 *
 * @author Cris
 */
public class ButtonCart extends JButton{
    
    private Projection proiezione;
    
    public ButtonCart(Projection proiezione) throws IOException {
        
        this.proiezione = proiezione;
        this.setIcon(imageScaling(new ImageIcon("images/cart.png"), 30, 30));
        
        
    }
    
    private ImageIcon imageScaling(ImageIcon immagine, int lunghezza, int altezza) {
        return new ImageIcon(immagine.getImage().getScaledInstance(lunghezza, altezza, java.awt.Image.SCALE_SMOOTH));
    }
    
    
    
    
}
