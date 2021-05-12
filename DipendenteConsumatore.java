/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensaaziendale;

/**
 *<p>Classe che consuma il dato</p>
 * @author informatica
 */
public class DipendenteConsumatore extends Thread{
    
    Bancone b;

    /**
     * 
     * @param b <p>Variabile consivisa</p>
     */
    public DipendenteConsumatore(Bancone b) {
        this.b = b;
    }

    /**
     *<p>Viene usato il metodo preleva della classe Bancone </p>
     */
    public void run(){ 
        
        b.preleva();
        
        try {
            
            sleep((int)(Math.random() * 1500)); //Metodo che simula la consumazione del piatto
            
        } catch (InterruptedException e) {
        }
         
    }
   
    
    
}
