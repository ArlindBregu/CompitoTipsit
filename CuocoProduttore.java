/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensaaziendale;

/**
 *<p>Classe che produce il dato</p>
 * @author informatica
 */
public class CuocoProduttore extends Thread{ 
    
    Bancone b; // variabile Condivisa
    int numeroPiattiDaServire; //Variabile usata per il numero massimo dei piatti da servire
    
    /**
     *
     * @param b <p>Variabile condivisa</p>
     * @param numeroPiattiDaServire <p>Numero massimo di piatti da servire</p>
     */
    public CuocoProduttore(Bancone b, int numeroPiattiDaServire) {
        this.b = b;
        this.numeroPiattiDaServire = numeroPiattiDaServire;
    }
    
    /**
     *<p>Viene usato il metodo deposita della classe Bancone tante volte quanti sono i piatti da servire</p>
     */
    public void run(){ //
        
        for(int i = 0; i<this.numeroPiattiDaServire; i++){
    
            try {
                sleep((int)(Math.random() * 2000)); //metodo che simula il tempo che ci vuole per la creazione di un piatto
            } catch (InterruptedException e) {
            }

            b.deposita();
        
        }
    }
    
}
