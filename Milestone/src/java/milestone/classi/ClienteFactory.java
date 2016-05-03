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
public class ClienteFactory {
 
 // Codice che permette di creare una sola istanza della classe
    private static ClienteFactory singleton;
    public static ClienteFactory getInstance() {
        if (singleton == null) {
            singleton = new ClienteFactory();
        }
        return singleton;
    }    
    
    private ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
    
    public ClienteFactory (){
        Cliente client1 = new Cliente();
        client1.setUsername("almura");
        client1.setPassword("0");
        client1.setNome("Alessandro");
        client1.setCognome("Mura");
       // client1.setFoto("http://immaginibuongiorno.it/wp-content/uploads/2015/08/Immagini-buongiorno-301-e1411874877531-320x296.jpg");
        client1.setId(0);
        client1.conto.setSaldo(1220.05);
        listaClienti.add(client1);
        
        
        Cliente client2 = new Cliente();
        client2.setUsername("petrap");
        client2.setPassword("1");
        client2.setNome("Petra");
        client2.setCognome("Pirastu");
       // client2.setFoto("http://static.tecnocino.it/r/845X0/www.tecnocino.it/img/San-Valentino-2016-e-cuore-rosso.jpg");
        client2.setId(1);
        client2.conto.setSaldo(95.30);
    
    
        
        listaClienti.add(client2);
        
        
        Cliente client3 = new Cliente();
        client3.setUsername("NBS");
        client3.setPassword("2");
        client3.setNome("Nobume");
        client3.setCognome("Smith");
       // client3.setFoto("http://i0.wp.com/www.alessiopomaro.com/wp-content/uploads/2014/03/scelta-immagini-emozioni-positive.jpg");
        client3.setId(2);
        client3.conto.setSaldo(1500.00);
        listaClienti.add(client3);
        
    }
    
    public ArrayList<Cliente> getClientList(){
       return listaClienti;
    }
    
}
