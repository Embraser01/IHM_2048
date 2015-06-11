/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_2048;

/**
 *
 * @author Marc-Antoine
 */
public class Case {
    
    private int value;

    public Case() {
        this.value = 0;
    }

    public boolean isEmpty(){
        if(value == 0)
            return true;
        return false;
    }
    
    public void clear(){
        this.value = 0;
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
}
