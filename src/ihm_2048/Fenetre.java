/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_2048;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Marc-Antoine
 */
public class Fenetre extends JFrame  implements KeyListener{
    
    private Grille mGrille;
    
    private VueGrille vueFen;
        

    public Fenetre() {
        this.mGrille = new Grille(4);
        
        this.setTitle("IHM | 2048 | Fernandes Marc-Antoine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        
        vueFen = new VueGrille(mGrille);
        this.setContentPane(vueFen);
        this.pack();
        
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            mGrille.play(0);
            vueFen.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            mGrille.play(1);
            vueFen.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            mGrille.play(2);
            vueFen.repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            mGrille.play(3);
            vueFen.repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_R){
            mGrille.reset();
            vueFen.repaint();
        }
        else if(e.getKeyChar() == '+'){
            mGrille.agrandir();
            vueFen.repaint();
        }
        else if(e.getKeyChar() == '-'){
            mGrille.reduire();
            vueFen.repaint();
        }
        else if (e.getKeyChar() == 'z'){
            for(int i = 0; i < 25*mGrille.getTaille(); i++){
                mGrille.play((int) (Math.random()*512));
            }
            vueFen.repaint();
        }
        if(mGrille.isFinish()){
            JOptionPane.showMessageDialog(this,
                "Partie terminée.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
            mGrille.reset();
            vueFen.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    
}
