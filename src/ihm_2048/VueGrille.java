/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_2048;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Marc-Antoine
 */
public class VueGrille extends JComponent{

    private static final int TAILLE_FEN = 700;
    
    private Grille mGrille;
    
    private int taille_case;
    private int taille_bordure;

    public VueGrille(Grille mGrille) {
        this.mGrille = mGrille;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(TAILLE_FEN,TAILLE_FEN);
    }

    @Override
    protected void paintComponent(Graphics g) {
       taille_case = (int) ((TAILLE_FEN * 0.90)/mGrille.getTaille());
       taille_bordure = (int) ((TAILLE_FEN * 0.10)/(mGrille.getTaille()+ 1));
       
       g.setFont(new Font(null,Font.BOLD, (int) (200/mGrille.getTaille())));
       g.setColor(Color.BLACK);
       g.fillRect(0, 0, TAILLE_FEN, TAILLE_FEN);
       
       
       for(int y = 0; y < mGrille.getTaille(); y++){
           for(int x = 0; x < mGrille.getTaille(); x++){
               int value = mGrille.getCase(x,y).getValue();
               if(value != 0){
                   Color c = new Color(255,240,240);
                   
                   if(value == 2)
                       c = new Color(0xFFFF00);
                   if(value == 4)
                       c = new Color(0xFFBF00);
                   if(value == 8)
                       c = new Color(0xFF8000);
                   if(value == 16)
                       c = new Color(0xFF4000);
                   if(value == 32)
                       c = new Color(0xFF0000);
                   if(value == 64)
                       c = new Color(0x013ADF);
                   if(value == 128)
                       c = new Color(0x0101DF);
                   if(value == 256)
                       c = new Color(0x0404B4);
                   if(value == 512)
                       c = new Color(0x08088A);
                   if(value == 1024)
                       c = new Color(0x00FF00);
                   if(value == 2048)
                       c = new Color(0x04B404);
                   
                   
                   g.setColor(c);
                   g.fillRect(((x+1)*taille_bordure) + x*taille_case, ((y+1)*taille_bordure) + y*taille_case, taille_case+1, taille_case+1);
                   g.setColor(Color.BLACK);
                   
                   g.drawString(Integer.toString(value), ((x+1)*taille_bordure) + x*taille_case + taille_case/8, ((y+1)*taille_bordure) + y*taille_case + taille_case - taille_case/12);
               }
               else{
                   g.setColor(Color.white);
                   g.fillRect(((x+1)*taille_bordure) + x*taille_case, ((y+1)*taille_bordure) + y*taille_case, taille_case+1, taille_case+1);
               
               }
           }
       }
    }    
}
