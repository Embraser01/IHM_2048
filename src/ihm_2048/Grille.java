/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_2048;

import java.util.ArrayList;

/**
 *
 * @author Marc-Antoine
 */
public class Grille {
    private int taille;
    
    private Case[][] tab;

    public Grille(int taille) {
        this.taille = taille;
        this.tab = new Case[taille][taille];
        
        for(int y = 0; y < taille; y++){
            for(int x = 0; x < taille; x++){
                tab[y][x] = new Case();
            }
        }
        this.setRand();
        this.setRand();
    }
    
    public void agrandir(){
        if(taille == 12)
            return;
        
        taille++;
        
        this.tab = new Case[taille][taille];
        
        for(int y = 0; y < taille; y++){
            for(int x = 0; x < taille; x++){
                tab[y][x] = new Case();
            }
        }
        this.reset();
    }
    
    public void reduire(){
        if(taille == 2)
            return;
        
        taille--;
        
        this.tab = new Case[taille][taille];
        
        for(int y = 0; y < taille; y++){
            for(int x = 0; x < taille; x++){
                tab[y][x] = new Case();
            }
        }
        this.reset();
    }
    
    public Case getCase(int x, int y){
        return tab[y][x];
    }
    
    public int getTaille(){
        return taille;
    }
    
    public boolean setRand(){
        ArrayList<Integer> tmp1 = new ArrayList();
        ArrayList<Integer> tmp2 = new ArrayList();
        
        for(int y = 0; y < taille; y++){
            for(int x = 0; x < taille; x++){
                if(tab[y][x].isEmpty()){
                    tmp1.add(y);
                    tmp2.add(x);
                }
            }
        }
        
        if(tmp1.isEmpty())
            return false;
        
        int value = (int) ((Math.random() * 1) + 1) * 2;
                
        int nb = (int) (Math.random() * tmp1.size());
        
        tab[tmp1.get(nb)][tmp2.get(nb)].setValue(value);
        return true;
    }
    
    
    public void reset(){
        
        for(int y = 0; y < taille; y++){
            for(int x = 0; x < taille; x++){
                tab[y][x].clear();
            }
        }
        this.setRand();
        this.setRand();
    }
    
    
    private boolean move(int dir){
        
        switch(dir){
            case 0:
                for(int x = 0; x < taille; x++){
                    for(int y = 1; y < taille; y++){
                        if(!tab[y][x].isEmpty()){
                            boolean empty = true;
                            int k = 0;
                            
                            while(empty){
                                if(y-k-1 < 0 || !tab[y-k - 1 ][x].isEmpty()){
                                    empty = false;
                                }
                                else{
                                    k++;
                                }
                            }
                            if(k > 0){
                                this.tab[y-k][x].setValue(this.tab[y][x].getValue());
                                this.tab[y][x].clear();
                            }
                            
                        }
                        
                        
                    }
                }
                break;
                
            case 1:
                for(int y = 0; y < taille; y++){
                    for(int x = taille - 2; x >= 0; x--){
                    
                        if(!tab[y][x].isEmpty()){
                            boolean empty = true;
                            int k = 0;
                            
                            while(empty){
                                if(x+k+1 >= taille || !tab[y][x+k+1].isEmpty()){
                                    empty = false;
                                }
                                else{
                                    k++;
                                }
                            }
                            if(k > 0){
                                this.tab[y][x + k].setValue(this.tab[y][x].getValue());
                                this.tab[y][x].clear();
                            }
                        }
                    }
                }
                break;
                
            case 2:
                for(int x = 0; x < taille; x++){
                    for(int y = taille-2; y >= 0; y--){
                        if(!tab[y][x].isEmpty()){
                            boolean empty = true;
                            int k = 0;
                            
                            while(empty){
                                if(y+k+1 >= taille || !tab[y+k + 1 ][x].isEmpty()){
                                    empty = false;
                                }
                                else{
                                    k++;
                                }
                            }
                            if(k > 0){
                                this.tab[y+k][x].setValue(this.tab[y][x].getValue());
                                this.tab[y][x].clear();
                            }
                            
                        }
                        
                        
                    }
                }
                break;
            case 3:
                for(int y = 0; y < taille; y++){
                    for(int x = 1; x < taille; x++){
                    
                        if(!tab[y][x].isEmpty()){
                            boolean empty = true;
                            int k = 0;
                            
                            while(empty){
                                if(x-k-1 < 0 || !tab[y][x-k-1].isEmpty()){
                                    empty = false;
                                }
                                else{
                                    k++;
                                }
                            }
                            if(k > 0){
                                this.tab[y][x - k].setValue(this.tab[y][x].getValue());
                                this.tab[y][x].clear();
                            }
                        }
                    }
                }
                break;
        }
        return false;
        
    }
    
    public void play(int dir){
        dir = dir%4;
        
        this.move(dir);
        
        switch(dir){
            case 0:
                for(int x = 0; x < taille; x++){
                    for(int y = 0; y < taille - 1; y++){
                        if(tab[y][x].getValue() == tab[y + 1][x].getValue()){
                            
                            tab[y][x].setValue(2*tab[y + 1][x].getValue());
                            tab[y + 1][x].clear();
                            y++;                        
                        }
                    }
                }
                break;
            case 1:
                for(int y = 0; y < taille; y++){
                    for(int x = taille - 1; x > 0; x--){
                        if(tab[y][x].getValue() == tab[y][x - 1].getValue()){
                            
                            tab[y][x].setValue(2*tab[y][x - 1].getValue());
                            tab[y][x - 1].clear();
                            x--;                        
                        }
                    }
                }
               break;
                
            case 2:
                for(int x = 0; x < taille; x++){
                    for(int y = taille - 1; y >0; y--){
                        if(tab[y][x].getValue() == tab[y - 1][x].getValue()){
                            
                            tab[y][x].setValue(2*tab[y - 1][x].getValue());
                            tab[y - 1][x].clear();
                            y--;                        
                        }
                    }
                }
               break;
            case 3:
                for(int y = 0; y < taille; y++){
                    for(int x = 0; x < taille - 1; x++){
                        if(tab[y][x].getValue() == tab[y][x + 1].getValue()){
                            
                            tab[y][x].setValue(2*tab[y][x + 1].getValue());
                            tab[y][x + 1].clear();
                            x++;                        
                        }
                    }
                }
               break;
            
        }
        this.move(dir);
        this.setRand();
    }
    
    
    public boolean isFinish(){
        
        for(int y = 0; y < taille; y++){
            for(int x = 0; x < taille; x++){
                if(tab[y][x].isEmpty())
                    return false;
            }
        }
        for(int y = 0; y < taille; y++){
            for(int x = 0; x < taille; x++){
                try{
                    if(tab[y][x].getValue() == tab[y-1][x].getValue())
                        return false;
                }catch(Exception e){}
                try{
                    if(tab[y][x].getValue() == tab[y+1][x].getValue())
                        return false;
                }catch(Exception e){}
                try{
                    if(tab[y][x].getValue() == tab[y][x-1].getValue())
                        return false;
                }catch(Exception e){}
                try{
                    if(tab[y][x].getValue() == tab[y][x+1].getValue())
                        return false;
                }catch(Exception e){}
            }
        }
        
        
     return true;
    }
    
    @Override
    public String toString() {
        String tmp = "";
        
        for(int y = 0; y < taille; y++){
            for(int x = 0; x < taille; x++){
                tmp += tab[y][x].getValue() + " ";
            }
            tmp += "\n";
        }
        
        return tmp;
    }
    
}
