package milestone.classi;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ale
 */
public class VenditoreFactory {
 
 // Codice che permette di creare una sola istanza della classe
    private static VenditoreFactory singleton;
    public static VenditoreFactory getInstance() {
        if (singleton == null) {
            singleton = new VenditoreFactory();
        }
        return singleton;
    }    
    
    private ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
    
    public VenditoreFactory (){
        Venditore vend1 = new Venditore();
        vend1.setImpresa("TuttoTacchi");
        vend1.setUsername("maniR");
        vend1.setPassword("a");
        vend1.setNome("Manila");
        vend1.setCognome("Rossi");
        vend1.setId(0);
        vend1.setIdConto(0);
        listaVenditori.add(vend1);
        
        
        Venditore vend2 = new Venditore();
        vend1.setImpresa("JapanShoes");
        vend2.setUsername("jss");
        vend2.setPassword("b");
        vend2.setNome("Ilario");
        vend2.setCognome("Sakata");
        vend2.setId(1);
        vend1.setIdConto(1);
        listaVenditori.add(vend2);

    }
    
    public ArrayList<Venditore> getSellerList(){
       return listaVenditori;
    }
    
    
}
