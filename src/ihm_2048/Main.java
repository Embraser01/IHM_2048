/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_2048;

import java.util.Scanner;

/**
 *
 * @author Marc-Antoine
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Grille mGrille = new Grille(4);
        System.out.println(mGrille);
        
        boolean continuer = true;
        Scanner sc = new Scanner(System.in);
        int input;
        
        while(continuer){
            input = sc.nextInt();
            if(input == 5){
                break;
            }
            
            mGrille.play(input);
            System.out.println(mGrille);
        }*/
        
        
        Fenetre fen = new Fenetre();
        fen.setLocationRelativeTo(fen.getParent());
        fen.setVisible(true);
    }
    
}
